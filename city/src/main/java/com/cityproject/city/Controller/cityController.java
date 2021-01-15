package com.cityproject.city.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class cityController {
    @GetMapping("/city")
    public String cities(){
        return "city";
    }
}
