package com.tlacuano.springsecurity.model.permission;

import com.tlacuano.springsecurity.model.role.BeanRole;
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

    //many to many con roles
    @ManyToMany(mappedBy = "permissions")
    private Set<BeanRole> roles;

}
