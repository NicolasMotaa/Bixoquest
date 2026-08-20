package model.jogatina;

import model.entidades.Area;
import model.entidades.Professor;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Disciplina implements Serializable {
    private String nome;
    private Area area; //exatas, eletronica, programacao
    private int semestre;
    private double nota = 0;
    private Disciplina preRequisito;
    private boolean aprovado = false;
    private Professor professor;
    private int faltas = 0;
    private boolean isPBL;
    private List<Pergunta> perguntas;


    public Disciplina(String nome, Area area, int semestre, Disciplina preRequisito, Professor professor, boolean isPBL, List<Pergunta> perguntas) {
        this.nome = nome;
        this.area = area;
        this.semestre = semestre;
        this.preRequisito = preRequisito;
        this.professor = professor;
        this.isPBL = isPBL;
        this.perguntas = perguntas;

    }

    public void calcularAprovacao(){
        this.aprovado = (this.faltas <= 2) && !(this.nota < 3.0);
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    public void adicionarFalta(){
        this.faltas++;
    }

    public int getFaltas() {
        return faltas;
    }

    public Area getArea() {
        return area;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public Disciplina getPreRequisito() {
        return preRequisito;
    }

    public int getSemestre() {
        return semestre;
    }

    public String getNome() {
        return nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Pergunta> getPerguntasPorNivel(NivelPergunta nivel) {
        return perguntas.stream()
                .filter(p -> p.getNivel() == nivel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object d){return (d instanceof Disciplina e) && e.nome.equals(nome);}

    @Override
    public int hashCode(){
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
