package ru.netology.QaExceptions;
public class AlreadyExistsException extends RuntimeException {

    public  AlreadyExistsException (String msg) {
        super(msg);
    }

}
