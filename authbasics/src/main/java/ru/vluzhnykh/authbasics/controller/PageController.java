package ru.vluzhnykh.authbasics.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
