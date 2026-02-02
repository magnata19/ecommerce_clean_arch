package br.com.curso.clean_arch.application.usecase.store.impl;

import br.com.curso.clean_arch.application.gateway.store.StoreGateway;
import br.com.curso.clean_arch.application.usecase.store.contract.CreateStoreUseCase;
import br.com.curso.clean_arch.core.entitites.Store;

public class CreateStoreUseCaseImpl implements CreateStoreUseCase {

    private final StoreGateway storeGateway;

    public CreateStoreUseCaseImpl(StoreGateway storeGateway) {
        this.storeGateway = storeGateway;
    }

    @Override
    public Store execute(Store store) {
        return storeGateway.create(store);
    }
}
