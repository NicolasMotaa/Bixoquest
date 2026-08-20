package model.entidades;

import model.locais.Colegiado;


public class Maeli extends NPC {
    public Maeli(Colegiado localizacao) {
        super("Sacerdotisa Maeli", "Simpática secretária do colegiado, devia ser reitora da UEFS.", localizacao);
    }


    public String ajudar() {
        return "Vai dar tudo certo!";
    }
}
