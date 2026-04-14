package model.model;

public class Jogo {
    private Jogador j;
    private Tempo tempo;
    private final int id; //no service vai chamar nextId do repositório
    public Jogo(Jogador j, int id) {
        this.j = j;
        this.tempo = new Tempo();
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
}
