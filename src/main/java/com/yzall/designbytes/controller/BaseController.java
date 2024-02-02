package com.yzall.designbytes.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class BaseController {
    @GetMapping("/")
    public String index() {
        return "index.html";
    }
}
