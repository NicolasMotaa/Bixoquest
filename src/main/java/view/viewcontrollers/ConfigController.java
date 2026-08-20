package view.viewcontrollers;

import controller.Controller;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import view.SceneManager;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ConfigController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private Label lblTitulo;

    @FXML
    private Button btnSalvarJogo;

    @FXML
    private Button btnSelecionarSaves;

    @FXML
    private Button btnFecharJogo;

    @FXML
    private HUDController hudController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Font.loadFont(getClass().getResourceAsStream("/fonts/PressStart2P-Regular.ttf"), 14);
        root.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());

        btnFecharJogo.setOnAction(e->fechar());
        btnSalvarJogo.setOnAction(e->salvar());
        btnSelecionarSaves.setOnAction(e-> goToSaves());
    }

    private void salvar(){
        try {
            Controller.getInstance().salvarJogo();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Falha ao salvar o jogo");
            alert.setContentText("Não foi possível salvar o jogo. Tente novamente.");

            alert.showAndWait();
        }
    }

    private void goToSaves(){
        SceneManager.getInstance().navigateTo("/fxml/saves.fxml");
    }

    private void fechar(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Fechar jogo");
        alert.setHeaderText(null);
        alert.setContentText("Tem certeza que deseja fechar o jogo? Verifique se salvou.");

        Optional<ButtonType> resultado = alert.showAndWait();

        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            Platform.exit();
        }
    }
}
