package br.com.curso.clean_arch.infrastructure.dtos.user;

import jakarta.validation.constraints.NotNull;

public record LoginRequest(
        @NotNull(message = "Email é obrigatório.")
        String email,

        @NotNull(message = "Senha é obrigatória.")
        String password
) {
}
