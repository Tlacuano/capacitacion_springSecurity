package com.tlacuano.springsecurity.controller.role;

import com.tlacuano.springsecurity.model.role.BeanRole;
import com.tlacuano.springsecurity.service.role.RoleService;
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
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*")
public class RoleController {

    @Autowired
    private RoleService service;

    //find by id
    @PostMapping("/findRoleById")
    public ResponseEntity<CustomReponse<BeanRole>> findRoleById(@RequestBody Long id) {
        return ResponseEntity.ok(service.findRoleById(id));
    }

    //find all
    @PostMapping("/findAllRoles")
    public ResponseEntity<CustomReponse<List<BeanRole>>> findAllRoles() {
        return ResponseEntity.ok(service.findAllRoles());
    }

    //save
    @PostMapping("/saveRole")
    public ResponseEntity<CustomReponse<BeanRole>> saveRole(@RequestBody BeanRole role) {
        return ResponseEntity.ok(service.saveRole(role));
    }

    //delete
    @PostMapping("/deleteRoleById")
    public ResponseEntity<CustomReponse<String>> deleteRoleById(@RequestBody Long id) {
        return ResponseEntity.ok(service.deleteRoleById(id));
    }

    //update
    @PostMapping("/updateRole")
    public ResponseEntity<CustomReponse<BeanRole>> updateRole(@RequestBody BeanRole role) {
        return ResponseEntity.ok(service.updateRole(role));
    }
}
