package com.medoptica.medoptica.contollers;

import com.medoptica.medoptica.models.HelloResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/hello")
    HelloResponse hello() {
        return new HelloResponse("Hello World");
    }

}
