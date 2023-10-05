package com.example.shaurma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ReviewsController {
    @GetMapping("/review")
    public String review(){
        return "review";
    }

}
