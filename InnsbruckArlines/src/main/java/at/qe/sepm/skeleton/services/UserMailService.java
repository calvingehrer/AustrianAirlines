package at.qe.sepm.skeleton.services;

import at.qe.sepm.skeleton.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Scope("application")
public class UserMailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String toAddress, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toAddress);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    public void sendMailTo(User user, String subject, String text) {
        if (user.getEmail() != null && !user.getEmail().isEmpty()) {
            sendMail(user.getEmail(), subject, text);
        }
    }
}