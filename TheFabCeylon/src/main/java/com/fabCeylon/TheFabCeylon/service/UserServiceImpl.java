package com.fabCeylon.TheFabCeylon.service;

import com.fabCeylon.TheFabCeylon.domain.user.User;
import com.fabCeylon.TheFabCeylon.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserDetailsService,UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired private UserDetailsService userDetailsService;

    @Override
    public UserDetails loadUserByUsername(String contactNumber) throws UsernameNotFoundException {
        User user = userRepository.findByContactNumber(contactNumber);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getContactNumber(), user.getPassword(), new ArrayList<>());
    }

    @Override
    public User signupUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByContactNumber(String contactNumber) {
        return userRepository.findByContactNumber(contactNumber);
    }



}
