package com.tlacuano.springsecurity.model.role;


import com.fasterxml.jackson.annotation.*;
import com.tlacuano.springsecurity.model.permission.BeanPermission;
import com.tlacuano.springsecurity.model.roles_permissions.BeanRolesPermissions;
import com.tlacuano.springsecurity.model.user.BeanUser;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@Data
public class BeanRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    //one to many con roles_permissions
    @OneToMany(mappedBy = "role")
    private List<BeanRolesPermissions> rolesPermissions;


    //one to one con usuario
    @JsonIgnore
    @OneToOne(mappedBy = "role")
    private BeanUser user;
}
