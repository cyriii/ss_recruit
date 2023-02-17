package com.cyriii.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "个人测试", description = "请勿使用")
@RestController
public class DemoController {

    @PostMapping("/demo")
    public String demo() {
        return "hello world;";
    }

}
