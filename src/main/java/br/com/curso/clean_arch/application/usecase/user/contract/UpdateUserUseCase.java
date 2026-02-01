package br.com.curso.clean_arch.application.usecase.user.contract;

import br.com.curso.clean_arch.core.entitites.User;

public interface UpdateUserUseCase {
    User execute(Long id, User user);
}
