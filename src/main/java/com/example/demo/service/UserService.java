package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {


    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(encoder.encode("user"));
//        user.setRoles(Collections.singleton(Role.USER));

        User user = userRepo.findByUsername(username);
        System.out.println(user);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
