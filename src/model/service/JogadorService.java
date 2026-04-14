package model.service;

import model.entidades.Animal;
import model.entidades.Colega;
import model.entidades.Maeli;
import model.entidades.Vendedor;
import model.jogatina.*;
import model.locais.*;


public class JogadorService {
    public JogadorService() {
    }

    public void interagirMaeli(Jogo jogo, Colegiado colegiado, Maeli maeli) {
        Jogador jogador = jogo.getJogador();
        if (jogador.getLocalizacao() != colegiado)
            throw new IllegalStateException("Esteja junto com Maelinda");
        maeli.ajudar();
    }

    public void comprarLanche(Jogo jogo, Cantina cantina, Vendedor vendedor) {
        Jogador jogador = jogo.getJogador();
        if (jogador.getLocalizacao() != cantina)
            throw new IllegalStateException("Esteja na cantina");
        if (jogador.getDinheiro() < 5)
            throw new IllegalStateException("Tá tudo dorme. Saldo insuficiente");
        SemTroco evento = new SemTroco();
        vendedor.vender(jogador);
        evento.acontecer(jogador);
    }


    public void interagirComSalaDeAula(Jogo jogo, SalaDeAula sala, Disciplina disciplina) {
        Jogador jogador = jogo.getJogador();
        Tempo tempo = jogo.getTempo();
        int dia = tempo.getDiaDaSemana();
        int semana = tempo.getSemanaAtual();
        if (jogador.getLocalizacao() != sala)
            throw new IllegalStateException("interação somente da sala de aula");
        if (tempo.getAcoesDisponiveis() < 1)
            throw new IllegalStateException("Você não pode estudar tão tarde!");
        if ((semana == 4) && (dia == 4 || dia == 5)) {
            MilagreAcademico milagreAcademico = new MilagreAcademico();
            milagreAcademico.acontecer(disciplina, jogador);
            sala.escolherInteracao(1, jogador, disciplina);
        } else {
            if (jogador.getEnergia() < Constantes.CUSTO_ENERGIA_ESTUDAR)
                throw new IllegalStateException("Cansado demais para estudar.");
            if (jogador.getMotivacao() < Constantes.CUSTO_MOTIVACAO_AULA)
                throw new IllegalStateException("Triste demais para estudar.");
            sala.escolherInteracao(2, jogador, disciplina);
            tempo.consumirAcoes();
            jogador.setPresenteNaAula(true);
        }
    }

    public void pegarOnibus(Jogo jogo, PontoDeOnibus ponto) {
        Jogador jogador = jogo.getJogador();
        ponto.interagir(jogador);
        NoiteMalDormida evento = new NoiteMalDormida();
        evento.acontecer(jogador);
        //Controller deve chamar JogoService avancarDia()
    }

    public void estudarBiblioteca(Jogo jogo, Biblioteca biblioteca) {
        Jogador jogador = jogo.getJogador();
        Tempo tempo = jogo.getTempo();
        if (tempo.getAcoesDisponiveis() <= 0)
            throw new IllegalStateException("A biblioteca fecha daqui a pouco!");
        if (jogador.getLocalizacao() != biblioteca)
            throw new IllegalStateException("Esse tipo de estudo necessita de silêncio. Vá à biblioteca");
        if (jogador.getEnergia() < Constantes.CUSTO_ENERGIA_ESTUDAR)
            throw new IllegalStateException("Cansado demais para estudar.");
        biblioteca.interagir(jogador);
        tempo.consumirAcoes();

    }

    public void desenvolverNoLab(Jogo jogo, Laboratorio laboratorio, Disciplina disciplina) {
        Jogador jogador = jogo.getJogador();
        Tempo tempo = jogo.getTempo();
        if (tempo.getAcoesDisponiveis() <= 0)
            throw new IllegalStateException("Está tarde, o Lab vai fechar!");
        if (jogador.getLocalizacao() != laboratorio)
            throw new IllegalStateException("Vá ao laboratório");
        if (jogador.getEnergia() < Constantes.CUSTO_ENERGIA_AULA)
            throw new IllegalStateException("Cansado demais para estudar.");
        if (jogador.getMotivacao() < Constantes.CUSTO_MOTIVACAO_AULA)
            throw new IllegalStateException("Triste demais para estudar.");

        laboratorio.desenvolverPBL(jogador, disciplina);

    }

    public void estudarComColega(Jogo jogo, Colega colega, Disciplina disciplina) {
        Jogador jogador = jogo.getJogador();
        Tempo tempo = jogo.getTempo();
        if (tempo.getAcoesDisponiveis() <= 0)
            throw new IllegalStateException("Você não pode estudar com seu colega tão tarde!");
        if ((colega.getLocalizacao() != (jogador.getLocalizacao())))
            throw new IllegalStateException("jogador e colega não estão no mesmo lugar");
        if ((jogador.getEnergia() < Constantes.CUSTO_ENERGIA_ESTUDAR))
            throw new IllegalStateException("Cansado demais pra estudar.");
        colega.estudarJunto(jogador, disciplina);
        tempo.consumirAcoes();

    }

    public void jogarComColega(Jogo jogo, Colega colega) {
        Jogador jogador = jogo.getJogador();
        Tempo tempo = jogo.getTempo();
        if (tempo.getAcoesDisponiveis() <= 0)
            throw new IllegalStateException("Você não pode jogar com seu colega tão tarde!");
        if ((colega.getLocalizacao() != (jogador.getLocalizacao())))
            throw new IllegalStateException("jogador e colega não estão no mesmo lugar");
        if ((jogador.getEnergia() < Constantes.CUSTO_ENERGIA_JOGAR_COLEGA))
            throw new IllegalStateException("Cansado demais pra jogar.");
        colega.jogar(jogador);
        tempo.consumirAcoes();
    }

    public void fazerCarinho(Jogo jogo, Animal animal) {
        Jogador jogador = jogo.getJogador();
        if (jogador.getLocalizacao() != animal.getLocalizacao())
            throw new IllegalStateException("jogador e animal não estão no mesmo lugar");
        animal.acariciar(jogador);
        //não consome ação
    }

}


