/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MudancaSenha;

import java.util.Properties;

/**
 *
 * @author Guilherme
 */
public class MailJavaSender {
    public void senderMail(final MailJava mail) throws
            UnsupportedEncodingExceptions, MessaginException {
         Properties props = new Properties();
         props.setProperty("mail.transport.protool", "smt");
         props.setProperty("mail.smtp.host", mail.getSmtpHostMail());
         props.setProperty("mail.smtp.auth", mail.getSmtpAuth());
         props.setProperty("mail.smtp.starttls.enable", mail.getSmtpStarttls());
         props.setProperty("mail.smtp.port", mail.getSmtpPortMail());
         props.setProperty("mail.smtp.socketFactory.port", mail.getSmtpPortMail());
         props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory" );
         props.setProperty("mail.smtp.socketFactory.fallback", "false");
         props.setProperty("mail.mine.charset", mail.getCharsetMaill());
    }

    private static class MessaginException extends Exception {

        public MessaginException() {
        }
    }
}














