package br.com.curso.clean_arch.application.usecase.user.impl;

import br.com.curso.clean_arch.application.gateway.user.UserGateway;
import br.com.curso.clean_arch.application.usecase.user.contract.CreateUserUseCase;
import br.com.curso.clean_arch.core.entitites.User;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserGateway userGateway;

    public CreateUserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(User user) {
        return userGateway.create(user.withDefaultRoles());
    }
}
