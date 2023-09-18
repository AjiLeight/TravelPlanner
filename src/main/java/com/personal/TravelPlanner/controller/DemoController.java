package com.personal.TravelPlanner.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoController {

    @GetMapping
    public ResponseEntity<String> hw(){
        return ResponseEntity.ok("Hello WOrld");
    }
}
