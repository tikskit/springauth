package ru.vluzhnykh.authbasics.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

    @GetMapping("/index")
    public String hello() {
        return "Success";
    }

    @GetMapping("/failure")
    public String error() {
        return "Failure";
    }
}
