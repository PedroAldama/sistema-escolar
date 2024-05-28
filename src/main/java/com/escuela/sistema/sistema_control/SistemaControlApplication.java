package com.escuela.sistema.sistema_control;

import com.escuela.sistema.sistema_control.entities.RoleEntity;
import com.escuela.sistema.sistema_control.entities.UsersEntity;
import com.escuela.sistema.sistema_control.repositories.UserRepository;
import com.escuela.sistema.sistema_control.role.PermissionEntity;
import com.escuela.sistema.sistema_control.role.RoleEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SistemaControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaControlApplication.class, args);
	}

	/*
	@Bean
	CommandLineRunner init(UserRepository userRepository){
		return args -> {
			//CREATE PERMISSION
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();
			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();
			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();
			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();
			PermissionEntity refactorPermission = PermissionEntity.builder()
					.name("REFACTOR")
					.build();

			//CREATE ROLES
			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(
							 createPermission
							,readPermission
							,updatePermission
							,deletePermission))
					.build();

			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permissionList(Set.of(
							 createPermission
							,readPermission))
					.build();

			RoleEntity roleInvited = RoleEntity.builder()
					.roleEnum(RoleEnum.INVITED)
					.permissionList(Set.of(readPermission))
					.build();

			RoleEntity roleDeveloper = RoleEntity.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permissionList(Set.of(
							 createPermission
							,readPermission
							,updatePermission
							,deletePermission
							,refactorPermission))
					.build();

			//Create USERS
			UsersEntity userPedro = UsersEntity.builder()
					.username("Pedro")
					.password("hikari359")
					.isEnable(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNonExpired(true)
					.roles(Set.of(roleDeveloper))
					.build();

			UsersEntity userAdmin = UsersEntity.builder()
					.username("Admin")
					.password("1234")
					.isEnable(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNonExpired(true)
					.roles(Set.of(roleAdmin))
					.build();

			UsersEntity userInvited = UsersEntity.builder()
					.username("Invited")
					.password("1234")
					.isEnable(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNonExpired(true)
					.roles(Set.of(roleInvited))
					.build();

			UsersEntity userUser = UsersEntity.builder()
					.username("User")
					.password("1234")
					.isEnable(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNonExpired(true)
					.roles(Set.of(roleUser))
					.build();

			userRepository.saveAll(List.of(userPedro,userAdmin,userUser,userInvited));
		};
	}*/
}
