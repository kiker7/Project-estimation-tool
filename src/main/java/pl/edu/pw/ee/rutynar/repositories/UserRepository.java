package pl.edu.pw.ee.rutynar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.ee.rutynar.domain.User;

import java.util.Optional;

/**
 * Created by kiker on 14.01.17.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);
}
