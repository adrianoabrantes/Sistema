package sistema;

import java.io.IOException;
import view.ScreensController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author adrianoabrantesdeandrade
 */
public class Login extends Application {

    public static String screenLogin = "login";
    public static String screenLoginFile = "Login.fxml";
    public static String screenHome = "home";
    public static String screenHomeFile = "Home.fxml";
    public static String screenUsuarios = "usuarios";
    public static String screenUsuariosFile = "Usuarios.fxml";
    public static String screenTabelaUsuarios = "Tabela";
    public static String screenTabelaUsuariosFile = "TabelaUsuarios.fxml";
    public static String screenLicenca = "licanca";
    public static String screenLicencaFile = "Licenca.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {
        ScreensController mainContainer = new ScreensController();

        mainContainer.loadScreen(Login.screenLogin, Login.screenLoginFile);
        mainContainer.loadScreen(Login.screenHome, Login.screenHomeFile);
        mainContainer.loadScreen(Login.screenUsuarios, Login.screenUsuariosFile);
        mainContainer.loadScreen(Login.screenTabelaUsuarios, Login.screenTabelaUsuariosFile);
        mainContainer.loadScreen(Login.screenLicenca, Login.screenLicencaFile);
        mainContainer.setScreen(Login.screenLogin);
        Group root = new Group();
        root.getChildren().addAll(mainContainer);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        //primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }
}
