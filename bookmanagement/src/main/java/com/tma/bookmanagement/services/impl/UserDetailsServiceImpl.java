package com.tma.bookmanagement.services.impl;

import com.tma.bookmanagement.repositories.RoleRepository;
import com.tma.bookmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.tma.bookmanagement.entities.User user = userRepository.findByUserName(username);
        if(user==null){
            System.out.println("User not found!" + username);
            throw new UsernameNotFoundException("User" + username + " was not found in the database");
        }
        System.out.println("Found user: " + user);
        //[ROLE_USER,ROLE_ADMIN,..]
        List<String> roleNames = roleRepository.getRoleNames(user.getUserId());

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if(roleNames!=null){
            for(String role : roleNames){
                //ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }

        }
        UserDetails userDetails = (UserDetails) new User(user.getUser_name(),//
                user.getPass_word(),grantList);
        return userDetails;
    }
}
