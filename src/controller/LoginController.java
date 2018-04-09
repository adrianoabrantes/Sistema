package controller;

import DAO.PessoaDAO;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import model.Pessoa;
import sistema.Config;
import sistema.Login;

/**
 * FXML Controller class
 *
 * @author adrianoabrantesdeandrade
 */
public class LoginController implements Initializable, ControlledScreen {

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
    @FXML
    private Label lblVersao;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblStatusLogin.setVisible(false);
        lblVersao.setText("Versao: 1.0");

    }

    @FXML
    private void EntrarEventoCick() {

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
            Config config = new Config();

            if (txtUsuario.getText().equals("MASTER") && txtSenha.getText().equals(config.usuarioMaster(txtUsuario.getText(), txtSenha.getText()))) {
                myController.setScreen(Login.screenHome);

            } else {
                if (validarUsuario(txtUsuario.getText(), txtSenha.getText())) {
                    myController.setScreen(Login.screenHome);

                } else {
                    lblStatusLogin.setTextFill(Paint.valueOf("#FF0000"));
                    lblStatusLogin.setVisible(true);
                    lblStatusLogin.setText("Usuario ou senha invalido.");
                }
            }
        }
    }

    @FXML
    private void keyPressed(KeyEvent event) {
        lblStatusLogin.setVisible(false);
        if (event.getCode() == KeyCode.ENTER) {
            EntrarEventoCick();
        }
    }

    @FXML
    private void SairEventoClick(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

    public static boolean validarUsuario(String usuario, String senha) {
        PessoaDAO dao = new PessoaDAO();
        Pessoa pessoa = new Pessoa();
        pessoa.setUsuario(usuario);
        pessoa.setSenha(senha);

        if (dao.login(pessoa)) {
            return true;
        } else {
            return false;
        }
    }
}
