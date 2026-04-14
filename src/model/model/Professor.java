package model.model;

public class Professor extends NPC {
    private Area area;

    public Professor(String nome, String descricao, Local localizacao, Area area) {
        super(nome, descricao, localizacao);
        this.area = area;
    }


}
