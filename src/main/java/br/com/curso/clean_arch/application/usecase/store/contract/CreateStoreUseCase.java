package br.com.curso.clean_arch.application.usecase.store.contract;

import br.com.curso.clean_arch.core.entitites.Store;

public interface CreateStoreUseCase {
    Store execute(Store store);
}
