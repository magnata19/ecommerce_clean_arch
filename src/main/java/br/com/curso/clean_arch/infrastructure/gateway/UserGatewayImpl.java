package br.com.curso.clean_arch.infrastructure.gateway;

import br.com.curso.clean_arch.application.gateway.user.UserGateway;
import br.com.curso.clean_arch.core.entitites.User;
import br.com.curso.clean_arch.core.enums.UserRole;
import br.com.curso.clean_arch.infrastructure.mappers.UserEntityMapper;
import br.com.curso.clean_arch.infrastructure.persistence.model.UserEntity;
import br.com.curso.clean_arch.infrastructure.persistence.repository.UserRepository;

import java.util.Optional;

public class UserGatewayImpl implements UserGateway {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserGatewayImpl(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User create(User user) {
        UserEntity userSaved = userRepository.save(userEntityMapper.toEntity(user));
        return userEntityMapper.toDomain(userSaved);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .map(userEntityMapper::toDomain)
                .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado."));
    }

    @Override
    public User update(User user) {
        return userEntityMapper.toDomain(userRepository.save(userEntityMapper.toEntity(user)));
    }

    @Override
    public void delete(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new IllegalArgumentException("Usuario não encontrado.");
        }
        userRepository.deleteById(id);
    }
}
