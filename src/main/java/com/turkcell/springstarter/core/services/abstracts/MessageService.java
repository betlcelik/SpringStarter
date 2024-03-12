package com.turkcell.springstarter.core.services.abstracts;

public interface MessageService {
    String getMessage(String key);
    String getMessageWithArguments(String key, Object... args);
}
