package model.locais;

import model.jogatina.Constantes;
import model.jogatina.Jogador;
import model.entidades.NPC;

import java.util.ArrayList;

public class PontoDeOnibus extends Local {
    public PontoDeOnibus(ArrayList<NPC> npcs) {
        super("Ponto De Onibus", "Pegar o 003 pra ir pra casa", npcs);
    }

    @Override
    public void interagir(Jogador jogador){
        //jogador volta pra casa, lógica via service
        jogador.alterarEnergia(Constantes.RECUPERACAO_ENERGIA_SONO);
        jogador.alterarMotivacao(Constantes.RECUPERACAO_MOTIVACAO_SONO);
    }
}
