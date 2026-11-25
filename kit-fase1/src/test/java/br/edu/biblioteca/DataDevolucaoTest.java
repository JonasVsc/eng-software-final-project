package br.edu.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

class DataDevolucaoTest {

    private final RegrasBiblioteca regras = new RegrasBiblioteca();

    @ParameterizedTest
    @CsvSource({
        "ALUNO, 2026-02-03, 2026-02-17",
        "ALUNO, 2026-02-04, 2026-02-18",
        "ALUNO, 2026-02-05, 2026-02-19",
        "ALUNO, 2026-02-06, 2026-02-20",
        "ALUNO, 2026-02-07, 2026-02-21",
        "ALUNO, 2026-02-08, 2026-02-23",
        "ALUNO, 2026-02-09, 2026-02-23",
        "PROFESSOR, 2026-02-03, 2026-03-05",
        "PROFESSOR, 2026-02-04, 2026-03-06",
        "PROFESSOR, 2026-02-05, 2026-03-07",
        "PROFESSOR, 2026-02-06, 2026-03-09",
        "PROFESSOR, 2026-02-07, 2026-03-09",
        "PROFESSOR, 2026-02-08, 2026-03-10",
        "PROFESSOR, 2026-02-09, 2026-03-11",
        "VISITANTE, 2026-02-03, 2026-02-10",
        "VISITANTE, 2026-02-04, 2026-02-11",
        "VISITANTE, 2026-02-05, 2026-02-12",
        "VISITANTE, 2026-02-06, 2026-02-13",
        "VISITANTE, 2026-02-07, 2026-02-14",
        "VISITANTE, 2026-02-08, 2026-02-16",
        "VISITANTE, 2026-02-09, 2026-02-16"
    })
    void calculaDevolucaoConsiderandoPrazoEDomingo(
            TipoUsuario tipo, LocalDate retirada, LocalDate devolucaoEsperada) {
        assertEquals(devolucaoEsperada, regras.dataDevolucao(retirada, tipo));
    }

    @ParameterizedTest
    @EnumSource(TipoUsuario.class)
    void rejeitaDataDeRetiradaNula(TipoUsuario tipo) {
        assertThrows(IllegalArgumentException.class, () -> regras.dataDevolucao(null, tipo));
    }

    @Test
    void rejeitaTipoNulo() {
        LocalDate retirada = LocalDate.of(2026, 2, 3);
        assertThrows(IllegalArgumentException.class, () -> regras.dataDevolucao(retirada, null));
    }
}
