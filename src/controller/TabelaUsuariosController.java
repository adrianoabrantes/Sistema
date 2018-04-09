package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.Pessoa;
import sistema.Login;
import view.ControlledScreen;
import view.ScreensController;

/**
 * FXML Controller class
 *
 * @author adrianoabrantesdeandrade
 */
public class TabelaUsuariosController implements Initializable, ControlledScreen {

    Pessoa pessoa = new Pessoa();

    ScreensController myController;
    @FXML
    private JFXButton btnVoltar;
    @FXML
    private JFXListView<?> listView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void eventoVoltar(ActionEvent event) {
        myController.setScreen(Login.screenUsuarios);
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

}
