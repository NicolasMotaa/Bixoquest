package model.jogatina;

import java.io.Serializable;
import java.util.List;

public class Pergunta implements Serializable {

    private final String enunciado;
    private final List<String> alternativas;
    private final int respostaCorreta;
    private final NivelPergunta nivel;

    public Pergunta(String enunciado,
                    List<String> alternativas,
                    int respostaCorreta,
                    NivelPergunta nivel) {

        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.respostaCorreta = respostaCorreta;
        this.nivel = nivel;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public List<String> getAlternativas() {
        return alternativas;
    }

    public int getRespostaCorreta() {
        return respostaCorreta;
    }

    public NivelPergunta getNivel() {
        return nivel;
    }

    public boolean isCorreta(int indiceResposta) {
        return indiceResposta == respostaCorreta;
    }
}