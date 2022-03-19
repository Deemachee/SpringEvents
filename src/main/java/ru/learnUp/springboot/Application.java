package ru.learnUp.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnUp.springboot.events.EventListener;
import ru.learnUp.springboot.events.EventPublisher;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class Application {

    public final static Locale locale = Locale.getDefault();

    public final static int desiredNumber = (int) (Math.random() * 1000);

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        EventPublisher publisher = context.getBean(EventPublisher.class);

        Scanner scanner = new Scanner(System.in);
        int inputNumber;
        System.out.println(context.getMessage("hiMessage", null, locale));

        while (!EventListener.isFind()) {
            System.out.print(context.getMessage("inputMessage", null, locale));
            inputNumber = scanner.nextInt();
            publisher.publishEvent(inputNumber);
        }
    }

}
