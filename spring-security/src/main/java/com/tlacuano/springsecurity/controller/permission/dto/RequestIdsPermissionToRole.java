package com.tlacuano.springsecurity.controller.permission.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestIdsPermissionToRole {
    private Long idRole;
    private Long idPermission;
}
