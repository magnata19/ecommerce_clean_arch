package br.com.curso.clean_arch.infrastructure.mappers;

import br.com.curso.clean_arch.core.entitites.User;
import br.com.curso.clean_arch.infrastructure.dtos.CreateUserRequest;
import br.com.curso.clean_arch.infrastructure.dtos.UserResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserCreateMapper {

    public User toEntity(CreateUserRequest dto) {
        return new User(
                null,
                dto.name(),
                dto.email(),
                dto.password(),
                dto.role(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    public UserResponse toDto (User user) {
        return new UserResponse(
                user.id(),
                user.name(),
                user.email(),
                user.role(),
                user.createdAt(),
                user.updatedAt()
        );
    }

}
