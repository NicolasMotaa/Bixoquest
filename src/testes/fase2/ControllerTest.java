package testes.fase2;

import controller.Controller;
import model.jogatina.Jogador;
import model.jogatina.Jogo;
import model.repository.DisciplinaRepository;
import model.repository.JogoRepository;
import model.repository.MapaRepository;
import model.service.DisciplinaService;
import model.service.JogadorService;
import model.service.JogoService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    JogoRepository jogoRepository;
    private static DisciplinaRepository disciplinaRepository;
    private DisciplinaService disciplinaService;
    private JogadorService jogadorService;
    private JogoService jogoService;
    private Controller controller;

    @BeforeAll
    public static void inicializar(){
        MapaRepository.inicializar();
        disciplinaRepository = new DisciplinaRepository();
    }

    @BeforeEach
    public void preparar(){
        limpar();
        jogoRepository = new JogoRepository();
        jogadorService = new JogadorService();
        disciplinaService = new DisciplinaService(disciplinaRepository);
        jogoService = new JogoService(jogoRepository, disciplinaService);
        controller = new Controller(disciplinaService, jogadorService, jogoService);
    }

    @AfterEach
    public void limpar(){
        new File("saves.bin").delete();
    }

    @Test
    public void criarPrimeiroJogo() throws Exception{
        controller.criarNovoJogo("Nico");

        //verifica se o arquivo foi criado
        assertTrue(new File("saves.bin").exists());

        //verifica se o jogo existe e se tem id = 1 (primeiro jogo a ser criado)
        assertNotNull(controller.listarJogos());
        assertEquals(controller.getJogoAtual(), new Jogo(new Jogador("Nico", MapaRepository.getPracaDoBorogodo()), 1));
    }

    @Test
    public void verificarExistencia() throws Exception {
        //verifica se o arquivo de fato não existe ao apagá-lo
        limpar();
        assertFalse(new File ("saves.bin").exists());

        //verifica se a função de carregar jogos realmente cria novo arquivo em caso de não encontrá-lo
        controller.carregarJogos();
        assertTrue(new File ("saves.bin").exists());

    }

    @Test
    public void testarFluxo() throws Exception{

        controller.criarNovoJogo("Nico");
        controller.criarNovoJogo("Bia");
        //verifica se os dois jogos criados estão de fato no banco
        assertEquals(2, controller.listarJogos().size());
        //verifica se o jogo atual é o ultimo a ser criado
        assertEquals(controller.getJogoAtual(), new Jogo(new Jogador("", MapaRepository.getPracaDoBorogodo()), 2));

        //verifica se a semana passa corretamente ao voltar para casa algumas vezes
        //aqui percebi que NPC e Local precisam implementar Serializable tbm, para guardar o local do jogador
        for (int i = 0; i < 6; i++) {
            controller.voltarParaCasa();
        }
        assertEquals(2, controller.getJogoAtual().getTempo().getSemanaAtual());
        //verifica se a troca de jogo atual é feita
        controller.escolherJogo(1, "");
        assertEquals(controller.getJogoAtual(), new Jogo(new Jogador("", MapaRepository.getPracaDoBorogodo()), 1));

        //verifica se um jogo é removido ao usar a função de deletar por id
        var jogoDeletado = jogoService.buscarJogo(2);
        jogoService.deletarJogo(2);
        assertFalse(controller.listarJogos().contains(jogoDeletado));

    }


}