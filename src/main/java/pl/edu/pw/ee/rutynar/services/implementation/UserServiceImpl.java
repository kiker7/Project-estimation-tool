package pl.edu.pw.ee.rutynar.services.implementation;

import org.springframework.stereotype.Service;
import pl.edu.pw.ee.rutynar.domain.Role;
import pl.edu.pw.ee.rutynar.domain.User;
import pl.edu.pw.ee.rutynar.dto.RegisterForm;
import pl.edu.pw.ee.rutynar.repositories.UserRepository;
import pl.edu.pw.ee.rutynar.services.UserService;

/**
 * Created by kiker on 14.01.17.
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isExistingUser(String userName) {
        return userRepository.findByUserName(userName).isPresent();
    }

    @Override
    public void createNewUserFromForm(RegisterForm form) {
        User user = new User();
        user.setUserName(form.getUserName());
        user.setPassword(form.getPassword());
        user.setRole(Role.USER);
        userRepository.save(user);
    }
}
