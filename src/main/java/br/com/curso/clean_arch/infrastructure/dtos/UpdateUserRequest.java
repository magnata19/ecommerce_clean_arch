package br.com.curso.clean_arch.infrastructure.dtos;

import br.com.curso.clean_arch.core.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateUserRequest (
        @NotNull(message = "O campo nome é obrigatório.")
        @Size(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres.")
        String name,

        @NotNull(message = "O campo email é obrigatório.")
        @Size(min = 5, max = 100, message = "O campo email deve ter entre 5 e 100 caracteres.")
        @Email(message = "O campo email deve ser um email válido.")
        String email,

        @NotNull(message = "O campo senha é obrigatório.")
        @Size(min = 6, max = 50, message = "O campo senha deve ter entre 6 e 50 caracteres.")
        String password,
        UserRole role
){
}
