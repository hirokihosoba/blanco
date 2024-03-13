package blanco.controller.view.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import blanco.controller.view.SignController;

@Controller
public class SignControllerImpl implements SignController{

    @Override
    @GetMapping("/sign/up")
    public String signUp(Model model) {
        return "sign/up/index";
    }

    @Override
    @GetMapping("/sign/in")
    public String signIn(Model model) {
        return "sign/in/index";
    }

    @Override
    @GetMapping("/sign/out")
    public String signOut(Model model) {
        return "sign/out/index";
    }
    
}
