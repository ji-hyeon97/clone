package eatda.clone.exception.store;

import eatda.clone.exception.EatDaException;
import eatda.clone.exception.Message;
import org.springframework.http.HttpStatus;

public class StoreNotFoundException extends EatDaException {
    public StoreNotFoundException() {
        super(HttpStatus.NOT_FOUND, Message.STORE_NOT_FOUND);
    }
}
