package model.repository;

import model.jogatina.Jogo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class JogoRepository {
    private final Map<Integer, Jogo> bancoDeJogos = new LinkedHashMap<>();
    private final AtomicInteger id = new AtomicInteger(0);

    public int gerarId(){ return id.incrementAndGet(); }

    public Jogo salvar(Jogo jogo) {
        bancoDeJogos.put(jogo.getId(), jogo);
        return jogo;
    }
    public Jogo buscarJogo(int id){
        return bancoDeJogos.get(id);
    }

    public List<Jogo> listarJogos(){
        return new ArrayList<>(bancoDeJogos.values());
    }

    public boolean deletarJogo(int id) {
        return (bancoDeJogos.remove(id)) != null;
    }



}
