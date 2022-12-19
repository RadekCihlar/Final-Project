package com.brights.vuesecurityservice.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> users() {
        return this.userService.findAll()
                .stream()
                .map(UserDTO::fromEntity)
                .toList();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long userId) {
        Optional<User> userOptional = this.userService.findById(userId);

        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.map(UserDTO::fromEntity).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/me")
    public ResponseEntity<UserDTO> me(Principal principal) {
        if (principal != null) {
            Optional<User> userOptional = this.userService.findByUsername(principal.getName());
            if (userOptional.isPresent()) {
                return ResponseEntity.ok(userOptional.map(UserDTO::fromEntity).get());
            }
        }

        return ResponseEntity.notFound().build();
    }

}
