package com.github.straider.felix.consumer;

import com.github.straider.felix.producer.HelloWorldService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorldConsumer implements ActionListener {

    private final HelloWorldService service;
    private final Timer             timer;

    public HelloWorldConsumer(final HelloWorldService service ) {
        super();

        this.service = service;
        this.timer   = new Timer( 1000, this );
    }

    @Override
    public void actionPerformed( final ActionEvent actionEvent ) {
        service.say();
    }

    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

}
