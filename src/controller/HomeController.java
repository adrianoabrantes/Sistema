package controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

}
