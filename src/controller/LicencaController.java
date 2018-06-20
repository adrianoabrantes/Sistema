package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Licenca;
import sistema.Login;
import view.ControlledScreen;
import view.ScreensController;

/**
 * FXML Controller class
 *
 * @author adrianoabrantesdeandrade
 */
public class LicencaController implements Initializable, ControlledScreen {

    private ScreensController myController;
    @FXML
    private JFXTextField txtLicenca;
    @FXML
    private Label lblStatus;
    @FXML
    private JFXButton btnAtivar;
    @FXML
    private Label lblPeriodo;
    @FXML
    private JFXButton btnVoltar;
    @FXML
    private Pane PainelAtivacao;
    @FXML
    private JFXButton btnConcluir;
    @FXML
    private JFXButton btnCancelar;
    Licenca licenciamento = new Licenca();
    @FXML
    private Label lblEstadoChave;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void eventoAtivarClick(ActionEvent event) throws IOException {
        if (txtLicenca.getText().isEmpty()) {
            txtLicenca.requestFocus();
        } else {
            licenciamento.setChaveAtivada(txtLicenca.getText());
            if (licenciamento.ativarChave()) {
                PainelAtivacao.setVisible(true);
                lblStatus.setText("ATIVADO");
                
            } else {
                lblEstadoChave.setText("Chave invalida! Contate-nos 1194794-1116");
                lblEstadoChave.setVisible(true);
                txtLicenca.requestFocus();
                lblStatus.setText("TESTE");
                
            }
        }
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

    @FXML
    private void eventoVoltarClick(ActionEvent event) {
        myController.setScreen(Login.screenConfigurar);
    }

    @FXML
    private void eventoKeyPressed(KeyEvent event) {
        lblEstadoChave.setVisible(false);
        if (txtLicenca.getLength() > 9) {
            String chave = txtLicenca.getText().toUpperCase();
            txtLicenca.setText(chave.substring(0, 2) + "-" + chave.substring(2, 4)
                    + "-" + chave.substring(4, 6) + "-" + chave.substring(6, 8)
                    + "-" + chave.substring(8, 10));
            btnAtivar.requestFocus();
        }
    }

    @FXML
    private void eventoMouseClick(MouseEvent event) {
        txtLicenca.setText("");
    }

    @FXML
    private void eventoConcluirClick(ActionEvent event) {
        PainelAtivacao.setVisible(false);
    }

    @FXML
    private void eventoCancelarClick(ActionEvent event) {
        licenciamento.setChaveAtivada("");
        txtLicenca.setText("");
        PainelAtivacao.setVisible(false);
    }

    public void setLblStatus(String lblStatus) {
        this.lblStatus.setText(lblStatus);
    }

}
