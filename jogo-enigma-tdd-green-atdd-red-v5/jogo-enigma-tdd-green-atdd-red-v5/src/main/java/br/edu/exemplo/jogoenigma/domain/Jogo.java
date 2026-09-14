package br.edu.exemplo.jogoenigma.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jogo {
    private final String descricao;
    private final List<Resultado> resultados;

    public Jogo(String descricao) {
        this.descricao = descricao;
        this.resultados = new ArrayList<>();
    }

    public void anota(Resultado resultado) {
        // TDD - GREEN da primeira regra de domínio:
        // um resultado válido é registrado no jogo.
        resultados.add(resultado);
    }

    public boolean isValido() {
        // ATDD - RED proposital.
        // O critério de aceitação completo ainda não foi implementado.
        return !resultados.isEmpty();
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Resultado> getResultados() {
        return Collections.unmodifiableList(resultados);
    }
}
