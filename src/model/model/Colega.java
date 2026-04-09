package model.model;

public class Colega extends NPC{
    public Colega(String nome, Local localizacao, String descricao) {
        super(nome, localizacao, descricao);
    }
    public void jogar(Jogador j){
        j.alterarMotivacao(25);
        j.alterarEnergia(-10);
        //açao é consumida via service
    }
    public void estudarJunto(Jogador j){
        j.alterarEnergia(-25);
        //como vai ser o nível de conhecimento? precisa ser alterado.
    }
}
