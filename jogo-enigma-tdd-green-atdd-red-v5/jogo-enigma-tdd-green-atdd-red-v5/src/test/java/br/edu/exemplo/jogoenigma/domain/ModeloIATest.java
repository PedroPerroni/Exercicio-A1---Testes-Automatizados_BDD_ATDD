package br.edu.exemplo.jogoenigma.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModeloIATest {

    @Test
    void naoDeveAceitarPontuacaoDeRiscoNegativa() {
        // TDD RED: Espera que o sistema dê erro ao tentar colocar risco negativo
        assertThrows(IllegalArgumentException.class, () -> {
            new ModeloIA("Algoritmo de Crédito", -5.0);
        });
    }

    @Test
    void deveClassificarComoAltoRiscoQuandoPontuacaoMaiorQue80() {
        // TDD RED: Espera que um risco de 85 seja classificado como Alto Risco
        ModeloIA modelo = new ModeloIA("Reconhecimento Facial", 85.0);

        assertTrue(modelo.isAltoRisco(), "O modelo deveria ser classificado como alto risco.");
    }

    @Test
    void naoDeveClassificarComoAltoRiscoQuandoPontuacaoMenorOuIgualA80() {
        ModeloIA modelo = new ModeloIA("Chatbot de Atendimento", 50.0);

        assertFalse(modelo.isAltoRisco(), "O modelo não deveria ser alto risco.");
    }

    @Test
    void naoDeveAceitarModeloSemNome() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ModeloIA("", 50.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new ModeloIA(null, 50.0);
        });
    }
}