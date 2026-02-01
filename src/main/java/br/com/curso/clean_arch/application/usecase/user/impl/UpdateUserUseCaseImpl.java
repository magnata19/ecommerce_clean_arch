package br.com.curso.clean_arch.application.usecase.user.impl;

import br.com.curso.clean_arch.application.gateway.user.UserGateway;
import br.com.curso.clean_arch.application.usecase.user.contract.UpdateUserUseCase;
import br.com.curso.clean_arch.core.entitites.User;

import java.time.LocalDateTime;

public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    private final UserGateway userGateway;

    public UpdateUserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(Long id, User user) {
        User userFounded = userGateway.findById(id);
        if(userFounded == null) {
            throw new IllegalArgumentException("Usuario não encontrado.");
        }
        return userGateway.update(new User(
                userFounded.id(),
                user.name(),
                user.email(),
                user.password(),
                user.role(),
                userFounded.createdAt(),
                LocalDateTime.now()
        ));
    }
}
