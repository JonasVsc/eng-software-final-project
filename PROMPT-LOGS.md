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

