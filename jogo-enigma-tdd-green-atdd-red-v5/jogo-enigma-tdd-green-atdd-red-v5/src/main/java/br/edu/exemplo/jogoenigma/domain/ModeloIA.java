package br.edu.exemplo.jogoenigma.domain;

public class ModeloIA {

    private String nome;
    private double pontuacaoRisco;

    public ModeloIA(String nome, double pontuacaoRisco) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do modelo não pode ser vazio.");
        }

        // Regra de não aceitar risco negativo
        if (pontuacaoRisco < 0) {
            throw new IllegalArgumentException("A pontuação de risco não pode ser negativa.");
        }

        this.nome = nome;
        this.pontuacaoRisco = pontuacaoRisco;
    }

    public boolean isAltoRisco() {
        // Regra para o segundo e terceiro testes passarem
        return this.pontuacaoRisco > 80.0;
    }

    public String getNome() {
        return nome;
    }

    public double getPontuacaoRisco() {
        return pontuacaoRisco;
    }
}