package model.model;

public class Tempo {
    private int semestreAtual = 0;
    private int semanaAtual = 1;
    private int acoes = 3;

    public void consumirAcoes(){
        this.acoes -= 1;
    }
}
