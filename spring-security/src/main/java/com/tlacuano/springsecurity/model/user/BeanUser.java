package com.tlacuano.springsecurity.model.user;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.tlacuano.springsecurity.model.role.BeanRole;
import com.tlacuano.springsecurity.model.user_roles.BeanUserRoles;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class BeanUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    //one to one con rol
    @OneToMany(mappedBy = "user")
    private List<BeanUserRoles> roles;

}
