package br.com.curso.clean_arch.infrastructure.config;

import lombok.Builder;

@Builder
public record JWTUserData(
        Long userId,
        String email
) {
}
