package model.jogatina.strategy;


import model.jogatina.Jogo;

public class Formar implements EstrategiaFinalizar {
    @Override
    public String executar(Jogo jogo) {
        jogo.setFinalizado(true);
        return "Parabéns! Você se formou!";
    }
}
