package sistema;

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

    public static String screen1ID = "main";
    public static String screen1File = "Login.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {
        ScreensController mainContainer = new ScreensController();

        mainContainer.loadScreen(Login.screen1ID, Login.screen1File);
        //mainContainer.loadScreen(ScreensFramework.screen2ID, ScreensFramework.screen2File);
        mainContainer.setScreen(Login.screen1ID);
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
