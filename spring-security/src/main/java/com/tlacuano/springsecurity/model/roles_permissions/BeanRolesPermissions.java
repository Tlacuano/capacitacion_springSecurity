package com.tlacuano.springsecurity.model.roles_permissions;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tlacuano.springsecurity.model.permission.BeanPermission;
import com.tlacuano.springsecurity.model.role.BeanRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "roles_permissions")
@Entity
public class BeanRolesPermissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //many to one con roles
    @ManyToOne
    @JoinColumn(name = "id_role")
    @JsonIgnore
    @JsonIdentityReference(alwaysAsId = true)
    private BeanRole role;

    //many to one con permissions
    @ManyToOne
    @JoinColumn(name = "id_permission")
    @JsonIdentityReference(alwaysAsId = true)
    private BeanPermission permission;


}
