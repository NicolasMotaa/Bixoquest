package model.jogatina.strategy;

import model.jogatina.Disciplina;
import model.jogatina.Jogador;

public class PrestarAtencao implements EstrategiaAula {
    @Override
    public String executar(Jogador jogador, Disciplina disciplina) {
        jogador.alterarConhecimento(disciplina, 35);
        jogador.alterarEnergia(-20);
        jogador.alterarMotivacao(-15);
        jogador.setPresenteNaAula(true);
        return "+35 Conhecimento\n-20 Energia\n-15 Motivação";
    }
}
