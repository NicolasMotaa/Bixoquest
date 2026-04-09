package model.model;

public class Local {
    private String nome;
    private String descricao;

    public Local(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public void interagir(Jogador j){
        System.out.println("interação com jogador, método a ser sobrescrito");
    }
}
