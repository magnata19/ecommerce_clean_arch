package br.com.curso.clean_arch.infrastructure.persistence.repository;

import br.com.curso.clean_arch.infrastructure.persistence.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserByEmail(String email);
}
