package com.secure.notes.utils;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendPasswordResetEmail(String to, String resetUrl) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject("🔐 Password Reset Request");

            String htmlContent = "<!DOCTYPE html>" +
                    "<html>" +
                    "<head>" +
                    "  <style>" +
                    "    body { font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px; }" +
                    "    .container { background-color: #ffffff; padding: 30px; border-radius: 10px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }" +
                    "    .button { display: inline-block; padding: 12px 20px; background-color: #007BFF; color: white; text-decoration: none; border-radius: 5px; }" +
                    "    .footer { margin-top: 20px; font-size: 12px; color: #999999; }" +
                    "  </style>" +
                    "</head>" +
                    "<body>" +
                    "  <div class='container'>" +
                    "    <h2>Password Reset Requested</h2>" +
                    "    <p>Hello,</p>" +
                    "    <p>We received a request to reset your password. Click the button below to proceed:</p>" +
                    "    <p><a class='button' href='" + resetUrl + "'>Reset Password</a></p>" +
                    "    <p>If you did not request a password reset, you can safely ignore this email.</p>" +
                    "    <p class='footer'>This is an automated message. Please do not reply.</p>" +
                    "  </div>" +
                    "</body>" +
                    "</html>";

            helper.setText(htmlContent, true); // Set to HTML

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            // Log or handle the error appropriately
            e.printStackTrace();
        }
    }
}