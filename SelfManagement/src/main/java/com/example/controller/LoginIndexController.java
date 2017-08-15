package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginIndexController {
    @RequestMapping(value = "/loginIndex")
    String loginIndex() {
        return "loginIndex";
    }
}
