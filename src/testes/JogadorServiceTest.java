package testes;

import model.entidades.Animal;
import model.entidades.Area;
import model.entidades.Professor;
import model.jogatina.Jogador;
import model.jogatina.Jogo;
import model.locais.PracaDoBorogodo;
import model.repository.DisciplinaRepository;
import model.repository.JogoRepository;
import model.repository.MapaRepository;
import model.service.DisciplinaService;
import model.service.JogadorService;
import model.service.JogoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JogadorServiceTest {
    private JogadorService jogadorService;
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
        jogadorService = new JogadorService();
        PracaDoBorogodo pracaDoBorogodo = MapaRepository.getPracaDoBorogodo();
        jogo = jogoService.criarJogo("Nicolas", pracaDoBorogodo);
        disciplinaService.matricular(jogo.getJogador());
    }

    // ===== JOGADOR =====

    @Test
    void jogadorCriadoComAtributosMaximos() {
        Jogador jogador = jogo.getJogador();
        assertEquals(100, jogador.getEnergia());
        assertEquals(100, jogador.getMotivacao());
        assertEquals(100, jogador.getSaude());
    }

    @Test
    void alterarEnergiaRespeiraLimiteMinimo() {
        Jogador jogador = jogo.getJogador();
        jogador.alterarEnergia(-200);
        assertEquals(0, jogador.getEnergia());
    }

    @Test
    void alterarEnergiaRespeiraLimiteMaximo() {
        Jogador jogador = jogo.getJogador();
        jogador.alterarEnergia(200);
        assertEquals(100, jogador.getEnergia());
    }

    // ===== ESTUDAR BIBLIOTECA =====

    @Test
    void estudarBibliotecaConsumeEnergia() {
        Jogador jogador = jogo.getJogador();
        jogador.setLocalizacao(MapaRepository.getBiblioteca());
        int energiaAntes = jogador.getEnergia();
        jogadorService.estudarBiblioteca(jogo, MapaRepository.getBiblioteca());
        assertTrue(jogador.getEnergia() < energiaAntes);
    }

    @Test
    void estudarBibliotecaForaDoLocalLancaExcecao() {
        Jogador jogador = jogo.getJogador();
        jogador.setLocalizacao(MapaRepository.getPracaDoBorogodo());
        assertThrows(IllegalStateException.class, () ->
                jogadorService.estudarBiblioteca(jogo, MapaRepository.getBiblioteca())
        );
    }

    @Test
    void estudarBibliotecaSemEnergiaSuficienteLancaExcecao() {
        Jogador jogador = jogo.getJogador();
        jogador.setLocalizacao(MapaRepository.getBiblioteca());
        jogador.alterarEnergia(-200); // zera energia
        assertThrows(IllegalStateException.class, () ->
                jogadorService.estudarBiblioteca(jogo, MapaRepository.getBiblioteca())
        );
    }

    // ===== FAZER CARINHO =====

    @Test
    void fazerCarinhoNoMesmoLocalNaoLancaExcecao() {
        Jogador jogador = jogo.getJogador();
        Animal cachorro = MapaRepository.getCachorro();
        jogador.setLocalizacao(MapaRepository.getPracaDoBorogodo());
        assertDoesNotThrow(() -> jogadorService.fazerCarinho(jogo, cachorro));
    }

    @Test
    void fazerCarinhoEmLocalDiferenteLancaExcecao() {
        Jogador jogador = jogo.getJogador();
        Animal cachorro = MapaRepository.getCachorro();
        jogador.setLocalizacao(MapaRepository.getBiblioteca());
        assertThrows(IllegalStateException.class, () ->
                jogadorService.fazerCarinho(jogo, cachorro)
        );
    }
}