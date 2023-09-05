package java13g3.justMeet.services;

import java13g3.justMeet.models.User;
import java13g3.justMeet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User u){
        if(u != null) {
            userRepository.save(u);
        }
    }

    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    public User retrieveUserById(Long userId){
        return userRepository.findById(userId).orElse(null);
    }


    public Optional<User>updateUser(Long id, User newCurrentUser){
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
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

}
