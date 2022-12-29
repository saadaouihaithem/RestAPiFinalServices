package com.smartTech.RestApi.Repository;

import com.smartTech.RestApi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
 public Optional<User> findByUsername(String username);
 Optional<User> findByEmail(String email);

 Optional<User> findByResetToken(String resetToken);

 User findByToken(String token);
 Optional<User> findByUsernameOrEmail(String username, String email);
 Boolean existsByUsername(String username);
 Boolean existsByEmail(String email);

}
