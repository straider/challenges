package com.github.straider.osgi.producer.internal;

import com.github.straider.osgi.producer.IMailerService;
import com.github.straider.osgi.producer.Sender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public final class MailerService implements IMailerService {

    public void sendMailMessage( final Sender sender, final SimpleMailMessage message ) {
        final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost( "mail.host.org" );
        mailSender.setPort( 25 );
        message.setFrom( sender.toString() );
        mailSender.send( message );
    }

}

