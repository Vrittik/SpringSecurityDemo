package com.SpringSecurityDemo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping("welcome")
    public String adminWelcome()
    {
        return "You are authorized to access the admin route";
    }
}
