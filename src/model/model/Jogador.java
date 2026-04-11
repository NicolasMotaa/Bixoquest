package model.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jogador {
    private final String nome;
    private int energia;
    private int motivacao;
    private int saude;
    private int dinheiro;
    private List<Disciplina> disciplinasAprovadas;
    private List<Disciplina> disciplinasAtuais;
    private Map<Disciplina, Integer> conhecimentos;
    private final int id; //no service vai chamar nextId do repositório
    private Local localizacao; //definir local inicial

    public Jogador(String nome, int id, Local localizacao) {
        this.nome = nome;
        this.energia = 100;
        this.motivacao = 100;
        this.saude = 100;
        this.dinheiro = 100;
        this.disciplinasAprovadas = new ArrayList<>();
        this.disciplinasAtuais = new ArrayList<>();
        this.conhecimentos = new HashMap<>();
        this.id = id;
        this.localizacao = localizacao;
    }


    public int getId() {
        return id;
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
        this.dinheiro = Math.max(0, this.dinheiro + valor);
    }

    public String getNome() {
        return nome;
    }

    public int getEnergia() {
        return energia;
    }

    public int getMotivacao() {
        return motivacao;
    }

    public int getSaude() {
        return saude;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public List<Disciplina> getDisciplinasAprovadas() {
        return disciplinasAprovadas;
    }

    public List<Disciplina> getDisciplinasAtuais() {
        return disciplinasAtuais;
    }

    public Local getLocalizacao() {
        return localizacao;
    }
}
