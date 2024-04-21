package Conexao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Classe responsável por fazer requisições à API de conversão de moedas.
 */
public class Requisicao {

    /**
     * Método para fazer uma requisição à API de conversão de moedas e obter a resposta em formato JSON.
     * @param moedaSolicitada A moeda para a qual se deseja obter as taxas de câmbio.
     * @return A resposta da API em formato JSON.
     * @throws IOException Se ocorrer um erro de I/O ao fazer a requisição.
     * @throws InterruptedException Se a thread for interrompida enquanto espera pela resposta.
     */
    public String responseJson(String moedaSolicitada) throws IOException, InterruptedException {
        // Cria um cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Constrói a requisição HTTP para a API de conversão de moedas
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://v6.exchangerate-api.com/v6/17f8bea8870b0f71abbf970d/latest/" + moedaSolicitada))
                .build();

        // Envia a requisição e obtém a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Retorna o corpo da resposta (JSON)
        return response.body();
    }
}
