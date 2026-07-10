package com.authentication.jwt_oauth.repo;

import java.util.Optional;

import com.authentication.jwt_oauth.model.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepo extends ListCrudRepository<User, Integer>{

    Optional<User> findByUsername(String username);
}
