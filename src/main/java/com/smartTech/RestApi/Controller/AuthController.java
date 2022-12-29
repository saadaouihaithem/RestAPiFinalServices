package com.smartTech.RestApi.Controller;



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

import static com.twilio.Twilio.setPassword;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
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
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        userRepository.save(user);


        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }


    // login nto the database

    @PostMapping(value="/login")
    public ResponseEntity <String> authenticateUser (@RequestBody LoginRequest loginRequest) {
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


        return   userService.resetPassword(token, password);



    }





}


