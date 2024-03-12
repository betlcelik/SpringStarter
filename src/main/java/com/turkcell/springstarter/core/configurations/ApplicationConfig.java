package com.turkcell.springstarter.core.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
public class ApplicationConfig {

    //dil evirilerini hangi kaynaktan alacak
    @Bean //ne zaman turda bir interface istense benim yazdığım metoto içeriisnde geri dönen instancebunu çalıştırsın
    public ResourceBundleMessageSource bundleMessageSource(){

        ResourceBundleMessageSource source= new ResourceBundleMessageSource();
        source.setBasename("messages"); //messages.properties dosyasından okuduk
        return source;
    }
    //kullanıcında dil tercşhlerini nerden alıcak

    @Bean
    public LocaleResolver localeResolver() {
        //dili anlamak için
        AcceptHeaderLocaleResolver acceptHeaderLocaleResolver=new AcceptHeaderLocaleResolver();
        acceptHeaderLocaleResolver.setDefaultLocale(new Locale("tr"));
        return acceptHeaderLocaleResolver;
    }
}
