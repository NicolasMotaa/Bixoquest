package model;

import model.entidades.Area;
import model.entidades.Professor;

import java.util.Objects;

public class Disciplina {
    private String nome;
    private Area area; //exatas, eletronica, programacao
    private int semestre;
    private double nota = 0;
    private Disciplina preRequisito;
    private boolean aprovado = false;
    private Professor professor;
    private int faltas = 0;
    private boolean isPBL;

    public Disciplina(String nome, Area area, int semestre, Disciplina preRequisito, Professor professor, boolean isPBL) {
        this.nome = nome;
        this.area = area;
        this.semestre = semestre;
        this.preRequisito = preRequisito;
        this.professor = professor;
        this.isPBL = isPBL;
    }

    public void calcularAprovacao(){
        this.aprovado = this.faltas <= 5 && !(this.nota < 7.0);
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    public void adicionarFalta(){
        this.faltas++;
    }

    public Area getArea() {
        return area;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    @Override
    public boolean equals(Object d){return (d instanceof Disciplina e) && e.nome.equals(nome);}

    @Override
    public int hashCode(){
        return Objects.hash(nome);
    }
}
