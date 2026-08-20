package model.locais;

import model.entidades.Area;
import model.entidades.NPC;
import model.jogatina.Constantes;
import model.jogatina.Disciplina;
import model.jogatina.Jogador;

import java.util.ArrayList;

public class SalaDeAula extends Local {


    public SalaDeAula(ArrayList<NPC> npcs) {
        super("Sala de Aula", "PAT 57", npcs);
    }

//    public void escolherInteracao(int num, Jogador jogador, Disciplina disciplina){
//        switch (num){
//            case 1 -> fazerProva(disciplina, jogador);
//            case 2 -> assistirAula(jogador, disciplina);
//        }
//    }

    public void prestarAtencao(Jogador jogador, Disciplina disciplina) {
        jogador.alterarConhecimento(disciplina, Constantes.BONUS_CONHECIMENTO_AULA);
        jogador.alterarEnergia(-Constantes.CUSTO_ENERGIA_AULA);
        jogador.alterarMotivacao(-Constantes.CUSTO_MOTIVACAO_AULA);
        jogador.setPresenteNaAula(true);
    }

    public void estudarComAmigo(Jogador jogador, Disciplina disciplina) {
        jogador.alterarConhecimento(disciplina, 10);
        jogador.alterarMotivacao(+5);
        jogador.alterarEnergia(-Constantes.CUSTO_ENERGIA_AULA);
        jogador.setPresenteNaAula(true);
    }

    public void mexerNoCelular(Jogador jogador) {
        jogador.alterarMotivacao(+10);
        jogador.alterarEnergia(-Constantes.CUSTO_ENERGIA_AULA);
        jogador.setPresenteNaAula(true);
    }


    public void fazerProva(Area area, Jogador jogador, int nota){
        jogador.getDisciplinaAtual(area).setNota(nota);
        jogador.getDisciplinaAtual(area).calcularAprovacao();
    }
}
