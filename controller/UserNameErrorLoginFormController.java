package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;
import org.controlsfx.control.Notifications;

import java.io.IOException;

public class UserNameErrorLoginFormController {
    public Label lblForgetPassword;
    @FXML
    private BorderPane brdrPaneLogin;

    @FXML
    private Pane paneLogin;

    @FXML
    private Pane innerLoginPane;

    @FXML
    private JFXPasswordField pswdPassword;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        if (!txtUsername.getText().equals("E1234")){
            Navigation.navigate(Routes.USERNAME_ERROR,brdrPaneLogin);


        } else if (!pswdPassword.getText().equals("E1234@l")) {
            Navigation.navigate(Routes.PASSWORD_ERROR,brdrPaneLogin);
        }else{
            Navigation.navigate(Routes.DASHBOARD,brdrPaneLogin);
        }
    }

    @FXML
    void pswdPasswordOnAction(ActionEvent event) throws IOException {
        btnLoginOnAction(event);
    }

    public void lblForgetPasswordOnMouseClick(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.PASSWORD_RESET,brdrPaneLogin);
    }
}
