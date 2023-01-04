package com.smartTech.RestApi.Service;


import com.smartTech.RestApi.Model.User;

import com.smartTech.RestApi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;



@Service
public class UserServiceImpl implements UserService{

    private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;

    @Autowired
    private UserRepository userRepository;




    @Override
    public User getSingleUser(Long user_id) {

        Optional<User> user =userRepository.findById(user_id);
        if(user.isPresent()){

            return user.get();
        }
        throw new RuntimeException("User not available");

    }

    @Override
    public User getSingleUserByPhone(String phone) {

        Optional<User> user = Optional.ofNullable(userRepository.getSingleUserByPhone(phone));
        if(user.isPresent()){

            return user.get();
        }
        throw new RuntimeException("User not available");

    }




    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long user_id) {
        userRepository.deleteById(user_id);
    }


    @Override
    public String forgotPassword(String email) {

        Optional<User> userOptional =userRepository.findByEmail(email);

        if (!userOptional.isPresent()) {
            return "Invalid email id.";
        }

        User user = userOptional.get();
        user.setToken(generateToken());
        user.setTokenCreationDate(LocalDateTime.now());

        user = userRepository.save(user);

        return user.getToken();
    }
   @Override
    public String resetPassword(String token, String password) {

        Optional<User> userOptional = Optional.ofNullable(userRepository.findByToken(token));

        if (!userOptional.isPresent()) {
            return "Invalid token.";
        }

        LocalDateTime tokenCreationDate = userOptional.get().getTokenCreationDate();

        if (isTokenExpired(tokenCreationDate)) {
            return "Token expired.";

        }

        User user = userOptional.get();

        user.setPassword(password);
        user.setToken(null);
        user.setTokenCreationDate(null);

        userRepository.save(user);

        return "Your password successfully updated.";
    }
    @Override
    public Optional findUserByResetToken(String resetToken) {
        return userRepository.findByResetToken(resetToken);
    }

    // generated  a UUI token
    private String generateToken()
    {
        StringBuilder token = new StringBuilder();

        return token.append(UUID.randomUUID().toString())
                .append(UUID.randomUUID().toString()).toString();
    }

// test if my token is expired
    private boolean isTokenExpired(final LocalDateTime tokenCreationDate) {

        LocalDateTime now = LocalDateTime.now();
        Duration diff = Duration.between(tokenCreationDate, now);

        return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
    }
}
