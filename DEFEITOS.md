# Registro de defeitos da fase 1

Execução de 24/11/2026 às 23h22, com o JAR fornecido pelo professor. Foram executados **163 casos**, com **70 falhas de asserção**, **0 erros de execução** e **0 casos ignorados**. O total inclui o teste de exemplo do kit.

O comando de execução e o caminho dos relatórios do Surefire estão no [BUILD.md](BUILD.md). Os identificadores CE correspondem às classes de equivalência do [plano de testes](PLANO-DE-TESTES.md), dentro da seção de cada método.

Cada linha registra uma invocação que falhou. Quando o Surefire informou que a exceção esperada não foi lançada, repetimos a mesma chamada à API pública do JAR para registrar o valor retornado. Os valores monetários estão em centavos.

## Resumo da execução

| Método | Casos | Falhas |
| --- | ---: | ---: |
| `prazoDias` | 4 | 1 |
| `dataDevolucao` | 25 | 9 |
| `limiteEmprestimos` | 4 | 0 |
| `multaCentavos` | 31 | 15 |
| `podeEmprestar` | 35 | 12 |
| `podeRenovar` | 21 | 3 |
| `multaTotalCentavos` | 42 | 30 |
| teste de exemplo do kit | 1 | 0 |

## Falhas por método

### prazoDias

[PrazoDiasTest.java](kit-fase1/src/test/java/br/edu/biblioteca/PrazoDiasTest.java)

| Entrada em ordem de chamada | Esperado | Obtido | Classe ou valor-limite | Caso JUnit |
| --- | --- | --- | --- | --- |
| `VISITANTE` | `7` | `10` | CE03 (visitante) | `retornaOValorPrevistoParaCadaTipo[3]` |

### dataDevolucao

[DataDevolucaoTest.java](kit-fase1/src/test/java/br/edu/biblioteca/DataDevolucaoTest.java)

| Entrada em ordem de chamada | Esperado | Obtido | Classe ou valor-limite | Caso JUnit |
| --- | --- | --- | --- | --- |
| `2026-02-06, PROFESSOR` | `2026-03-09` | `2026-03-08` | CE02 e CE04 (domingo antes do ajuste) | `calculaDevolucaoConsiderandoPrazoEDomingo[11]` |
| `2026-02-08, PROFESSOR` | `2026-03-10` | `2026-03-11` | CE01 e CE04 | `calculaDevolucaoConsiderandoPrazoEDomingo[13]` |
| `2026-02-03, VISITANTE` | `2026-02-10` | `2026-02-13` | CE01 e CE05 | `calculaDevolucaoConsiderandoPrazoEDomingo[15]` |
| `2026-02-04, VISITANTE` | `2026-02-11` | `2026-02-14` | CE01 e CE05 | `calculaDevolucaoConsiderandoPrazoEDomingo[16]` |
| `2026-02-05, VISITANTE` | `2026-02-12` | `2026-02-15` | CE01 e CE05 | `calculaDevolucaoConsiderandoPrazoEDomingo[17]` |
| `2026-02-06, VISITANTE` | `2026-02-13` | `2026-02-16` | CE01 e CE05 | `calculaDevolucaoConsiderandoPrazoEDomingo[18]` |
| `2026-02-07, VISITANTE` | `2026-02-14` | `2026-02-17` | CE01 e CE05 (sábado antes do ajuste) | `calculaDevolucaoConsiderandoPrazoEDomingo[19]` |
| `2026-02-08, VISITANTE` | `2026-02-16` | `2026-02-19` | CE02 e CE05 (domingo antes do ajuste) | `calculaDevolucaoConsiderandoPrazoEDomingo[20]` |
| `2026-02-09, VISITANTE` | `2026-02-16` | `2026-02-19` | CE01 e CE05 (segunda-feira antes do ajuste) | `calculaDevolucaoConsiderandoPrazoEDomingo[21]` |

### multaCentavos

[MultaCentavosTest.java](kit-fase1/src/test/java/br/edu/biblioteca/MultaCentavosTest.java)

