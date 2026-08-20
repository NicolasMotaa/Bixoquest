package model.service;

import model.entidades.*;
import model.jogatina.*;
import model.locais.*;
import model.repository.MapaRepository;


public class JogadorService {
    private final MapaRepository mapaRepository = new MapaRepository();


    public String interagirMaeli(){
        return MapaRepository.getMaeli().ajudar();

    }

    public boolean comprarLanche(Jogador jogador) {
        MapaRepository.getCantina().comprar(jogador);
        return new SemTroco().acontecer(jogador);
    }

    public boolean fazerCarinho(){
        return MapaRepository.getCachorro().isBravo();
    }

    public boolean gerarMilagre(Jogador jogador, Disciplina disciplina){
        return new MilagreAcademico().acontecer(disciplina, jogador);
    }

    public void realizarProva(Area area, Jogador jogador, int nota){
        MapaRepository.getSalaDeAula().fazerProva(area, jogador, nota);
    }


    public boolean pegarOnibus(Jogo jogo) {
        Jogador jogador = jogo.getJogador();
        MapaRepository.getPontoDeOnibus().interagir(jogador);
        return new NoiteMalDormida().acontecer(jogador);
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

//    public void fazerCarinho(Jogo jogo, Animal animal) {
//        Jogador jogador = jogo.getJogador();
//        if (jogador.getLocalizacao() != animal.getLocalizacao())
//            throw new IllegalStateException("jogador e animal não estão no mesmo lugar");
//        animal.acariciar(jogador);
//        //não consome ação
//    }

}


