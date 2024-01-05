package com.tlacuano.springsecurity.model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<BeanUser, Long> {
    //findByUsername
    BeanUser findByUsername (String usernme);

    //find by username and password
    @Query(value = "SELECT * FROM users WHERE username = :username AND password = :password", nativeQuery = true)
    BeanUser findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
