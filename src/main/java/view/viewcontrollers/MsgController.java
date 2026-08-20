package view.viewcontrollers;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import model.entidades.strategy.EstrategiaMordida;
import view.SceneManager;

import java.net.URL;
import java.util.ResourceBundle;

public class MsgController implements Initializable, Refreshable {

    @FXML
    private AnchorPane root;

    @FXML
    private Button btnOk;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Font.loadFont(getClass().getResourceAsStream("/fonts/PressStart2P-Regular.ttf"), 14);
        root.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());



        btnOk.setOnAction(e -> SceneManager.getInstance().navigateTo("/fxml/mapa.fxml"));
    }

    @Override
    public void onShow() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Vish...");
        alert.setHeaderText(null);
        alert.setContentText("Parece que algum dos seus atributos foi zerado...\nVocê volta no próximo semestre.");
        alert.showAndWait();

        Controller.getInstance().pularSemestre();
    }
}
