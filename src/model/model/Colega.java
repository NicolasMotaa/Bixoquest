package model.model;

public class Colega extends NPC{
    public Colega(String nome, String descricao, Local localizacao) {
        super(nome, descricao, localizacao);
    }

    public void jogar(Jogador j){
        j.alterarMotivacao(Constantes.BONUS_MOTIVACAO_JOGAR_COLEGA);
        j.alterarEnergia(-Constantes.CUSTO_ENERGIA_JOGAR_COLEGA);

        //açao é consumida via service
    }
    public void estudarJunto(Jogador j, Disciplina disciplina){
        j.alterarEnergia(-Constantes.CUSTO_ENERGIA_ESTUDAR);
        //usar get?
        j.alterarConhecimento(disciplina, Constantes.BONUS_CONHECIMENTO_AULA);
    }


}
