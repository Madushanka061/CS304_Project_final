package com.example.tutorial01.repo;

import com.example.tutorial01.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepo extends JpaRepository<Services,Integer> {

}
