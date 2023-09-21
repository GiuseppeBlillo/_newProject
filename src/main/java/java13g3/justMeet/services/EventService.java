package java13g3.justMeet.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.mashape.unirest.http.exceptions.UnirestException;
import java13g3.justMeet.config.GoogleMapsConfig;
import java13g3.justMeet.enumerations.LanguageEnum;
import java13g3.justMeet.models.Event;
import java13g3.justMeet.models.User;
import java13g3.justMeet.repositories.EventRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.mashape.unirest.http.Unirest;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private GoogleMapsConfig googleMapsConfig;

    @Autowired
    private Storage storage;

    @Value("${google.cloud.storage.bucketName}")
    private String bucketName;

    private final RestTemplate restTemplate = new RestTemplate();

    public Event createEvent(Event e) {
        return eventRepository.save(e);
    }

    public List<Event> retrieveAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> retrieveEventById(Long id) {
        return eventRepository.findById(id);
    }

    public List<Event> retrieveEventByName(String eventName){
        return eventRepository.findByName(eventName);
    }

    public List<Event> retrieveEventByCategory(String category) {
        return eventRepository.findByCategory(category);
    }

    public List<Event> retrieveEventByEventDate(Date date){
        return eventRepository.findByEventDate(date);
    }

    public List<Event> retrieveEventByAddressApi(String addressApi) {
        return eventRepository.findByAddressApi(addressApi);
    }

    public List<Event> retrieveEventByLanguage(LanguageEnum languageEnum){
        return eventRepository.findByLanguage(languageEnum);
    }

    public Optional<Event> updateEvent(Long id, Event currentEvent) {
        Optional<Event> updateEvent = eventRepository.findById(id);
        if (updateEvent.isPresent()){
            updateEvent.get().setName(currentEvent.getName());
            updateEvent.get().setDescription(currentEvent.getDescription());
            updateEvent.get().setCategory(currentEvent.getCategory());
            updateEvent.get().setLanguage(currentEvent.getLanguage());
            updateEvent.get().setCoverPhoto(currentEvent.getCoverPhoto());
            updateEvent.get().setEventDate(currentEvent.getEventDate());
            updateEvent.get().setIdMaker(currentEvent.getIdMaker());
            String newLocation = updateEventWithLocation(currentEvent.getAddressApi());
            updateEvent.get().setAddressApi(newLocation);
            updateEvent.get().setPrivate(currentEvent.getPrivate());
            return Optional.of(eventRepository.save(updateEvent.get()));
        } else {
            return Optional.empty();
        }
    }

    public String updateEventWithLocation(String address) {
        String googleMapsApiKey = googleMapsConfig.getGoogleMapsApiKey();

        String addressTemp = URLEncoder.encode(address, StandardCharsets.UTF_8).replace("+", "%20");

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("maps.googleapis.com")
                .path("/maps/api/geocode/json")
                .queryParam("key", googleMapsApiKey)
                .queryParam("address", addressTemp)
                .build();

        JSONObject jsonResponse = null;

        try {
            jsonResponse = Unirest.get(uri.toString()).asJson().getBody().getObject();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonResponse.toString());

            JsonNode results = jsonNode.get("results");
            if (results != null && results.isArray() && !results.isEmpty()) {
                JsonNode location = results.get(0).path("geometry").path("location");

                if (location != null) {
                    String lat = location.path("lat").asText();
                    String lng = location.path("lng").asText();

                    UriComponents correctUri = UriComponentsBuilder.newInstance()
                            .scheme("https")
                            .host("www.google.com")
                            .path("/maps/")
                            .queryParam("key", googleMapsApiKey)
                            .queryParam("q", lat + "," + lng)
                            .build();

                    return correctUri.toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String y = URLEncoder.encode(address, StandardCharsets.UTF_8).replace("+", "%20");
        return "https://www.google.com/maps/place/" + y;
    }

    public void deleteEventById(Long id, Long idDeleter) throws Exception {
        Optional<Event> eventTemp = eventRepository.findById(id);
        if (eventTemp.isPresent()) {
            if (eventTemp.get().getIdMaker().getId().equals(idDeleter)) {
                eventRepository.deleteById(id);
            } else {
                throw new IllegalAccessException();
            }
        } else throw new Exception();
    }

    public Optional<Event> updateEventWithPhoto(Long id, MultipartFile o) {
        Optional<Event> eventTemp = eventRepository.findById(id);
        if (eventTemp.isPresent()) {
            try {
                Storage st = storage;
                String buckName = bucketName;
                String objName = "event-pictures/" + id + "/" + o.getOriginalFilename();

                BlobId bID = BlobId.of(buckName, objName);
                BlobInfo bInfo = BlobInfo.newBuilder(bID).build();
                Blob bl = st.create(bInfo, o.getBytes());

                String phUrl = "https://storage.googleapis.com/" + buckName + "/" + objName;

                Event event = eventTemp.get();

                event.setCoverPhoto(phUrl);
                eventRepository.save(event);
                return Optional.of(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }

    public Optional<Event> updateEventUserList(Long id, User user){
        Optional<Event> eventTemp = eventRepository.findById(id);
        if (eventTemp.isPresent()){
            Event event = eventTemp.get();
            event.getUserList().add(user);
            eventRepository.save(event);
            return Optional.of(event);
        }
        return Optional.empty();
    }

}