package com.home.onlineshop.service.impl.mailSerivces;

import com.home.onlineshop.service.interfaces.mailSerivces.SendReportToMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class SendReportToMailImpl implements SendReportToMail {

    private final JavaMailSender sender;

    @Autowired
    public SendReportToMailImpl(JavaMailSender sender) {
        this.sender = sender;
    }

    @Override
    public void sendEmail(String to, String subject, String text) throws Exception {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setText(text);
        helper.setSubject(subject);

        sender.send(message);
    }

}
