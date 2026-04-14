package model.service;

import model.entidades.Area;
import model.Jogador;
import model.repository.DisciplinaRepository;


public class DisciplinaService {
    private DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }


    private void matricularPorArea(Jogador jogador, Area area) {
        disciplinaRepository.buscarPorArea(area)
                .stream()
                .filter(d -> d != null && !jogador.getDisciplinasAprovadas().contains(d))
                .findFirst()
                .ifPresent(d -> jogador.getDisciplinasAtuais().add(d));
    }

    public void matricular(Jogador jogador) {
        matricularPorArea(jogador, Area.EXATAS);
        matricularPorArea(jogador, Area.PROGRAMACAO);
        matricularPorArea(jogador, Area.ELETRONICA);
    }
}
