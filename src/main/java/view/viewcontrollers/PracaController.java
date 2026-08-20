package view.viewcontrollers;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import model.entidades.strategy.EstrategiaAnimal;
import model.entidades.strategy.EstrategiaCarinho;
import model.entidades.strategy.EstrategiaMordida;
import model.jogatina.Jogador;
import view.SceneManager;

import java.net.URL;
import java.util.ResourceBundle;

public class PracaController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private Button btnCaramelo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Font.loadFont(getClass().getResourceAsStream("/fonts/PressStart2P-Regular.ttf"), 14);
        root.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());

        btnCaramelo.setOnAction(e -> executarEstrategia());
    }

    private void executarEstrategia(){
        Jogador jogador = Controller.getInstance().getJogoAtual().getJogador();
        if(Controller.getInstance().fazerCarinho()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Mordida");
            alert.setHeaderText(null);
            alert.setContentText(new EstrategiaMordida().executar(jogador));
            alert.showAndWait();
            if(jogador.getSaude() <=0 ){
                SceneManager.getInstance().navigateTo("/fxml/msg.fxml");
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Carinho");
            alert.setHeaderText(null);
            alert.setContentText(new EstrategiaCarinho().executar(jogador));
            alert.showAndWait();

        }
    }



}