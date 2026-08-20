package view.viewcontrollers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import view.SceneManager;

import java.net.URL;
import java.util.ResourceBundle;


public class HUDController implements Initializable {

    @FXML
    private AnchorPane rootHud;

    @FXML
    private Button btnMapa;

    @FXML
    private Button btnStats;

    @FXML
    private Button btnConfig;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Font.loadFont(getClass().getResourceAsStream("/fonts/PressStart2P-Regular.ttf"), 14);
        rootHud.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());

        System.out.println("Tela de HUD carregada");

        btnMapa.setOnAction(e->abrirMapa());
        btnStats.setOnAction(e->abrirStatus());
        btnConfig.setOnAction(e->abrirConfig());
    }

    public void abrirMapa(){
        SceneManager.getInstance().navigateTo("/fxml/mapa.fxml");
    }
    public void abrirStatus(){
        SceneManager.getInstance().navigateTo("/fxml/status.fxml");
    }
    public void abrirConfig(){
        SceneManager.getInstance().navigateTo("/fxml/config.fxml");
    }
}
