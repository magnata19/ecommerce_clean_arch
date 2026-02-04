package br.com.curso.clean_arch.infrastructure.mappers.store;

import br.com.curso.clean_arch.core.entitites.Store;
import br.com.curso.clean_arch.infrastructure.dtos.store.CreateStoreRequest;
import br.com.curso.clean_arch.infrastructure.dtos.store.StoreResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class StoreCreateMapper {

    public Store toDomain(CreateStoreRequest dto){
        return new Store(
                null,
                dto.name(),
                dto.description(),
                dto.cnpj(),
                null,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    public StoreResponse toDto(Store store) {
        return new StoreResponse(
                store.id(),
                store.name(),
                store.description(),
                store.cnpj(),
                store.owner() != null ? store.owner(): null,
                store.createdAt(),
                store.updatedAt()
        );
    }
}
