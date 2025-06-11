package com.cetpa;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/deploy")
public class HomeController {
    @GetMapping("/test")
    public ResponseEntity<Map<String, Object>> serviceTest() {
        Map<String, String> data = new HashMap<>();
        data.put("ServiceName", "Deployment Testing");
        data.put("Cloud", "render.com");
        data.put("Developer", "Mr.Brijesh (SDE)");

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", "success");
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("version", "v1.0.0");
        response.put("data", data);

        return ResponseEntity.ok(response);
    }


}
