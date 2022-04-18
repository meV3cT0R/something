package com.vector.app.repository;

import com.vector.app.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer>{
    User findByUserNameAndPassword(String userName,String password);

    @Query(value="SELECT * FROM user WHERE user_name= :username AND password= :password",nativeQuery=true)
    User login(@Param("username") String username,@Param("password") String password);
}
