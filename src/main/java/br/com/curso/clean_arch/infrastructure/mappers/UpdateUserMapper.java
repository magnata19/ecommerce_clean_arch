package br.com.curso.clean_arch.infrastructure.mappers;

import br.com.curso.clean_arch.core.entitites.User;
import br.com.curso.clean_arch.infrastructure.dtos.user.UpdateUserRequest;
import br.com.curso.clean_arch.infrastructure.dtos.user.UserResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UpdateUserMapper {

    public UserResponse toDto(User user){
        return new UserResponse(
                user.id(),
                user.name(),
                user.email(),
                user.role(),
                user.createdAt(),
                user.updatedAt()
        );
    }

    public User toDomain(UpdateUserRequest dto) {
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

    public User merge (User currentUser, UpdateUserRequest dto) {
        return new User(
                currentUser.id(),
                dto.name(),
                dto.email(),
                dto.password(),
                dto.role(),
                currentUser.createdAt(),
                LocalDateTime.now()
        );
    }
}
