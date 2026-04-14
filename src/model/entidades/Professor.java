package model.entidades;

import model.locais.SalaDeAula;

public class Professor extends NPC {
    private Area area;

    public Professor(String nome, String descricao, SalaDeAula localizacao, Area area) {
        super(nome, descricao, localizacao);
        this.area = area;
    }


}
