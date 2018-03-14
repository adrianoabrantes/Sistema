package controller;

import view.ScreensController;
import view.ControlledScreen;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import sistema.Login;
import sistema.LoginOld;

/**
 * FXML Controller class
 *
 * @author adrianoabrantesdeandrade
 */
public class LoginController implements Initializable,ControlledScreen {

    ScreensController myController;
    @FXML
    private JFXTextField txtUsuario;
    @FXML
    private JFXPasswordField txtSenha;
    @FXML
    private Label lblStatusLogin;
    @FXML
    private JFXButton btnEntrar;
    @FXML
    private JFXButton btnSair;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblStatusLogin.setVisible(false);
    }

    @FXML
    private void EntrarEventoCick(ActionEvent event) {
        if (txtUsuario.getText().isEmpty()) {
            lblStatusLogin.setTextFill(Paint.valueOf("#FF0000"));
            lblStatusLogin.setText("Campo usuario nao podem estar vazios.");
            lblStatusLogin.setVisible(true);
            txtUsuario.requestFocus();

        } else if (txtSenha.getText().isEmpty()) {
            lblStatusLogin.setTextFill(Paint.valueOf("#FF0000"));
            lblStatusLogin.setText("Campo Senha nao podem estar vazios.");
            lblStatusLogin.setVisible(true);
            txtSenha.requestFocus();
        } else {
            lblStatusLogin.setTextFill(Paint.valueOf("#0000FF"));
            lblStatusLogin.setText("Logado");
            lblStatusLogin.setVisible(true);
            
        }
    }

    @FXML
    private void keyPressed(KeyEvent event) {
        lblStatusLogin.setVisible(false);
    }

    @FXML
    private void SairEventoClick(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }
}
