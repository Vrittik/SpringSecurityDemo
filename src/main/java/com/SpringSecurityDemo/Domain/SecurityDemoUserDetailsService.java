package com.SpringSecurityDemo.Domain;

import com.SpringSecurityDemo.Entity.UserInfo;
import com.SpringSecurityDemo.Repositories.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityDemoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = repository.findByEmail(username);

        return userInfo.map(SecurityDemoUserDetails::new).orElseThrow(() -> new
                UsernameNotFoundException("The username is not found: " + username));
    }
}
