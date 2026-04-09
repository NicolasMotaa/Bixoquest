package model.model;

public abstract class NPC {
    private String nome;
    private Local localizacao;
    private String descricao;

    public NPC(String nome, Local localizacao, String descricao) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.descricao = descricao;
    }

    public void interagir(Jogador j){
        System.out.println("interação com o jogador");
        //chamar biblioteca ou repositório com frases para interação simples
    }
}
