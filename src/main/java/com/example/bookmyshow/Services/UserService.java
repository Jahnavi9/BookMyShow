package com.example.bookmyshow.Services;

import com.example.bookmyshow.Repository.UserRepository;
import com.example.bookmyshow.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User signup(String email, String password)
    {
        Optional<User> userOptional= userRepository.findByEmail(email);
        if(userOptional.isPresent())
            throw new IllegalArgumentException("User already exists");
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        return userRepository.save(user);

    }
    public boolean signin(String email, String password)
    {
        Optional<User> userOptional= userRepository.findByEmail(email);
        if(userOptional.isPresent() && userOptional.get().getPassword().equals(password))
            return true;
        return false;
    }



}
