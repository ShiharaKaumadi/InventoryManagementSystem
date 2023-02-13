package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import lk.ijse.finalproject.bo.custom.BOFactory;
import lk.ijse.finalproject.bo.custom.BOTypes;
import lk.ijse.finalproject.bo.custom.EmployeeBO;
import lk.ijse.finalproject.dao.custom.EmployeeDAO;
import lk.ijse.finalproject.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class ResetPasswordFormController {
    public JFXTextField txtMobileNumber;
    public JFXButton btnMCancel;
    public JFXButton btnNumberSearch;
    public JFXTextField btnEmailAddress;
    public JFXButton btnECancel;
    public JFXButton btnEmailSearch;
    public Pane paneReset;
    public Pane lblReset;
    public BorderPane brdPaneResetPassword;
    public JFXTextField txtEmailAddress;
    public Label lblEmailMismatchWarning;
    // creating first MimeBodyPart object
    BodyPart messageBodyPart1 = new MimeBodyPart();
    // creating MultiPart object
    Multipart multipartObject = new MimeMultipart();

    EmployeeBO employeeBOImpl = (EmployeeBO) BOFactory.getBoFactory().getBO(BOTypes.EMPLOYEE);

    public void txtMobileNumberOnAction(ActionEvent actionEvent) {
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
    }

    public void btnNumberSearchOnAction(ActionEvent actionEvent) {
    }



    public void btnEmailSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String receiver = txtEmailAddress.getText();
        System.out.println(receiver);

            String from = "eshani9544@gmail.com";
            String to = receiver;
//        String email = employeeDAOImpl.SearchPassword(to).getEmail();
            String password = employeeBOImpl.SearchPassword(to).getPassword();


            //     String text = employeeDAOImpl.SearchPassword(to).toString();
            //Get system properties
            Properties properties = System.getProperties();
            //set up mail server
            //simple mail transfer protocol
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            //get the session object
            //then pass username password
            Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("eshani9544@gmail.com", "cijsfysrrmskvntl");
                }
            });

            //use to debug smtp issues
            session.setDebug(true);
            try {
                //create a default mimemessage object
                MimeMessage mimeMessage = new MimeMessage(session);
                //set from: set the header feild of header
                mimeMessage.setFrom(new InternetAddress(from));
                //set To:
                mimeMessage.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(to)));
                mimeMessage.setSubject("Your Password");
                System.out.println(password);
                messageBodyPart1.setText("Your Password: " + password + "\n\nThank you\nAdmin");
                multipartObject.addBodyPart(messageBodyPart1);
                // set body of the email.
                mimeMessage.setContent(multipartObject);
                Transport.send(mimeMessage);
            } catch (MessagingException e) {
                e.printStackTrace();
            }


    }

    public void btnNavigateOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,brdPaneResetPassword);
    }

    public void txtEmailAddressOnAction(ActionEvent actionEvent) {
    }
}
