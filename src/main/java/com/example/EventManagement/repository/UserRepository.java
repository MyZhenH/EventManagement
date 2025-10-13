package com.example.EventManagement.repository;

import com.example.EventManagement.entity.Role;
import com.example.EventManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    List<User> findByEmail(String email);
    boolean existsByEmail(String email);
    List<Role> findByRoleId(Long roleId);

}
