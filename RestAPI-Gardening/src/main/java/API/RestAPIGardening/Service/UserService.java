package API.RestAPIGardening.Service;

import API.RestAPIGardening.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User updateUserById(long id, User user);

    User saveUser(User user);

    List<User> findAll();

    User findById(long id);

    void deleteById(long id);

    boolean existsById(long id);


    List<User> findAllByUsernameContainsIgnoreCase(String username);
}
