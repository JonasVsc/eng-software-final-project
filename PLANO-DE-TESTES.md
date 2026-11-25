
# Plano de testes

Plano de testes feito em "pseudocodigo".
Comentarios com //.

cada método especifica a tecnica utilizada e um pseudocodigo.

## prazoDias()

Tecnica utilizada: partição de equivalencia

classes válidas:
- CE01: ALUNO
- CE02: PROFESSOR
- CE03: VISITANTE

classes inválidas:
- CE04: tipo nulo

**Cobertura em JUnit 5** [PrazoDiasTest.java](kit-fase1/src/test/java/br/edu/biblioteca/PrazoDiasTest.java)

| Classe ou valor-limite | Teste e entradas que exercitam o item |
| --- | --- |
| CE01, CE02 e CE03 | `retornaOValorPrevistoParaCadaTipo`, nas linhas de `ALUNO`, `PROFESSOR` e `VISITANTE`, respectivamente. |
| CE04 | `rejeitaTipoNulo`, com `tipo = null`. |

```
bool test_prazoDias()
{
    diasAluno = 14
    diasProfessor = 30
    diasVisitante = 7

    TipoUsuario aluno(ALUNO)
    TipoUsuario professor(PROFESSOR)
    TipoUsuario visitante(VISITANTE)

    assert(prazoDias(aluno) == diasAluno)
    assert(prazoDias(professor) == diasProfessor)
    assert(prazoDias(visitante) == diasVisitante)

    assertThrows(IllegalArgumentException, prazoDias(null))
}
```

## dataDevolucao()

Tecnica utilizada: partição de equivalência e análise de valor-limite.

verificamos se o metodo funciona pata todos os dias da semana e quando o data_devolucao cai em um domingo.

classes validas:
- CE01: devolução em dia útil ou sábado
- CE02: devolução no domingo
- CE03: tipo ALUNO
- CE04: tipo PROFESSOR
- CE05: tipo VISITANTE

classes inválidas:
- CE06: data de retirada nula
- CE07: tipo nulo

Valores-limite:
- Sábado: dia anterior ao domingo.
- Domingo: dia que exige alteração da devolução.
- Segunda-feira: dia posterior ao domingo.

**Cobertura em JUnit 5** [DataDevolucaoTest.java](kit-fase1/src/test/java/br/edu/biblioteca/DataDevolucaoTest.java)

| Classe ou valor-limite | Teste e entradas que exercitam o item |
| --- | --- |
| CE01 | `calculaDevolucaoConsiderandoPrazoEDomingo`, nos casos em que a data calculada antes do ajuste cai de segunda a sábado. |
| CE02 | `calculaDevolucaoConsiderandoPrazoEDomingo`, nas retiradas de `2026-02-08` para aluno e visitante e de `2026-02-06` para professor. |
| CE03, CE04 e CE05 | `calculaDevolucaoConsiderandoPrazoEDomingo`, nas linhas de `ALUNO`, `PROFESSOR` e `VISITANTE`, respectivamente. |
| CE06 | `rejeitaDataDeRetiradaNula`, para os três tipos. |
| CE07 | `rejeitaTipoNulo`, com data de retirada `2026-02-03`. |
| Sábado, domingo e segunda-feira antes do ajuste | `calculaDevolucaoConsiderandoPrazoEDomingo`, com retiradas de `2026-02-07`, `2026-02-08` e `2026-02-09` para aluno e visitante, e de `2026-02-05`, `2026-02-06` e `2026-02-07` para professor, nessa ordem. |

```
bool test_dataDevolucao()
{
    datas[] = { 2026-02-03, 2026-02-04, 2026-02-05, 2026-02-06, 2026-02-07, 2026-02-08, 2026-02-09 };
    prazos[] = { 14, 30, 7 }

    for(tipo : TipoUsuario)
    {
        prazo = prazos[tipo]

        for(data : datas)
        {
            data_devolucao = data + prazo

            if(data_devolucao == domingo)
            {
                data_devolucao += 1;
            }

            assert(dataDevolucao(data, tipo) == data_devolucao)
        }    
    }

    assertThrows(IllegalArgumentException, dataDevolucao(null, tipo))
}
```

## limiteEmprestimos()

Tecnica utilizada: partição de equivalencia

classes válidas:
- CE01: ALUNO
- CE02: PROFESSOR
- CE03: VISITANTE

classes inválidas:
- CE04: tipo nulo

**Cobertura em JUnit 5** [LimiteEmprestimosTest.java](kit-fase1/src/test/java/br/edu/biblioteca/LimiteEmprestimosTest.java)

