package com.SpringSecurityDemo.Controllers;

import com.SpringSecurityDemo.Domain.UserManagerService;
import com.SpringSecurityDemo.Entity.UserInfo;
import com.SpringSecurityDemo.Models.AuthRequest;
import com.SpringSecurityDemo.Service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserManagerService userManagerService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;
//
//    public UserController(
//            UserManagerService userManagerService,
//            AuthenticationManager authenticationManager,
//            JwtService jwtService
//    )
//    {
//        this.userManagerService = userManagerService;
//        this.authenticationManager = authenticationManager;
//        this.jwtService = jwtService;
//    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to the public endpoint";
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody UserInfo userInfo)
    {
        return this.userManagerService.addNewUser(userInfo);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody AuthRequest authRequest)
    {
        // Standard auth
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            return jwtService.generateToken(authRequest.getUsername());
        }
        catch(Exception e)
        {
            throw new UsernameNotFoundException("Invalid credentials");
        }
    }
}
