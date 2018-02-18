package com.github.straider.osgi.felix.consumer;

import com.github.straider.osgi.felix.common.HelloWorldService;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorldServiceConsumer implements ActionListener {

    private final HelloWorldService service;
    private final Timer             timer;

    public HelloWorldServiceConsumer( final HelloWorldService service ) {
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
