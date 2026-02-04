package br.com.curso.clean_arch.infrastructure.gateway;

import br.com.curso.clean_arch.application.gateway.store.StoreGateway;
import br.com.curso.clean_arch.core.entitites.Store;
import br.com.curso.clean_arch.infrastructure.exception.EntityNotFoundException;
import br.com.curso.clean_arch.infrastructure.mappers.store.StoreEntityMapper;
import br.com.curso.clean_arch.infrastructure.persistence.model.StoreEntity;
import br.com.curso.clean_arch.infrastructure.persistence.repository.StoreRepository;

public class StoreGatewayImpl implements StoreGateway {

    private final StoreRepository storeRepository;
    private final StoreEntityMapper storeEntityMapper;

    public StoreGatewayImpl(StoreRepository storeRepository,
                            StoreEntityMapper storeEntityMapper) {
        this.storeRepository = storeRepository;
        this.storeEntityMapper = storeEntityMapper;
    }

    @Override
    public Store create(Store store) {
        StoreEntity savedStore = storeRepository.save(storeEntityMapper.toEntity(store));
        return storeEntityMapper.toDomain(savedStore);
    }

    @Override
    public Store findById(Long id) {
        return storeRepository.findById(id)
                .map(storeEntityMapper::toDomain)
                .orElseThrow(() -> new EntityNotFoundException("Loja com id %d não encontrada.".formatted(id)));
    }

    @Override
    public Store update(Store store) {
        return null;
    }

    @Override
    public void delete(Long id) {
        StoreEntity store = storeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Loja não encontrada."));
        storeRepository.deleteById(store.getId());
    }
}
