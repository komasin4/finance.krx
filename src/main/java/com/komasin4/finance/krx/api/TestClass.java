package com.komasin4.finance.krx.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(value = "/test")
public class TestClass {

//    @Value("${enc.test}")
//    private String encString;

    @Value("${jasypt.key}")
    private String jasyptKey;

    @GetMapping("/apitest")
    public String getTest() {
        log.debug("**************jasyptKey:" + jasyptKey);
//        log.debug("**************encString:" + encString);
        return "testok";
    }
}
