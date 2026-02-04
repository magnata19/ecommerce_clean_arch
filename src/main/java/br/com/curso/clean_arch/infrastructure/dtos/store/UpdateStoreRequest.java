package br.com.curso.clean_arch.infrastructure.dtos.store;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateStoreRequest(
        @NotBlank(message = "O campo nome não pode ser vazio.")
        @NotNull
        String name,
        @NotBlank(message = "O campo descrição não pode ser vazio.")
        @NotNull
        String description,
        @NotBlank(message = "O campo cnpj não pode ser vazio.")
        @NotNull
        String cnpj
){
}
