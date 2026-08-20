package model.service;

import model.entidades.Area;
import model.jogatina.Disciplina;
import model.jogatina.Jogador;
import model.jogatina.Jogo;
import model.jogatina.Tempo;
import model.repository.DisciplinaRepository;
import model.repository.JogoRepository;
import model.repository.MapaRepository;

import java.util.List;
import java.util.Optional;

public class JogoService {
    private final JogoRepository jogoRepository;
    private DisciplinaService disciplinaService;

    public JogoService(JogoRepository jogoRepository, DisciplinaService disciplinaService){
        this.jogoRepository = jogoRepository;
        this.disciplinaService = disciplinaService;
        DisciplinaRepository.inicializar(MapaRepository.getProfExatas(), MapaRepository.getProfProgramacao(), MapaRepository.getProfEletronica());
    }



    private Area getAreaDoDia(int dia) {
        return switch (dia) {
            case 1 -> Area.EXATAS;
            case 2 -> Area.PROGRAMACAO;
            case 3 -> Area.ELETRONICA;
            default -> null; // dias 4 e 5 são livres
        };
    }
    public Disciplina getDisciplinaDoDia(Jogo jogo) {
        Area area = getAreaDoDia(jogo.getTempo().getDiaDaSemana());
        if (area == null) return null;

        return jogo.getJogador().getDisciplinasAtuais()
                .stream()
                .filter(d -> d.getArea() == area)
                .findFirst()
                .orElse(null);
    }

    public void consumirAcao(Jogo jogo){
        jogo.getTempo().consumirAcoes();
    }

    public void avancarDia(Jogo jogo) {
        Area areaDoDia = getAreaDoDia(jogo.getTempo().getDiaDaSemana());
        Jogador jogador = jogo.getJogador();
        Tempo tempo = jogo.getTempo();

        if (tempo.getSemanaAtual() != 4 && !jogador.isPresenteNaAula()) {
            for (Disciplina d : jogador.getDisciplinasAtuais()) {
                if (d.getArea() == areaDoDia) {
                    d.adicionarFalta();
                    break;
                }
            }
        }

        tempo.avancarDia();
        jogador.setPresenteNaAula(false);
        if (tempo.getDiaDaSemana() > 5) {
            avancarSemana(jogo);
        }
    }

    public void avancarSemana(Jogo jogo){
        Tempo tempo = jogo.getTempo();
        int semanaAnterior = tempo.getSemanaAtual();
        tempo.avancarSemana();
        if (semanaAnterior == 4)
            avancarSemestre(jogo);
    }

    public void avancarSemestre(Jogo jogo) {
        Jogador jogador = jogo.getJogador();
        Tempo tempo = jogo.getTempo();

        for (Disciplina d : jogador.getDisciplinasAtuais()) {
            if (d.isAprovado())
                jogador.getDisciplinasAprovadas().add(d);
        }
        jogador.getDisciplinasAtuais().clear();

        if (jogador.getDisciplinasAprovadas().size() == 15) {
            formar();
            return; // encerra sem matricular
        }

        tempo.avancarSemestre();
        jogador.alterarDinheiro(+50);
        jogador.alterarSaude(+100);
        jogador.alterarEnergia(+100);
        if (tempo.getSemestreAtual() > 10)
            jubilar();
        else
            disciplinaService.matricular(jogador);
    }
    public void jubilar(){
        //implementar logica de game over
    }

    public void formar(){
        // a implementar
    }


    //funções CRUD

    public Jogo criarJogo(String nome) throws Exception {

        Optional<Integer> slot = jogoRepository.getSlotLivre();
        if(slot.isEmpty()){
            return null;
        }
        else {
            Jogador j = new Jogador(nome, MapaRepository.getPracaDoBorogodo());
            disciplinaService.matricular(j);
            Jogo jogo = new Jogo(j, slot.get());

            return salvarJogo(jogo);

        }
    }

    public List<Jogo> listarJogos(){return jogoRepository.listarJogos();}

    public Jogo salvarJogo (Jogo jogo) throws Exception {
            atualizarJogo(jogo);
            jogoRepository.save();
            return jogo;
    }
    public void carregarJogos() throws Exception {
        jogoRepository.load();
    }

    public Jogo buscarJogo(int id){
        return jogoRepository.buscarJogo(id).orElse(null);
    }
    public Jogo atualizarJogo(Jogo jogo){
        return jogoRepository.salvar(jogo);
    }

    public void deletarJogo(int id) throws Exception {
        jogoRepository.deletarJogo(id);
        jogoRepository.save();
        return;
    }
}
