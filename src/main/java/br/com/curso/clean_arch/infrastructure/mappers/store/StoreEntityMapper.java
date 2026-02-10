package br.com.curso.clean_arch.infrastructure.mappers.store;

import br.com.curso.clean_arch.core.entitites.Store;
import br.com.curso.clean_arch.infrastructure.persistence.model.StoreEntity;
import br.com.curso.clean_arch.infrastructure.persistence.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class StoreEntityMapper {

    public Store toDomain(StoreEntity entity){
        return new Store(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getCnpj(),
                entity.getOwner().getId(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public StoreEntity toEntity(Store store) {
        return StoreEntity.builder()
                .id(store.id())
                .name(store.name())
                .description(store.description())
                .cnpj(store.cnpj())
                .owner(UserEntity.builder().id(store.owner()).build())
                .createdAt(store.createdAt())
                .updatedAt(store.updatedAt())
                .build();
    }
}
