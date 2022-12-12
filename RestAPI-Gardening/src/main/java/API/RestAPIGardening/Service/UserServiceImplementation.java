package API.RestAPIGardening.Service;

import API.RestAPIGardening.Model.User;
import API.RestAPIGardening.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImplementation  implements UserService{

    private UserRepository userRepository;
    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User updateUserById(long id, User user) {
        User _user = findById(id);

        if (_user != null){
            _user.setUsername(user.getUsername());
            _user.setPassword(user.getPassword());
            userRepository.save(user);
        }

        return null;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        Optional<User> user = userRepository.findById(id);

        return user.orElse(null);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean existsById(long id) {
        return userRepository.existsById(id);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
