package java13g3.justMeet.services;

import java13g3.justMeet.models.User;
import java13g3.justMeet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User u) {
        return userRepository.save(u);
    }

    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> retrieveUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public List<User> retrieveUserByName(String userName) {
        return userRepository.findByName(userName);
    }

    public List<User> retrieveUserBySurname(String userSurname) {
        return userRepository.findBySurname(userSurname);
    }

    public List<User> retrieveUserByNickname(String userNickname) {
        return userRepository.findByNickname(userNickname);
    }

    public List<User> retrieveUserByAge(int age) {
        return userRepository.findByAge(age);
    }

    public Optional<User> retrieveUserByEmail(String userEmail) {
        return Optional.of(userRepository.findByEmail(userEmail));
    }

    public Optional<User> retrieveUserByPhoneNumbers(String userPhoneNumber) {
        return Optional.of(userRepository.findByPhoneNumber(userPhoneNumber));
    }

    public Optional<User> updateUser(Long id, User newCurrentUser) {
        Optional<User> updateUser = userRepository.findById(id);
        if (updateUser.isPresent()) {
            updateUser.get().setName(newCurrentUser.getName());
            updateUser.get().setSurname(newCurrentUser.getSurname());
            updateUser.get().setPhotoProfile(newCurrentUser.getPhotoProfile());
            updateUser.get().setNickname(newCurrentUser.getNickname());
            updateUser.get().setAge(newCurrentUser.getAge());
            updateUser.get().setEmail(newCurrentUser.getEmail());
            updateUser.get().setPhoneNumber(newCurrentUser.getPhoneNumber());
            return Optional.of(userRepository.save(updateUser.get()));
        } else {
            return Optional.empty();
        }
    }

        public void deleteUserById(Long id) {
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
        }
    }
}
