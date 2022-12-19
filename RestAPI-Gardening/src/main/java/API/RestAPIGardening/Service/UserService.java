package API.RestAPIGardening.Service;

import API.RestAPIGardening.Model.User;
import API.RestAPIGardening.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean userExists(String username) {
        return this.userRepository.existsByUsernameIgnoreCase(username);
    }

    public Optional<User> findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public Optional<User> findById(Long userId) {
        return this.userRepository.findById(userId);
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

}
