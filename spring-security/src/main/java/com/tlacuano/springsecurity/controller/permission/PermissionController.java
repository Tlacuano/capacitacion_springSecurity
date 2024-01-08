package com.tlacuano.springsecurity.controller.permission;

import com.tlacuano.springsecurity.controller.permission.dto.RequestIdsPermissionToRole;
import com.tlacuano.springsecurity.model.permission.BeanPermission;
import com.tlacuano.springsecurity.service.permission.PermissionService;
import com.tlacuano.springsecurity.utils.CustomReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/permission")
@CrossOrigin(origins = "*")
public class PermissionController {
    @Autowired
    private PermissionService service;

    //find by id
    @PostMapping("/findPermissionById")
    public ResponseEntity<CustomReponse<BeanPermission>> findPermissionById(@RequestBody Long id) {
        return ResponseEntity.ok(service.findPermissionById(id));
    }

    //find all
    @PostMapping("/findAllPermissions")
    public ResponseEntity<CustomReponse<List<BeanPermission>>> findAllPermissions() {
        return ResponseEntity.ok(service.findAllPermissions());
    }

}
