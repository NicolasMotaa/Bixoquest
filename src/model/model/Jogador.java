package model.model;

public class Jogador {
    private String nome;
    private int energia;
    private int motivacao;
    private int saude;
    private int semestre;
    private int dinheiro;

    public Jogador(String nome, int energia, int motivacao, int saude, int semestre, int dinheiro) {
        this.nome = nome;
        this.energia = energia;
        this.motivacao = motivacao;
        this.saude = saude;
        this.semestre = semestre;
        this.dinheiro = dinheiro;
    }

}
