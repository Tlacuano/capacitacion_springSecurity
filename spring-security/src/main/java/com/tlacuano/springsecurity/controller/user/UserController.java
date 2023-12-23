package com.tlacuano.springsecurity.controller.user;

import com.tlacuano.springsecurity.controller.user.dtos.RequestSaveUser;
import com.tlacuano.springsecurity.model.user.BeanUser;
import com.tlacuano.springsecurity.service.user.UserService;
import com.tlacuano.springsecurity.utils.CustomReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService service;

    //find by id
    @PostMapping("/findUserByUsername")
    public ResponseEntity<CustomReponse<BeanUser>> findUserByUsername(@RequestBody BeanUser user) {
        return new ResponseEntity<>(service.findUserByUsername(user.getUsername()), HttpStatus.OK);
    }

    //find all
    @PostMapping("/findAllUsers")
    public ResponseEntity<CustomReponse<List<BeanUser>>> findAllUsers() {
        return new ResponseEntity<>(service.findAllUsers(), HttpStatus.OK);
    }

    //save
    @PostMapping("/saveUser")
    public ResponseEntity<CustomReponse<BeanUser>> saveUser(@RequestBody RequestSaveUser requestSaveUser) {
        BeanUser user = requestSaveUser.getUser();
        user.setRole(requestSaveUser.getRole());

        return new ResponseEntity<>(service.saveUser(user), HttpStatus.OK);
    }

    //delete
    @PostMapping("/deleteUserById")
    public ResponseEntity<CustomReponse<String>> deleteUserById(@RequestBody BeanUser user) {
        return new ResponseEntity<>(service.deleteUserById(user.getId()), HttpStatus.OK);
    }

    //update
    @PostMapping("/updateUser")
    public ResponseEntity<CustomReponse<BeanUser>> updateUser(@RequestBody BeanUser user) {
        return new ResponseEntity<>(service.updateUser(user), HttpStatus.OK);
    }
}
