/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author guilherme
 */
public class Mail {

    public static StringBuilder msg = new StringBuilder("");
    Properties props = new Properties();

    public void sendEmail(String emailDestinatario, String[] mensagem) {
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put(
                "mail.smtp.host", "smtp.gmail.com");
        props.put(
                "mail.smtp.socketFactory.port", "465");
        props.put(
                "mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put(
                "mail.smtp.auth", "true");
        props.put(
                "mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sisgavgestao@gmail.com",  "gestao123@"); // Aqui  o endereço de email que envia
            }
        });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(
                true);

        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("sisgavgestao@gmail.com")); //Remetente
            Address[] toUser = InternetAddress.parse(emailDestinatario); // Destinatario
            message.setRecipients(Message.RecipientType.TO, toUser);
            /* Assunto*/
            message.setSubject("Solicitação de Login e Senha");
            /* Mensagem */
            message.setText("Seu login: "+mensagem[0]
            +"\nSua senha: "+mensagem[1]);
            /* Método para enviar a mensagem criada */
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Email enviado com sucesso!");
        } catch (javax.mail.MessagingException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}