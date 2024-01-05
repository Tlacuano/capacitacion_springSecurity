package com.tlacuano.springsecurity.model.permission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tlacuano.springsecurity.model.roles_permissions.BeanRolesPermissions;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "permissions")
@NoArgsConstructor
@Data
public class BeanPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    //One to many con roles_permissions
    @OneToMany(mappedBy = "permission")
    @JsonIgnore
    private Set<BeanRolesPermissions> rolesPermissions;

}
