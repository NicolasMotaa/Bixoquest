package model.repository;

import model.jogatina.Jogo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public class PersistenciaFacade {

    private static final Path PATH = Path.of("saves.bin");

    public static void salvar(Map<Integer, Jogo> jogos) throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(PATH))) {
            out.writeObject(jogos);
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<Integer, Jogo> carregar() throws Exception {
        if (!Files.exists(PATH) || Files.size(PATH) == 0) {
            return new LinkedHashMap<>();
        }
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(PATH))) {
            return (Map<Integer, Jogo>) in.readObject();
        }
    }
}