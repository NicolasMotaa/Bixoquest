package model.jogatina.strategy;

import model.jogatina.Disciplina;
import model.jogatina.Jogador;

public class EstudarComAmigo implements EstrategiaAula {
    @Override
    public String executar(Jogador jogador, Disciplina disciplina) {
        jogador.alterarEnergia(-25);
        jogador.alterarMotivacao(+10);
        jogador.alterarConhecimento(disciplina, 10);
        jogador.setPresenteNaAula(true);
        return "+10 Conhecimento\n+10 Motivação\n-25 Energia";
    }
}