| Entrada em ordem de chamada | Esperado | Obtido | Classe ou valor-limite | Caso JUnit |
| --- | --- | --- | --- | --- |
| `ALUNO, -1` | `IllegalArgumentException` | Retornou `-100` sem lançar exceção | CE05 · atraso negativo (`-1`) | `rejeitaAtrasoNegativo[1]` |
| `PROFESSOR, -1` | `IllegalArgumentException` | Retornou `0` sem lançar exceção | CE05 · atraso negativo (`-1`) | `rejeitaAtrasoNegativo[2]` |
| `VISITANTE, -1` | `IllegalArgumentException` | Retornou `-100` sem lançar exceção | CE05 · atraso negativo (`-1`) | `rejeitaAtrasoNegativo[3]` |
| `ALUNO, 11` | `1200` | `1100` | CE03 · mudança de tarifa | `calculaMultaSegundoCarenciaTarifaETeto[5]` |
| `ALUNO, 31` | `5000` | `5200` | CE04 · limite do teto individual | `calculaMultaSegundoCarenciaTarifaETeto[8]` |
| `VISITANTE, 11` | `1200` | `1100` | CE03 · mudança de tarifa | `calculaMultaSegundoCarenciaTarifaETeto[13]` |
| `VISITANTE, 31` | `5000` | `5200` | CE04 · limite do teto individual | `calculaMultaSegundoCarenciaTarifaETeto[16]` |
| `PROFESSOR, 3` | `0` | `100` | CE01 · limite da carência | `calculaMultaSegundoCarenciaTarifaETeto[20]` |
| `PROFESSOR, 4` | `100` | `200` | CE02 · limite da carência | `calculaMultaSegundoCarenciaTarifaETeto[21]` |
| `PROFESSOR, 12` | `900` | `1000` | CE02 · mudança de tarifa | `calculaMultaSegundoCarenciaTarifaETeto[22]` |
| `PROFESSOR, 13` | `1000` | `1100` | CE02 · mudança de tarifa | `calculaMultaSegundoCarenciaTarifaETeto[23]` |
| `PROFESSOR, 14` | `1200` | `1400` | CE03 · mudança de tarifa | `calculaMultaSegundoCarenciaTarifaETeto[24]` |
| `PROFESSOR, 32` | `4800` | `5000` | CE03 · limite do teto individual | `calculaMultaSegundoCarenciaTarifaETeto[25]` |
| `PROFESSOR, 33` | `5000` | `5200` | CE04 · limite do teto individual | `calculaMultaSegundoCarenciaTarifaETeto[26]` |
| `PROFESSOR, 34` | `5000` | `5400` | CE04 · limite do teto individual | `calculaMultaSegundoCarenciaTarifaETeto[27]` |

### podeEmprestar

[PodeEmprestarTest.java](kit-fase1/src/test/java/br/edu/biblioteca/PodeEmprestarTest.java)

