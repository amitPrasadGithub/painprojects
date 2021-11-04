package com.springboot.jenkinstomcat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Welcome {
    @RequestMapping(value = {"/get"})
    public String get(Model model) {
        return "index";
    }
}
