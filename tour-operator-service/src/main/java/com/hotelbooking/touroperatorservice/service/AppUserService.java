package com.hotelbooking.touroperatorservice.service;

import com.hotelbooking.touroperatorservice.model.AppUser;
import com.hotelbooking.touroperatorservice.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService{

    @Autowired
    private AppUserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       AppUser appUser = repo.findByUsername(username);

       if (appUser != null) {
           var springUser = User.withUsername(appUser.getUsername())
                   .password(appUser.getPassword())
                   .build();
           return springUser;
       }
        return null;
    }
}
