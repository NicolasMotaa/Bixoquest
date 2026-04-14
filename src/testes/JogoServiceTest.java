package testes;

import model.entidades.Area;
import model.entidades.Professor;
import model.jogatina.Disciplina;
import model.jogatina.Jogo;
import model.locais.PracaDoBorogodo;
import model.repository.DisciplinaRepository;
import model.repository.JogoRepository;
import model.repository.MapaRepository;
import model.service.DisciplinaService;
import model.service.JogoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

    public class JogoServiceTest {

        private JogoService jogoService;
        private DisciplinaService disciplinaService;
        private Jogo jogo;

        @BeforeAll
        public static void inicializarRepositorios() {
            MapaRepository.inicializar();
            Professor profEx = new Professor("Gegê", "Prof exatas", MapaRepository.getSalaDeAula(), Area.EXATAS);
            Professor profProg = new Professor("Ana Cláudia", "Prof prog", MapaRepository.getSalaDeAula(), Area.PROGRAMACAO);
            Professor profElet = new Professor("Jonas", "Prof elet", MapaRepository.getSalaDeAula(), Area.ELETRONICA);
            DisciplinaRepository.inicializar(profEx, profProg, profElet);
        }

        @BeforeEach
        void prepararJogo() {
            JogoRepository jogoRepository = new JogoRepository();
            disciplinaService = new DisciplinaService(new DisciplinaRepository());
            jogoService = new JogoService(jogoRepository, disciplinaService);
            PracaDoBorogodo pracaDoBorogodo = MapaRepository.getPracaDoBorogodo();
            jogo = jogoService.criarJogo("Nicolas", pracaDoBorogodo);
            disciplinaService.matricular(jogo.getJogador());
        }

        @Test
        void criarJogoInicializaTempoCorretamente() {
            assertEquals(1, jogo.getTempo().getSemestreAtual());
            assertEquals(1, jogo.getTempo().getSemanaAtual());
            assertEquals(1, jogo.getTempo().getDiaDaSemana());
        }

        @Test
        void criarJogoMatriculaTresDisciplinas() {
            assertEquals(3, jogo.getJogador().getDisciplinasAtuais().size());
        }

        @Test
        void avancarDiaRegistraFaltaQuandoNaoFoiAula() {
            jogo.getJogador().setPresenteNaAula(false);
            // dia 1 = exatas
            Disciplina exatas = jogo.getJogador().getDisciplinasAtuais().stream()
                    .filter(d -> d.getArea() == Area.EXATAS)
                    .findFirst().orElseThrow();
            int faltasAntes = exatas.getFaltas();
            jogoService.avancarDia(jogo);
            assertEquals(faltasAntes + 1, exatas.getFaltas());
        }

        @Test
        void avancarDiaNaoRegistraFaltaQuandoFoiAula() {
            jogo.getJogador().setPresenteNaAula(true);
            Disciplina exatas = jogo.getJogador().getDisciplinasAtuais().stream()
                    .filter(d -> d.getArea() == Area.EXATAS)
                    .findFirst().orElseThrow();
            int faltasAntes = exatas.getFaltas();
            jogoService.avancarDia(jogo);
            assertEquals(faltasAntes, exatas.getFaltas());
        }

        @Test
        void avancarSemestreJubilaAoAtingirLimite() {
            // força semestre 10
            for (int i = 0; i < 9; i++) jogo.getTempo().avancarSemestre();
            // aprova nenhuma disciplina — vai repetir até jubilar
            assertDoesNotThrow(() -> jogoService.avancarSemestre(jogo));
            // jubilação é game over — verifica semestre > 10
            assertTrue(jogo.getTempo().getSemestreAtual() > 10);
        }
}