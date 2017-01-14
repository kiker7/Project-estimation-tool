package pl.edu.pw.ee.rutynar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by kiker on 14.01.17.
 */

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLoginForm(@RequestParam(required = false) String error, Model model){
        if(error != null)
            model.addAttribute("loginError", "Niepoprawne dane");
        return "login";
    }
}
