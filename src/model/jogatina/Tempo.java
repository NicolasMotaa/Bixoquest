package model.jogatina;

import java.io.Serializable;

public class Tempo implements Serializable {
    private int semestreAtual = 1;
    private int semanaAtual = 1;
    private int acoesDisponiveis = 3;
    private int diaDaSemana = 1;
    //5 semestres de 4 semanas de 5 dias. Por enquanto 3 ações por dia

    public void avancarDia() {
        this.diaDaSemana += 1;
        this.acoesDisponiveis = 3;
    }

    public void avancarSemana() {
        this.semanaAtual += 1;
        this.diaDaSemana = 1;
        this.acoesDisponiveis = 3;
    }
    public void avancarSemestre(){
        this.semestreAtual += 1;
        this.semanaAtual = 1;
        this.diaDaSemana = 1;
        this. acoesDisponiveis = 3;
    }
    public void consumirAcoes() {
        this.acoesDisponiveis -= 1;
    }

    public int getDiaDaSemana() {
        return diaDaSemana;
    }

    // atualizar setters com as lógicas dos limites definidos
    public int getSemestreAtual() {
        return semestreAtual;
    }

    public int getSemanaAtual() {
        return semanaAtual;
    }

    public int getAcoesDisponiveis() {
        return acoesDisponiveis;
    }

}
