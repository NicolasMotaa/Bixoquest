package controller;

import model.jogatina.Disciplina;
import model.jogatina.Jogador;
import model.jogatina.Jogo;
import model.jogatina.Pergunta;
import model.repository.DisciplinaRepository;
import model.repository.JogoRepository;
import model.repository.MapaRepository;
import model.service.DisciplinaService;
import model.service.JogadorService;
import model.service.JogoService;

import java.util.List;

public class Controller {

    private static Controller instance;
    private DisciplinaService disciplinaService;
    private JogadorService jogadorService;
    private JogoService jogoService;
    private Jogo jogoAtual;

    private Controller(DisciplinaService disciplinaService, JogadorService jogadorService, JogoService jogoService) {
        this.disciplinaService = disciplinaService;
        this.jogadorService = jogadorService;
        this.jogoService = jogoService;
    }

    public static Controller getInstance(){
        if (instance == null){
            MapaRepository.inicializar();
            JogoRepository jogoRepository = new JogoRepository();
            JogadorService jogadorService = new JogadorService();
            DisciplinaService disciplinaService = new DisciplinaService();
            JogoService jogoService = new JogoService(jogoRepository, disciplinaService);

            return instance = new Controller(disciplinaService, jogadorService, jogoService);
        }
        return instance;
    }

    public Jogo getJogoAtual() {
        return jogoAtual;
    }

    public void setJogoAtual(Jogo jogoAtual) {
        this.jogoAtual = jogoAtual;
    }

    public Jogo buscarJogo(int id){
        return jogoService.buscarJogo(id);
    }

    public void deletarJogo(int id) throws Exception {
         jogoService.deletarJogo(id);
    }

    public Jogo criarNovoJogo() throws Exception {
        return jogoService.criarJogo("Henry");
    }

    public void salvarJogo() throws Exception{
        jogoService.salvarJogo(jogoAtual);
    }

    public void consumirAcao(){
        jogoService.consumirAcao(jogoAtual);
    }

    public boolean voltarPCasa(){
        jogoService.avancarDia(jogoAtual);
        return jogadorService.pegarOnibus(jogoAtual);
    }

    public Disciplina getDisciplinaDoDia(){
        return jogoService.getDisciplinaDoDia(jogoAtual);
    }

    public boolean verificarMilagre(Disciplina disciplina){
        return jogadorService.gerarMilagre(jogoAtual.getJogador(), disciplina);
    }

    public List<Pergunta> gerarProva(Disciplina disciplina, int conhecimento){
        return disciplinaService.gerarProva(disciplina,conhecimento);
    }

    public void realizarProva(int nota){
        jogadorService.realizarProva(getDisciplinaDoDia().getArea(), jogoAtual.getJogador(), nota);
    }

    public boolean fazerCarinho(){
        return jogadorService.fazerCarinho();
    }

    public void pularSemestre(){
        jogoService.avancarSemestre(jogoAtual);
    }
    public boolean verificarAprovacao(){
        return disciplinaService.aprovadoEmTodas(jogoAtual.getJogador());
    }

    public Jogo getJogoQualquer(int id){
        return jogoService.buscarJogo(id);
    }
    public String fraseMaeli(){
        return jogadorService.interagirMaeli();
    }

    public boolean comprar(){
        return jogadorService.comprarLanche(jogoAtual.getJogador());
    }
}
