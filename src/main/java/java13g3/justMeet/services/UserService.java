package java13g3.justMeet.services;

import java13g3.justMeet.models.User;
import java13g3.justMeet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

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
        return userRepository.getReferenceById(userId);
    }


    public void updateUser(Long id, User u){
        userRepository.deleteById(id);
        userRepository.save(u);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

}
