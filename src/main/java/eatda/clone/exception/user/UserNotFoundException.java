package eatda.clone.exception.user;

import eatda.clone.exception.EatDaException;
import eatda.clone.exception.Message;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends EatDaException {
    public UserNotFoundException(){
        super(HttpStatus.NOT_FOUND, Message.USER_NOT_FOUND);
    }
}
