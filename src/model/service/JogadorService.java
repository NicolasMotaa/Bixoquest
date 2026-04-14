package model.service;

import model.model.*;
import model.repository.JogoRepository;

import java.util.ArrayList;

public class JogadorService {

    //como deve ficar esse tempo aqui? vem de onde, é atributo ou oq?
    private Tempo tempo;
    private JogoRepository jogoRepository;

    public JogadorService(Tempo tempo, JogoRepository jogoRepository) {
        this.tempo = tempo;
        this.jogoRepository = jogoRepository;
    }

    public void interagirComSalaDeAula(Jogo jogo, SalaDeAula sala, Disciplina disciplina){
        Jogador jogador = jogo.getJogador();
        int dia = tempo.getDiaDaSemana();
        int semana = tempo.getSemanaAtual();
        if (jogador.getLocalizacao() != sala)
            throw new IllegalStateException("interação somente da sala de aula");
        if (tempo.getAcoesDisponiveis() < 1)
            throw new IllegalStateException("Você não pode estudar tão tarde!");
        if ((semana == 4 ) && (dia == 4 || dia == 5) ){
            sala.escolherInteracao(1, jogador, disciplina);
        }
        else{
            if (jogador.getEnergia()<Constantes.CUSTO_ENERGIA_ESTUDAR)
                throw new IllegalStateException("Cansado demais para estudar.");
            if (jogador.getMotivacao()<Constantes.CUSTO_MOTIVACAO_AULA)
                throw new IllegalStateException("Triste demais para estudar.");
            sala.escolherInteracao(2, jogador, disciplina);
            tempo.consumirAcoes();
            jogador.setPresenteNaAula(true);
        }
    }

    public void pegarOnibus(Jogo jogo, Jogador jogador, PontoDeOnibus ponto){
        ponto.interagir(jogador);
        //Controller deve chamar JogoService avancarDia()
    }

    public void estudarBiblioteca(Jogador jogador, Biblioteca biblioteca) {
        if (tempo.getAcoesDisponiveis() <= 0)
            throw new IllegalStateException("A biblioteca fecha daqui a pouco!");
        if (jogador.getLocalizacao() != biblioteca)
            throw new IllegalStateException("Esse tipo de estudo necessita de silêncio. Vá à biblioteca");
        if (jogador.getEnergia() < Constantes.CUSTO_ENERGIA_ESTUDAR)
            throw new IllegalStateException("Cansado demais para estudar.");
        biblioteca.interagir(jogador);
        tempo.consumirAcoes();

    }

    public void estudarComColega(Jogador jogador, Colega colega) {
        if (tempo.getAcoesDisponiveis() <= 0)
            throw new IllegalStateException("Você não pode estudar com seu colega tão tarde!");
        if ((colega.getLocalizacao() != (jogador.getLocalizacao())))
            throw new IllegalStateException("jogador e colega não estão no mesmo lugar");
        if ((jogador.getEnergia() < Constantes.CUSTO_ENERGIA_ESTUDAR))
            throw new IllegalStateException("Cansado demais pra estudar.");
        colega.estudarJunto(jogador);
        tempo.consumirAcoes();

    }
    public void jogarComColega(Jogador jogador, Colega colega) {
        if (tempo.getAcoesDisponiveis() <= 0)
            throw new IllegalStateException("Você não pode jogar com seu colega tão tarde!");
        if ((colega.getLocalizacao() != (jogador.getLocalizacao())))
            throw new IllegalStateException("jogador e colega não estão no mesmo lugar");
        if ((jogador.getEnergia() < Constantes.CUSTO_ENERGIA_JOGAR_COLEGA))
            throw new IllegalStateException("Cansado demais pra jogar.");
        colega.jogar(jogador);
        tempo.consumirAcoes();
    }

    public void fazerCarinho(Jogador jogador, Animal animal) {
        if (jogador.getLocalizacao() != animal.getLocalizacao())
            throw new IllegalStateException("jogador e animal não estão no mesmo lugar");
        animal.acariciar(jogador);
        //não consome ação
    }

}


