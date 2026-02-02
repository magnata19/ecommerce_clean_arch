package br.com.curso.clean_arch.application.usecase.store.impl;

import br.com.curso.clean_arch.application.gateway.store.StoreGateway;
import br.com.curso.clean_arch.application.usecase.store.contract.DeleteStoreUseCase;
import br.com.curso.clean_arch.core.entitites.Store;

public class DeleteStoreUseCaseImpl implements DeleteStoreUseCase {

    private final StoreGateway storeGateway;

    public DeleteStoreUseCaseImpl(StoreGateway storeGateway) {
        this.storeGateway = storeGateway;
    }

    @Override
    public void execute(Long id) {
        Store existingStore = storeGateway.findById(id);
        if(existingStore == null) {
            throw new IllegalArgumentException("Loja com id %d não encontrada.".formatted(id));
        }
        storeGateway.delete(id);
    }
}
