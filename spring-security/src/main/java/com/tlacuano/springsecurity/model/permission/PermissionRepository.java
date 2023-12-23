package com.tlacuano.springsecurity.model.permission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<BeanPermission, Long> {
    //tabla intermedia
    //guardar permiso y rol en tabla intermedia
    @Query(value = "INSERT INTO roles_permissions (id_role, id_permission) VALUES (:idRole, :idPermission)", nativeQuery = true)
    void saveRolePermission(@Param("idRole") Long idRole, @Param("idPermission") Long idPermission);

    //traer permisos de un rol
    @Query(value = "SELECT p.* FROM permissions p JOIN roles_permissions rp ON p.id = rp.id_permission WHERE rp.id_role = :idRole", nativeQuery = true)
    List<BeanPermission> findRolePermission(@Param("idRole") Long idRole);

    //eliminar un permiso de un rol
    @Query(value = "DELETE FROM roles_permissions WHERE id_role = :idRole AND id_permission = :idPermission", nativeQuery = true)
    void deleteRolePermission(@Param("idRole") Long idRole, @Param("idPermission") Long idPermission);
}
