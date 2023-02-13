package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;

import java.io.IOException;

public class PasswordErrorLoginFormController {
    public JFXButton btnLogin;

    public Pane innerLoginPane;
    public Pane paneLogin;
    public BorderPane brdPaneLogin;
    public JFXPasswordField pswdPassword;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
         if (!pswdPassword.getText().equals("E1234@l")) {
            Navigation.navigate(Routes.PASSWORD_ERROR,brdPaneLogin);
        }else{
            Navigation.navigate(Routes.DASHBOARD,brdPaneLogin);
        }
    }

    public void lblForgetPwdOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.PASSWORD_RESET,brdPaneLogin);
    }

    public void pswdPasswordOnAction(ActionEvent actionEvent) throws IOException {
        btnLoginOnAction(actionEvent);
    }
}
