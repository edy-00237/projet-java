package com.example.quoteapp01.security.sercices;

import com.example.quoteapp01.security.entites.AppRole;
import com.example.quoteapp01.security.entites.AppUSer;

import java.util.List;

public interface AccountSercice {
    AppUSer addNewUser(AppUSer appUSer);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String userName,String roleName);
    AppUSer loadUserByUSerName(String userName);
    List<AppUSer> listUsers();
    List<AppRole> listRoles();
}
