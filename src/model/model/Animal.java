package model.model;

import java.util.Random;

public class Animal extends NPC{
    private String especie;
    private boolean bravo = false;

    public Animal(String nome, Local localizacao, String descricao, String especie) {
        super(nome, localizacao, descricao);
        this.especie = especie;
    }

    public void calcularHumor(){
        Random random = new Random();
        this.bravo = random.nextDouble() < 0.20;
    }

    public void acariciar(Jogador j){
        calcularHumor();
        if(bravo){
            j.alterarSaude(-20);
            j.alterarMotivacao(-20);
        }
        else{
            j.alterarMotivacao(+5);
        }
    }

}
