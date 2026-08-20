package view.viewcontrollers;


import controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import model.entidades.Area;
import model.jogatina.Jogo;
import model.repository.DisciplinaRepository;
import view.SceneManager;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class SaveController implements Initializable, Refreshable {

    @FXML
    private AnchorPane root;
    // SLOT 1

    @FXML
    private Label lblJogador1;

    @FXML
    private Label lblSemestre1;

    @FXML
    private Label lblData1;

    @FXML
    private Button btnJogar1;

    @FXML
    private Button btnDeletar1;



    // SLOT 2

    @FXML
    private Label lblJogador2;

    @FXML
    private Label lblSemestre2;

    @FXML
    private Label lblData2;

    @FXML
    private Button btnJogar2;

    @FXML
    private Button btnDeletar2;



    // SLOT 3

    @FXML
    private Label lblJogador3;

    @FXML
    private Label lblSemestre3;

    @FXML
    private Label lblData3;

    @FXML
    private Button btnJogar3;

    @FXML
    private Button btnDeletar3;

    private List<Label> lblJogadores;
    private List<Label> lblSemestres;
    private List<Label> lblDatas;

    private List<Button> btnJogar;
    private List<Button> btnDeletar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Font.loadFont(getClass().getResourceAsStream("/fonts/PressStart2P-Regular.ttf"), 14);
        root.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());

        System.out.println("Tela de saves carregada");

        lblJogadores = List.of(lblJogador1, lblJogador2, lblJogador3);
        lblSemestres = List.of(lblSemestre1, lblSemestre2, lblSemestre3);
        lblDatas = List.of(lblData1, lblData2, lblData3);

        btnJogar = List.of(btnJogar1, btnJogar2, btnJogar3);
        btnDeletar = List.of(btnDeletar1, btnDeletar2, btnDeletar3);

        atualizarTela();
    }

    private void atualizarTela() {

        for (int i = 0; i < 3; i++) {

            Jogo jogo = Controller.getInstance().buscarJogo(i + 1);

            boolean existeSave = jogo != null;
            final int slot = i + 1;

            if (existeSave) {
                lblJogadores.get(i).setText(jogo.getJogador().getNome());
                lblSemestres.get(i).setText("Semestre: "+ (jogo.getTempo().getSemestreAtual()));
                lblDatas.get(i).setText(jogo.getData());
            } else {
                lblJogadores.get(i).setText("");
                lblSemestres.get(i).setText("");
                lblDatas.get(i).setText("");
            }

            btnJogar.get(i).setText(existeSave ? "Continuar" : "Novo Jogo");
            btnDeletar.get(i).setDisable(!existeSave);

            btnJogar.get(i).setOnAction(e -> {
                if (existeSave) {
                    carregarJogo(slot);
                } else {
                    try {
                        novoJogo(slot);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            btnDeletar.get(i).setOnAction(e -> {
                try {
                    deletarSave(slot);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
    }

    private void novoJogo(int slot) throws Exception {

        Controller.getInstance().criarNovoJogo();
        atualizarTela();

        // chama tela de apresentação com botão de continuar -> mapa

    }

    private void carregarJogo(int slot){
        SceneManager.getInstance().navigateTo("/fxml/mapa.fxml");
        Controller.getInstance().setJogoAtual(Controller.getInstance().buscarJogo(slot));
    }


    private void deletarSave(int slot) throws Exception {

        Controller.getInstance().deletarJogo(slot);
        atualizarTela();
        // depois você apaga o arquivo do save

    }


    @Override
    public void onShow() {
        atualizarTela();
    }
}