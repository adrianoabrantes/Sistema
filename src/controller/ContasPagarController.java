package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import sistema.Login;
import view.ControlledScreen;
import view.ScreensController;

/**
 * FXML Controller class
 *
 * @author adrianoabrantesdeandrade
 */
public class ContasPagarController implements Initializable, ControlledScreen {

    ScreensController myController;
    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXTextField txtMercadoria;
    @FXML
    private JFXTextField txtDataCompra;
    @FXML
    private JFXTextField txtDataVencimento;
    @FXML
    private JFXTextField txtValor;
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
    @FXML
    private JFXTextField txtPrimeiroAlerta;
    @FXML
    private JFXTextField txtSegundoAlerta;
    @FXML
    private JFXTextField txtTerceiroAlerta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

    @FXML
    private void eventoKeyPressed(KeyEvent event) {
    }

    @FXML
    private void eventoSalvar(ActionEvent event) {
    }

    @FXML
    private void eventoAlterar(ActionEvent event) {
    }

    @FXML
    private void eventoExcluir(ActionEvent event) {
    }

    @FXML
    private void eventoCancelar(ActionEvent event) {
    }

    @FXML
    private void eventoSair(ActionEvent event) {
        limparCampos();
        desativarCampos();
        myController.setScreen(Login.screenHome);
    }
public void limparCampos() {
        txtNome.setText("");
        txtMercadoria.setText("");
        txtDataCompra.setText("");
        txtDataVencimento.setText("");
        txtValor.setText("");
        btnSalvar.setText("Novo");

    }

    public void ativarCampos() {
        txtNome.setDisable(false);
        txtNome.requestFocus();
        txtMercadoria.setDisable(false);
        txtDataCompra.setDisable(false);
        txtDataVencimento.setDisable(false);
        txtValor.setDisable(false);

    }

    public void desativarCampos() {
        txtNome.setDisable(true);
        txtNome.requestFocus();
        txtMercadoria.setDisable(true);
        txtDataCompra.setDisable(true);
        txtDataVencimento.setDisable(true);
        txtValor.setDisable(true);
        btnSalvar.setText("Novo");

    }
}
