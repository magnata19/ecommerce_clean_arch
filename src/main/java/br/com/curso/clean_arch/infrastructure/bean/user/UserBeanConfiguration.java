package br.com.curso.clean_arch.infrastructure.bean.user;

import br.com.curso.clean_arch.application.gateway.user.UserGateway;
import br.com.curso.clean_arch.application.usecase.user.contract.CreateUserUseCase;
import br.com.curso.clean_arch.application.usecase.user.contract.DeleteUserUseCase;
import br.com.curso.clean_arch.application.usecase.user.contract.FindUserByIdUseCase;
import br.com.curso.clean_arch.application.usecase.user.contract.UpdateUserUseCase;
import br.com.curso.clean_arch.application.usecase.user.impl.CreateUserUseCaseImpl;
import br.com.curso.clean_arch.application.usecase.user.impl.DeleteUserUseCaseImpl;
import br.com.curso.clean_arch.application.usecase.user.impl.FindUserByIdUseCaseImpl;
import br.com.curso.clean_arch.application.usecase.user.impl.UpdateUserUseCaseImpl;
import br.com.curso.clean_arch.infrastructure.gateway.UserGatewayImpl;
import br.com.curso.clean_arch.infrastructure.mappers.user.UserEntityMapper;
import br.com.curso.clean_arch.infrastructure.persistence.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBeanConfiguration {

    @Bean
    public UserGateway userGateway(UserRepository userRepository, UserEntityMapper userEntityMapper){
        return new UserGatewayImpl(userRepository, userEntityMapper);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(UserGateway userGateway){
        return new CreateUserUseCaseImpl(userGateway);
    }

    @Bean
    public UpdateUserUseCase updateUserUseCase(UserGateway userGateway){
        return new UpdateUserUseCaseImpl(userGateway);
    }

    @Bean
    public FindUserByIdUseCase findUserByIdUseCase(UserGateway userGateway){
        return new FindUserByIdUseCaseImpl(userGateway);
    }

    @Bean
    public DeleteUserUseCase deleteUserUseCase(UserGateway userGateway){
        return new DeleteUserUseCaseImpl(userGateway);
    }

}
