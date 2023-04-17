package com.example.tutorial01.repo;

import com.example.tutorial01.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@EnableJpaRepositories
@Repository
public interface LoginRepo extends JpaRepository<Login,Integer> {

    @Query("select l from Login l WHERE l.email = ?1")
    Login validateEmail1(String email);


    @Query(value = "SELECT * FROM login_table WHERE login_id =?1",nativeQuery = true)
    Login getLoginDetailsById(int id);

    @Query(value = "SELECT * FROM login_table WHERE user_id =?1",nativeQuery = true)
    Login getLoginDetailsByUserId(int id);

    @Query(value = "SELECT * FROM login_table WHERE email =?1",nativeQuery = true)
    Login getDetailsByEmail(String userEmail);

    @Query(value = "SELECT * FROM login_table WHERE email=?1 AND password=?2 LIMIT 1", nativeQuery = true)
    Login login(String email, String pw);
}
