package com.pouillcorp.sortirnice.email;

import android.content.Context;
import android.graphics.Bitmap;

import com.pouillcorp.sortirnice.enumeration.EntriesType;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
public class SendEmailService {

    private static SendEmailService instance = null;
    private static Context ctx;

    static final String username = "pouillcorp@gmail.com";
    final String password = "pouillos1416";

    Properties prop;
    static Session session;

    private SendEmailService(Context context) {
        ctx = context;
        prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
    }

    public static synchronized SendEmailService getInstance(Context context) {
        if(instance == null) {
            instance = new SendEmailService(context);
        }
        return instance;
    }

    public static void sendEmailErreurSynchro(EntriesType entryType, String erreur) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("pouillcorp@gmail.com")
            );
            String model = "";
            if (entryType != null) {
                model += entryType.toString();
            } else {
                model += "Evenement";
            }
                message.setSubject("APP - Sortir Nice - Erreur Modele : " + model);
                message.setText("l'app Sortir à Nice a bugué à cause d'un probleme dans le modele " + model + "\n"
                        + "\n" + "Exception:" + "\n" + erreur);
                Transport.send(message);
        }
        catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
