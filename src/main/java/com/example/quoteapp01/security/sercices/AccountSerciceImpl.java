package com.example.quoteapp01.security.sercices;

import com.example.quoteapp01.security.entites.AppRole;
import com.example.quoteapp01.security.entites.AppUSer;
import com.example.quoteapp01.security.repositories.AppRoleRepo;
import com.example.quoteapp01.security.repositories.AppUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AccountSerciceImpl implements AccountSercice {
    public AccountSerciceImpl(AppUserRepo userRepo, AppRoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    private AppUserRepo userRepo;
    private AppRoleRepo roleRepo;
    @Override
    public AppUSer addNewUser(AppUSer appUSer) {
        return this.userRepo.save(appUSer);
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return roleRepo.save(appRole);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        AppUSer uSer=userRepo.findByUserName(userName);
        AppRole role=roleRepo.findByRoleName(roleName);
        uSer.getAppRoles().add(role);
    }

    @Override
    public AppUSer loadUserByUSerName(String userName) {
        return userRepo.findByUserName(userName);
    }

    @Override
    public List<AppUSer> listUsers() {
        return userRepo.findAll();
    }

    @Override
    public List<AppRole> listRoles() {
        return roleRepo.findAll();
    }
}
