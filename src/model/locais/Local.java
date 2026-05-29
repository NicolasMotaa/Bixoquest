package model.locais;

import model.jogatina.Jogador;
import model.entidades.NPC;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public abstract class Local implements Serializable {
    private String nome;
    private String descricao;
    private List<NPC> npcs;


    public Local(String nome, String descricao, ArrayList<NPC> npcs) {
        this.nome = nome;
        this.descricao = descricao;
        this.npcs = npcs;
    }

    public void interagir(Jogador j){
       for(NPC npc : this.npcs){
           System.out.println(npc.getNome());
       }
    }

    public List<NPC> getNpcs() {
        return npcs;
    }
}
