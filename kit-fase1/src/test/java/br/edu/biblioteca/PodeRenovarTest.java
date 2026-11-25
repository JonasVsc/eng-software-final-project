package br.edu.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

class PodeRenovarTest {

    private final RegrasBiblioteca regras = new RegrasBiblioteca();

    @ParameterizedTest
    @CsvSource({
        "ALUNO, 0, true",
        "ALUNO, 1, true",
        "ALUNO, 2, false",
        "ALUNO, 3, false",
        "PROFESSOR, 0, true",
        "PROFESSOR, 1, true",
        "PROFESSOR, 2, true",
        "PROFESSOR, 3, false",
        "PROFESSOR, 4, false",
        "VISITANTE, 0, false",
        "VISITANTE, 1, false"
    })
    void comparaQuantidadeDeRenovacoesComOLimite(
            TipoUsuario tipo, int renovacoesFeitas, boolean esperado) {
        assertEquals(esperado, regras.podeRenovar(tipo, renovacoesFeitas, false, false));
    }

    @ParameterizedTest
    @CsvSource({
        "ALUNO, true, false",
        "ALUNO, false, true",
        "ALUNO, true, true",
        "PROFESSOR, true, false",
        "PROFESSOR, false, true",
        "PROFESSOR, true, true"
    })
    void impedeRenovacaoQuandoHaReservaOuAtraso(
            TipoUsuario tipo, boolean possuiReserva, boolean emAtraso) {
        assertFalse(regras.podeRenovar(tipo, 0, possuiReserva, emAtraso));
    }

    @ParameterizedTest
    @EnumSource(TipoUsuario.class)
    void rejeitaQuantidadeNegativaDeRenovacoes(TipoUsuario tipo) {
        assertThrows(IllegalArgumentException.class, () -> regras.podeRenovar(tipo, -1, false, false));
    }

    @Test
    void rejeitaTipoNulo() {
        assertThrows(IllegalArgumentException.class, () -> regras.podeRenovar(null, 0, false, false));
    }
}
