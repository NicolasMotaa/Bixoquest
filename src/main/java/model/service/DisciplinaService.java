package model.service;

import model.entidades.Area;
import model.jogatina.Disciplina;
import model.jogatina.Jogador;
import model.jogatina.NivelPergunta;
import model.jogatina.Pergunta;
import model.repository.DisciplinaRepository;

import java.util.Collections;
import java.util.List;


public class DisciplinaService {


    private void matricularPorArea(Jogador jogador, Area area) {
        DisciplinaRepository.buscarPorArea(area)
                .stream()
                .filter(d -> d != null && !jogador.getDisciplinasAprovadas().contains(d))
                .findFirst()
                .ifPresent(d -> jogador.getDisciplinasAtuais().add(d));

    }

    public void matricular(Jogador jogador) {
        matricularPorArea(jogador, Area.EXATAS);
        matricularPorArea(jogador, Area.PROGRAMACAO);
        matricularPorArea(jogador, Area.ELETRONICA);
        for (Disciplina disciplina: jogador.getDisciplinasAtuais()){
            jogador.alterarConhecimento(disciplina, 0);
        }
    }

    public List<Pergunta> gerarProva(Disciplina disciplina, int conhecimento) {
        NivelPergunta nivel;
        if (conhecimento <= 30) nivel = NivelPergunta.FACIL;
        else if (conhecimento <= 70) nivel = NivelPergunta.MEDIO;
        else nivel = NivelPergunta.DIFICIL;

        List<Pergunta> pool = disciplina.getPerguntasPorNivel(nivel);
        Collections.shuffle(pool);
        return pool.subList(0, 5);
    }

    public boolean aprovadoEmTodas(Jogador jogador) {
        return jogador.getDisciplinasAtuais().stream()
                .allMatch(d -> d.isAprovado());
    }
}
