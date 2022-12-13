package API.RestAPIGardening.Repository;

import API.RestAPIGardening.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByUsernameContainsIgnoreCase(String Username);

}