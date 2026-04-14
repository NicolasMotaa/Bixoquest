package model.service;

import model.*;
import model.entidades.Area;
import model.locais.PracaDoBorogodo;
import model.repository.JogoRepository;

import java.util.List;

public class JogoService {
    private final JogoRepository repository;
    private DisciplinaService disciplinaService;
    public JogoService(JogoRepository repository, DisciplinaService disciplinaService){
        this.repository = repository;
        this.disciplinaService = disciplinaService;
    }

    public Jogo criarJogo(String nome, PracaDoBorogodo pracaDoBorogodo){
        //Local vai mudar porque se tornou abstrato
        Jogador j = new Jogador(nome, pracaDoBorogodo);
        int id = repository.gerarId();
        return repository.salvar(new Jogo(j, id));
    }

    private Area getAreaDoDia(int dia) {
        return switch (dia) {
            case 1 -> Area.EXATAS;
            case 2 -> Area.PROGRAMACAO;
            case 3 -> Area.ELETRONICA;
            default -> null; // dias 4 e 5 são livres
        };
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
        jogador.alterarDinheiro(+100);
        if (tempo.getSemestreAtual() > 10)
            jubilar();
        else
            this.disciplinaService.matricular(jogador);
    }
    public void jubilar(){
        //implementar logica de game over
    }

    public void formar(){
        // a implementar
    }
    public List<Jogo> listarJogos(){return repository.listarJogos();}

    public Jogo atualizarJogo(Jogo jogo){
        return repository.salvar(jogo);
    }

    public boolean deletarJogo(int id){
        return repository.deletarJogo(id);
    }
}
