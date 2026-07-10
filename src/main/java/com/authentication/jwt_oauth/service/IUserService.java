package com.authentication.jwt_oauth.service;

import com.authentication.jwt_oauth.model.User;
import com.authentication.jwt_oauth.security.MyToken;

public interface IUserService {
    User addUser(User user);
    User getByUsername(String username);
    MyToken userLogin(User user);
}
