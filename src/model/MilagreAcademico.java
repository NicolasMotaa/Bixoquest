package model;

public class MilagreAcademico extends Evento{
    public MilagreAcademico() {
        super("Milagre Academico", "Prova mamão com açúcar!", 0.1);
    }

    @Override
    public void calcularSeOcorre() {
        super.calcularSeOcorre();
    }

    public void acontecer(Disciplina disciplina, Jogador jogador){
        calcularSeOcorre();
        if(this.isAplicado())
            jogador.alterarConhecimento(disciplina, 100);
    }
}
