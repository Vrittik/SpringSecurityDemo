package com.SpringSecurityDemo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("welcome")
    public String userWelcome()
    {
        return "You are authorized to access the user route";
    }
}
