package br.com.curso.clean_arch.infrastructure.bean.store;

import br.com.curso.clean_arch.application.gateway.store.StoreGateway;
import br.com.curso.clean_arch.application.usecase.store.contract.CreateStoreUseCase;
import br.com.curso.clean_arch.application.usecase.store.impl.CreateStoreUseCaseImpl;
import br.com.curso.clean_arch.infrastructure.gateway.StoreGatewayImpl;
import br.com.curso.clean_arch.infrastructure.mappers.store.StoreEntityMapper;
import br.com.curso.clean_arch.infrastructure.persistence.repository.StoreRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreBeanConfiguration {

    @Bean
    public StoreGateway storeGateway(StoreRepository repository, StoreEntityMapper mapper){
        return new StoreGatewayImpl(repository, mapper);
    }

    @Bean
    public CreateStoreUseCase createStoreUseCase(StoreGateway storeGateway) {
        return new CreateStoreUseCaseImpl(storeGateway);
    }
}
