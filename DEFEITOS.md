# Defeitos

## PrazoDiasTest

```
mvn -f kit-fase1/pom.xml "-Dtest=PrazoDiasTest" test
```

interpretação:

```
run 4 tests.

1 falha:

expected 7 but was 10.
```


## dataDevolucao

```
mvn -f kit-fase1/pom.xml "-Dtest=DataDevolucaoTest" test
```

interpretação:

```
run 25 tests.

9 falhas:

prazo domingo nao foi satisfeito.

expected: <2026-03-09> but was: <2026-03-08>

o mesmo erro se repete com datas diferentes.

falha de intervalos de 1 dia, que acredito que seja referente ao dia de domingo, e 3 dias, que precisa ser investigado.

```

## limiteEmprestimos

```
mvn -f kit-fase1/pom.xml "-Dtest=LimiteEmprestimosTest" test
```

interpretação:

```
run 4 tests.

0 falhas.

```

## PodeEmprestar

```
mvn -f kit-fase1/pom.xml "-Dtest=PodeEmprestarTest" test
```

interpretação:

```
run 35 tests.

12 falhas.

- falha: comparação entre emprestimos ativos com o limite estabelecido. divergente.
- falha: comparação multa pendente com o limite estabelecido. divergente.
- falha: rejeitar multa negativa
- falha: impedir emprestimo com atraso

```

## podeRenovar

```
mvn -f kit-fase1/pom.xml "-Dtest=PodeRenovarTest" test
```

interpretação:

```
run 21 tests.

3 falhas.

- falha: comparar quantidade de renovações com limite estabelecido. divergente.

```

## multaTotalCentavos

```
mvn -f kit-fase1/pom.xml "-Dtest=MultaTotalCentavosTest" test
```

interpretação:

```
run 42 tests.

30 falhas.

- falha: rejeitar valores negativo.
- falha: somar multas respeitando o teto estabelecido.

```