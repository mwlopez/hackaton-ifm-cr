/*
 * Alvaro Araya @aaocr Copyright (c) 2015
 */
package cpapi.utilities;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;

import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aao on 2015-07-21.
 */
public class Email {

    private static void addValidAddresses(String addresses, ArrayList<InternetAddress> addressesList) {
        String emailStr;
        StringTokenizer st;
        st = new StringTokenizer(addresses, ";");
        while (st.hasMoreTokens()) {
            emailStr = st.nextToken();
            if (isValidEmail(emailStr)) {
                try {
                    addressesList.add(new InternetAddress(emailStr));
                } catch (Exception ex) {
                    System.out.println("ERROR " + ex.getMessage());
                }
            }
        }
    }

    public static boolean isValidEmail(String email) {
        if (email != null && !email.isEmpty()) {
            Pattern ptr = Pattern.compile("[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?");
            return ptr.matcher(email).matches();
        } else {
            return false;
        }
    }

    public static String send(String to, String cc, String bcc, String replyTo, String subject, String html, List<AttachmentType> attachments) {
        /* TODO: Cambiar los credenciales de usuario de correo */
        String output = "OK";
        try {
            HtmlEmail email;
            to = to.replaceAll("\\s", "");
            if (isValidEmail(to)) {
                email = new HtmlEmail();
                email.setCharset(org.apache.commons.mail.EmailConstants.UTF_8);

                email.setHostName("smtp.gmail.com");
                email.setSmtpPort(587);
                email.setAuthenticator(new DefaultAuthenticator("user", "pass"));
                email.setStartTLSEnabled(true);
                email.setFrom("user", "cp-api");
                email.setCharset(org.apache.commons.mail.EmailConstants.UTF_8);
                email.setHtmlMsg(html);
                email.setSubject(subject);
                if (attachments != null && !attachments.isEmpty()) {
                    for (AttachmentType a : attachments) {
                        if (a.isOk()) {
                            EmailAttachment emailAttachment = new EmailAttachment();
                            emailAttachment.setPath(a.getPath());
                            emailAttachment.setDisposition(EmailAttachment.ATTACHMENT);
                            emailAttachment.setDescription(a.getName());
                            emailAttachment.setName(a.getName());
                            email.attach(emailAttachment);
                        }
                    }
                }
                /* TO */
                ArrayList<InternetAddress> addressesList = new ArrayList<>();
                addValidAddresses(to, addressesList);
                email.setTo(addressesList);
                /* CC */
                if (cc != null && !cc.isEmpty()) {
                    addressesList = new ArrayList<>();
                    addValidAddresses(cc, addressesList);
                    email.setCc(addressesList);
                }
                /* BCC */
                if (bcc != null && !bcc.isEmpty()) {
                    addressesList = new ArrayList<>();
                    addValidAddresses(bcc, addressesList);
                    email.setBcc(addressesList);
                }
                email.addReplyTo(replyTo);
                email.send();
            } else {
                output = "EMAIL: " + to + " INVÁLIDO<br/>";
            }
        } catch (Exception e) {
            output = "ERROR CORREO: " + e.getMessage();
            Logger.logThis("ERROR CORREO: " + e.getMessage());
        }
        return output;
    }

    public static boolean send(String to, String subject, String message, List<AttachmentType> attachments) {
        boolean ok = true;
        String htmlPath = FileManager.getHTMLPath() + "email.html";
        String htmlBody;
        String result;
        String bcc = "";
        String replyTo = "email@email.com";
        htmlBody = FileManager.getStrFromFile(htmlPath);
        if (htmlBody != null && !htmlBody.isEmpty()) {
            try {
                htmlBody = htmlBody.replaceAll("%ASUNTO%", Matcher.quoteReplacement(subject));
                htmlBody = htmlBody.replaceAll("%MENSAJE%", Matcher.quoteReplacement(message));
                result = send(to, null, bcc, replyTo, subject, htmlBody, attachments);
                if (!result.equals("OK")) {
                    System.out.println("EMAIL: " + result);
                    ok = false;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                ok = false;
            }
        } else {
            ok = false;
        }
        return ok;
    }
}
