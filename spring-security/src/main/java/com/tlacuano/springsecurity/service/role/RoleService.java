package com.tlacuano.springsecurity.service.role;

import com.tlacuano.springsecurity.model.role.BeanRole;
import com.tlacuano.springsecurity.model.role.RoleRepository;
import com.tlacuano.springsecurity.utils.CustomReponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    //find by id
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<BeanRole> findRoleById(Long id) {
        BeanRole role = roleRepository.findById(id).get();

        if(role == null){
            return new CustomReponse<BeanRole>(role, "No se encontro el rol", true, 404);
        }

        return new CustomReponse<BeanRole>(role, "Rol encontrado", false, 200);
    }

    //find all
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<List<BeanRole>> findAllRoles() {
        List<BeanRole> roles = roleRepository.findAll();

        if(roles == null){
            return new CustomReponse<List<BeanRole>>(roles, "No se encontraron roles", false, 200);
        }

        return new CustomReponse<List<BeanRole>>(roles, "Roles encontrados", false, 200);
    }

    //save
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<BeanRole> saveRole(BeanRole role) {
        BeanRole roleSaved = roleRepository.saveAndFlush(role);

        if(roleSaved == null){
            return new CustomReponse<BeanRole>(roleSaved, "No se pudo guardar el rol", true, 400);
        }

        return new CustomReponse<BeanRole>(roleSaved, "Rol guardado", false, 200);
    }

    //delete
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<String> deleteRoleById(Long id) {
        roleRepository.deleteById(id);
        return new CustomReponse<String>(null,"Rol eliminado", false, 200);
    }

    //update
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<BeanRole> updateRole(BeanRole role) {
        BeanRole roleUpdated = roleRepository.saveAndFlush(role);
        return new CustomReponse<BeanRole>(roleUpdated,"Rol actualizado", false, 200);
    }
}
