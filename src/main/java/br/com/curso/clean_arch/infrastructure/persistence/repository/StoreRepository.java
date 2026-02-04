package br.com.curso.clean_arch.infrastructure.persistence.repository;

import br.com.curso.clean_arch.infrastructure.persistence.model.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<StoreEntity, Long> {
}
