package br.com.curso.clean_arch.infrastructure.gateway;

import br.com.curso.clean_arch.application.gateway.user.UserGateway;
import br.com.curso.clean_arch.core.entitites.User;
import br.com.curso.clean_arch.infrastructure.exception.EntityAlreayExists;
import br.com.curso.clean_arch.infrastructure.exception.EntityNotFoundException;
import br.com.curso.clean_arch.infrastructure.mappers.user.UserEntityMapper;
import br.com.curso.clean_arch.infrastructure.persistence.model.UserEntity;
import br.com.curso.clean_arch.infrastructure.persistence.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserGatewayImpl implements UserGateway {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final PasswordEncoder encoder;

    public UserGatewayImpl(UserRepository userRepository, UserEntityMapper userEntityMapper, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
        this.encoder = encoder;
    }

    @Override
    public User create(User user) {
        UserEntity entity = userEntityMapper.toEntity(user);
        entity.setPassword(encoder.encode(entity.getPassword()));
        UserEntity saved = userRepository.save(entity);
        return userEntityMapper.toDomain(saved);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .map(userEntityMapper::toDomain)
                .orElseThrow(() -> new EntityNotFoundException("Usuario com id %d não encontrado.".formatted(id)));
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
