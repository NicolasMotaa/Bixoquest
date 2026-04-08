package model.model;

public class Disciplina {
    private String nome;
    private String area; //exatas, eletronica, programacao
    private int semestre;
    private double media;
    private Disciplina preRequisito;
    private boolean aprovado;

    public Disciplina(String nome, String area, Disciplina pre){
        this.nome = nome;
        this.area = area;
        this.preRequisito = pre;
    }

}
