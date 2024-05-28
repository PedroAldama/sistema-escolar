package com.escuela.sistema.sistema_control.repositories;

import com.escuela.sistema.sistema_control.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UsersEntity,Long> {

    Optional<UsersEntity> findUserEntityByUsername(String username);

}
