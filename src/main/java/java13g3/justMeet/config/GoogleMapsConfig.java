package java13g3.justMeet.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Map;

@Configuration
public class GoogleMapsConfig {

    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    public Map<String, String> googleMaps()  {
        try {
            return objectMapper.readValue(
                    GoogleMapsConfig.class.getResourceAsStream("/google-maps-config.json"),
                    Map.class
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getGoogleMapsApiKey()  {
        Map<String, String> config = googleMaps();
        return config.get("googleMapsApiKey");
    }
}
