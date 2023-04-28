package com.example.quoteapp01.security.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppUSer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    Collection<AppRole> appRoles= new ArrayList<>();
}
