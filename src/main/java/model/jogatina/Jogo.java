package model.jogatina;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

public class Jogo implements Serializable {
    private Jogador j;
    private Tempo tempo;
    private int id; //no service vai chamar nextId do repositório
    private String data;
    private boolean finalizado = false;

    public Jogo(Jogador j, int id) {
        this.j = j;
        this.tempo = new Tempo();
        this.id = id;
        setData();
    }

    public String getData() {
        return data;
    }

    public void setData(){
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatoBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.data = hoje.format(formatoBr);
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

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
}
