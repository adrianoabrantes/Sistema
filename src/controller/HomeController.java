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
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
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
    private JFXButton btnConfigurar;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        lblUltLogin.setEffect(new DropShadow(10, Color.WHITE));
        lblUltLogin.setTextFill(Color.WHITE);
        btnUsuarios.setEffect(new DropShadow(10, Color.WHITE));
        btnConfigurar.setEffect(new DropShadow(10, Color.WHITE));
        btnEncerrar.setEffect(new DropShadow(10, Color.WHITE));  
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
    private void eventoConfigurar(ActionEvent event) {
        myController.setScreen(Login.screenConfigurar);
    }
}
