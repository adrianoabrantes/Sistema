package controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sistema.Config;
import sistema.Login;
import view.ControlledScreen;
import view.ScreensController;

/**
 * FXML Controller class
 *
 * @author adrianoabrantesdeandrade
 */
public class HomeController implements Initializable, ControlledScreen {

    ScreensController myController;
    
    @FXML
    private Button btnSair;
    @FXML
    private JFXButton btnUsuarios;
    @FXML
    private JFXButton btnContas;
    @FXML
    private Label lblUltLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUltLogin.setText("Ultimo Login as "+new Config().getData());
    }

    @FXML
    private void EventoSairClick(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

    @FXML
    private void eventoUsuariosClick(ActionEvent event) {
        myController.setScreen(Login.screenUsuarios);
    }

    @FXML
    private void eventoContasClick(ActionEvent event) {
        myController.setScreen(Login.screenContasPagar);
    }

}
