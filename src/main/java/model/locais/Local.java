package model.locais;

import model.entidades.NPC;
import model.jogatina.Jogador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Local implements Serializable {
    private String nome;
    private String descricao;
    private List<NPC> npcs;


    public Local(String nome, String descricao, ArrayList<NPC> npcs) {
        this.nome = nome;
        this.descricao = descricao;
        this.npcs = npcs;
    }

    public void interagir(Jogador j){

    }

    public List<NPC> getNpcs() {
        return npcs;
    }
}
