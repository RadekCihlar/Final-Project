package API.RestAPIGardening.Controller;

import API.RestAPIGardening.Model.User;
import API.RestAPIGardening.Model.UserDTO;
import API.RestAPIGardening.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:5173/")
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
