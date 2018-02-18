package com.github.straider.osgi.producer;

import org.springframework.mail.SimpleMailMessage;

public interface IMailerService {

    void sendMailMessage( final Sender sender, final SimpleMailMessage message );

}

