package model.locais;

import model.entidades.NPC;

import java.util.ArrayList;

public class Cantina extends Local{
    public Cantina(ArrayList<NPC> npcs) {
        super("Cantina", "Lanche caro, café frio", npcs);
    }
}
