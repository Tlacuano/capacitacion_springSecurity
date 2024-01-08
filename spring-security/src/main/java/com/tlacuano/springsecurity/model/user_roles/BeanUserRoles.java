package com.tlacuano.springsecurity.model.user_roles;


import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tlacuano.springsecurity.model.role.BeanRole;
import com.tlacuano.springsecurity.model.user.BeanUser;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "user_roles")
@Entity
@Data
@NoArgsConstructor
public class BeanUserRoles {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    //relacion muchos a uno con usuario
    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnore
    @JsonIdentityReference(alwaysAsId = true)
    private BeanUser user;

    // relacion muchos a uno con roles
    @ManyToOne
    @JoinColumn(name = "id_role")
    @JsonIdentityReference(alwaysAsId = true)
    private BeanRole role;
}
