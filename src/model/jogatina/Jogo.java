package model.jogatina;

import java.io.Serializable;
import java.util.Objects;

public class Jogo implements Serializable {
    private Jogador j;
    private Tempo tempo;
    private int id; //no service vai chamar nextId do repositório

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

    public void setId(int id){
        this.id = id;
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

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Jogo jogo = (Jogo) object;
        return id == jogo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