| Classe ou valor-limite | Teste e entradas que exercitam o item |
| --- | --- |
| CE01, CE02 e CE03 | `retornaOValorPrevistoParaCadaTipo`, nas linhas de `ALUNO`, `PROFESSOR` e `VISITANTE`, respectivamente. |
| CE04 | `rejeitaTipoNulo`, com `tipo = null`. |

```
bool test_limiteEmprestimos()
{
    lim_empr_aluno = 3
    lim_empr_professor = 8
    lim_empr_visitante = 1

    TipoUsuario aluno(ALUNO)
    TipoUsuario professor(PROFESSOR)
    TipoUsuario visitante(VISITANTE)

    assert(limiteEmprestimos(aluno) == lim_empr_aluno)
    assert(limiteEmprestimos(professor) == lim_empr_professor)
    assert(limiteEmprestimos(visitante) == lim_empr_visitante)

    assertThrows(IllegalArgumentException, limiteEmprestimos(null))
}
```

## multaCentavos()

Técnicas: partição de equivalência e análise de valor-limite.

classes válidas:
- CE01: nenhum atraso e dentro da carência
- CE02: cobrança de 100 centavos por dia
- CE03: cobrança de 200 centavos por dia adicional
- CE04: multa limitada a 5000 centavos

classes inválidas:
- CE05: atraso negativo
- CE06: tipo nulo

Valores-limite:

Alunos e visitantes:
-1, 0,  1
9,  10, 11
29, 30, 31

Professores:
-1, 0,  1
2,  3,  4
12, 13, 14
32, 33, 34

**Cobertura em JUnit 5** [MultaCentavosTest.java](kit-fase1/src/test/java/br/edu/biblioteca/MultaCentavosTest.java)

| Classe ou valor-limite | Teste e entradas que exercitam o item |
| --- | --- |
| CE01 | `calculaMultaSegundoCarenciaTarifaETeto`, com atraso `0` para os três tipos e `1`, `2` e `3` para professor. |
| CE02 | `calculaMultaSegundoCarenciaTarifaETeto`, com atrasos `1`, `9` e `10` para aluno e visitante e `4`, `12` e `13` para professor. |
| CE03 | `calculaMultaSegundoCarenciaTarifaETeto`, com atrasos `11` e `29` para aluno e visitante e `14` e `32` para professor. |
| CE04 | `calculaMultaSegundoCarenciaTarifaETeto`, com atrasos `30` e `31` para aluno e visitante e `33` e `34` para professor. |
| CE05 | `rejeitaAtrasoNegativo`, com `-1` para os três tipos. |
| CE06 | `rejeitaTipoNulo`, com atraso `0`. |
| `-1`, `0`, `1` para os três tipos | `rejeitaAtrasoNegativo` para `-1` e `calculaMultaSegundoCarenciaTarifaETeto` para `0` e `1`. |
| `9`, `10`, `11` e `29`, `30`, `31` para aluno e visitante | `calculaMultaSegundoCarenciaTarifaETeto` nas linhas desses tipos e atrasos. |
| `2`, `3`, `4`, `12`, `13`, `14` e `32`, `33`, `34` para professor | `calculaMultaSegundoCarenciaTarifaETeto` nas linhas de `PROFESSOR` com esses atrasos. |

```
bool test_multaCentavos()
{
     for(tipo : [ALUNO, VISITANTE])
    {
        // Limite inferior
        assert(multaCentavos(tipo, 0) == 0)
        assert(multaCentavos(tipo, 1) == 100)

        // Mudança de tarifa
        assert(multaCentavos(tipo, 9) == 900)
        assert(multaCentavos(tipo, 10) == 1000)
        assert(multaCentavos(tipo, 11) == 1200)

        // Limite da multa
        assert(multaCentavos(tipo, 29) == 4800)
        assert(multaCentavos(tipo, 30) == 5000)
        assert(multaCentavos(tipo, 31) == 5000)
    }

    // Limite inferior
    assert(multaCentavos(PROFESSOR, 0) == 0)
    assert(multaCentavos(PROFESSOR, 1) == 0)
    assert(multaCentavos(PROFESSOR, 2) == 0)
    assert(multaCentavos(PROFESSOR, 3) == 0)
    assert(multaCentavos(PROFESSOR, 4) == 100)

    // Mudança de tarifa
    assert(multaCentavos(PROFESSOR, 12) == 900)
    assert(multaCentavos(PROFESSOR, 13) == 1000)
    assert(multaCentavos(PROFESSOR, 14) == 1200)

    // Limite da multa
    assert(multaCentavos(PROFESSOR, 32) == 4800)
    assert(multaCentavos(PROFESSOR, 33) == 5000)
    assert(multaCentavos(PROFESSOR, 34) == 5000)

    // Atraso negativo
    for(tipo : TipoUsuario)
        assertThrows(IllegalArgumentException, multaCentavos(tipo, -1))

    // Tipo nulo
    assertThrows(IllegalArgumentException, multaCentavos(null, 0))
}
```

