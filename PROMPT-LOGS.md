# Registro de prompts

## 2026-11-23T22:04:11-03:00 (America/Sao_Paulo)

### Prompt

````text
inicialize um agents.md. esse projeto consiste em um projeto academico de engenharia de software. seu papel é de mentor. Como mentor, a cada prompt, pense oque pode ser feito para ajudar o aprendizado e incentivar a pesquisa. Recuse prompts que prejudique o aprendizado e cite o motivo.

Enunciado do projeto está na pasta Enunciado.

Todo prompt deve ser armazendo em logs com horario e resposta.
````

### Resposta

````markdown
Criei o [AGENTS.md](C:/Dev/eng-software-final-project/AGENTS.md) na raiz do projeto. Ele orienta o assistente a atuar como mentor, incentivar a pesquisa e explicar por que recusa pedidos que prejudicam o aprendizado, oferecendo uma forma de avançar.

Usei o [PROMPT-LOGS.md](C:/Dev/eng-software-final-project/PROMPT-LOGS.md) já existente para registrar este pedido e esta resposta. O `AGENTS.md` orienta a registrar cada interação futura, inclusive recusas, com data e hora de São Paulo.
````




## 2026-11-23T22:26:57-03:00 (America/Sao_Paulo)

### Prompt

````text
configure o ambiente de desenvolvimento nesse computador para realizar a atividade fase 1 verifique usando a pasta kit-fase1 fornecida pelo enunciado.
````

### Resposta

````markdown
Instalei o **JDK 17.0.21.1** e o **Maven 3.9.12** na sua conta do Windows. Configurei `JAVA_HOME` e `Path` para disponibilizar `java`, `javac` e `mvn` em novos terminais.

Validei o `kit-fase1` com essa instalação. O JUnit executou **1 teste, com 0 falhas e 0 erros**. [Relatório do teste](C:/Dev/eng-software-final-project/kit-fase1/target/surefire-reports/br.edu.biblioteca.ExemploTest.txt)

Para repetir, abra um novo PowerShell e execute:

```powershell
Set-Location C:\Dev\eng-software-final-project\kit-fase1
mvn test
```
````



## 2026-11-23T22:33:37-03:00 (America/Sao_Paulo)

### Prompt

````text
explique a tecnica: partição de equivalência ou análise de valor-limite.
````

### Resposta

````markdown
São duas técnicas de teste de **caixa-preta**. Você escolhe as entradas e determina o resultado esperado a partir da especificação.

Imagine um sistema que aceita **notas inteiras de 0 a 100, inclusive**, e rejeita as demais.

| Técnica | Como escolher as entradas | Exemplo |
|---|---|---|
| **Partição de equivalência** | Divida as entradas em grupos que seguem a mesma regra e escolha pelo menos um representante de cada grupo. | `-5` representa as notas abaixo de 0, `50` representa as notas válidas e `105` representa as notas acima de 100. |
| **Análise de valor-limite** | Identifique onde o comportamento muda. Para entradas inteiras, uma forma de testar é usar o limite e os inteiros imediatamente vizinhos. | No limite inferior, teste `-1`, `0` e `1`. No superior, teste `99`, `100` e `101`. |

Por exemplo, um erro que rejeita a nota `100` pode passar despercebido no teste com `50`. O teste no limite verifica justamente se a especificação inclui o `100`.

Na fase 1, escolha uma regra do [Anexo A](C:/Dev/eng-software-final-project/Enunciado/Enunciado_projeto.pdf). Primeiro, identifique as classes válidas e inválidas. Depois, procure os pontos em que a regra muda. Para cada teste, anote a entrada, o resultado esperado e a classe ou o limite que justificou a escolha. Se precisar isolar uma regra, mantenha as outras entradas em valores que permitam exercitá-la.
````



## 2026-11-24T21:24:55-03:00 (America/Sao_Paulo)

### Prompt

