package controller;

import model.jogatina.Jogo;
import model.service.DisciplinaService;
import model.service.JogadorService;
import model.service.JogoService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/* O QUE É QUE FALTA MEU DEUS?
 *  - criar novo jogo
 *       -> lista = service.listarJogos(); CHECK
 *  - loop CHECK
 *  - classe de excessões -> vai ficar na view
 *  - testes
 *
 * */

public class Controller {
    private final DisciplinaService disciplinaService;
    private final JogadorService jogadorService;
    private final JogoService jogoService;
    private boolean isRunning = true;
    private Jogo jogoAtual;
    private final Scanner sc = new Scanner(System.in); //completamente provisório, isso é função da view

    public Controller(DisciplinaService disciplinaService, JogadorService jogadorService, JogoService jogoService) {
        this.disciplinaService = disciplinaService;
        this.jogadorService = jogadorService;
        this.jogoService = jogoService;
        this.jogoAtual = null;
    }

    public void loop() throws Exception {
        int id = lerInt();
        escolherJogo(id, id == 0 ? lerString() : null);
        while (isRunning) {
            switch (lerInt()) {
                case 1 -> voltarParaCasa();
                case 2 -> salvarJogo();
                case 3 -> escolherJogo(lerInt(), null);
                case 4 -> fechar();
                default -> System.out.println("opção inválida");
            }
        }
    }

    public Jogo criarNovoJogo(String nome) throws Exception {
        Jogo novo = jogoService.criarJogo(nome);
        setJogoAtual(novo);
        salvarJogo();
        return novo;
    }

    public void escolherJogo(int id, String nomeSeNovo) throws Exception {
        if (jogoAtual != null) salvarJogo();
        carregarJogos();
        if (id == 0) {
            criarNovoJogo(nomeSeNovo);
        } else {
            setJogoAtual(jogoService.buscarJogo(id));
        }
    }

    public void voltarParaCasa() throws Exception {
        jogadorService.pegarOnibus(jogoAtual);
        jogoService.avancarDia(jogoAtual);
        salvarJogo();
    }

    public void fechar() throws Exception {
        salvarJogo();
        setRunning(false);
    }

    public List<Jogo> listarJogos() {
        return jogoService.listarJogos();
    }

    public void salvarJogo() throws Exception {
        jogoService.salvarJogo(jogoAtual);
    }

    public void carregarJogos() throws Exception {
        jogoService.carregarJogos();
    }

    private int lerInt() { return sc.nextInt(); }
    private String lerString() { return sc.next(); }

    // getters e setters
    public Jogo getJogoAtual() { return jogoAtual; }
    public void setJogoAtual(Jogo jogoAtual) { this.jogoAtual = jogoAtual; }
    public void setRunning(boolean running) { isRunning = running; }
    public boolean isRunning() { return isRunning; }



}

