package model.entidades;

import model.locais.SalaDeAula;

public class Professor extends NPC {
    private Area area;
    private String caminhoImagem;

    public Professor(String nome, String descricao, SalaDeAula localizacao, Area area, String caminhoImagem) {
        super(nome, descricao, localizacao);
        this.area = area;
        this.caminhoImagem = caminhoImagem;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }
}
