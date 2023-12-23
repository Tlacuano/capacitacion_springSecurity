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

    //save
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<BeanPermission> savePermission(BeanPermission permission) {
        BeanPermission permissionSaved = permissionRepository.saveAndFlush(permission);

        if(permissionSaved == null){
            return new CustomReponse<BeanPermission>(permissionSaved, "No se pudo guardar el permiso", true, 400);
        }

        return new CustomReponse<BeanPermission>(permissionSaved, "Permiso guardado", false, 200);
    }

    //delete
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<String> deletePermissionById(Long id) {
        permissionRepository.deleteById(id);
        return new CustomReponse<String>(null,"Permiso eliminado", false, 200);
    }

    //update
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<BeanPermission> updatePermission(BeanPermission permission) {
        BeanPermission permissionUpdated = permissionRepository.saveAndFlush(permission);
        return new CustomReponse<BeanPermission>(permissionUpdated, "Permiso actualizado", false, 200);
    }

    /*TABLA ROLES_PERMISSIONS*/
    //add permission to role
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<BeanPermission> addPermissionToRole(Long idRole, Long idPermission) {
       permissionRepository.saveRolePermission(idRole, idPermission);
         return new CustomReponse<BeanPermission>(null, "Permiso agregado al rol", false, 200);
    }

    //traer todos los permisos de un rol
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<List<BeanPermission>> findRolePermission(Long idRole) {
        List<BeanPermission> permissions = permissionRepository.findRolePermission(idRole);

        if(permissions == null){
            return new CustomReponse<List<BeanPermission>>(permissions, "No se encontraron permisos", false, 200);
        }

        return new CustomReponse<List<BeanPermission>>(permissions, "Permisos encontrados", false, 200);
    }

    //eliminar un permiso de un rol
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<BeanPermission> deleteRolePermission(Long idRole, Long idPermission) {
        permissionRepository.deleteRolePermission(idRole, idPermission);
        return new CustomReponse<BeanPermission>(null,"Permiso eliminado del rol", false, 200);
    }
}
