package br.com.curso.clean_arch.infrastructure.exception;

public class EntityAlreayExists extends RuntimeException{
    public EntityAlreayExists(String message) {
        super(message);
    }
}
