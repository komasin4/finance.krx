package com.komasin4.finance.krx.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
public class ProductInfoController {

    @GetMapping("/info")
    public String getTest() {
        return "test ok";
    }

}
