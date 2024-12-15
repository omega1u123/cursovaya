package org.example.cursovayamarketplace.servie;

import lombok.RequiredArgsConstructor;
import org.example.cursovayamarketplace.domain.model.UserEntity;
import org.example.cursovayamarketplace.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public boolean createUser(String username, String password){
        if(userRepository.findByUsername(username) != null){
            return false;
        }
        UserEntity newUser = new UserEntity(username, password);
        userRepository.save(newUser);
        return true;
    }

    public UserEntity findUserById(int id) {
        return userRepository.findById(id).orElseThrow();
    }

    public UserEntity findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
