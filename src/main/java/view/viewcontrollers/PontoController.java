package view.viewcontrollers;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import model.jogatina.Jogo;
import model.jogatina.Tempo;
import model.jogatina.strategy.Formar;
import model.jogatina.strategy.Jubilar;
import view.SceneManager;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class PontoController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private Button btnPonto;

    @FXML
    private HUDController hudController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Font.loadFont(getClass().getResourceAsStream("/fonts/PressStart2P-Regular.ttf"), 14);
        root.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());

        System.out.println("Tela de Ponto carregada");

        btnPonto.setOnAction(e-> voltarPCasa());
    }

    public void voltarPCasa(){
        Jogo jogo = Controller.getInstance().getJogoAtual();
        if(Controller.getInstance().voltarPCasa()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Noite Mal Dormida!");
            alert.setHeaderText("Evento");
            alert.setContentText("Que dor de cabeça! você dormiu mal hoje.");
            alert.showAndWait();
        }

        Tempo tempo = Controller.getInstance().getJogoAtual().getTempo();
        if(tempo.getSemestreAtual() >= 11){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Fim de Jogo");
            alert.setHeaderText(null);
            alert.setContentText(new Jubilar().executar(jogo));

            Optional<ButtonType> resultado = alert.showAndWait();

            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                SceneManager.getInstance().navigateTo("/fxml/saves.fxml");
            }

        }
        else if (Controller.getInstance().verificarAprovacao()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Fim de Jogo");
            alert.setHeaderText(null);
            alert.setContentText(new Formar().executar(jogo));

            Optional<ButtonType> resultado = alert.showAndWait();

            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                SceneManager.getInstance().navigateTo("/fxml/saves.fxml");
            }
        }
    }

}