## podeEmprestar()

Técnicas utilizadas: partição de equivalência e análise de valor-limite.

classes válidas:
- CE01: empréstimos ativos abaixo do limite
- CE02: empréstimos ativos iguais ou acima do limite
- CE03: multa pendente de até 1000 centavos
- CE04: multa pendente acima de 1000 centavos
- CE05: possui atraso
- CE06: não possui atraso

classes inválidas:
- CE07: empréstimos ativos negativos
- CE08: multa pendente negativa
- CE09: tipo nulo

Empréstimos ativos:
- Aluno: 2, 3, 4
- Professor: 7, 8, 9
- Visitante: 0, 1, 2
- Limite inferior: -1, 0, 1

Multa pendente:
- -1, 0, 1
- 999, 1000, 1001

**Cobertura em JUnit 5** [PodeEmprestarTest.java](kit-fase1/src/test/java/br/edu/biblioteca/PodeEmprestarTest.java)

| Classe ou valor-limite | Teste e entradas que exercitam o item |
| --- | --- |
| CE01 | `comparaEmprestimosAtivosComOLimite`, com `2` empréstimos para aluno, `7` para professor e `0` para visitante. |
| CE02 | `comparaEmprestimosAtivosComOLimite`, com `3` e `4` para aluno, `8` e `9` para professor e `1` e `2` para visitante. |
| CE03 | `comparaEmprestimosAtivosComOLimite` com multa `0`, e `comparaMultaPendenteComOLimite` com `1`, `999` e `1000`. |
| CE04 | `comparaMultaPendenteComOLimite`, com `1001` para os três tipos. |
| CE05 | `impedeEmprestimoQuandoHaAtraso`, com `possuiAtraso = true` para os três tipos. |
| CE06 | `comparaEmprestimosAtivosComOLimite` e `comparaMultaPendenteComOLimite`, ambos com `possuiAtraso = false`. |
| CE07 | `rejeitaEmprestimosAtivosNegativos`, com `-1` empréstimo ativo. |
| CE08 | `rejeitaMultaPendenteNegativa`, com `-1` centavo. |
| CE09 | `rejeitaTipoNulo`, com as demais entradas válidas. |
| Limites por tipo de empréstimos ativos | `comparaEmprestimosAtivosComOLimite`, com `2`, `3` e `4` para aluno, `7`, `8` e `9` para professor e `0`, `1` e `2` para visitante. |
| Limite inferior de empréstimos ativos (`-1`, `0`, `1`) | `rejeitaEmprestimosAtivosNegativos` para `-1` e `comparaEmprestimosAtivosComOLimite` para `0` e `1`. |
| Limite inferior da multa pendente (`-1`, `0`, `1`) | `rejeitaMultaPendenteNegativa` para `-1`, `comparaEmprestimosAtivosComOLimite` para a multa `0` e `comparaMultaPendenteComOLimite` para `1`. |
| Limite superior da multa pendente (`999`, `1000`, `1001`) | `comparaMultaPendenteComOLimite`, nas três linhas de fronteira de cada tipo. |

```
bool test_podeEmprestar()
{
    limites[] = { 3, 8, 1 };

    for(tipo : TipoUsuario)
    {
        limite = limites[tipo]

        // Limite de empréstimos
        assert(podeEmprestar(tipo, limite - 1, 0, false) == true)
        assert(podeEmprestar(tipo, limite, 0, false) == false)
        assert(podeEmprestar(tipo, limite + 1, 0, false) == false)

        // Limite inferior de empréstimos
        assert(podeEmprestar(tipo, 0, 0, false) == true)
        assert(podeEmprestar(tipo, 1, 0, false) == (1 < limite))

        // Limite inferior da multa
        assert(podeEmprestar(tipo, 0, 0, false) == true)
        assert(podeEmprestar(tipo, 0, 1, false) == true)

        // Limite superior da multa
        assert(podeEmprestar(tipo, 0, 999, false) == true)
        assert(podeEmprestar(tipo, 0, 1000, false) == true)
        assert(podeEmprestar(tipo, 0, 1001, false) == false)

        // Possui atraso
        assert(podeEmprestar(tipo, 0, 0, true) == false)

        // Classes inválidas
        assertThrows(IllegalArgumentException, podeEmprestar(tipo, -1, 0, false))

        assertThrows(IllegalArgumentException, podeEmprestar(tipo, 0, -1, false))
    }

    assertThrows(IllegalArgumentException, podeEmprestar(null, 0, 0, false))
}
```

