package model;

public class SemTroco extends Evento{
    public SemTroco() {
        super("Sem troco", "Você ficou sem dinheiro miúdo e precisou pagar no cartão. - 5 reais.", 0.15);
    }

    @Override
    public void calcularSeOcorre() {
        super.calcularSeOcorre();
    }

    public void acontecer(Jogador jogador){
        if(isAplicado())
            jogador.alterarDinheiro(-5);
    }
}
