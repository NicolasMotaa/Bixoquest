package view.viewcontrollers;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;


public class ColegiadoController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private Button btnMaeli;

    @FXML
    private HUDController hudController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Font.loadFont(getClass().getResourceAsStream("/fonts/PressStart2P-Regular.ttf"), 14);
        root.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());

        btnMaeli.setOnAction(e->exibirMsg());
    }

    private void exibirMsg(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sacerdotisa Maeli");
        alert.setHeaderText(null);
        alert.setContentText(Controller.getInstance().fraseMaeli());

        alert.showAndWait();
    }
}