| Entrada em ordem de chamada | Esperado | Obtido | Classe ou valor-limite | Caso JUnit |
| --- | --- | --- | --- | --- |
| `ALUNO, 3, 0, false` | `false` | `true` | CE02 · quantidade igual ao limite do tipo | `comparaEmprestimosAtivosComOLimite[4]` |
| `PROFESSOR, 8, 0, false` | `false` | `true` | CE02 · quantidade igual ao limite do tipo | `comparaEmprestimosAtivosComOLimite[9]` |
| `VISITANTE, 1, 0, false` | `false` | `true` | CE02 · quantidade igual ao limite do tipo | `comparaEmprestimosAtivosComOLimite[12]` |
| `ALUNO, 0, 1001, false` | `false` | `true` | CE04 · multa de `1001` centavos | `comparaMultaPendenteComOLimite[4]` |
| `PROFESSOR, 0, 1001, false` | `false` | `true` | CE04 · multa de `1001` centavos | `comparaMultaPendenteComOLimite[8]` |
| `VISITANTE, 0, 1001, false` | `false` | `true` | CE04 · multa de `1001` centavos | `comparaMultaPendenteComOLimite[12]` |
| `ALUNO, 0, -1, false` | `IllegalArgumentException` | Retornou `true` sem lançar exceção | CE08 · multa pendente negativa (`-1`) | `rejeitaMultaPendenteNegativa[1]` |
| `PROFESSOR, 0, -1, false` | `IllegalArgumentException` | Retornou `true` sem lançar exceção | CE08 · multa pendente negativa (`-1`) | `rejeitaMultaPendenteNegativa[2]` |
| `VISITANTE, 0, -1, false` | `IllegalArgumentException` | Retornou `true` sem lançar exceção | CE08 · multa pendente negativa (`-1`) | `rejeitaMultaPendenteNegativa[3]` |
| `ALUNO, 0, 0, true` | `false` | `true` | CE05 · possui atraso | `impedeEmprestimoQuandoHaAtraso[1]` |
| `PROFESSOR, 0, 0, true` | `false` | `true` | CE05 · possui atraso | `impedeEmprestimoQuandoHaAtraso[2]` |
| `VISITANTE, 0, 0, true` | `false` | `true` | CE05 · possui atraso | `impedeEmprestimoQuandoHaAtraso[3]` |

### podeRenovar

[PodeRenovarTest.java](kit-fase1/src/test/java/br/edu/biblioteca/PodeRenovarTest.java)

| Entrada em ordem de chamada | Esperado | Obtido | Classe ou valor-limite | Caso JUnit |
| --- | --- | --- | --- | --- |
| `PROFESSOR, 3, false, false` | `false` | `true` | CE04 · `3` renovações, no limite | `comparaQuantidadeDeRenovacoesComOLimite[8]` |
| `VISITANTE, 0, false, false` | `false` | `true` | CE05 · visitante | `comparaQuantidadeDeRenovacoesComOLimite[10]` |
| `VISITANTE, 1, false, false` | `false` | `true` | CE05 · visitante | `comparaQuantidadeDeRenovacoesComOLimite[11]` |

### multaTotalCentavos

[MultaTotalCentavosTest.java](kit-fase1/src/test/java/br/edu/biblioteca/MultaTotalCentavosTest.java)

