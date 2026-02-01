package br.com.curso.clean_arch.infrastructure.mappers;

import br.com.curso.clean_arch.core.entitites.User;
import br.com.curso.clean_arch.infrastructure.persistence.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public User toDomain(UserEntity userEntity){
        return new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getRole(),
                userEntity.getCreatedAt(),
                userEntity.getUpdatedAt()
        );
    }

    public UserEntity toEntity(User user){
        return UserEntity.builder()
                .id(user.id())
                .name(user.name())
                .email(user.email())
                .password(user.password())
                .role(user.role())
                .createdAt(user.createdAt())
                .updatedAt(user.updatedAt())
                .build();
    }
}
