package ru.learnUp.springboot.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
    public class ConfigSBoot {

        @Bean
        public MessageSource messageSource() {
            ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
            messageSource.setBasenames("text");
            messageSource.setDefaultEncoding("UTF-8");
            return messageSource;
        }
}
