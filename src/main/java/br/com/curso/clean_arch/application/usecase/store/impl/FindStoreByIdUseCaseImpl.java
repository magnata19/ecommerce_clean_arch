package br.com.curso.clean_arch.application.usecase.store.impl;

import br.com.curso.clean_arch.application.gateway.store.StoreGateway;
import br.com.curso.clean_arch.application.usecase.store.contract.FindStoreByIdUseCase;
import br.com.curso.clean_arch.core.entitites.Store;

public class FindStoreByIdUseCaseImpl implements FindStoreByIdUseCase {

    private final StoreGateway storeGateway;

    public FindStoreByIdUseCaseImpl(StoreGateway storeGateway) {
        this.storeGateway = storeGateway;
    }

    @Override
    public Store execute(Long id) {
        Store existingStore = storeGateway.findById(id);
        if(existingStore == null) {
            throw new IllegalArgumentException("Loja com id %d não encontrada.".formatted(id));
        }
        return existingStore;
    }
}
