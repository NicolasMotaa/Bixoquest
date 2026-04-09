package model.model;

public class Professor extends NPC {
    private Area area;

    public Professor(String nome, Local localizacao, String descricao, Area area) {
        super(nome, localizacao, descricao);
        this.area = area;
    }

}
