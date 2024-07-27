package com.backend.backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @GetMapping("/")
    public ResponseEntity<String> index() {
            
            return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {

        return ResponseEntity.ok("test...");
    }
}
