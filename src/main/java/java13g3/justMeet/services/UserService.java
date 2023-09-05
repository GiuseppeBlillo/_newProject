package java13g3.justMeet.services;

import java13g3.justMeet.models.User;
import java13g3.justMeet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User u){
        if(u.getName().isEmpty() || u.getSurname().isEmpty() || u.getNickname().isEmpty() || u.getPhotoProfile().isEmpty() || u.getAge() <= 0 ||
        u.getAge() >= 120 || u.getEmail().isEmpty() || u.getPhoneNumber().isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            userRepository.save(u);
        }
    }

    public List<User> retrieveAllUsers(){
        if(userRepository.findAll().size() >= 1){
            return userRepository.findAll();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Optional<User> retrieveUserById(Long userId){
        if(userRepository.findById(userId).isPresent()){
            return userRepository.findById(userId);
        } else {
            return Optional.empty();
        }
    }
    public Optional<List<User>> retrieveUserByName(String userName){
        if(userRepository.findByName(userName).isPresent()){
            return userRepository.findByName(userName);
        } else {
            return Optional.empty();
        }
    }
    public Optional<List<User>> retrieveUserBySurname(String userSurname){
        if(userRepository.findBySurname(userSurname).isPresent()){
            return userRepository.findBySurname(userSurname);
        } else {
            return Optional.empty();
        }
    }
    public Optional<List<User>> retrieveUserByPhotoProfile(String urlPhotoProfile){
        if(userRepository.findByPhotoProfile(urlPhotoProfile).isPresent()){
            return userRepository.findByPhotoProfile(urlPhotoProfile);
        } else {
            return Optional.empty();
        }
    }
    public Optional<List<User>> retrieveUserByNickname(String userNickname){
        if(userRepository.findByNickname(userNickname).isPresent()){
            return userRepository.findByNickname(userNickname);
        } else {
            return Optional.empty();
        }
    }
    public Optional<List<User>> retrieveUserByAge(int age){
        if(userRepository.findByAge(age).isPresent()){
            return userRepository.findByAge(age);
        } else {
            return Optional.empty();
        }
    }
    public Optional<User> retrieveUserByEmail(String userEmail){
        if(userRepository.findByEmail(userEmail).isPresent()){
            return userRepository.findByEmail(userEmail);
        } else {
            return Optional.empty();
        }
    }
    public Optional<User> retrieveUserByPhoneNumbers(String userPhoneNumber){
        if(userRepository.findByPhoneNumber(userPhoneNumber).isPresent()){
            return userRepository.findByPhoneNumber(userPhoneNumber);
        } else {
            return Optional.empty();
        }
    }

   /* public Optional<User>updateUser(Long id, User newCurrentUser){
        Optional<User>  updateUser = userRepository.findById(id);
        if(updateUser.isPresent()){
            updateUser.get().setName(newCurrentUser.getName());
            updateUser.get().setSurname(newCurrentUser.getSurname());
            updateUser.get().setPhotoProfile(newCurrentUser.getPhotoProfile());
            updateUser.get().setNickname(newCurrentUser.getNickname());
            updateUser.get().setAge(newCurrentUser.getAge());
            updateUser.get().setEmail(newCurrentUser.getEmail());
            updateUser.get().setPhoneNumber(newCurrentUser.getPhoneNumber());
            userRepository.save(updateUser.get());
            return updateUser;
        }else {
            return Optional.empty();
        }
    }*/

    public void updateUser(Long id, User modifiedUser){
        User oldUser = userRepository.findById(id).get();
        if(userRepository.findById(id).isPresent() && id.equals(modifiedUser.getId())) {
            oldUser.setName(modifiedUser.getName());
            oldUser.setSurname(modifiedUser.getSurname());
            oldUser.setPhotoProfile(modifiedUser.getPhotoProfile());
            oldUser.setNickname(modifiedUser.getNickname());
            oldUser.setAge(modifiedUser.getAge());
            oldUser.setEmail(modifiedUser.getEmail());
            oldUser.setPhoneNumber(modifiedUser.getPhoneNumber());
            userRepository.save(oldUser);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void deleteUserById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        } else throw new IllegalArgumentException();
    }

}
