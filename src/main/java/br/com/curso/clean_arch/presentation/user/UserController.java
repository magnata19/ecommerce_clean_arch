package br.com.curso.clean_arch.presentation.user;

import br.com.curso.clean_arch.application.usecase.user.contract.CreateUserUseCase;
import br.com.curso.clean_arch.application.usecase.user.contract.DeleteUserUseCase;
import br.com.curso.clean_arch.application.usecase.user.contract.FindUserByIdUseCase;
import br.com.curso.clean_arch.application.usecase.user.contract.UpdateUserUseCase;
import br.com.curso.clean_arch.core.entitites.User;
import br.com.curso.clean_arch.infrastructure.dtos.user.CreateUserRequest;
import br.com.curso.clean_arch.infrastructure.dtos.user.UpdateUserRequest;
import br.com.curso.clean_arch.infrastructure.dtos.user.UserResponse;
import br.com.curso.clean_arch.infrastructure.mappers.user.UpdateUserMapper;
import br.com.curso.clean_arch.infrastructure.mappers.user.UserCreateMapper;
import br.com.curso.clean_arch.infrastructure.mappers.user.UserResponseMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserCreateMapper userCreateMapper;
    private final UpdateUserMapper updateUserMapper;
    private final UserResponseMapper userResponseMapper;
    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody CreateUserRequest dto) {
        User user = createUserUseCase.execute(userCreateMapper.toEntity(dto));
        Map<String, Object> response = new HashMap<>();
        response.put("message: ", "Usuário criado com sucesso!");
        response.put("user: ", userCreateMapper.toDto(user));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody UpdateUserRequest dto, @PathVariable Long id) {
        User user = updateUserUseCase.execute(id, updateUserMapper.toDomain(dto));
        Map<String, Object> response = new HashMap<>();
        response.put("message: ", "Usuário atualizado com sucesso!");
        response.put("user: ", updateUserMapper.toDto(user));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        User user = findUserByIdUseCase.execute(id);
        return ResponseEntity.ok(userResponseMapper.toDto(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        deleteUserUseCase.execute(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuário deletado com sucesso!");
        return ResponseEntity.ok(response);
    }
}
