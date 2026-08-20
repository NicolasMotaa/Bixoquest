package model.locais;

import model.entidades.NPC;
import model.jogatina.Constantes;
import model.jogatina.Jogador;

import java.util.ArrayList;

public class Biblioteca extends Local implements iLocal {
    public Biblioteca(ArrayList<NPC> npcs) {
        super("Biblioteca Julieta", "Onde se pode estudar", npcs);
    }

    @Override
    public void interagir(Jogador jogador) {
        //estudar
        jogador.alterarEnergia(-Constantes.CUSTO_ENERGIA_ESTUDAR);
        //implementar melhora de conhecimento
    }


}
