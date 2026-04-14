package model.model;

import java.util.ArrayList;

public class PontoDeOnibus extends Local{
    public PontoDeOnibus(String nome, String descricao, ArrayList<NPC> npcs) {
        super(nome, descricao, npcs);
    }

    @Override
    public void interagir(Jogador jogador){
        //jogador volta pra casa, lógica via service
        jogador.alterarEnergia(Constantes.RECUPERACAO_ENERGIA_SONO);
        jogador.alterarMotivacao(Constantes.RECUPERACAO_MOTIVACAO_SONO);
    }
}
