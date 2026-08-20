package model.jogatina.strategy;

import model.jogatina.Disciplina;
import model.jogatina.Jogador;

public interface EstrategiaAula {
    String executar(Jogador jogador, Disciplina disciplina);
}
