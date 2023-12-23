package com.tlacuano.springsecurity.model.role;


import com.tlacuano.springsecurity.model.permission.BeanPermission;
import com.tlacuano.springsecurity.model.user.BeanUser;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    //many to many con permisos
    @ManyToMany
    @JoinTable(
            name = "roles_permissions",
            joinColumns = @JoinColumn(name = "id_role"),
            inverseJoinColumns = @JoinColumn(name = "id_permission")
    )
    private Set<BeanPermission> permissions;

    //one to one con usuario
    @OneToOne(mappedBy = "role")
    private BeanUser user;
}
