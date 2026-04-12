package model.model;

public class Jogo {
    private Jogador j;
    private Tempo tempo;
    private final int id; //no service vai chamar nextId do repositório
    public Jogo(Jogador j, Tempo tempo, int id) {
        this.j = j;
        this.tempo = tempo;
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
