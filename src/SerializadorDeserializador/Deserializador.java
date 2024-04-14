package SerializadorDeserializador;

import ManipulacaoDados.DadosAPI;
import com.google.gson.Gson;

/**
 * A classe Deserializador é responsável por deserializar objetos JSON para objetos da classe DadosAPI.
 * Utiliza a biblioteca Gson para realizar a desserialização.
 */
public class Deserializador {

    /**
     * Método responsável por desserializar uma string JSON em um objeto da classe DadosAPI.
     *
     * @param objJson String contendo o objeto JSON a ser desserializado.
     * @return Um objeto da classe DadosAPI com os dados desserializados.
     * @throws com.google.gson.JsonSyntaxException se o JSON não for válido ou não puder ser desserializado para DadosAPI.
     */
    public DadosAPI serializandoJsonEmString(String objJson) {
        // Cria uma instância do Gson com configuração para pretty printing
        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();

        // Desserializa a string JSON para um objeto da classe DadosAPI
        return gson.fromJson(objJson, DadosAPI.class);
    }
}

