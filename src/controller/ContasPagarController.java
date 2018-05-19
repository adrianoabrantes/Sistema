package controller;

import DAO.ContasPagarDAO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import model.ContasPagar;
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
    private JFXCheckBox ckbxAlertaMensal;
    @FXML
    private Label lblStatus;

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
        ContasPagarDAO dao = new ContasPagarDAO();
        ContasPagar contas = new ContasPagar();
        lblStatus.setVisible(false);

        if (btnSalvar.getText().equals("Novo")) {
            ativarCampos();
            btnSalvar.setText("Salvar");

        } else if (btnSalvar.getText().equals("Salvar")) {
            if (txtNome.getText().isEmpty()) {
                lblStatus.setTextFill(Paint.valueOf("#FF0000"));
                lblStatus.setText("Campo nome nao podem estar vazios.");
                lblStatus.setVisible(true);
                txtNome.requestFocus();

            } else if (txtMercadoria.getText().isEmpty()) {
                lblStatus.setTextFill(Paint.valueOf("#FF0000"));
                lblStatus.setText("Campo Mercadoria nao podem estar vazios.");
                lblStatus.setVisible(true);
                txtMercadoria.requestFocus();

            } else if (txtDataCompra.getText().isEmpty()) {
                lblStatus.setTextFill(Paint.valueOf("#FF0000"));
                lblStatus.setText("Campo Data da Compra nao podem estar vazios.");
                lblStatus.setVisible(true);
                txtDataCompra.requestFocus();

            } else if (txtDataVencimento.getText().isEmpty()) {
                lblStatus.setTextFill(Paint.valueOf("#FF0000"));
                lblStatus.setText("Campo Data do Vencimento nao podem estar vazios.");
                lblStatus.setVisible(true);
                txtDataVencimento.requestFocus();

            } else if (txtValor.getText().isEmpty()) {
                lblStatus.setTextFill(Paint.valueOf("#FF0000"));
                lblStatus.setText("Campo Valor nao podem estar vazios.");
                lblStatus.setVisible(true);
                txtValor.requestFocus();
            }else{
                dao.SalvarContaPagar(contas);
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

    public void limparCampos() {
        txtNome.setText("");
        txtMercadoria.setText("");
        txtDataCompra.setText("");
        txtDataVencimento.setText("");
        txtValor.setText("");
        ckbxAlertaMensal.setSelected(false);
        btnSalvar.setText("Novo");

    }

    public void ativarCampos() {
        txtNome.setDisable(false);
        txtNome.requestFocus();
        txtMercadoria.setDisable(false);
        txtDataCompra.setDisable(false);
        txtDataVencimento.setDisable(false);
        txtValor.setDisable(false);
        ckbxAlertaMensal.setDisable(false);

    }

    public void desativarCampos() {
        txtNome.setDisable(true);
        txtNome.requestFocus();
        txtMercadoria.setDisable(true);
        txtDataCompra.setDisable(true);
        txtDataVencimento.setDisable(true);
        txtValor.setDisable(true);
        ckbxAlertaMensal.setDisable(true);
        btnSalvar.setText("Novo");

    }
}
