package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
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
    }

}
