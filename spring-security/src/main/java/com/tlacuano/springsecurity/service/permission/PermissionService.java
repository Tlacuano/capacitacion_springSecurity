package com.tlacuano.springsecurity.service.permission;

import com.tlacuano.springsecurity.model.permission.BeanPermission;
import com.tlacuano.springsecurity.model.permission.PermissionRepository;
import com.tlacuano.springsecurity.utils.CustomReponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    //find by id
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<BeanPermission> findPermissionById(Long id) {
        BeanPermission permission = permissionRepository.findById(id).get();

        if(permission == null){
            return new CustomReponse<BeanPermission>(permission, "No se encontro el permiso", true, 404);
        }

        return new CustomReponse<BeanPermission>(permission, "Permiso encontrado", false, 200);
    }

    //find all
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<List<BeanPermission>> findAllPermissions() {
        List<BeanPermission> permissions = permissionRepository.findAll();

        if(permissions == null){
            return new CustomReponse<List<BeanPermission>>(permissions, "No se encontraron permisos", false, 200);
        }

        return new CustomReponse<List<BeanPermission>>(permissions, "Permisos encontrados", false, 200);
    }


}
