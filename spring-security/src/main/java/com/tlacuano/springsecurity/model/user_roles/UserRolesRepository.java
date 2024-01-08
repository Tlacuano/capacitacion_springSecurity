package com.tlacuano.springsecurity.model.user_roles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepository extends JpaRepository<BeanUserRoles, Long> {
}
