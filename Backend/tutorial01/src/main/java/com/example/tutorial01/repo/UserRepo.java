package com.example.tutorial01.repo;

import com.example.tutorial01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer>{
    @Query(value = "SELECT * FROM user WHERE user_id =?1",nativeQuery = true)
    User getUserByUserId(int id);
}
