package model.model;

public class Disciplina {
    private String nome;
    private String area; //exatas, eletronica, programacao
    private int semestre;
    private double media;
    private Disciplina preRequisito;
    private boolean aprovado = false;

    public Disciplina(String nome, String area, Disciplina pre){
        this.nome = nome;
        this.area = area;
        this.preRequisito = pre;
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
