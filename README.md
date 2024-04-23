# ConversorDeMoedas
O projeto é um conversor de moedas em Java, projetado para oferecer uma solução rápida e eficiente para usuários que 
precisam realizar conversões monetárias frequentes.

# Desafio Conversor de Moedas

![Build Status](https://github.com/seu-usuario/nome-do-repositorio/actions/workflows/build.yml/badge.svg)
![Version](https://img.shields.io/github/v/release/seu-usuario/nome-do-repositorio?include_prereleases)
![License](https://img.shields.io/github/license/seu-usuario/nome-do-repositorio)

## Descrição

Este projeto é um conversor de moedas que permite converter valores entre diferentes moedas. Além disso, o projeto mantém um registro de todas as conversões feitas em um arquivo JSON.

## Funcionalidades

- Conversão de valores entre diferentes moedas.
- Registro das conversões em um arquivo JSON.
- Leitura e exibição do histórico de conversões e logs de conversões.

## Requisitos

- Java 8 ou superior
- Biblioteca Gson para manipulação de JSON
- Arquivo de configuração de moedas (não fornecido neste exemplo)

## Instalação


2. Importe o projeto para a sua IDE preferida.

3. Adicione a biblioteca Gson ao seu projeto. (A versão usada neste exemplo é a 2.8.8)

## Uso

### Conversão de Moedas

Para realizar uma conversão de moedas, você pode utilizar a classe `ConversorDeMoedas`.

Exemplo de uso:

```java
ConversorDeMoedas conversor = new ConversorDeMoedas();
double valorConvertido = conversor.converter(100.0, "USD", "BRL");
System.out.println("Valor convertido: " + valorConvertido);

