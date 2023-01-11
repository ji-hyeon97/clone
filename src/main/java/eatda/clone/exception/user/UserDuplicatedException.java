package eatda.clone.exception.user;

import eatda.clone.exception.EatDaException;
import eatda.clone.exception.Message;
import org.springframework.http.HttpStatus;

public class UserDuplicatedException extends EatDaException {
    public UserDuplicatedException(){
        super(HttpStatus.BAD_REQUEST, Message.USER_DUPLICATED);
    }

}
