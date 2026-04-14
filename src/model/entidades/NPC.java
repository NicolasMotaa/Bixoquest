package model.entidades;

import model.locais.Local;

public abstract class NPC {
    private String nome;
    private String descricao;
    private Local localizacao;

    public NPC(String nome, String descricao, Local localizacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.localizacao = localizacao;
    }

    public String interagir(String frase){
        return frase;
        //chamar biblioteca ou repositório com frases para interação simples
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Local getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Local localizacao) {
        this.localizacao = localizacao;
    }
}
