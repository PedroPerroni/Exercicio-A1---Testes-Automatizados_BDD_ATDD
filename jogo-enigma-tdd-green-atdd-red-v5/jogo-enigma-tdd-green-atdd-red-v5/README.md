# Jogo Enigma — v5 — TDD GREEN e ATDD RED

Esta versão separa deliberadamente **TDD** e **ATDD** em níveis diferentes.

## Estado esperado

- `JogoTest` (JUnit/TDD): **GREEN**.
- `RunCucumberTest` (Cucumber/ATDD): **RED**.
- Não há erro de execução: a falha do Cucumber é uma falha de asserção proposital.

## Por que isso não é redundante?

O JUnit testa uma regra menor do domínio:

> um resultado válido deve ser registrado no jogo.

O Cucumber testa um comportamento de aceitação mais amplo:

> um resultado válido deve ser aceito **e o jogo deve ser considerado válido**.

A primeira parte já foi implementada em `Jogo.anota(...)`, portanto o TDD está GREEN.
A segunda parte ainda não foi implementada: `Jogo.isValido()` retorna `false`, portanto o ATDD permanece RED.

## Fluxo didático

```text
BDD / critério de aceitação
          ↓
Cucumber / ATDD
          ↓
        RED
          ↓
TDD de domínio: regra menor
          ↓
RED → implementação mínima → GREEN
          ↓
JUnit GREEN, mas Cucumber ainda RED
          ↓
novos ciclos TDD para completar o comportamento
          ↓
Cucumber GREEN
```

## O que observar ao executar

Ao rodar `mvn test`, o objetivo conceitual é:

- 1 teste JUnit passando;
- 1 cenário Cucumber falhando;
- a falha do Cucumber ocorre no passo `E o jogo deve ser considerado válido`.

O total exato exibido pelo Maven pode variar conforme a forma como o JUnit Platform contabiliza a suíte Cucumber, mas a distinção importante é: **JUnit passa e o cenário Cucumber falha**.

## Próximo passo

Não altere o teste JUnit que já está GREEN. Crie o próximo teste de domínio necessário para definir quando um jogo deve ser considerado válido. Esse novo teste deve começar em RED. Depois implemente o mínimo para fazê-lo ficar GREEN e execute novamente o Cucumber.
