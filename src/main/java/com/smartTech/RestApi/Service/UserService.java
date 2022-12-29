package com.smartTech.RestApi.Service;

import com.smartTech.RestApi.Model.Services;
import com.smartTech.RestApi.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User getSingleUser(Long user_id );
    public Optional<User> findUserByResetToken(String resetToken);
    List<User> getUsers();
    User saveUser(User user);

    void deleteUser(Long user_id );

    String forgotPassword(String email);
    String resetPassword(String token, String password);
}
