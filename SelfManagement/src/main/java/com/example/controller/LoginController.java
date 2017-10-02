package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.common.PageName;

@Controller
public class LoginController {
    @RequestMapping(value = "/loginIndex")
    String loginIndex() {
        return PageName.LOGININDEX;
    }
}
