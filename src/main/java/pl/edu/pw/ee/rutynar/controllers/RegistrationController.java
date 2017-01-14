package pl.edu.pw.ee.rutynar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.ee.rutynar.dto.RegisterForm;
import pl.edu.pw.ee.rutynar.services.UserService;

import javax.validation.Valid;

/**
 * Created by kiker on 14.01.17.
 */

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterForm(@ModelAttribute RegisterForm registerForm){
        return "registration";
    }

    @PostMapping
    public String createNewAccount(@ModelAttribute @Valid RegisterForm registerForm, BindingResult buBindingResult){
        if(buBindingResult.hasErrors())
            return "registration";
        userService.createNewUserFromForm(registerForm);
        return "redirect:/home";
    }
}
