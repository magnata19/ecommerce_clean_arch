package br.com.curso.clean_arch.infrastructure.config;

import br.com.curso.clean_arch.infrastructure.exception.EntityNotFoundException;
import br.com.curso.clean_arch.infrastructure.persistence.model.UserEntity;
import br.com.curso.clean_arch.infrastructure.persistence.repository.UserRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    public SecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String email) throws UsernameNotFoundException {
        UserEntity userDetails = userRepository.findUserByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("Usuario com email %s não encontrado.".formatted(email)));
        return new JwtUserDetails(userDetails);
    }
}
