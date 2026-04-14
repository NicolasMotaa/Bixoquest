package model.jogatina;

public class NoiteMalDormida extends Evento{
    public NoiteMalDormida() {
        super("Noite Mal Dormida", "Você dormiu mal e não descansou direito", 0.15);
    }

    @Override
    public void calcularSeOcorre() {
        super.calcularSeOcorre();
    }

    public void acontecer(Jogador jogador){
        jogador.alterarEnergia(-30);
    }
}
