package br.com.store.exceptions;


public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(){
        super("Usuario não foi encontrado!");
    }

    public UserNotFoundException(String message){
        super(message);
    }
}
