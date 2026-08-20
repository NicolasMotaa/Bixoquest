package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.viewcontrollers.Refreshable;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneManager {

    private static SceneManager instance;
    private Stage stage;
    private Map<String, Scene> cache = new HashMap<>();
    private Map<String, Object> controllers = new HashMap<>();

    private SceneManager() {}

    public static SceneManager getInstance(){
        if (instance == null){
            instance = new SceneManager();
        }

        return instance;
    }

    public void init(Stage stage) {
        this.stage = stage;
    }

    public void navigateTo(String fxmlPath) {
        try {
            if (!cache.containsKey(fxmlPath)) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
                Parent root = loader.load();
                cache.put(fxmlPath, new Scene(root, 768, 576));
                controllers.put(fxmlPath, loader.getController());
            }


            Object controller = controllers.get(fxmlPath);
            if (controller instanceof Refreshable) {
                ((Refreshable) controller).onShow();
            }

            stage.setScene(cache.get(fxmlPath));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
