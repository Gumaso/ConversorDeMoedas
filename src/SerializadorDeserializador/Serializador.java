package SerializadorDeserializador;

import Conexao.Requisicao;
import Mapeadores.ValoresMonetarios;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

public class Serializador {

    // Método para serializar um objeto JSON em um objeto ValoresMonetarios e salvar em um arquivo
    public ValoresMonetarios serializandoValoresMonetarios(String objJsonString) throws IOException {
        // Cria um novo Gson com configurações de pretty printing e exclusão de campos sem anotação Expose
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();

        // Desserializa o JSON para um objeto ValoresMonetarios
        ValoresMonetarios valoresMonetarios = gson.fromJson(objJsonString, ValoresMonetarios.class);

        // Cria um FileWriter para escrever o objeto serializado em um arquivo
        FileWriter escritor = new FileWriter("valoresMonetarios.json");

        // Escreve o objeto serializado no arquivo
        escritor.write(gson.toJson(valoresMonetarios));

        // Fecha o FileWriter
        escritor.close();

        // Retorna o objeto ValoresMonetarios
        return valoresMonetarios;
    }

    // Método para obter um objeto JSON de uma requisição e serializá-lo
    public String objetoJson(Requisicao requisicao, String moedaSolicitada) throws IOException, InterruptedException {
        // Cria um novo Gson com configurações de pretty printing
        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();

        // Realiza a requisição e obtém o JSON de resposta
        return gson.toJson(requisicao.responseJson(moedaSolicitada));
    }
}

