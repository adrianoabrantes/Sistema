package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
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
import javafx.scene.paint.Paint;
import model.Licenca;
import sistema.Configurar;
import sistema.LerArquivos;
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
    private Pane PainelAtivacao;

    Licenca licenca = new Licenca();

    @FXML
    private Label lblEstadoChave;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resumoLicenca();
    }

    @FXML
    private void eventoAtivarClick(ActionEvent event) throws IOException {
        if (btnAtivar.getText().equals("Ativar")) {
            if (txtLicenca.getText().isEmpty()) {
                txtLicenca.requestFocus();
            } else if (txtLicenca.getLength() != 10) {
                txtLicenca.requestFocus();
            } else {
                licenca.setChaveAtivada(txtLicenca.getText());
                if (licenca.calcularLicenca()) {
                    txtLicenca.setText(txtLicenca.getText().toUpperCase());
                    PainelAtivacao.setVisible(true);
                    lblStatus.setTextFill(Paint.valueOf("#00BFFF"));
                    lblStatus.setText("ATIVADO");
                    txtLicenca.setDisable(true);
                    btnAtivar.setText("Alterar");
                    lblPeriodo.setVisible(false);

                } else {
                    lblEstadoChave.setText("Chave invalida! Contate o Suporte.");
                    lblEstadoChave.setVisible(true);
                    txtLicenca.clear();
                    txtLicenca.requestFocus();
                    lblStatus.setText("TESTE");

                }
            }
        } else {
            txtLicenca.setDisable(false);
            btnAtivar.setText("Ativar");
        }
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

    @FXML
    private void eventoVoltarClick(ActionEvent event) {
        lblEstadoChave.setVisible(false);
        myController.setScreen(Login.screenHome);
    }

    @FXML
    private void eventoKeyPressed(KeyEvent event) {
        lblEstadoChave.setVisible(false);
        if (txtLicenca.getLength() > 9) {
            btnAtivar.requestFocus();
        }
    }

    @FXML
    private void eventoMouseClick(MouseEvent event) {
        txtLicenca.setText("");
    }

    private void eventoConcluirClick(ActionEvent event) {
        txtLicenca.setText((new LerArquivos().LerArquivos(".licenca.cfg", "config")
                .substring(0, 2) + "-" + new LerArquivos().LerArquivos(".licenca.cfg", "config")
                .substring(2, 4) + "-" + new LerArquivos().LerArquivos(".licenca.cfg", "config")
                .substring(4, 6) + "-" + new LerArquivos().LerArquivos(".licenca.cfg", "config")
                .substring(6, 8) + "-" + new LerArquivos().LerArquivos(".licenca.cfg", "config")
                .substring(8, 10)).toUpperCase());
        PainelAtivacao.setVisible(false);
    }

    private void eventoCancelarClick(ActionEvent event) {
        licenca.setChaveAtivada("");
        txtLicenca.setText("");
        PainelAtivacao.setVisible(false);
    }

    public void setLblStatus(String lblStatus) {
        this.lblStatus.setText(lblStatus);
    }

    private void resumoLicenca() {
        File licenca = new File(new Configurar().getDiretorioAtual() + "/config/.licenca.cfg");

        if (licenca.exists()) {
            lblStatus.setTextFill(Paint.valueOf("#00FFFF"));
            txtLicenca.setText((new LerArquivos().LerArquivos(".licenca.cfg", "config")
                    .substring(0, 2) + "-" + new LerArquivos().LerArquivos(".licenca.cfg", "config")
                    .substring(2, 4) + "-" + new LerArquivos().LerArquivos(".licenca.cfg", "config")
                    .substring(4, 6) + "-" + new LerArquivos().LerArquivos(".licenca.cfg", "config")
                    .substring(6, 8) + "-" + new LerArquivos().LerArquivos(".licenca.cfg", "config")
                    .substring(8, 10)).toUpperCase());
            txtLicenca.setDisable(true);
            btnAtivar.setText("Alterar");
            lblStatus.setText("ATIVADO");
            lblPeriodo.setVisible(false);

        } else if (new Configurar().calculoPeriodoAvaliacao() > 30 || new Configurar().calculoPeriodoAvaliacao() <= 0) {
            lblPeriodo.setText("Licenca expirada");
            lblStatus.setText("LICENCA EXPIRADA");

        } else {
            lblStatus.setText("TESTE");
            lblPeriodo.setText("Valido por " + new Configurar().calculoPeriodoAvaliacao() + " dias.");

        }
    }
}
