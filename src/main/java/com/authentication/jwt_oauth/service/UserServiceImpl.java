package com.authentication.jwt_oauth.service;

import com.authentication.jwt_oauth.model.User;
import com.authentication.jwt_oauth.repo.UserRepo;
import com.authentication.jwt_oauth.security.MyToken;
import com.authentication.jwt_oauth.security.TokenUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService{

    private UserRepo repo;


    public UserServiceImpl(UserRepo repo) {
        super();
        this.repo = repo;
    }

    @Override
    public User addUser(User user) {
        // TODO Auto-generated method stub
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    @Override
    public User getByUsername(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MyToken userLogin(User user) {
        // TODO Auto-generated method stub

        User storedUser = repo.findByUsername(user.getUsername()).orElseThrow(()->new RuntimeException("User not found!"));

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(user.getPassword(), storedUser.getPassword())) {
            return TokenUtil.encode(storedUser);
        }
        throw new RuntimeException("Unauthorized user");
    }

}