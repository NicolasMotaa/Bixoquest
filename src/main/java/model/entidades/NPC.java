package model.entidades;

import model.locais.Local;

import java.io.Serializable;

public abstract class NPC implements Serializable {
    private String nome;
    private String descricao;
    private Local localizacao;

    public NPC(String nome, String descricao, Local localizacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.localizacao = localizacao;
    }

    //sem método interagir()
    //a intenção é remover as interações de todos os NPCs e concentrá-las nos locais.
    //Excessões: fazer carinho em Animal e conversas com os NPCs

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
