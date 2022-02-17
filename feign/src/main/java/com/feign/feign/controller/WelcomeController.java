package com.feign.feign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	@RequestMapping("/")
    public String home() {
        return "redirect:/swagger-ui/";
    }

}