| Entrada em ordem de chamada | Esperado | Obtido | Classe ou valor-limite | Caso JUnit |
| --- | --- | --- | --- | --- |
| `ALUNO, [-1]` | `IllegalArgumentException` | Retornou `0` sem lançar exceção | CE09 · lista com elemento negativo | `rejeitaListaComAtrasoNegativo[1]` |
| `ALUNO, [1, -1]` | `IllegalArgumentException` | Retornou `-100` sem lançar exceção | CE09 · lista com elemento negativo | `rejeitaListaComAtrasoNegativo[2]` |
| `ALUNO, [33, 33, -1]` | `IllegalArgumentException` | Retornou `5500` sem lançar exceção | CE09 · lista com elemento negativo | `rejeitaListaComAtrasoNegativo[3]` |
| `PROFESSOR, [-1]` | `IllegalArgumentException` | Retornou `0` sem lançar exceção | CE09 · lista com elemento negativo | `rejeitaListaComAtrasoNegativo[4]` |
| `PROFESSOR, [1, -1]` | `IllegalArgumentException` | Retornou `0` sem lançar exceção | CE09 · lista com elemento negativo | `rejeitaListaComAtrasoNegativo[5]` |
| `PROFESSOR, [33, 33, -1]` | `IllegalArgumentException` | Retornou `5200` sem lançar exceção | CE09 · lista com elemento negativo | `rejeitaListaComAtrasoNegativo[6]` |
| `VISITANTE, [-1]` | `IllegalArgumentException` | Retornou `0` sem lançar exceção | CE09 · lista com elemento negativo | `rejeitaListaComAtrasoNegativo[7]` |
| `VISITANTE, [1, -1]` | `IllegalArgumentException` | Retornou `-100` sem lançar exceção | CE09 · lista com elemento negativo | `rejeitaListaComAtrasoNegativo[8]` |
| `VISITANTE, [33, 33, -1]` | `IllegalArgumentException` | Retornou `5500` sem lançar exceção | CE09 · lista com elemento negativo | `rejeitaListaComAtrasoNegativo[9]` |
| `ALUNO, [1]` | `100` | `0` | CE03 · um empréstimo com `1` dia de atraso | `somaMultasRespeitandoOTeto[3]` |
| `ALUNO, [1, 2]` | `300` | `200` | CE04 · dois empréstimos com atraso | `somaMultasRespeitandoOTeto[4]` |
| `ALUNO, [10, 11]` | `2200` | `1100` | CE04 · dois empréstimos na mudança de tarifa | `somaMultasRespeitandoOTeto[5]` |
| `ALUNO, [31]` | `5000` | `0` | CE03 · um empréstimo com multa individual limitada ao teto | `somaMultasRespeitandoOTeto[6]` |
| `ALUNO, [30, 29, 1]` | `9900` | `4900` | CE05 · soma de `9900` antes do teto | `somaMultasRespeitandoOTeto[7]` |
| `ALUNO, [30, 30]` | `10000` | `5000` | CE06 · soma de `10000` antes do teto | `somaMultasRespeitandoOTeto[8]` |
| `ALUNO, [30, 30, 1]` | `10000` | `5100` | CE07 · soma de `10100` antes do teto | `somaMultasRespeitandoOTeto[9]` |
| `VISITANTE, [1]` | `100` | `0` | CE03 · um empréstimo com `1` dia de atraso | `somaMultasRespeitandoOTeto[12]` |
| `VISITANTE, [1, 2]` | `300` | `200` | CE04 · dois empréstimos com atraso | `somaMultasRespeitandoOTeto[13]` |
| `VISITANTE, [10, 11]` | `2200` | `1100` | CE04 · dois empréstimos na mudança de tarifa | `somaMultasRespeitandoOTeto[14]` |
| `VISITANTE, [31]` | `5000` | `0` | CE03 · um empréstimo com multa individual limitada ao teto | `somaMultasRespeitandoOTeto[15]` |
| `VISITANTE, [30, 29, 1]` | `9900` | `4900` | CE05 · soma de `9900` antes do teto | `somaMultasRespeitandoOTeto[16]` |
| `VISITANTE, [30, 30]` | `10000` | `5000` | CE06 · soma de `10000` antes do teto | `somaMultasRespeitandoOTeto[17]` |
| `VISITANTE, [30, 30, 1]` | `10000` | `5100` | CE07 · soma de `10100` antes do teto | `somaMultasRespeitandoOTeto[18]` |
| `PROFESSOR, [1, 2, 3]` | `0` | `100` | CE04 · vários empréstimos dentro da carência do professor | `somaMultasRespeitandoOTeto[21]` |
| `PROFESSOR, [4]` | `100` | `0` | CE03 · um empréstimo no primeiro dia cobrado após a carência | `somaMultasRespeitandoOTeto[22]` |
| `PROFESSOR, [13, 14]` | `2200` | `1400` | CE04 · dois empréstimos na mudança de tarifa | `somaMultasRespeitandoOTeto[24]` |
| `PROFESSOR, [34]` | `5000` | `0` | CE03 · um empréstimo com multa individual limitada ao teto | `somaMultasRespeitandoOTeto[25]` |
| `PROFESSOR, [33, 32, 4]` | `9900` | `5200` | CE05 · soma de `9900` antes do teto | `somaMultasRespeitandoOTeto[26]` |
| `PROFESSOR, [33, 33]` | `10000` | `5200` | CE06 · soma de `10000` antes do teto | `somaMultasRespeitandoOTeto[27]` |
| `PROFESSOR, [33, 33, 4]` | `10000` | `5400` | CE07 · soma de `10100` antes do teto | `somaMultasRespeitandoOTeto[28]` |
