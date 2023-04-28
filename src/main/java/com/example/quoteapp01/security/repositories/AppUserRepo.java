package com.example.quoteapp01.security.repositories;

import com.example.quoteapp01.security.entites.AppUSer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUSer,Long> {
    AppUSer findByUserName(String name);
}