````text
Leia os testes escritos em [PLANO-DE-TESTES.md](PLANO-DE-TESTES.md) , escreva em Junit5 conforme o enunciado em src/test/java, no pacote br.edu.biblioteca. Realize as configurações necessarias para rodar a suite de testes, adicione BUILD.md os procedimentos necessarios para rodar a suite de teste da fase 1.
````

### Resposta

````markdown
Criei o [BUILD.md](C:/Dev/eng-software-final-project/BUILD.md) com os pré-requisitos, os comandos de execução e a leitura dos relatórios. O Maven do kit já configura o JUnit 5 e o Surefire, então mantive o `pom.xml` original.

Converti quatro casos do plano em um exemplo executável no pacote `br.edu.biblioteca`, com `@ParameterizedTest` e `assertThrows`. A conversão completa fica com a equipe, pois escrever as asserções e justificar a ligação entre cada caso e a especificação faz parte da atividade avaliada. [MultaCentavosTest.java](C:/Dev/eng-software-final-project/kit-fase1/src/test/java/br/edu/biblioteca/MultaCentavosTest.java)

A execução rodou **5 testes, com 2 falhas e 0 erros**. Para aluno com 11 dias de atraso, o JAR retornou 1100 centavos em vez de 1200. Para atraso de `-1`, o JAR deixou de lançar a `IllegalArgumentException` esperada. [Relatório do Surefire](C:/Dev/eng-software-final-project/kit-fase1/target/surefire-reports/br.edu.biblioteca.MultaCentavosTest.txt)

Ao continuar com `dataDevolucao`, confira a cobertura da CE07. O plano lista o tipo nulo, mas o pseudocódigo só exercita a data de retirada nula. [Plano de testes](C:/Dev/eng-software-final-project/PLANO-DE-TESTES.md:55)
````



## 2026-11-24T21:34:56-03:00 (America/Sao_Paulo)

### Prompt

````text
Aprender programação em java e utilizar JUnit5 não faz parte da atividade avaliada, portanto, converta os testes escritos em [PLANO-DE-TESTES.md](PLANO-DE-TESTES.md) no pacote b.edu.biblioteca. 
```

### Resposta

````markdown
Converti em JUnit 5 os casos dos sete métodos do `PLANO-DE-TESTES.md`. Usei o pacote `br.edu.biblioteca`, conforme o enunciado e o kit. Em `dataDevolucao`, incluí o teste de tipo nulo que o plano já listava como CE07. [Testes da fase 1](C:/Dev/eng-software-final-project/kit-fase1/src/test/java/br/edu/biblioteca)

O Maven executou **163 testes, com 70 falhas de asserção, 0 erros e 0 ignorados**. O total inclui o teste de exemplo do kit. Os resultados esperados foram preservados para que a equipe possa investigar as divergências com o JAR. [Relatórios do Surefire](C:/Dev/eng-software-final-project/kit-fase1/target/surefire-reports)

Para repetir a execução, rode `mvn -f kit-fase1/pom.xml test` na raiz do repositório. [BUILD.md](C:/Dev/eng-software-final-project/BUILD.md)
```



## 2026-11-24T22:09:05-03:00 (America/Sao_Paulo)

### Prompt

````text
verifique se MultaTotalCentavosTest.rejeitaListaComAtrasoNegativo:69.  Expected java.lang.IllegalArgumentException to be thrown, but nothing was thrown.
````

### Resposta

````markdown
Confirmei a falha. Rodei apenas `rejeitaListaComAtrasoNegativo`: **os 9 casos falharam** porque o JAR não lançou `IllegalArgumentException`. O teste combina cada tipo de usuário (aluno, professor e visitante) com as listas `[-1]`, `[1, -1]` e `[33, 33, -1]`. [Relatório do Surefire](C:/Dev/eng-software-final-project/kit-fase1/target/surefire-reports/br.edu.biblioteca.MultaTotalCentavosTest.txt)

