package ru.learnUp.springboot.events;

import org.springframework.context.ApplicationEvent;

public class Event extends ApplicationEvent {

    private int inputNumber;

    public Event(int inputNumber) {
        super(inputNumber);
        this.inputNumber = inputNumber;
    }

    public int getInputNumber() {
        return inputNumber;
    }
}
