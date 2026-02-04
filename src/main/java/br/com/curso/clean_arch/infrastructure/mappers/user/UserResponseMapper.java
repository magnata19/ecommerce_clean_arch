package br.com.curso.clean_arch.infrastructure.mappers.user;

import br.com.curso.clean_arch.core.entitites.User;
import br.com.curso.clean_arch.infrastructure.dtos.user.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper {

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

    public User toDomain(UserResponse dto) {
        return new User(
                dto.id(),
                dto.name(),
                dto.email(),
                null,
                dto.role(),
                dto.createdAt(),
                dto.updatedAt()
        );
    }
}
