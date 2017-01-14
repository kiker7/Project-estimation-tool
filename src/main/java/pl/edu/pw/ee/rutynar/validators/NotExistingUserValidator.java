package pl.edu.pw.ee.rutynar.validators;

import pl.edu.pw.ee.rutynar.services.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by kiker on 14.01.17.
 */

public class NotExistingUserValidator implements ConstraintValidator<NotExisitingUser, String>{

    private final UserService userService;

    public NotExistingUserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(NotExisitingUser constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !userService.isExistingUser(value);
    }
}
