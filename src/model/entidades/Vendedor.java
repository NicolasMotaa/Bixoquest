package model.entidades;

import model.Constantes;
import model.Jogador;
import model.locais.Cantina;


public class Vendedor extends NPC {
    public Vendedor(Cantina localizacao) {
        super("Vendedor Salles", "Cobra muito caro, mas te salva", localizacao);
    }

    public void vender(Jogador jogador){
        jogador.alterarDinheiro(-5);
        jogador.alterarEnergia(Constantes.BONUS_CAFEZINHO);
        jogador.alterarMotivacao(Constantes.BONUS_CAFEZINHO);
    }
}
