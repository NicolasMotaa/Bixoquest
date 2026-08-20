package model.locais;

import model.entidades.NPC;
import model.jogatina.Jogador;

import java.util.ArrayList;

public class Cantina extends Local{
    public Cantina(ArrayList<NPC> npcs) {
        super("Cantina", "Lanche caro, café frio", npcs);
    }

    public void comprar(Jogador jogador){
        jogador.alterarEnergia(+5);
        jogador.alterarSaude(+10);
        jogador.alterarDinheiro(-10);
    }
}
