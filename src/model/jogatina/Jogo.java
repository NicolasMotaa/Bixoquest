package model.jogatina;

import java.io.Serializable;

public class Jogo implements Serializable {
    private Jogador j;
    private Tempo tempo;
    private final int id; //no service vai chamar nextId do repositório

    public Jogo(Jogador j, int id) {
        this.j = j;
        this.tempo = new Tempo();
        this.id = id;
    }

    public Jogador getJ() {
        return j;
    }

    public void setJ(Jogador j) {
        this.j = j;
    }

    public void setTempo(Tempo tempo) {
        this.tempo = tempo;
    }


    public int getId() {
        return id;
    }

    public Jogador getJogador(){
        return j;
    }
    public Tempo getTempo() {
        return tempo;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                ", tempo=" + tempo +
                ", id=" + id +
                '}';
    }
}
