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

public class CantinaController implements Initializable, Refreshable {

    @FXML
    private AnchorPane root;

    @FXML
    private Button btnComprar;

    @FXML
    private HUDController hudController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Font.loadFont(getClass().getResourceAsStream("/fonts/PressStart2P-Regular.ttf"), 14);
        root.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());

        btnComprar.setOnAction(e->comprar());
    }

    private void comprar(){
        if(Controller.getInstance().comprar()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Sem Troco");
            alert.setHeaderText("Evento");
            alert.setContentText("O vendedor não tinha troco e você gastou dinheiro de papel kkkk\n-5 reais"+
                    "\nMas o café tava bonzinho até.");
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cafézinho");
            alert.setHeaderText(null);
            alert.setContentText("+5 Energia\n+10 Saúde\n-10 reais");
            alert.showAndWait();
        }
        onShow();
    }

    @Override
    public void onShow() {
        if(Controller.getInstance().getJogoAtual().getJogador().getDinheiro() < 10){
            btnComprar.setDisable(true);
        }
    }
}
