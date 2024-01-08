package com.tlacuano.springsecurity.controller.user.dtos;

import com.tlacuano.springsecurity.model.role.BeanRole;
import com.tlacuano.springsecurity.model.user.BeanUser;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestSaveUser {
    private BeanUser user;
    private int idRoles[];
}
