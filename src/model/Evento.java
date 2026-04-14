package model;

import java.util.Map;

public abstract class Evento {
    private String nome;
    private String descricao;
    private int probabilidade;
    private Map<String, Integer> alteracoes;

    public Evento(String nome, String descricao, int probabilidade, Map<String, Integer> alteracoes) {
        this.nome = nome;
        this.descricao = descricao;
        this.probabilidade = probabilidade;
        this.alteracoes = alteracoes;
    }

}