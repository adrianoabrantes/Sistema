package controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sistema.Login;
import view.ControlledScreen;
import view.ScreensController;

/**
 * FXML Controller class
 *
 * @author adrianoabrantesdeandrade
 */
public class ConfigurarController implements Initializable, ControlledScreen {

    ScreensController myController;
    @FXML
    private JFXButton btnVoltar;
    @FXML
    private JFXButton btnLicenca;
    
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

    @FXML
    private void eventoVoltarClick(ActionEvent event) {     
            myController.setScreen(Login.screenHome);
    }

    @FXML
    private void eventoLicencaClick(ActionEvent event) {
       myController.setScreen(Login.screenLicenca);
    }
}
