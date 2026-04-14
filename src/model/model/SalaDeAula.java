package model.model;

import java.util.ArrayList;

public class SalaDeAula extends Local{


    public SalaDeAula(String nome, String descricao, ArrayList<NPC> npcs) {
        super(nome, descricao, npcs);
    }

    public void escolherInteracao(int num, Jogador jogador, Disciplina disciplina){
        switch (num){
            case 1 -> fazerProva(disciplina, jogador);
            case 2 -> assistirAula(jogador, disciplina);
        }
    }
    public void assistirAula(Jogador jogador, Disciplina disciplina){
        jogador.alterarEnergia(-Constantes.CUSTO_ENERGIA_AULA);
        jogador.alterarMotivacao(-Constantes.CUSTO_MOTIVACAO_AULA);
        jogador.alterarConhecimento(disciplina, Constantes.BONUS_CONHECIMENTO_AULA);
    }

    public void fazerProva(Disciplina disciplina, Jogador jogador){
        disciplina.setNota(jogador.getConhecimentoPorDisciplina(disciplina)/100.0);
        disciplina.calcularAprovacao();
    }
}
