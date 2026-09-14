package br.edu.exemplo.jogoenigma.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JogoTest {

    private Jogo jogo;

    @BeforeEach
    void setUp() {
        jogo = new Jogo("Descrição de teste para o jogo");
    }

    @Test
    void deveRegistrarResultadoComSucesso() {
        // TDD: Garante que a anotação funciona (já está GREEN no seu código)
        Participante participante = new Participante("Maria");
        Resultado resultado = new Resultado(participante, 8.0);

        jogo.anota(resultado);

        assertEquals(1, jogo.getResultados().size());
        assertEquals(resultado, jogo.getResultados().get(0));
    }

    @Test
    void naoDeveAceitarMetricaNegativa() {
        Participante julia = new Participante("Julia");

        // O teste espera que ao tentar criar um Resultado negativo, o sistema dê erro
        assertThrows(IllegalArgumentException.class, () -> {
            new Resultado(julia, -5.0);
        });
    }

    @Test
    void deveRetornarInvalidoQuandoNaoHouverResultados() {
        // TDD: Teste da regra de invalidez
        assertFalse(jogo.isValido(), "O jogo deve ser inválido sem resultados.");
    }

    @Test
    void deveRetornarValidoQuandoHouverPeloMenosUmResultado() {
        // TDD: Este teste falhará (RED) até você alterar o isValido() no domínio
        Participante participante = new Participante("Carlos");
        Resultado resultado = new Resultado(participante, 7.5);

        jogo.anota(resultado);

        assertTrue(jogo.isValido(), "O jogo deve ser válido após anotar um resultado.");
    }
}