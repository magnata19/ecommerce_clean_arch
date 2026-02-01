package br.com.curso.clean_arch.application.usecase.user.impl;

import br.com.curso.clean_arch.application.gateway.user.UserGateway;
import br.com.curso.clean_arch.application.usecase.user.contract.FindUserByIdUseCase;
import br.com.curso.clean_arch.core.entitites.User;

public class FindUserByIdUseCaseImpl implements FindUserByIdUseCase {

    private final UserGateway userGateway;

    public FindUserByIdUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(Long id) {
        User user = userGateway.findById(id);
        if(user == null) {
            throw new IllegalArgumentException("Usuario não encontrado.");
        }
        return user;
    }
}
