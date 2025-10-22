package com.example.EventManagement.repository;

import com.example.EventManagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {
    List<Role> findByRoleNameContainingIgnoreCase(String roleName);
    Optional<Role> findByRoleName(String roleName);
}
