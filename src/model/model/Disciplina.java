package model.model;

public class Disciplina {
    private String nome;
    private Area area; //exatas, eletronica, programacao
    private int semestre;
    private double media;
    private Disciplina preRequisito;
    private boolean aprovado = false;
    private Professor professor;

    public Disciplina(String nome, Area area, int semestre, Disciplina preRequisito, Professor professor) {
        this.nome = nome;
        this.area = area;
        this.semestre = semestre;
        this.preRequisito = preRequisito;
        this.professor = professor;
    }

    public void aprovar(){
        this.aprovado = true;
    }

    public void setMedia(double media) {
        this.media = media;
       /* if (media >= 7.0)
            aprovar();*/ //eu posso fazer isso num setter?
    }
}
