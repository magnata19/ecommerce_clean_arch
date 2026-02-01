package br.com.curso.clean_arch.application.usecase.user.impl;

import br.com.curso.clean_arch.application.gateway.user.UserGateway;
import br.com.curso.clean_arch.application.usecase.user.contract.DeleteUserUseCase;
import br.com.curso.clean_arch.core.entitites.User;

public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final UserGateway userGateway;

    public DeleteUserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public void execute(Long id) {
        User user = userGateway.findById(id);
        if(user == null) {
            throw new IllegalArgumentException("Usuario não encontrado.");
        }
        userGateway.delete(id);
    }
}
