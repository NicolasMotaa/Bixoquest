package model.entidades;

import model.Jogador;
import model.locais.Local;

import java.util.Random;

public class Animal extends NPC {
    private Especie especie;
    private boolean bravo = false;

    public Animal(String nome, String descricao, Local localizacao, Especie especie, boolean bravo) {
        super(nome, descricao, localizacao);
        this.especie = especie;
        this.bravo = bravo;
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
