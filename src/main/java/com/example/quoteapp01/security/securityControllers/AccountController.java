package com.example.quoteapp01.security.securityControllers;

import com.example.quoteapp01.security.entites.AppRole;
import com.example.quoteapp01.security.entites.AppUSer;
import com.example.quoteapp01.security.sercices.AccountSerciceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    private AccountSerciceImpl accountSercice;

    public AccountController(AccountSerciceImpl accountSercice) {
        this.accountSercice = accountSercice;
    }
    @GetMapping("/users")
    public List<AppUSer> appUSerList(){
        return accountSercice.listUsers();
    }
    @GetMapping("/roles")
    public List<AppRole> appRoleList(){
        return accountSercice.listRoles();
    }


}
