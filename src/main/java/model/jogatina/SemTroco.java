package model.jogatina;

public class SemTroco extends Evento{
    public SemTroco() {
        super("Sem troco", "Você ficou sem dinheiro miúdo e precisou pagar no cartão. - 5 reais.", 0.15);
    }

    public boolean acontecer(Jogador jogador){
        if(calcularSeOcorre()) {
            jogador.alterarDinheiro(-5);
            return true;
        }
        else
            return false;
    }
}
