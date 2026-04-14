package model.repository;

import model.model.Area;
import model.model.Disciplina;
import model.model.Professor;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaRepository {
    private static final List<Disciplina> exatas = new ArrayList<>();
    private static final List<Disciplina> programacao = new ArrayList<>();
    private static final List<Disciplina> eletronica = new ArrayList<>();

    private static boolean inicializado = false;

    // Chamado uma vez pelo JogoService na inicialização do sistema
    public static void inicializar(Professor profExatas, Professor profProg, Professor profElet) {
        if (inicializado) return; // garante que não popula duas vezes

        // índice 0 = null em todas as listas (sem pré-requisito)
        exatas.add(null);
        exatas.add(new Disciplina("Pré-Cálculo", Area.EXATAS, 1, null, profExatas, false));
        exatas.add(new Disciplina("Cálculo 1", Area.EXATAS, 2, exatas.get(1), profExatas, false));
        exatas.add(new Disciplina("Cálculo 2", Area.EXATAS, 3, exatas.get(2), profExatas, false));
        exatas.add(new Disciplina("Física", Area.EXATAS, 4, exatas.get(3), profExatas, false));
        exatas.add(new Disciplina("Equações Diferenciais", Area.EXATAS, 5, exatas.get(4), profExatas, false));

        programacao.add(null);
        programacao.add(new Disciplina("Algoritmos 1", Area.PROGRAMACAO, 1, null, profProg, true));
        programacao.add(new Disciplina("Estruturas de Dados", Area.PROGRAMACAO, 2, programacao.get(1), profProg, false));
        programacao.add(new Disciplina("Java", Area.PROGRAMACAO, 3, programacao.get(2), profProg, true));
        programacao.add(new Disciplina("Banco de Dados", Area.PROGRAMACAO, 4, programacao.get(3), profProg, false));
        programacao.add(new Disciplina("Engenharia de Software", Area.PROGRAMACAO, 5, programacao.get(4), profProg, true));

        eletronica.add(null);
        eletronica.add(new Disciplina("Introdução à Eletrônica", Area.ELETRONICA, 1, null, profElet, false));
        eletronica.add(new Disciplina("Circuitos Digitais", Area.ELETRONICA, 2, eletronica.get(1), profElet, true));
        eletronica.add(new Disciplina("Sistemas Operacionais", Area.ELETRONICA, 3, eletronica.get(2), profElet, false));
        eletronica.add(new Disciplina("Sistemas Digitais", Area.ELETRONICA, 4, eletronica.get(3), profElet, true));
        eletronica.add(new Disciplina("Sinais e Sistemas", Area.ELETRONICA, 5, eletronica.get(4), profElet, false));

        inicializado = true;
    }

    public static List<Disciplina> buscarPorArea(Area area) {
        return switch (area) {
            case EXATAS -> new ArrayList<>(exatas);
            case PROGRAMACAO -> new ArrayList<>(programacao);
            case ELETRONICA -> new ArrayList<>(eletronica);
        };
    }

    // Retorna a disciplina do semestre X da área Y (semestre começa em 1)
    public static Disciplina buscarPorSemestre(Area area, int semestre) {
        List<Disciplina> lista = buscarPorArea(area);
        if (semestre < 1 || semestre >= lista.size()) return null;
        return lista.get(semestre); // índice = semestre, já que índice 0 é null
    }
}
