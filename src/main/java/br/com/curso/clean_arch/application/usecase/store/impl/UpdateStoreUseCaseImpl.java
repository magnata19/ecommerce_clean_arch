package br.com.curso.clean_arch.application.usecase.store.impl;

import br.com.curso.clean_arch.application.gateway.store.StoreGateway;
import br.com.curso.clean_arch.application.usecase.store.contract.UpdateStoreUseCase;
import br.com.curso.clean_arch.core.entitites.Store;

public class UpdateStoreUseCaseImpl implements UpdateStoreUseCase {

    private final StoreGateway storeGateway;

    public UpdateStoreUseCaseImpl(StoreGateway storeGateway) {
        this.storeGateway = storeGateway;
    }

    @Override
    public Store execute(Store store) {
        Store existingStore = storeGateway.findById(store.id());
        if(existingStore == null) {
            throw new IllegalArgumentException("Loja com id %d não encontrada.".formatted(store.id()));
        }
        return storeGateway.update(new Store(
                existingStore.id(),
                store.name(),
                store.description(),
                store.cnpj(),
                existingStore.ownerId(),
                existingStore.createdAt(),
                existingStore.updatedAt()
        ));
    }
}
