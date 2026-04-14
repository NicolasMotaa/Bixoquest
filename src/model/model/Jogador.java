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
    private Local localizacao; //definir local inicial
    private boolean isPresenteNaAula = false;

    public Jogador(String nome, Local localizacao) {
        this.nome = nome;
        this.energia = 100;
        this.motivacao = 100;
        this.saude = 100;
        this.dinheiro = 100;
        this.disciplinasAprovadas = new ArrayList<>();
        this.disciplinasAtuais = new ArrayList<>();
        this.conhecimentos = new HashMap<>();
        this.localizacao = localizacao;
    }

    public void alterarConhecimento(Disciplina disciplina,int valor){
        this.conhecimentos.merge(disciplina, Math.max(100, valor+conhecimentos.get(disciplina)), (valorAntigo, valorNovo) -> valorAntigo + valorNovo);
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

    public int getConhecimentoPorDisciplina(Disciplina disciplina){
        return this.conhecimentos.get(disciplina);
    }

    public Local getLocalizacao() {
        return localizacao;
    }

    public boolean isPresenteNaAula() {
        return isPresenteNaAula;
    }

    public void setPresenteNaAula(boolean presenteNaAula) {
        this.isPresenteNaAula = presenteNaAula;
    }
}
