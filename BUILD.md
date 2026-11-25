# Execução dos testes da fase 1

O projeto Maven está em [kit-fase1](kit-fase1/). O [pom.xml](kit-fase1/pom.xml) já configura o JUnit 5, o Maven Surefire e o uso do JAR compilado em `kit-fase1/lib/biblioteca-1.0.jar`. Os testes ficam em `kit-fase1/src/test/java/br/edu/biblioteca/`, no pacote `br.edu.biblioteca`.

## Pré-requisitos

- JDK 17 ou superior e Maven disponíveis no terminal. Confira o JDK que o Maven usa com `mvn -version`.
- Acesso ao Maven Central para baixar dependências na primeira execução, se elas ainda estiverem fora do cache local.
- JAR fornecido pelo professor na pasta `kit-fase1/lib/`.

## Rodar os testes

A partir da raiz do repositório, execute:

```powershell
mvn -f kit-fase1/pom.xml test
```

Para rodar somente a classe `MultaCentavosTest`, use:

```powershell
mvn -f kit-fase1/pom.xml "-Dtest=MultaCentavosTest" test
```

## Interpretar o resultado

O resumo aparece no terminal. Os relatórios detalhados por classe ficam em `kit-fase1/target/surefire-reports/`. Confira `Tests run`, `Failures`, `Errors` e `Skipped`. O kit mantém `testFailureIgnore` habilitado, então `BUILD SUCCESS` pode aparecer mesmo com falhas de teste.

Em caso de falha, confira a regra no [Anexo A](Enunciado/Enunciado_projeto.pdf) e compare o esperado com o observado. Quando a divergência for do sistema, registre em `DEFEITOS.md` o método, a entrada, o esperado, o obtido e a classe de equivalência ou o valor-limite que motivou o caso. Preserve os resultados esperados derivados da especificação.
