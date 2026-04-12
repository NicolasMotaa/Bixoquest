package model.service;

import model.model.Jogador;
import model.model.Jogo;
import model.model.Local;
import model.model.Tempo;
import model.repository.JogoRepository;

import java.util.ArrayList;
import java.util.List;

public class JogoService {
    private final JogoRepository repository;

    public JogoService(JogoRepository repository){
        this.repository = repository;
    }

    public Jogo criarJogo(String nome){
        Jogador j = new Jogador(nome, new Local("Praça do borogodó", "onde voce fica de boa", new ArrayList<>()));
        Tempo tempo = new Tempo();
        int id = repository.gerarId();
        return repository.salvar(new Jogo(j, tempo, id));
    }

    public List<Jogo> listarJogos(){return repository.listarJogos();}

    public Jogo atualizarJogo(Jogo jogo){
        return repository.salvar(jogo);
    }

    public boolean deletarJogo(int id){
        return repository.deletarJogo(id);
    }
}
