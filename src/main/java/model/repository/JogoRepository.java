package model.repository;

import model.jogatina.Jogo;

import java.nio.file.Path;
import java.util.*;


public class JogoRepository {
    private Map<Integer, Jogo> bancoDeJogos = new LinkedHashMap<>();
    private final Path path = Path.of("saves.bin");

    public JogoRepository(){
        try{
            this.bancoDeJogos = load();
        }
        catch (Exception e){
            this.bancoDeJogos = new LinkedHashMap<>();
        }
    }
    public void save() throws Exception {
        PersistenciaFacade.salvar(bancoDeJogos);
    }

    public Map<Integer, Jogo> load() throws Exception {
        return PersistenciaFacade.carregar();
    }

    //limita a quantidade de saves a 3.
    public Optional<Integer> getSlotLivre() {
        for (int slot = 1; slot <= 3; slot++) {
            if (!bancoDeJogos.containsKey(slot)) {
                return Optional.of(slot);
            }
        }
        return Optional.empty(); // todos ocupados
    }

    public Jogo salvar(Jogo jogo) {
        bancoDeJogos.put(jogo.getId(), jogo);
        return jogo;
    }

    public Optional<Jogo> buscarJogo(int id){
        return Optional.ofNullable(bancoDeJogos.get(id));
    }

    public List<Jogo> listarJogos(){
        return new ArrayList<>(bancoDeJogos.values());
    }

    public boolean deletarJogo(int id) {

        return (bancoDeJogos.remove(id)) != null;
    }

    public Map<Integer, Jogo> getBancoDeJogos() {
        return bancoDeJogos;
    }
}
