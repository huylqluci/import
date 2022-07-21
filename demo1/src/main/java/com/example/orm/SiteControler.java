package com.example.orm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class SiteControler {
    @Autowired
    SiteService siteService;

    @GetMapping("/test-add")
    public void testAdd() {
        siteService.testAdd();
    }
}
