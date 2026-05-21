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
    private Scanner sc = new Scanner(System.in); //completamente provisório, isso é função da view

    public Controller(DisciplinaService disciplinaService, JogadorService jogadorService, JogoService jogoService) {
        this.disciplinaService = disciplinaService;
        this.jogadorService = jogadorService;
        this.jogoService = jogoService;
        this.jogoAtual = null;
    }

    public void loop() throws Exception {
        escolherJogo();
        while (isRunning) {
            System.out.println("Digite para:" +
                    "1- avançar dia (pegar onibus)" +
                    "2- salvar jogo" +
                    "3- escolher jogo" +
                    "4- salvar e fechar");
            switch (sc.nextInt()) {
                case 1 -> voltarParaCasa();
                case 2 -> salvarJogo();
                case 3 -> escolherJogo();
                case 4 -> fechar();
                default -> System.out.println("opção inválida");
            }
        }
    }

    private void salvarJogo() throws Exception {
        jogoService.salvarJogo(jogoAtual);
    }

    private void carregarJogos() throws IOException, ClassNotFoundException {
        jogoService.carregarJogos();

    }

    public void voltarParaCasa() throws Exception {
        jogadorService.pegarOnibus(jogoAtual);
        jogoService.avancarDia(jogoAtual);
        salvarJogo();
    }

    public void escolherJogo() throws Exception {
        carregarJogos();
        List<Jogo> lista = jogoService.listarJogos();
        for (Jogo jogo : lista) {
            System.out.println(jogo.toString());
        }
        System.out.println("Digite o ID do jogo desejado ou 0 para criar novo jogo.");

        int valor = sc.nextInt();
        if (valor == 0) {
            setJogoAtual(criarNovoJogo());
        } else
            setJogoAtual(jogoService.buscarJogo(valor));
        salvarJogo();
    }

    private Jogo criarNovoJogo() {
        System.out.println("Qual o nome do seu personagem?");
        String nome = sc.nextLine();
        return jogoService.criarJogo(nome);
    }

    public void fechar() throws Exception {
        salvarJogo();
        setRunning(false);
    }

    private void setJogoAtual(Jogo jogoAtual) {
        this.jogoAtual = jogoAtual;
    }

    private void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }


}

