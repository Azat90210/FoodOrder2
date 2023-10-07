package com.example.shaurma.repositories;

import com.example.shaurma.models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);



}
