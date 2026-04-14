package model.locais;

import model.jogatina.Constantes;
import model.jogatina.Disciplina;
import model.jogatina.Jogador;
import model.entidades.NPC;

import java.util.ArrayList;

public class Laboratorio extends Local {
    public Laboratorio(ArrayList<NPC> npcs) {
        super("Laboratorio", "Desenvolvimento de Projetos", npcs);
    }

    public void desenvolverPBL(Jogador jogador, Disciplina disciplina){
        jogador.alterarMotivacao(Constantes.CUSTO_MOTIVACAO_AULA);
        jogador.alterarEnergia(Constantes.CUSTO_ENERGIA_AULA);
        jogador.alterarConhecimento(disciplina, Constantes.BONUS_CONHECIMENTO_AULA);
    }
}
