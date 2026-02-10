package br.com.curso.clean_arch.infrastructure.config;

import br.com.curso.clean_arch.infrastructure.persistence.model.UserEntity;
import lombok.Getter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

@Getter
public class JwtUserDetails extends User {

    private final UserEntity userEntity;

    public JwtUserDetails(UserEntity userEntity) {
        super(userEntity.getEmail(), userEntity.getPassword(), AuthorityUtils.createAuthorityList(userEntity.getRole().name()));
        this.userEntity = userEntity;
    }

    public Long getId(){
        return userEntity.getId();
    }

    public String getEmail(){
        return userEntity.getEmail();
    }
}
