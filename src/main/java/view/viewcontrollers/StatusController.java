package view.viewcontrollers;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import model.jogatina.Disciplina;
import model.jogatina.Jogador;
import model.jogatina.Jogo;
import model.jogatina.Tempo;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StatusController implements Initializable, Refreshable {

    @FXML
    private AnchorPane root;

    // Informações do jogador
    @FXML
    private Label lblJogador;

    @FXML
    private Label lblTempo;

    // Status gerais
    @FXML
    private ProgressBar pbEnergia;

    @FXML
    private Label lblEnergiaValor;

    @FXML
    private ProgressBar pbMotivacao;

    @FXML
    private Label lblMotivacaoValor;

    @FXML
    private ProgressBar pbSaude;

    @FXML
    private Label lblSaudeValor;

    @FXML
    private Label lblDinheiro;

    // Conhecimentos
    @FXML
    private Label lblDisciplina1;

    @FXML
    private ProgressBar pbConhecimento1;

    @FXML
    private Label lblConhecimento1Valor;

    @FXML
    private Label lblDisciplina2;

    @FXML
    private ProgressBar pbConhecimento2;

    @FXML
    private Label lblConhecimento2Valor;

    @FXML
    private Label lblDisciplina3;

    @FXML
    private ProgressBar pbConhecimento3;

    @FXML
    private Label lblConhecimento3Valor;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Font.loadFont(getClass().getResourceAsStream("/fonts/PressStart2P-Regular.ttf"), 14);
        root.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
    }

    @Override
    public void onShow() {
        Jogo jogo = Controller.getInstance().getJogoAtual();
        Jogador jogador = jogo.getJogador();
        Tempo tempo = jogo.getTempo();

        // Informações gerais
        lblJogador.setText(jogador.getNome());
        lblTempo.setText("Semestre " + tempo.getSemestreAtual() +
                " | Semana " + tempo.getSemanaAtual() +
                " | Dia " + tempo.getDiaDaSemana());

        // Atributos
        pbEnergia.setProgress(jogador.getEnergia() / 100.0);
        lblEnergiaValor.setText(String.valueOf(jogador.getEnergia()));

        pbMotivacao.setProgress(jogador.getMotivacao() / 100.0);
        lblMotivacaoValor.setText(String.valueOf(jogador.getMotivacao()));

        pbSaude.setProgress(jogador.getSaude() / 100.0);
        lblSaudeValor.setText(String.valueOf(jogador.getSaude()));

        lblDinheiro.setText("R$ " + jogador.getDinheiro());

        // Conhecimentos por disciplina
        List<Disciplina> disciplinas = jogador.getDisciplinasAtuais();

        if (disciplinas.size() > 0) {
            Disciplina d1 = disciplinas.get(0);
            int c1 = jogador.getConhecimentoPorDisciplina(d1);
            int f1 = d1.getFaltas();
            lblDisciplina1.setText(d1.getNome());
            pbConhecimento1.setProgress(c1 / 100.0);
            lblConhecimento1Valor.setText(String.valueOf(f1));
        }

        if (disciplinas.size() > 1) {
            Disciplina d2 = disciplinas.get(1);
            int c2 = jogador.getConhecimentoPorDisciplina(d2);
            int f2 = d2.getFaltas();
            lblDisciplina2.setText(d2.getNome());
            pbConhecimento2.setProgress(c2 / 100.0);
            lblConhecimento2Valor.setText(String.valueOf(f2));
        }

        if (disciplinas.size() > 2) {
            Disciplina d3 = disciplinas.get(2);
            int c3 = jogador.getConhecimentoPorDisciplina(d3);
            int f3 = d3.getFaltas();
            lblDisciplina3.setText(d3.getNome());
            pbConhecimento3.setProgress(c3 / 100.0);
            lblConhecimento3Valor.setText(String.valueOf(f3));
        }
    }
}
