package com.tlacuano.springsecurity.model.roles_permissions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesPermissionsRepository extends JpaRepository<BeanRolesPermissions, Long> {
}
