package model.model;

import java.util.ArrayList;

public class Jogador {
    private String nome;
    private int energia;
    private int motivacao;
    private int saude;
    private int dinheiro;
    private ArrayList<Disciplina> disciplinasAprovadas;
    private ArrayList<Disciplina> disciplinasAtuais;

    public Jogador(String nome, int energia, int motivacao, int saude, int dinheiro) {
        this.nome = nome;
        this.energia = energia;
        this.motivacao = motivacao;
        this.saude = saude;
        this.dinheiro = dinheiro;
    }

    public void andar() {
        //alterar x e y, a ver como isso vai funcionar
    }

    public void alterarEnergia(int valor) {
        this.energia = Math.max(0, Math.min(100, this.energia + valor));
    }

    public void alterarMotivacao(int valor) {
        this.motivacao = Math.max(0, Math.min(100, this.motivacao + valor));
    }

    public void alterarSaude(int valor) {
        this.saude = Math.max(0, Math.min(100, this.saude + valor));
    }

    public void alterarDinheiro(int valor) {
        this.dinheiro = Math.max(0, Math.min(100, this.dinheiro + valor));
    }
}
