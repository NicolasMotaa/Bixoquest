import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.SceneManager;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        SceneManager.getInstance().init(primaryStage);
        primaryStage.setTitle("BixoQuest");
        primaryStage.setResizable(false);
        SceneManager.getInstance().navigateTo("/fxml/menu.fxml");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

