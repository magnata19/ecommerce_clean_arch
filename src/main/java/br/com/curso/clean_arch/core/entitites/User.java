package br.com.curso.clean_arch.core.entitites;

import br.com.curso.clean_arch.core.enums.UserRole;

import java.time.LocalDateTime;

public record User (
        Long id,
        String name,
        String email,
        String password,
        UserRole role,
        LocalDateTime createdAt,
        LocalDateTime updatedAt){

    public User withDefaultRoles() {
        return role == null ?
                new User(id,
                        name,
                        email,
                        password,
                        UserRole.CUSTOMER,
                        LocalDateTime.now(),
                        updatedAt) : this;
    }
}
