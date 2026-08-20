package model.entidades.strategy;

import model.jogatina.Jogador;

public class EstrategiaMordida implements EstrategiaAnimal{
    @Override
    public String executar(Jogador jogador) {
        jogador.alterarSaude(-40);
        jogador.alterarMotivacao(-20);
        return "AU AU! O caramelo estava bravo e te mordeu!\n-40 Saúde\n-20 Motivação";
    }
}
