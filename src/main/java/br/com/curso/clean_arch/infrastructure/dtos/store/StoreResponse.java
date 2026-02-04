package br.com.curso.clean_arch.infrastructure.dtos.store;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record StoreResponse (
        Long id,
        String name,
        String description,
        String cnpj,
        Long ownerId,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime createdAt,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime updatedAt
){
}
