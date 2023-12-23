package com.tlacuano.springsecurity.model.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<BeanRole, Long> {
}
