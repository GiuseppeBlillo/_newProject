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

    public User createNew(User u){
        if(u != null){
            return userRepository.save(u);
        } return null;
    }

    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }


    public User updateUser(User u){
        userRepository.deleteById(u.getId());
        return userRepository.save(u);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

}
