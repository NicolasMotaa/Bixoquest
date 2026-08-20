package view.viewcontrollers;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import model.entidades.Professor;
import model.jogatina.*;
import model.jogatina.strategy.EstrategiaAula;
import model.jogatina.strategy.EstudarComAmigo;
import model.jogatina.strategy.MexerNoCelular;
import model.jogatina.strategy.PrestarAtencao;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SalaController implements Initializable, Refreshable {

    private List<Pergunta> perguntasProva;
    private int indicePerguntaAtual;
    private int acertos;

    @FXML
    private AnchorPane root;

    @FXML
    private HUDController hudController;

    // ============================
    // Elementos principais
    // ============================

    @FXML
    private ImageView imgProfessor;

    @FXML
    private Label lblProfessor;

    @FXML
    private Label lblDisciplina;

    @FXML
    private Button btnInteragir;

    // ============================
    // Painel de opções
    // ============================

    @FXML
    private AnchorPane painelOpcoes;

    @FXML
    private Button btnAtencao;

    @FXML
    private Button btnAmigo;

    @FXML
    private Button btnCelular;

    // ============================
    // Painel de resultado
    // ============================

    @FXML
    private AnchorPane painelResultado;

    @FXML
    private Label lblResultado;

    @FXML
    private Button btnOk;

    // ============================
    // Painel da prova
    // ============================

    @FXML
    private AnchorPane painelProva;

    @FXML
    private Label lblPergunta;

    @FXML
    private Button btnRespostaA;

    @FXML
    private Button btnRespostaB;

    @FXML
    private Button btnRespostaC;

    @FXML
    private Button btnRespostaD;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Font.loadFont(getClass().getResourceAsStream("/fonts/PressStart2P-Regular.ttf"), 14);

        root.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());

        // Garante que todos os painéis iniciem ocultos
        painelOpcoes.setVisible(false);
        painelResultado.setVisible(false);
        painelProva.setVisible(false);

        btnRespostaA.setOnAction(e -> handleResposta(0));
        btnRespostaB.setOnAction(e -> handleResposta(1));
        btnRespostaC.setOnAction(e -> handleResposta(2));
        btnRespostaD.setOnAction(e -> handleResposta(3));

        System.out.println("Tela de Sala carregada");
    }

    @Override
    public void onShow() {

        for (Disciplina d : Controller.getInstance().getJogoAtual().getJogador().getDisciplinasAtuais()) {
            System.out.println(d.getNome() + " - Faltas: " + d.getFaltas());
        }

        Disciplina disciplina = Controller.getInstance().getDisciplinaDoDia();

        if (disciplina == null || Controller.getInstance().getJogoAtual().getJogador().isPresenteNaAula()) {
            lblDisciplina.setText("Você não tem mais aulas hoje");
            lblProfessor.setText("");
            imgProfessor.setVisible(false);
            btnInteragir.setDisable(true);
            return;
        }

        imgProfessor.setVisible(true);
        Professor professor = disciplina.getProfessor();
        lblDisciplina.setText(disciplina.getNome());
        lblProfessor.setText(professor.getNome());
        imgProfessor.setImage(new Image(getClass().getResourceAsStream(professor.getCaminhoImagem())));

        btnInteragir.setDisable(Controller.getInstance().getJogoAtual().getTempo().getAcoesDisponiveis() < 1);
    }

    @FXML
    private void handleInteragir() {
        if (Controller.getInstance().getJogoAtual().getTempo().getSemanaAtual() == 4) {
            iniciarProva();
        } else {
            painelOpcoes.setVisible(true);
        }
    }

    private void executarEstrategia(EstrategiaAula estrategia) {
        Jogo jogo = Controller.getInstance().getJogoAtual();
        String resultado = estrategia.executar(jogo.getJogador(), Controller.getInstance().getDisciplinaDoDia());
        Controller.getInstance().consumirAcao();
        mostrarResultado(resultado);
        atualizarBotoes();
    }

    @FXML
    private void handleAtencao() {
        Jogo jogo = Controller.getInstance().getJogoAtual();
        Jogador jogador = jogo.getJogador();

        if (jogador.getMotivacao() < Constantes.CUSTO_MOTIVACAO_AULA) {
            mostrarResultado("Você está desmotivado demais para prestar atenção!");
            return;
        }
        if (jogador.getEnergia() < Constantes.CUSTO_ENERGIA_ESTUDAR) {
            mostrarResultado("Você está cansado demais para prestar atenção!");
            return;
        }

        executarEstrategia(new PrestarAtencao());
    }

    @FXML
    private void handleAmigo() {
        Disciplina disciplina = Controller.getInstance().getDisciplinaDoDia();

        if (Controller.getInstance().getJogoAtual().getJogador().getEnergia() < Constantes.CUSTO_ENERGIA_ESTUDAR) {
            mostrarResultado("Você está cansado demais para estudar com amigo!");
            return;
        }
        executarEstrategia(new EstudarComAmigo());
    }

    @FXML
    private void handleCelular() {
        executarEstrategia(new MexerNoCelular());
    }

    @FXML
    private void handleOk() {
        painelResultado.setVisible(false);
    }

    private void mostrarResultado(String texto) {
        painelOpcoes.setVisible(false);
        lblResultado.setText(texto);
        painelResultado.setVisible(true);
    }

    private void atualizarBotoes() {
        boolean semAcoes = Controller.getInstance().getJogoAtual().getTempo().getAcoesDisponiveis() < 1;
        boolean jaInteragiu = Controller.getInstance().getJogoAtual().getJogador().isPresenteNaAula();
        btnInteragir.setDisable(semAcoes || jaInteragiu);
    }

    private void iniciarProva() {
        Disciplina disciplina = Controller.getInstance().getDisciplinaDoDia();
        if(Controller.getInstance().verificarMilagre(disciplina)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Milagre Acadêmico!");
            alert.setHeaderText("Evento");
            alert.setContentText("A prova ficou fácil demais!!");
            alert.showAndWait();
        }
        int conhecimento = Controller.getInstance().getJogoAtual()
                .getJogador().getConhecimentoPorDisciplina(disciplina);

        perguntasProva = Controller.getInstance().gerarProva(disciplina, conhecimento);
        indicePerguntaAtual = 0;
        acertos = 0;

        exibirPergunta();
        painelProva.setVisible(true);
    }

    private void exibirPergunta() {
        Pergunta p = perguntasProva.get(indicePerguntaAtual);
        lblPergunta.setText(p.getEnunciado());

        List<String> alternativas = p.getAlternativas();
        btnRespostaA.setText(alternativas.get(0));
        btnRespostaB.setText(alternativas.get(1));
        btnRespostaC.setText(alternativas.get(2));
        btnRespostaD.setText(alternativas.get(3));
    }

    private void handleResposta(int indice) {
        Pergunta p = perguntasProva.get(indicePerguntaAtual);
        if (p.isCorreta(indice)) acertos++;

        indicePerguntaAtual++;

        if (indicePerguntaAtual < perguntasProva.size()) {
            exibirPergunta();
        } else {
            encerrarProva();
        }
    }

    private void encerrarProva() {
        painelProva.setVisible(false);
        Controller.getInstance().realizarProva(acertos); // aplica efeitos no jogador
        mostrarResultado("Você acertou " + acertos + " de 5 questões!");
        Controller.getInstance().consumirAcao();
        atualizarBotoes();
    }
}