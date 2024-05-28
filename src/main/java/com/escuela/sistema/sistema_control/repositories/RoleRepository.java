package com.escuela.sistema.sistema_control.repositories;

import com.escuela.sistema.sistema_control.entities.RoleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface RoleRepository extends CrudRepository<RoleEntity,Long> {

    Set<RoleEntity> findRoleEntitiesByRoleEnumIn(Set<String> roleNames);
}
