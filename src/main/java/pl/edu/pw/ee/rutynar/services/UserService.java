package pl.edu.pw.ee.rutynar.services;

import pl.edu.pw.ee.rutynar.dto.RegisterForm;

/**
 * Created by kiker on 14.01.17.
 */
public interface UserService {
    boolean isExistingUser(String userName);
    void createNewUserFromForm(RegisterForm form);
}
