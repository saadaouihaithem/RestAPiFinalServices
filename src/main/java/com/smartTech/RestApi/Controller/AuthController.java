package com.smartTech.RestApi.Controller;



import com.smartTech.RestApi.Model.Services;
import com.smartTech.RestApi.Model.User;
import com.smartTech.RestApi.Repository.RoleRepository;
import com.smartTech.RestApi.Repository.UserRepository;
import com.smartTech.RestApi.Service.UserService;
import com.smartTech.RestApi.dto.ResetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import com.smartTech.RestApi.dto.LoginRequest;
import com.smartTech.RestApi.dto.RegisterRequest;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpSession;

import static com.twilio.Twilio.setPassword;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {


    private final UserRepository userRepository;


    private final RoleRepository roleRepository;


    @Autowired
    private UserService userService;


    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;


    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody RegisterRequest registerRequest) {

        if (userRepository.existsByUsername(registerRequest.getUsername())) {

            return new ResponseEntity<>("Username is already taken !,", HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPhone(registerRequest.getPhone());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        userRepository.save(user);


        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }


    // login nto the database

    @PostMapping(value = "/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }


    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam String email) {

        String response = userService.forgotPassword(email);

        if (!response.startsWith("Invalid")) {
            response = "http://localhost:8080/reset-password?token=" + response;
        }
        return response;
    }


    @PutMapping("/reset-password")
    public String resetPassword(@RequestParam String token,
                                @RequestParam String password
    ) {


        return userService.resetPassword(token, password);


    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        // Clear the user's session or authentication token
        session.invalidate();
        // Return a response to the client indicating that the log out was successful
        return ResponseEntity.ok().body("You have been successfully logged out.");
    }

    @PostMapping("/update-password")
    public ResponseEntity<String> updatePassword(@RequestParam("currentPassword") String currentPassword,
                                                 @RequestParam("newPassword") String newPassword,
                                                 HttpSession session) {
        // Retrieve the user's current password and the new password they want to set
        User user = (User) session.getAttribute("user");
        String password = user.getPassword();

        // Validate the current password
        if (!password.equals(currentPassword)) {
            return ResponseEntity.badRequest().body("Incorrect current password.");
        }

        // Update the user's password in the database or authentication system
        user.setPassword(newPassword);
        userRepository.save(user);

        // Return a response to the client indicating that the password update was successful
        return ResponseEntity.ok().body("Your password has been successfully updated.");
    }

    @PostMapping("/update-profile")
    public ResponseEntity<String> updateProfile(@RequestParam("username") String username,
                                                @RequestParam("email") String email,
                                                @RequestParam("phone") String phone,
                                                HttpSession session) {
        // Retrieve the user from the session
        User user = (User) session.getAttribute("user");

        // Update the user's profile in the database
        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        userRepository.save(user);

        // Return a response to the client indicating that the profile update was successful
        return ResponseEntity.ok().body("Your profile has been successfully updated.");
    }
}



