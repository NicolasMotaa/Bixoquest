package model.locais;

import model.Constantes;
import model.Jogador;
import model.entidades.NPC;

import java.util.ArrayList;

public class Biblioteca extends Local {
    public Biblioteca(ArrayList<NPC> npcs) {
        super("Biblioteca Julieta", "Onde se pode estudar", npcs);
    }

    @Override
    public void interagir(Jogador j){
        //estudar
        j.alterarEnergia(-Constantes.CUSTO_ENERGIA_ESTUDAR);
        //implementar melhora de conhecimento
    }
}
