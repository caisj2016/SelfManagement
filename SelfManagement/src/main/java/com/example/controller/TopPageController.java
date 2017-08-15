package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopPageController {
    @RequestMapping(value = "/")
    String topPage() {
        return "topPage";
    }
}
