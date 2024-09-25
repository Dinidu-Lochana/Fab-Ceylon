package com.fabCeylon.TheFabCeylon.service;

import com.fabCeylon.TheFabCeylon.domain.user.User;

public interface UserService {


    User getUserByContactNumber(String contactNumber);

    User signupUser(User user);
}
