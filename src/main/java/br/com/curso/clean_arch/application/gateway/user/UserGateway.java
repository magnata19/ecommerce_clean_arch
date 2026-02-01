package br.com.curso.clean_arch.application.gateway.user;

import br.com.curso.clean_arch.core.entitites.User;

public interface UserGateway {
    User create(User user);
    User findById(Long id);
    User update(User user);
    void delete(Long id);
}
