package pl.edu.pw.ee.rutynar.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import pl.edu.pw.ee.rutynar.validators.NotExisitingUser;

/**
 * Created by kiker on 14.01.17.
 */
public class RegisterForm {

    @NotBlank
    @Length(min = 5, max = 20)
    @NotExisitingUser
    private String userName;

    @NotBlank
    @Length(min = 5)
    private String password;

    @NotBlank
    @Length(min = 5)
    private String repeatedPassowrd;

    @Email
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassowrd() {
        return repeatedPassowrd;
    }

    public void setRepeatedPassowrd(String repeatedPassowrd) {
        this.repeatedPassowrd = repeatedPassowrd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
