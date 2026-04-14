package model.locais;

import model.Jogador;
import model.entidades.NPC;

import java.util.ArrayList;

/**
 * biblioteca, lab, sala de aula, ponto de onibus: subclasses com comportamentos proprios
 * cantina, colegiado, praça: instancias diretas, com npcs que assumem os comportamentos
 */
public abstract class Local {
    private String nome;
    private String descricao;
    private ArrayList<NPC> Npcs;


    public Local(String nome, String descricao, ArrayList<NPC> npcs) {
        this.nome = nome;
        this.descricao = descricao;
        Npcs = npcs;
    }

    public void interagir(Jogador j){
       for(NPC npc : this.Npcs){
           System.out.println(npc.getNome());
       }
    }
}
