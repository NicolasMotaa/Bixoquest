package model.jogatina;

public class NoiteMalDormida extends Evento{
    public NoiteMalDormida() {
        super("Noite Mal Dormida", "Você dormiu mal e não descansou direito", 0.3);
    }

    public Boolean acontecer(Jogador jogador){
        if(calcularSeOcorre()) {
            jogador.alterarEnergia(-30);
            return true;
        }
        else
            return false;
    }

}
