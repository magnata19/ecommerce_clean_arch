package br.com.curso.clean_arch.application.gateway.store;

import br.com.curso.clean_arch.core.entitites.Store;

public interface StoreGateway {
    Store create(Store store);
    Store findById(Long id);
    Store update (Store store);
    void delete(Long id);
}
