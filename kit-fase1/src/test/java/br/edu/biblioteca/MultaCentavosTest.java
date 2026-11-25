package br.edu.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

class MultaCentavosTest {

    private final RegrasBiblioteca regras = new RegrasBiblioteca();

    @ParameterizedTest(name = "{0}, {1} dias de atraso: {2} centavos")
    @CsvSource({
        "ALUNO, 0, 0",
        "ALUNO, 1, 100",
        "ALUNO, 9, 900",
        "ALUNO, 10, 1000",
        "ALUNO, 11, 1200",
        "ALUNO, 29, 4800",
        "ALUNO, 30, 5000",
        "ALUNO, 31, 5000",
        "VISITANTE, 0, 0",
        "VISITANTE, 1, 100",
        "VISITANTE, 9, 900",
        "VISITANTE, 10, 1000",
        "VISITANTE, 11, 1200",
        "VISITANTE, 29, 4800",
        "VISITANTE, 30, 5000",
        "VISITANTE, 31, 5000",
        "PROFESSOR, 0, 0",
        "PROFESSOR, 1, 0",
        "PROFESSOR, 2, 0",
        "PROFESSOR, 3, 0",
        "PROFESSOR, 4, 100",
        "PROFESSOR, 12, 900",
        "PROFESSOR, 13, 1000",
        "PROFESSOR, 14, 1200",
        "PROFESSOR, 32, 4800",
        "PROFESSOR, 33, 5000",
        "PROFESSOR, 34, 5000"
    })
    void calculaMultaSegundoCarenciaTarifaETeto(
            TipoUsuario tipo, int diasAtraso, int multaEsperada) {
        assertEquals(multaEsperada, regras.multaCentavos(tipo, diasAtraso));
    }

    @ParameterizedTest
    @EnumSource(TipoUsuario.class)
    void rejeitaAtrasoNegativo(TipoUsuario tipo) {
        assertThrows(IllegalArgumentException.class, () -> regras.multaCentavos(tipo, -1));
    }

    @Test
    void rejeitaTipoNulo() {
        assertThrows(IllegalArgumentException.class, () -> regras.multaCentavos(null, 0));
    }
}
