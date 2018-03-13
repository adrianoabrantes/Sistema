package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.org.apache.xml.internal.serialize.Method;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;

/**
 * FXML Controller class
 *
 * @author adrianoabrantesdeandrade
 */
public class LoginController implements Initializable {

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
        }else{
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
        
    }

}
