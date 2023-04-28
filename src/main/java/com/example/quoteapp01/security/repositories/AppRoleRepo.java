package com.example.quoteapp01.security.repositories;

import com.example.quoteapp01.security.entites.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepo extends JpaRepository<AppRole,Long> {
    AppRole findByRoleName(String roleName);
}
