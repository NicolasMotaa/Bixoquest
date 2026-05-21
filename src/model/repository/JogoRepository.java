package model.repository;

import model.jogatina.Jogo;

import java.io.IOException;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class JogoRepository {
    private Map<Integer, Jogo> bancoDeJogos;
    private final AtomicInteger id = new AtomicInteger(1); //coloquei 1 pra funcionar no controller provisório
    private final Path path = Path.of("saves.bin");

    public JogoRepository(){
        try{
            this.bancoDeJogos = load();
        }
        catch (IOException | ClassNotFoundException e){
            this.bancoDeJogos = new LinkedHashMap<>();
        }
    }
    public void save (Jogo jogo) throws Exception {

        try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))){
            out.writeObject(bancoDeJogos);
        }
    }
    @SuppressWarnings("unchecked")
    public Map<Integer, Jogo> load() throws IOException, ClassNotFoundException{
        if(!Files.exists(path)){
            return new LinkedHashMap<>();
        }
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))){

            return bancoDeJogos = (Map<Integer, Jogo>) in.readObject();
        }
    }
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
