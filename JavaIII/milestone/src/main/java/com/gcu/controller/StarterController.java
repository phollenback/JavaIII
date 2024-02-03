package com.gcu.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class StarterController {

    @GetMapping("/")
    public String showStarterPage(Model model) {
        model.addAttribute("title", "Portfol.io");
        return "starter";
    }
}
