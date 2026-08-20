package model.entidades.strategy;

import model.jogatina.Jogador;

public class EstrategiaCarinho implements EstrategiaAnimal{
    @Override
    public String executar(Jogador jogador) {
        jogador.alterarMotivacao(+5);
        return "Que fofo!!\n+5 Motivação";
    }
}
