package model.entidades;

import model.jogatina.Jogador;
import model.locais.Local;

import java.util.Random;

public class Animal extends NPC {
    private Especie especie;
    private boolean bravo;

    public Animal(String nome, String descricao, Local localizacao, Especie especie) {
        super(nome, descricao, localizacao);
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
