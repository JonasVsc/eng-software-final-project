package br.edu.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

class PodeEmprestarTest {

    private final RegrasBiblioteca regras = new RegrasBiblioteca();

    @ParameterizedTest
    @CsvSource({
        "ALUNO, 0, true",
        "ALUNO, 1, true",
        "ALUNO, 2, true",
        "ALUNO, 3, false",
        "ALUNO, 4, false",
        "PROFESSOR, 0, true",
        "PROFESSOR, 1, true",
        "PROFESSOR, 7, true",
        "PROFESSOR, 8, false",
        "PROFESSOR, 9, false",
        "VISITANTE, 0, true",
        "VISITANTE, 1, false",
        "VISITANTE, 2, false"
    })
    void comparaEmprestimosAtivosComOLimite(
            TipoUsuario tipo, int emprestimosAtivos, boolean esperado) {
        assertEquals(esperado, regras.podeEmprestar(tipo, emprestimosAtivos, 0, false));
    }

    @ParameterizedTest
    @CsvSource({
        "ALUNO, 1, true",
        "ALUNO, 999, true",
        "ALUNO, 1000, true",
        "ALUNO, 1001, false",
        "PROFESSOR, 1, true",
        "PROFESSOR, 999, true",
        "PROFESSOR, 1000, true",
        "PROFESSOR, 1001, false",
        "VISITANTE, 1, true",
        "VISITANTE, 999, true",
        "VISITANTE, 1000, true",
        "VISITANTE, 1001, false"
    })
    void comparaMultaPendenteComOLimite(
            TipoUsuario tipo, int multaPendenteCentavos, boolean esperado) {
        assertEquals(esperado, regras.podeEmprestar(tipo, 0, multaPendenteCentavos, false));
    }

    @ParameterizedTest
    @EnumSource(TipoUsuario.class)
    void impedeEmprestimoQuandoHaAtraso(TipoUsuario tipo) {
        assertFalse(regras.podeEmprestar(tipo, 0, 0, true));
    }

    @ParameterizedTest
    @EnumSource(TipoUsuario.class)
    void rejeitaEmprestimosAtivosNegativos(TipoUsuario tipo) {
        assertThrows(IllegalArgumentException.class, () -> regras.podeEmprestar(tipo, -1, 0, false));
    }

    @ParameterizedTest
    @EnumSource(TipoUsuario.class)
    void rejeitaMultaPendenteNegativa(TipoUsuario tipo) {
        assertThrows(IllegalArgumentException.class, () -> regras.podeEmprestar(tipo, 0, -1, false));
    }

    @Test
    void rejeitaTipoNulo() {
        assertThrows(IllegalArgumentException.class, () -> regras.podeEmprestar(null, 0, 0, false));
    }
}
