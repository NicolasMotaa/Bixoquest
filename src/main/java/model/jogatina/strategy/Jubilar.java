package model.jogatina.strategy;

import model.jogatina.Jogo;

public class Jubilar implements EstrategiaFinalizar{
    @Override
    public String executar(Jogo jogo) {
        jogo.setFinalizado(true);
        return "Você excedeu o limite de semestres e foi jubilado";
    }
}
