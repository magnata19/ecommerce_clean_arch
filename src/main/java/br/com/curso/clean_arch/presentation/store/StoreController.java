package br.com.curso.clean_arch.presentation.store;

import br.com.curso.clean_arch.application.gateway.store.StoreGateway;
import br.com.curso.clean_arch.application.usecase.store.contract.CreateStoreUseCase;
import br.com.curso.clean_arch.core.entitites.Store;
import br.com.curso.clean_arch.infrastructure.dtos.store.CreateStoreRequest;
import br.com.curso.clean_arch.infrastructure.mappers.store.StoreCreateMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/stores")
public class StoreController {

    private final CreateStoreUseCase createStoreUseCase;
    private final StoreCreateMapper storeCreateMapper;

    public StoreController(CreateStoreUseCase createStoreUseCase,
                           StoreCreateMapper storeCreateMapper
    ) {
        this.createStoreUseCase = createStoreUseCase;
        this.storeCreateMapper = storeCreateMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody CreateStoreRequest store){
        Store execute = createStoreUseCase.execute(storeCreateMapper.toDomain(store));
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem: ", "Loja criada com sucesso!");
        response.put("Loja: ", execute);
        return ResponseEntity.ok(response);
    }
}