## podeRenovar()

classes válidas:
- CE01: aluno com menos de 2 renovações
- CE02: aluno com 2 ou mais renovações
- CE03: professor com menos de 3 renovações
- CE04: professor com 3 ou mais renovações
- CE05: visitante
- CE06: possui reserva
- CE07: não possui reserva
- CE08: possui atraso
- CE09: não possui atraso

classes inválidas:
- CE10: quantidade de renovações negativa
- CE11: tipo nulo

Valores-limite:
- Aluno: 1, 2, 3
- Professor: 2, 3, 4
- Limite inferior: -1, 0, 1

**Cobertura em JUnit 5** [PodeRenovarTest.java](kit-fase1/src/test/java/br/edu/biblioteca/PodeRenovarTest.java)

| Classe ou valor-limite | Teste e entradas que exercitam o item |
| --- | --- |
| CE01 e CE02 | `comparaQuantidadeDeRenovacoesComOLimite`, com `0` e `1` para CE01 e `2` e `3` para CE02, todos para aluno. |
| CE03 e CE04 | `comparaQuantidadeDeRenovacoesComOLimite`, com `0`, `1` e `2` para CE03 e `3` e `4` para CE04, todos para professor. |
| CE05 | `comparaQuantidadeDeRenovacoesComOLimite`, com `0` e `1` para visitante. |
| CE06 | `impedeRenovacaoQuandoHaReservaOuAtraso`, com `possuiReserva = true`. |
| CE07 | `comparaQuantidadeDeRenovacoesComOLimite`, com `possuiReserva = false`. |
| CE08 | `impedeRenovacaoQuandoHaReservaOuAtraso`, com `emAtraso = true`. |
| CE09 | `comparaQuantidadeDeRenovacoesComOLimite`, com `emAtraso = false`. |
| CE10 | `rejeitaQuantidadeNegativaDeRenovacoes`, com `-1` para os três tipos. |
| CE11 | `rejeitaTipoNulo`, com as demais entradas válidas. |
| Limites de aluno (`1`, `2`, `3`) e professor (`2`, `3`, `4`) | `comparaQuantidadeDeRenovacoesComOLimite`, nas linhas do tipo e das quantidades indicadas. |
| Limite inferior (`-1`, `0`, `1`) | `rejeitaQuantidadeNegativaDeRenovacoes` para `-1` e `comparaQuantidadeDeRenovacoesComOLimite` para `0` e `1`. |

```
bool test_podeRenovar()
{
    limites[] = { 2, 3, 0 };

    for(tipo : [ALUNO, PROFESSOR])
    {
        limite = limites[tipo]

        // Limite de renovações
        assert(podeRenovar(tipo, limite - 1, false, false) == true)
        assert(podeRenovar(tipo, limite, false, false) == false)
        assert(podeRenovar(tipo, limite + 1, false, false) == false)

        // Limite inferior de renovações
        assert(podeRenovar(tipo, 0, false, false) == true)
        assert(podeRenovar(tipo, 1, false, false) == true)

        // Possui reserva
        assert(podeRenovar(tipo, 0, true, false) == false)

        // Possui atraso
        assert(podeRenovar(tipo, 0, false, true) == false)

        // Possui reserva e atraso
        assert(podeRenovar(tipo, 0, true, true) == false)
    }

    // Visitante nunca pode renovar
    assert(podeRenovar(VISITANTE, 0, false, false) == false)
    assert(podeRenovar(VISITANTE, 1, false, false) == false)

    // Classes inválidas
    for(tipo : TipoUsuario)
        assertThrows(IllegalArgumentException, podeRenovar(tipo, -1, false, false))

    assertThrows(IllegalArgumentException, podeRenovar(null, 0, false, false))
}
```

## multaTotalCentavos()

Técnicas utilizadas: partição de equivalência e análise de valor-limite.

classes válidas:
- CE01: lista vazia
- CE02: lista sem atrasos
- CE03: lista com um empréstimo
- CE04: lista com múltiplos empréstimos
- CE05: soma das multas abaixo de 10000 centavos
- CE06: soma das multas igual a 10000 centavos
- CE07: soma das multas acima de 10000 centavos antes da aplicação do teto

classes inválidas:
- CE08: lista nula
- CE09: lista com elemento negativo
- CE10: tipo nulo

valores-limite:
- Quantidade de empréstimos: 0, 1, 2
- Dias de atraso: -1, 0, 1
- Multa total: 9900, 10000, 10100

