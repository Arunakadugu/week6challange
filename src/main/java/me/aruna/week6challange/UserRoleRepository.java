package me.aruna.week6challange;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface UserRoleRepository extends CrudRepository<UserRole,Long> {
    UserRole findByRole(String role);

}