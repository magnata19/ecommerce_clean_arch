package br.com.curso.clean_arch.core.entitites;

import java.time.LocalDateTime;

public record Store(
  Long id,
  String name,
  String description,
  String cnpj,
  Long owner,
  LocalDateTime createdAt,
  LocalDateTime updatedAt
) {

}
