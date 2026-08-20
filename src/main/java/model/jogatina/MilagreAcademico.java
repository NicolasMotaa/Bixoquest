package model.jogatina;

public class MilagreAcademico extends Evento{
    public MilagreAcademico() {
        super("Milagre Academico", "Prova mamão com açúcar!", 0.3);
    }

    public boolean acontecer(Disciplina disciplina, Jogador jogador) {
        calcularSeOcorre();
        if(calcularSeOcorre()) {
            jogador.alterarConhecimento(disciplina, 100);
            return true;
        }
        else{
            return false;
        }
    }
}
