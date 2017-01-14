package pl.edu.pw.ee.rutynar.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by kiker on 14.01.17.
 */

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotExistingUserValidator.class)
public @interface NotExisitingUser {

    String message() default "{notExistingUser}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
