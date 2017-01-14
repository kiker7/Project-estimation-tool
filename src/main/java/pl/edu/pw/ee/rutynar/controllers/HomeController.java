package pl.edu.pw.ee.rutynar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by kiker on 14.01.17.
 */

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(){
        return "home";
    }
}
