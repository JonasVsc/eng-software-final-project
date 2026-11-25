# Testes de software do sistema de biblioteca

Projeto acadêmico de Engenharia de Software com testes de caixa-preta, testes de caixa-branca e desenvolvimento orientado por testes (TDD) de uma fila de reservas. [Enunciado](Enunciado/Enunciado_projeto.pdf)

## Fase 1 · Testes de caixa-preta

A suíte exercita os sete métodos especificados no Anexo A. Os casos foram definidos por partição de equivalência e análise de valor-limite e executados contra o JAR fornecido pelo professor. Os testes usam JUnit 5 e ficam no pacote `br.edu.biblioteca`. [Código dos testes](kit-fase1/src/test/java/br/edu/biblioteca/)

## Como executar

Com o JDK 17 ou superior e o Maven disponíveis no terminal, execute o comando abaixo na raiz do repositório.

```sh
mvn -f kit-fase1/pom.xml test
```

Confira as falhas no resumo do JUnit ou em `kit-fase1/target/surefire-reports/`. O Maven pode exibir `BUILD SUCCESS` mesmo quando uma asserção falha, pois o kit permite registrar divergências entre o JAR e o comportamento especificado. [Instruções de execução](BUILD.md)

## Documentação

| Arquivo | Conteúdo |
| --- | --- |
| [PLANO-DE-TESTES.md](PLANO-DE-TESTES.md) | Classes de equivalência, valores-limite e casos JUnit que os exercitam. |
| [DEFEITOS.md](DEFEITOS.md) | Falhas observadas, com entradas e resultados esperados e obtidos. |
| [USO-DE-IA.md](USO-DE-IA.md) | Uso de IA na atividade, com referência ao histórico de prompts. |
