package controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;
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
    private JFXButton btnUsuarios;
    @FXML
    private Label lblUltLogin;

    private final SimpleDateFormat formatarHora = new SimpleDateFormat("hh:mm:ss a");
    @FXML
    private JFXButton btnEncerrar;
    @FXML
    private JFXButton btnAtivacao;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       KeyFrame frame = new KeyFrame(Duration.millis(1000), e -> atualizaHora());
        
        Timeline timeline = new Timeline(frame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
         
    }

    @FXML
    private void eventoEncerrarClick(ActionEvent event) {
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

    private void atualizaHora() {
        Date agora = new Date();
        lblUltLogin.setText(formatarHora.format(agora));
    }

    @FXML
    private void eventoAtivacaoClick(ActionEvent event) {
        myController.setScreen(Login.screenLicenca);
    }
}
