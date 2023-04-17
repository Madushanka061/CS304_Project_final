package com.example.tutorial01.repo;

import com.example.tutorial01.entity.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceProviderRepo extends JpaRepository<ServiceProvider,Integer> {
}
