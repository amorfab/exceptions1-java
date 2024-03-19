package model.exceptions;

public class DomainException extends RuntimeException{
    // extends Exception obriga o tratamento da excecao

    public DomainException(String msg) {
        super(msg);
    }
}
