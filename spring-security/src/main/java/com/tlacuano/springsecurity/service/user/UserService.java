package com.tlacuano.springsecurity.service.user;

import com.tlacuano.springsecurity.model.user.BeanUser;
import com.tlacuano.springsecurity.model.user.UserRepository;
import com.tlacuano.springsecurity.utils.CustomReponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<BeanUser> findUserByUsername(String username) {
        BeanUser user = userRepository.findByUsername(username);
        return new CustomReponse<BeanUser>(user, "Usuario encontrado", false, 200);
    }

    //find all
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<List<BeanUser>> findAllUsers() {
        List<BeanUser> users = userRepository.findAll();

        if(users == null){
            return new CustomReponse<List<BeanUser>>(users, "No se encontraron usuarios", false, 200);
        }

        return new CustomReponse<List<BeanUser>>(users, "Usuarios encontrados", false, 200);
    }

    //save
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<BeanUser> saveUser(BeanUser user) {
        BeanUser userSaved = userRepository.saveAndFlush(user);

        if(userSaved == null){
            return new CustomReponse<BeanUser>(userSaved, "No se pudo guardar el usuario", true, 400);
        }

        return new CustomReponse<BeanUser>(userSaved, "Usuario guardado", false, 200);
    }

    //delete
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<String> deleteUserById(Long id) {
        userRepository.deleteById(id);
        return new CustomReponse<String>(null,"Usuario eliminado", false, 200);
    }

    //update
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<BeanUser> updateUser(BeanUser user) {
        BeanUser userUpdated = userRepository.saveAndFlush(user);

        if(userUpdated == null){
            return new CustomReponse<BeanUser>(userUpdated, "No se pudo actualizar el usuario", true, 400);
        }

        return new CustomReponse<BeanUser>(userUpdated, "Usuario actualizado", false, 200);
    }

    //register roles to user by id Role
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<BeanUser> registerRolesToUserByIdRole(Long idUser, Long idRole) {

        


        return null;
    }

}
