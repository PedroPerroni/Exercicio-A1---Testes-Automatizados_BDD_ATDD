package br.edu.exemplo.jogoenigma.acceptance;

import br.edu.exemplo.jogoenigma.domain.ModeloIA;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import static org.junit.jupiter.api.Assertions.*;

public class JogoStepDefinitions {

    private String nomeTemporario;
    private ModeloIA modelo;
    private Exception excecao;
    private boolean resultadoAltoRisco;

    // --- STEPS DO BDD 1 ---
    @Dado("um novo modelo de IA chamado {string}")
    public void um_novo_modelo_de_ia_chamado(String nome) {
        this.nomeTemporario = nome;
    }

    @Quando("eu tento registrar a sua pontuação de risco como {double}")
    public void eu_tento_registrar_a_sua_pontuacao_de_risco_como(Double risco) {
        try {
            modelo = new ModeloIA(nomeTemporario, risco);
        } catch (IllegalArgumentException e) {
            excecao = e;
        }
    }

    @Então("o sistema deve recusar o registro lançando uma exceção")
    public void o_sistema_deve_recusar_o_registro_lancando_uma_excecao() {
        assertNotNull(excecao, "O sistema deveria ter lançado uma exceção para risco negativo.");
    }

    @Então("o modelo não deve ser salvo")
    public void o_modelo_nao_deve_ser_salvo() {
        assertNull(modelo, "O modelo não deveria ter sido instanciado.");
    }

    // --- STEPS DOS BDD 2 E 3 ---
    @Dado("um modelo de IA chamado {string}")
    public void um_modelo_de_ia_chamado(String nome) {
        this.nomeTemporario = nome;
    }

    @Quando("a sua pontuação de risco for definida como {double}")
    public void a_sua_pontuacao_de_risco_for_definida_como(Double risco) {
        modelo = new ModeloIA(nomeTemporario, risco);
        resultadoAltoRisco = modelo.isAltoRisco();
    }

    @Então("o sistema deve classificá-lo como um modelo de Alto Risco")
    public void o_sistema_deve_classifica_lo_como_um_modelo_de_alto_risco() {
        assertTrue(resultadoAltoRisco, "O modelo deveria ser de alto risco.");
    }

    @Então("o sistema deve retornar que ele não é de Alto Risco")
    public void o_sistema_deve_retornar_que_ele_nao_e_de_alto_risco() {
        assertFalse(resultadoAltoRisco, "O modelo NÃO deveria ser de alto risco.");
    }

    // --- STEPS DO BDD 4 ---
    @Dado("que estou mapeando uma nova inteligência artificial no QAI Control")
    public void que_estou_mapeando_uma_nova_inteligencia_artificial_no_qai_control() {
        this.nomeTemporario = ""; // Nome em branco para forçar o erro
    }

    @Quando("eu tento registrar o modelo deixando o nome em branco")
    public void eu_tento_registrar_o_modelo_deixando_o_nome_em_branco() {
        try {
            modelo = new ModeloIA(nomeTemporario, 50.0);
        } catch (IllegalArgumentException e) {
            excecao = e;
        }
    }

    @Então("o sistema deve bloquear o cadastro lançando uma exceção")
    public void o_sistema_deve_bloquear_o_cadastro_lancando_uma_excecao() {
        assertNotNull(excecao, "O sistema deveria ter lançado uma exceção para nome vazio.");
    }
}