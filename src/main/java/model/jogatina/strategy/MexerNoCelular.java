package model.jogatina.strategy;

import model.jogatina.Disciplina;
import model.jogatina.Jogador;

public class MexerNoCelular implements EstrategiaAula {
    @Override
    public String executar(Jogador jogador, Disciplina disciplina) {
        jogador.alterarMotivacao(+10);
        jogador.setPresenteNaAula(true);
        return "+10 Motivação";
    }
}