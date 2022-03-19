package ru.learnUp.springboot.events;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.learnUp.springboot.Application;

import java.util.Locale;

@Component
public class EventListener implements ApplicationListener<Event>, ApplicationContextAware {

    private static volatile boolean find = false;

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public static synchronized boolean isFind() {
        return find;
    }

    @Override
    public void onApplicationEvent(Event event) {
        Locale locale = Application.locale;
        int desiredNumber = Application.desiredNumber;
        if (event.getInputNumber() < desiredNumber) {
            System.out.println(context.getMessage("moreMessage", null, locale));
        } else if (event.getInputNumber() > desiredNumber) {
            System.out.println(context.getMessage("lessMessage", null, locale));
        } else {
            System.out.println(context.getMessage("findMessage", new Object[]{desiredNumber}, locale));
            find = true;
        }
    }
}
