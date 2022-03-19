package ru.learnUp.springboot.events;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher implements ApplicationContextAware {

    private ApplicationContext context;

    public void publishEvent(int inputNumber) {
        context.publishEvent(new Event(inputNumber));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