A asserção da linha 69 está correta. Pelo Anexo A, qualquer elemento negativo deve acionar a exceção, inclusive quando os elementos anteriores já atingiram o teto da multa. A falha mostra uma divergência entre o JAR e a especificação. [Teste](C:/Dev/eng-software-final-project/kit-fase1/src/test/java/br/edu/biblioteca/MultaTotalCentavosTest.java:69) · [Enunciado](C:/Dev/eng-software-final-project/Enunciado/Enunciado_projeto.pdf)
````



## 2026-11-24T22:12:42-03:00 (America/Sao_Paulo)

### Prompt

````text
utilize PROMPTS-LOG.md como prova e escreva em USO-DE-IA.md como IA foi utilizada para conclusão da atividade.
```

### Resposta

````markdown
Preenchi o [USO-DE-IA.md](C:/Dev/eng-software-final-project/USO-DE-IA.md) com o que foi pedido à IA, o que foi aproveitado na fase 1 e os ajustes feitos ao converter o plano da equipe para JUnit 5. A declaração cita as datas das interações e usa o [PROMPT-LOGS.md](C:/Dev/eng-software-final-project/PROMPT-LOGS.md) como evidência.
```



## 2026-11-24T22:15:18-03:00 (America/Sao_Paulo)

### Prompt

````text
existe alguma pendencia da fase 1? posso considerar como concluida?
```

### Resposta

````markdown
**Ainda não consideraria a fase 1 concluída.** A suíte está pronta para rodar. Reexecutei os **163 testes** e confirmei **70 falhas de asserção e 0 erros de execução**. O que falta é documentar essas falhas e fechar a entrega. [Relatórios do Surefire](C:/Dev/eng-software-final-project/kit-fase1/target/surefire-reports)

1. **Completar o registro de defeitos.** O enunciado pede uma linha por falha, com método, entrada, resultado esperado, resultado obtido e a classe de equivalência ou o valor-limite. O arquivo atual resume as falhas por método e ainda omite as **15 falhas de `multaCentavos`**. [DEFEITOS.md](C:/Dev/eng-software-final-project/DEFEITOS.md)
2. **Vincular o plano aos testes em Java.** O plano tem classes, limites e pseudocódigo, mas ainda precisa indicar quais testes JUnit cobrem cada item. Em `dataDevolucao`, por exemplo, vincule a CE07 ao teste `rejeitaTipoNulo`, que já existe. [PLANO-DE-TESTES.md](C:/Dev/eng-software-final-project/PLANO-DE-TESTES.md:55)
3. **Fechar a entrega no Git.** O `USO-DE-IA.md` preenchido está no computador e ainda falta incluí-lo em um commit. Depois de completar a documentação, publique o commit e envie ao professor o link do repositório com acesso liberado. O prazo da fase 1 é **24/11/2026 às 23h59**. [Enunciado](C:/Dev/eng-software-final-project/Enunciado/Enunciado_projeto.pdf)
```



## 2026-11-24T22:35:54-03:00 (America/Sao_Paulo)

### Prompt

````text
realize 2.
```

### Resposta

````markdown
Concluí o item 2. Vinculei as **51 classes de equivalência** e os valores-limite do plano aos testes JUnit 5 dos sete métodos, indicando as entradas usadas nos casos parametrizados. Conferi que todos os métodos de teste citados existem na suíte. [PLANO-DE-TESTES.md](C:/Dev/eng-software-final-project/PLANO-DE-TESTES.md)

Também corrigi o identificador duplicado de `multaCentavos`. A classe de tipo nulo agora é `CE06`.
```



## 2026-11-24T23:22:41-03:00 (America/Sao_Paulo)

### Prompt

````text
execute a suite de testes e  complete o registro de defeitos em DEFEITOS.md
```

### Resposta

````markdown
Executei a suíte da fase 1. O Maven rodou **163 casos**, com **70 falhas de asserção, 0 erros de execução e 0 casos ignorados**.

Completei o [DEFEITOS.md](C:/Dev/eng-software-final-project/DEFEITOS.md) com uma linha por falha, identificando o método, a entrada, o resultado esperado, o resultado obtido e a classe de equivalência ou o valor-limite. Conferi a contagem por método com os relatórios do Surefire.
```

