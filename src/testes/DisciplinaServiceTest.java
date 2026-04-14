package testes;

import model.entidades.Area;
import model.entidades.Professor;
import model.jogatina.Disciplina;
import model.jogatina.Jogador;
import model.repository.DisciplinaRepository;
import model.repository.MapaRepository;
import model.service.DisciplinaService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisciplinaServiceTest {

    private DisciplinaService disciplinaService;
    private Jogador jogador;

    @BeforeAll
    static void inicializarRepositorios() {
        MapaRepository.inicializar();
        Professor profEx = new Professor("Gegê", "Prof exatas", MapaRepository.getSalaDeAula(), Area.EXATAS);
        Professor profProg = new Professor("Ana Cláudia", "Prof prog", MapaRepository.getSalaDeAula(), Area.PROGRAMACAO);
        Professor profElet = new Professor("Jonas", "Prof elet", MapaRepository.getSalaDeAula(), Area.ELETRONICA);
        DisciplinaRepository.inicializar(profEx, profProg, profElet);
    }

    @BeforeEach
    void prepararJogador() {
        disciplinaService = new DisciplinaService(new DisciplinaRepository());
        jogador = new Jogador("Nicolas", MapaRepository.getPracaDoBorogodo());
    }

    // ===== MATRÍCULA =====

    @Test
    void matricularAdicionaTresDisciplinas() {
        disciplinaService.matricular(jogador);
        assertEquals(3, jogador.getDisciplinasAtuais().size());
    }

    @Test
    void matricularAdicionaUmaDisciplinaPorArea() {
        disciplinaService.matricular(jogador);
        long exatas = jogador.getDisciplinasAtuais().stream()
                .filter(d -> d.getArea() == Area.EXATAS).count();
        long prog = jogador.getDisciplinasAtuais().stream()
                .filter(d -> d.getArea() == Area.PROGRAMACAO).count();
        long elet = jogador.getDisciplinasAtuais().stream()
                .filter(d -> d.getArea() == Area.ELETRONICA).count();
        assertEquals(1, exatas);
        assertEquals(1, prog);
        assertEquals(1, elet);
    }

    @Test
    void matricularPrimeiroSemestreNaoTemPreRequisito() {
        disciplinaService.matricular(jogador);
        jogador.getDisciplinasAtuais().forEach(d ->
                assertNull(d.getPreRequisito())
        );
    }

    @Test
    void matricularAvancaParaProximaDisciplinaAposAprovacao() {
        disciplinaService.matricular(jogador);
        // aprova todas do semestre 1
        jogador.getDisciplinasAtuais().forEach(d -> {
            d.setNota(8.0);
            d.calcularAprovacao();
        });
        jogador.getDisciplinasAprovadas().addAll(jogador.getDisciplinasAtuais());
        jogador.getDisciplinasAtuais().clear();

        disciplinaService.matricular(jogador);

        // agora deve ter as disciplinas do semestre 2
        jogador.getDisciplinasAtuais().forEach(d ->
                assertEquals(2, d.getSemestre())
        );
    }

    // ===== APROVAÇÃO =====

    @Test
    void disciplinaAprovadaComNotaSuficienteESemFaltas() {
        disciplinaService.matricular(jogador);
        Disciplina d = jogador.getDisciplinasAtuais().get(0);
        d.setNota(8.0);
        d.calcularAprovacao();
        assertTrue(d.isAprovado());
    }

    @Test
    void disciplinaReprovadaPorNotaInsuficiente() {
        disciplinaService.matricular(jogador);
        Disciplina d = jogador.getDisciplinasAtuais().get(0);
        d.setNota(4.0);
        d.calcularAprovacao();
        assertFalse(d.isAprovado());
    }

    @Test
    void disciplinaReprovadaPorExcessoDeFaltas() {
        disciplinaService.matricular(jogador);
        Disciplina d = jogador.getDisciplinasAtuais().get(0);
        d.setNota(9.0);
        for (int i = 0; i <= 5; i++) d.adicionarFalta();
        d.calcularAprovacao();
        assertFalse(d.isAprovado());
    }

    // ===== CONHECIMENTO =====

    @Test
    void conhecimentoInicialDaDisciplinaEZero() {
        disciplinaService.matricular(jogador);
        Disciplina d = jogador.getDisciplinasAtuais().get(0);
        assertEquals(0, jogador.getConhecimentoPorDisciplina(d));
    }

    @Test
    void alterarConhecimentoAtualizaMapaDoJogador() {
        disciplinaService.matricular(jogador);
        Disciplina d = jogador.getDisciplinasAtuais().get(0);
        jogador.alterarConhecimento(d, 30);
        assertEquals(30, jogador.getConhecimentoPorDisciplina(d));
    }

}