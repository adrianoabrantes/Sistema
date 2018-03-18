package controller;

import DAO.PessoaDAO;
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
import model.Pessoa;
import sistema.Login;
import view.ControlledScreen;
import view.ScreensController;

/**
 * FXML Controller class
 *
 * @author adrianoabrantesdeandrade
 */
public class UsuariosController implements Initializable, ControlledScreen {

    ScreensController myController;

    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXTextField txtUsuario;
    @FXML
    private JFXPasswordField txtSenha;
    @FXML
    private JFXPasswordField txtConfSenha;
    @FXML
    private Label lblStatus;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnAlterar;
    @FXML
    private JFXButton btnExcluir;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXButton btnSair;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void eventoKeyPressed(KeyEvent event) {
        lblStatus.setVisible(false);
    }

    @FXML
    private void eventoSalvar(ActionEvent event) {
        if (btnSalvar.getText().equals("Novo")) {
            ativarCampos();
            btnSalvar.setText("Salvar");

        } else if (btnSalvar.getText().equals("Salvar")) {
            if (txtNome.getText().isEmpty()) {
                lblStatus.setTextFill(Paint.valueOf("#FF0000"));
                lblStatus.setText("Campo nome nao podem estar vazios.");
                lblStatus.setVisible(true);
                txtNome.requestFocus();

            } else if (txtUsuario.getText().isEmpty()) {
                lblStatus.setTextFill(Paint.valueOf("#FF0000"));
                lblStatus.setText("Campo usuario nao podem estar vazios.");
                lblStatus.setVisible(true);
                txtUsuario.requestFocus();

            } else if (txtSenha.getText().isEmpty()) {
                lblStatus.setTextFill(Paint.valueOf("#FF0000"));
                lblStatus.setText("Campo senha nao podem estar vazios.");
                lblStatus.setVisible(true);
                txtSenha.requestFocus();

            } else if (txtConfSenha.getText().isEmpty()) {
                lblStatus.setTextFill(Paint.valueOf("#FF0000"));
                lblStatus.setText("Campo confirmar senha nao podem estar vazios.");
                lblStatus.setVisible(true);
                txtConfSenha.requestFocus();

            } else if (!txtSenha.getText().equals(txtConfSenha.getText())) {
                lblStatus.setTextFill(Paint.valueOf("#FF0000"));
                lblStatus.setText("Confirmacao de senha invalido.");
                lblStatus.setVisible(true);
                txtSenha.setText("");
                txtConfSenha.setText("");
                txtSenha.requestFocus();

            } else {
                PessoaDAO dao = new PessoaDAO();
                Pessoa pessoa = new Pessoa();

                pessoa.setNome(txtNome.getText());
                pessoa.setUsuario(txtUsuario.getText());
                pessoa.setSenha(txtSenha.getText());

                if (dao.salvarPessoa(pessoa)) {
                    lblStatus.setText("Usuario " + txtUsuario.getText() + " salvo com sucesso.");
                    lblStatus.setTextFill(Paint.valueOf("#03ff4e"));
                    lblStatus.setVisible(true);
                    limparCampos();
                } else {

                }
            }
        }
    }

    @FXML
    private void eventoAlterar(ActionEvent event) {
    }

    @FXML
    private void eventoExcluir(ActionEvent event) {
    }

    @FXML
    private void eventoCancelar(ActionEvent event) {
        limparCampos();
        desativarCampos();

    }

    @FXML
    private void eventoSair(ActionEvent event) {
        limparCampos();
        desativarCampos();
        myController.setScreen(Login.screenHome);
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

    public void limparCampos() {
        txtNome.setText("");
        txtUsuario.setText("");
        txtSenha.setText("");
        txtConfSenha.setText("");
        lblStatus.setVisible(false);
        btnSalvar.setText("Novo");

    }

    public void ativarCampos() {
        txtNome.setDisable(false);
        txtNome.requestFocus();
        txtUsuario.setDisable(false);
        txtSenha.setDisable(false);
        txtConfSenha.setDisable(false);

    }

    public void desativarCampos() {
        txtNome.setDisable(true);
        txtUsuario.setDisable(true);
        txtSenha.setDisable(true);
        txtConfSenha.setDisable(true);
        btnSalvar.setText("Novo");

    }
}
