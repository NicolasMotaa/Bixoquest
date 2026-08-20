package view.viewcontrollers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import view.SceneManager;


import java.net.URL;
import java.util.ResourceBundle;

public class MapaController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private Button btnBiblioteca;

    @FXML
    private Button btnCantina;

    @FXML
    private Button btnLab;

    @FXML
    private Button btnSala;

    @FXML
    private Button btnPonto;

    @FXML
    private Button btnColegiado;

    @FXML
    private Button btnPraca;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Font.loadFont(getClass().getResourceAsStream("/fonts/PressStart2P-Regular.ttf"), 14);
        root.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());

        System.out.println("Tela de Mapa carregada");

        btnBiblioteca.setOnAction(e-> goToBiblioteca());
        btnCantina.setOnAction(e->goToCantina());
        btnLab.setOnAction(e-> goToLab());
        btnSala.setOnAction(e-> goToSala());
        btnPonto.setOnAction(e-> goToPonto());
        btnColegiado.setOnAction(e-> goToColegiado());
        btnPraca.setOnAction(e-> goToPraca());
    }

    public void goToBiblioteca(){
        System.out.println("indo à biblioteca");
    }
    public void goToCantina(){
        SceneManager.getInstance().navigateTo("/fxml/cantina.fxml");
    }
    public void goToLab(){
        System.out.println("laboratorio");
    }
    public void goToSala(){
        SceneManager.getInstance().navigateTo("/fxml/sala.fxml");

    }
    public void goToPonto(){
        System.out.println("Ponto");
        SceneManager.getInstance().navigateTo("/fxml/ponto.fxml");
    }
    void goToColegiado(){
        SceneManager.getInstance().navigateTo("/fxml/colegiado.fxml");
    }
    void goToPraca(){
        SceneManager.getInstance().navigateTo("/fxml/praca.fxml");
    }
}