**Cobertura em JUnit 5** [MultaTotalCentavosTest.java](kit-fase1/src/test/java/br/edu/biblioteca/MultaTotalCentavosTest.java)

| Classe ou valor-limite | Teste e entradas que exercitam o item |
| --- | --- |
| CE01 e CE02 | `somaMultasRespeitandoOTeto`, com `[]` para CE01 e `[0, 0]` para CE02, para os três tipos. |
| CE03 e CE04 | `somaMultasRespeitandoOTeto`, com `[1]` e `[1, 2]` para aluno e visitante e `[4]` e `[4, 5]` para professor, respectivamente. |
| CE05, CE06 e CE07 | `somaMultasRespeitandoOTeto`, nos casos de soma antes do teto de `9900`, `10000` e `10100`, respectivamente. |
| CE08 | `rejeitaListaNula`, com lista nula para os três tipos. |
| CE09 | `rejeitaListaComAtrasoNegativo`, com `[-1]`, `[1, -1]` e `[33, 33, -1]`. |
| CE10 | `rejeitaTipoNulo`, com as listas `[0]` e `[]`. |
| Quantidade de empréstimos (`0`, `1`, `2`) | `somaMultasRespeitandoOTeto`, nas listas de CE01, CE03 e CE04, respectivamente. |
| Dias de atraso (`-1`, `0`, `1`) | `rejeitaListaComAtrasoNegativo` para `-1` e `somaMultasRespeitandoOTeto` para `[0, 0]` e para `[1]` (aluno e visitante) ou `[1, 2, 3]` (professor). |
| Soma antes do teto (`9900`, `10000`, `10100`) | `somaMultasRespeitandoOTeto`, com `[30, 29, 1]`, `[30, 30]` e `[30, 30, 1]` para aluno e visitante e com `[33, 32, 4]`, `[33, 33]` e `[33, 33, 4]` para professor, nessa ordem. |

```
bool test_multaTotalCentavos()
{
    for(tipo : [ALUNO, VISITANTE])
    {
        // Lista vazia
        assert(multaTotalCentavos(tipo, []) == 0)

        // Lista sem atrasos
        assert(multaTotalCentavos(tipo, [0, 0]) == 0)

        // Quantidade de empréstimos
        assert(multaTotalCentavos(tipo, [1]) == 100)
        assert(multaTotalCentavos(tipo, [1, 2]) == 300)

        // Mudança de tarifa
        assert(multaTotalCentavos(tipo, [10, 11]) == 2200)

        // Limite da multa individual
        assert(multaTotalCentavos(tipo, [31]) == 5000)

        // Limite da multa total
        assert(multaTotalCentavos(tipo, [30, 29, 1]) == 9900)
        assert(multaTotalCentavos(tipo, [30, 30]) == 10000)
        assert(multaTotalCentavos(tipo, [30, 30, 1]) == 10000)
    }

    // Lista vazia
    assert(multaTotalCentavos(PROFESSOR, []) == 0)

    // Lista sem atrasos
    assert(multaTotalCentavos(PROFESSOR, [0, 0]) == 0)

    // Carência
    assert(multaTotalCentavos(PROFESSOR, [1, 2, 3]) == 0)

    // Quantidade de empréstimos
    assert(multaTotalCentavos(PROFESSOR, [4]) == 100)
    assert(multaTotalCentavos(PROFESSOR, [4, 5]) == 300)

    // Mudança de tarifa
    assert(multaTotalCentavos(PROFESSOR, [13, 14]) == 2200)

    // Limite da multa individual
    assert(multaTotalCentavos(PROFESSOR, [34]) == 5000)

    // Limite da multa total
    assert(multaTotalCentavos(PROFESSOR, [33, 32, 4]) == 9900)
    assert(multaTotalCentavos(PROFESSOR, [33, 33]) == 10000)
    assert(multaTotalCentavos(PROFESSOR, [33, 33, 4]) == 10000)

    // Classes inválidas
    for(tipo : TipoUsuario)
    {
        assertThrows(IllegalArgumentException, multaTotalCentavos(tipo, null))

        assertThrows(IllegalArgumentException, multaTotalCentavos(tipo, [-1]))

        assertThrows(IllegalArgumentException, multaTotalCentavos(tipo, [1, -1]))

        // Elemento negativo após atingir o teto
        assertThrows(IllegalArgumentException, multaTotalCentavos(tipo, [33, 33, -1]))
    }

    assertThrows(IllegalArgumentException, multaTotalCentavos(null, [0]))

    assertThrows(IllegalArgumentException, multaTotalCentavos(null, []))
}
```
