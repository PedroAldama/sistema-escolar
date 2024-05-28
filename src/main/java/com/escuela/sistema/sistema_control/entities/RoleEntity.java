package com.escuela.sistema.sistema_control.entities;

import com.escuela.sistema.sistema_control.role.PermissionEntity;
import com.escuela.sistema.sistema_control.role.RoleEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="role_name")
    private RoleEnum roleEnum;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "role_permission"
            ,joinColumns = @JoinColumn(name = "role_id")
            ,inverseJoinColumns = @JoinColumn(name="permission_id"))
    private Set<PermissionEntity> permissionList = new HashSet<>();
}
