package br.com.curso.clean_arch.infrastructure.persistence.repository;

import br.com.curso.clean_arch.infrastructure.persistence.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
