# QA API Tests com Rest Assured

[![API Tests](https://github.com/CMarcel1004/qa-api-tests-rest-assured/actions/workflows/api-tests.yml/badge.svg)](https://github.com/CMarcel1004/qa-api-tests-rest-assured/actions/workflows/api-tests.yml)

Projeto desenvolvido com foco em automação de testes de API, aplicando boas práticas de organização, reutilização de código e validação de cenários positivos e negativos.

- Java
- Maven
- Rest Assured
- JUnit 5

## Testes implementados

### Users
- Listar usuários
- Buscar usuário por ID
- Validar estrutura do usuário
- Validar usuário inexistente (404)

### Posts
- Listar posts
- Criar novo post (POST)
- Validação de payload externo

## Como executar

```bash
mvn test

## Estrutura

- api → classes de teste
- base → configuração base
- utils → utilitários
- resources/payloads → payloads JSON