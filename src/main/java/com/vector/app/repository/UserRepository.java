package com.vector.app.repository;

import com.vector.app.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{
    User findByUserNameAndPassword(String userName,String password);
}
