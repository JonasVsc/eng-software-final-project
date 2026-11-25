package br.edu.biblioteca;

import static br.edu.biblioteca.TipoUsuario.ALUNO;
import static br.edu.biblioteca.TipoUsuario.PROFESSOR;
import static br.edu.biblioteca.TipoUsuario.VISITANTE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

class MultaTotalCentavosTest {

    private final RegrasBiblioteca regras = new RegrasBiblioteca();

    @ParameterizedTest
    @MethodSource("casosValidos")
    void somaMultasRespeitandoOTeto(TipoUsuario tipo, int[] atrasos, int esperado) {
        assertEquals(esperado, regras.multaTotalCentavos(tipo, atrasos));
    }

    static Stream<Arguments> casosValidos() {
        return Stream.of(
                arguments(ALUNO, new int[0], 0),
                arguments(ALUNO, new int[] {0, 0}, 0),
                arguments(ALUNO, new int[] {1}, 100),
                arguments(ALUNO, new int[] {1, 2}, 300),
                arguments(ALUNO, new int[] {10, 11}, 2200),
                arguments(ALUNO, new int[] {31}, 5000),
                arguments(ALUNO, new int[] {30, 29, 1}, 9900),
                arguments(ALUNO, new int[] {30, 30}, 10000),
                arguments(ALUNO, new int[] {30, 30, 1}, 10000),
                arguments(VISITANTE, new int[0], 0),
                arguments(VISITANTE, new int[] {0, 0}, 0),
                arguments(VISITANTE, new int[] {1}, 100),
                arguments(VISITANTE, new int[] {1, 2}, 300),
                arguments(VISITANTE, new int[] {10, 11}, 2200),
                arguments(VISITANTE, new int[] {31}, 5000),
                arguments(VISITANTE, new int[] {30, 29, 1}, 9900),
                arguments(VISITANTE, new int[] {30, 30}, 10000),
                arguments(VISITANTE, new int[] {30, 30, 1}, 10000),
                arguments(PROFESSOR, new int[0], 0),
                arguments(PROFESSOR, new int[] {0, 0}, 0),
                arguments(PROFESSOR, new int[] {1, 2, 3}, 0),
                arguments(PROFESSOR, new int[] {4}, 100),
                arguments(PROFESSOR, new int[] {4, 5}, 300),
                arguments(PROFESSOR, new int[] {13, 14}, 2200),
                arguments(PROFESSOR, new int[] {34}, 5000),
                arguments(PROFESSOR, new int[] {33, 32, 4}, 9900),
                arguments(PROFESSOR, new int[] {33, 33}, 10000),
                arguments(PROFESSOR, new int[] {33, 33, 4}, 10000));
    }

    @ParameterizedTest
    @EnumSource(TipoUsuario.class)
    void rejeitaListaNula(TipoUsuario tipo) {
        assertThrows(IllegalArgumentException.class, () -> regras.multaTotalCentavos(tipo, null));
    }

    @ParameterizedTest
    @MethodSource("casosComAtrasoNegativo")
    void rejeitaListaComAtrasoNegativo(TipoUsuario tipo, int[] atrasos) {
        assertThrows(IllegalArgumentException.class, () -> regras.multaTotalCentavos(tipo, atrasos));
    }

    static Stream<Arguments> casosComAtrasoNegativo() {
        return Arrays.stream(TipoUsuario.values())
                .flatMap(tipo -> Stream.of(
                        arguments(tipo, new int[] {-1}),
                        arguments(tipo, new int[] {1, -1}),
                        arguments(tipo, new int[] {33, 33, -1})));
    }

    @ParameterizedTest
    @MethodSource("listasParaTipoNulo")
    void rejeitaTipoNulo(int[] atrasos) {
        assertThrows(IllegalArgumentException.class, () -> regras.multaTotalCentavos(null, atrasos));
    }

    static Stream<int[]> listasParaTipoNulo() {
        return Stream.of(new int[] {0}, new int[0]);
    }
}
