package model.jogatina;

import java.util.Random;

public abstract class Evento {
    private String nome;
    private String descricao;
    private double probabilidade;
    private boolean isAplicado;
    public Evento(String nome, String descricao, double probabilidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.probabilidade = probabilidade;
    }

    public void calcularSeOcorre(){
        Random random = new Random();
        this.isAplicado = random.nextDouble() < this.probabilidade;
    }

    public boolean isAplicado() {
        return isAplicado;
    }
}