package com.example.dreamTeam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForbiddenController {

    @GetMapping("/403")
    public String forbiddenPage(){
        return "403";
    }

}
