package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.common.PageName;

@Controller
public class IndexController {
    @RequestMapping(value ={"/", "/index"})
    String topPage() {
        return PageName.INDEX;
    }
}
