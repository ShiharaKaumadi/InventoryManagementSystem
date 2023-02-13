package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import lk.ijse.finalproject.dao.custom.EmployeeDAO;
import lk.ijse.finalproject.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.finalproject.dto.EmployeeDTO;

import lk.ijse.finalproject.entity.Employee;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    public BorderPane brdrPaneLogin;
    public Pane paneLogin;
    public Pane innerLoginPane;
    public JFXButton btnLogin;

    public JFXTextField txtUsername;
    public JFXPasswordField pswdPassword;
    public Label lblForgetPassword;
    public Label lblUserNameError;
    public Label lblPasswordError;

    String  userName;

    EmployeeDAOImpl employeeDAOImpl  = new EmployeeDAOImpl();

    public void initialize(){
        txtUsername.setFocusColor(Paint.valueOf("Blue"));
        txtUsername.requestFocus();
    }


    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        userName= txtUsername.getText();
        String password = pswdPassword.getText();

        try {
            Employee login = employeeDAOImpl.loginUserName(userName);
            Employee loginPassword = employeeDAOImpl.loginPassword(password);
            String[] userCode = userName.split("-");
            String[] passCode = userName.split("-");
            if (login != null){
                switch (userCode[0]) {
                    case "EM":
                        if (userName.matches("^EM-1\\d{2}$")){
                            if (password.matches("^EM-1\\d{2}@l$")|password!=null){
                                Navigation.navigate(Routes.DASHBOARD, brdrPaneLogin);
                                break;
                            }else{
                                lblPasswordError.setText("Invalid Password");
                                pswdPassword.setFocusColor(Paint.valueOf("Red"));
                                pswdPassword.requestFocus();
                                break;
                            }
                        }



                    case "ES":
                        if (password.matches("^ES-2\\d{2}@l$")){
                            Navigation.navigate(Routes.STORE_DASHBOARD, brdrPaneLogin);
                            break;
                        }else{
                            lblPasswordError.setText("Invalid Password");
                            pswdPassword.setFocusColor(Paint.valueOf("Red"));
                            pswdPassword.requestFocus();
                            break;
                        }


                    case "EC":
                        if (password.matches("^EC-3\\d{2}@l$")){
                            Navigation.navigate(Routes.CASHIER_DASHBOARD, brdrPaneLogin);
                            break;

                        }else{
                            lblPasswordError.setText("Invalid Password");
                            pswdPassword.setFocusColor(Paint.valueOf("Red"));
                            pswdPassword.requestFocus();
                            break;
                        }

                }

            }else{
                    lblUserNameError.setText("Invalid User Name");
                    txtUsername.setFocusColor(Paint.valueOf("red"));
                    txtUsername.requestFocus();


            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            Notifications notifications = Notifications.create().title("Warning").text("Driver Not Found").hideAfter(Duration.seconds(3)).position(Pos.TOP_LEFT);
            notifications.showError();
        }

    }

    public void pswdPasswordOnAction(ActionEvent actionEvent) throws IOException {

        btnLoginOnAction(actionEvent);

    }

    public void lblForgetPasswordOnMouseClick(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.PASSWORD_RESET,brdrPaneLogin);
    }

    public void txtUserNameOnAction(ActionEvent actionEvent) {
        pswdPassword.setFocusColor(Paint.valueOf("Blue"));
        pswdPassword.requestFocus();
    }
}
