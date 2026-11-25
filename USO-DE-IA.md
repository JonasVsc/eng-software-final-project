# Uso de IA na fase 1

Usamos o Codex como apoio na fase de testes de caixa-preta do sistema de biblioteca. As solicitações e respostas estão no [registro de prompts](PROMPT-LOGS.md), com data e hora de São Paulo.

## O que pedimos e aproveitamos

| Quando | O que pedimos | O que aproveitamos |
| --- | --- | --- |
| 23/11/2026, 22h04 | Criar instruções para o assistente atuar como mentor e manter um registro das interações. | O [AGENTS.md](AGENTS.md) e o registro de prompts. |
| 23/11/2026, 22h26 | Configurar o ambiente local e verificar a execução do teste de exemplo. | JDK 17 e Maven configurados no Windows. O teste de exemplo do kit passou. |
| 23/11/2026, 22h33 | Explicar partição de equivalência e análise de valor-limite. | Uma explicação das técnicas com um exemplo de notas inteiras que serviu de referência para o trabalho. |
| 24/11/2026, 21h24 e 21h34 | Converter os casos do nosso [plano de testes](PLANO-DE-TESTES.md) em JUnit 5 e documentar a execução. | Os testes dos sete métodos descritos no plano e o [BUILD.md](BUILD.md), com os comandos de execução e instruções para ler os relatórios do Surefire. |
| 24/11/2026, 22h09 | Verificar a falha de `MultaTotalCentavosTest.rejeitaListaComAtrasoNegativo`. | A execução isolada confirmou que o JAR deixou de lançar `IllegalArgumentException` nas nove combinações verificadas. O resultado esperado foi mantido conforme o Anexo A. |

Também pedimos à IA que redigisse esta declaração com base no registro de interações.

## O que esclarecemos e corrigimos

- O primeiro pedido de conversão resultou em quatro casos de exemplo. Esclarecemos que o plano já continha os casos e os resultados esperados e que a ajuda solicitada era a tradução desse pseudocódigo para JUnit 5. A conversão passou a abranger os sete métodos.
- Na conversão, foi usado `br.edu.biblioteca`, conforme o enunciado e o kit. O teste de tipo nulo em `dataDevolucao` foi incluído porque a classe CE07 já estava no plano e ainda faltava no pseudocódigo.
- Na execução completa registrada, o Maven rodou 163 casos, incluindo o teste de exemplo. Houve 70 falhas de asserção e nenhum erro de execução. Os resultados esperados continuaram vinculados à especificação. O [DEFEITOS.md](DEFEITOS.md) contém o registro das divergências da fase.
