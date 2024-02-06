import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


import java.security.Provider;
import java.util.Properties;
import javax.swing.*;
import java.util.Random;
import java.awt.*;

public class SendEmail {
    public static  int randomCode;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JTextField txt = new JTextField();
        JButton btn = new JButton("Send");
        txt.setBounds(50,50,200,50);
        txt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btn.setBounds(100,120,120,50);
        btn.addActionListener(e -> {
            Random rand = new Random();
            randomCode = rand.nextInt(99999);

            String host = "smtp.gmail.com"; // Note the correct spelling of "smtp"
            String user = "data.python13@gmail.com"; // Your Gmail email address
             // Your Gmail password
            String subject = "Resetting password";
            String username = "data.python13";
            String password = "eypwnbmeqnuzicis";
            String to = txt.getText(); // Recipient's email address
            String message = "Your reset code is " + randomCode;

            Properties prop = System.getProperties();
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", host); // Use the 'host' variable here
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.required", "true");


            Session mailSession = Session.getDefaultInstance(prop, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            mailSession.setDebug(true); // Set this to true for debugging

            try {
                Message msg = new MimeMessage(mailSession);
                msg.setFrom(new InternetAddress(user));
                InternetAddress address = new InternetAddress(to);
                msg.setRecipient(Message.RecipientType.TO, address);
                msg.setSubject(subject);
                msg.setText(message);

                Transport.send(msg);

                System.out.println("Email sent successfully.");
            } catch (MessagingException ex) {
                ex.printStackTrace();
            }


        });


        frame.add(txt);
        frame.add(btn);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
