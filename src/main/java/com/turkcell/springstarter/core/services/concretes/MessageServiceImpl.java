package com.turkcell.springstarter.core.services.concretes;

import com.turkcell.springstarter.core.services.abstracts.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageSource messageSource;
    @Override
    public String getMessage(String key) {
        return messageSource.getMessage(key,null, LocaleContextHolder.getLocale());
    }

    @Override
    public String getMessageWithArguments(String key, Object... args) {
        return messageSource.getMessage(key,args,LocaleContextHolder.getLocale());
    }
}
