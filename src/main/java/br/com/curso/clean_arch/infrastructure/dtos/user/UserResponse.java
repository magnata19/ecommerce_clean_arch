package br.com.curso.clean_arch.infrastructure.dtos.user;

import br.com.curso.clean_arch.core.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record UserResponse (
        Long id,
        String name,
        String email,
        UserRole role,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime createdAt,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime updatedAt
){
}
