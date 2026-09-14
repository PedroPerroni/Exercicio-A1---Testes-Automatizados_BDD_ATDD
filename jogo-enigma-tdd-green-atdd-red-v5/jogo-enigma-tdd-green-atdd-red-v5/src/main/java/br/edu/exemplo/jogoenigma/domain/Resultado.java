package br.edu.exemplo.jogoenigma.domain;

public class Resultado {
    private final Participante participante;
    private final double metrica;

    public Resultado(Participante participante, double metrica) {
        if (metrica < 0) {
            throw new IllegalArgumentException("A métrica não pode ser negativa.");
        }
        this.participante = participante;
        this.metrica = metrica;
    }



    public Participante getParticipante() {
        return participante;
    }

    public double getMetrica() {
        return metrica;
    }
}
