package com.SpringSecurityDemo.Domain;

import com.SpringSecurityDemo.Entity.UserInfo;
import com.SpringSecurityDemo.Repositories.UserInfoRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserManagerService {

    private final UserInfoRepository userInfoRepository;
    private final PasswordEncoder encoder;

    public UserManagerService(UserInfoRepository userInfoRepo, PasswordEncoder encoder)
    {
        this.userInfoRepository = userInfoRepo;
        this.encoder = encoder;
    }
    public String addNewUser(UserInfo userInfo){
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        this.userInfoRepository.save(userInfo);
        return "User saved";
    }
}
