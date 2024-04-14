package Mapeadores;

import ManipulacaoDados.DadosAPI;
import SerializadorDeserializador.Deserializador;

import java.util.Map;
/**
 * A classe MapeandoMoedasValores é responsável por mapear as chaves e valores das taxas de conversão
 * de uma string JSON de acordo com a classe Deserializador e a classe DadosAPI.
 */
public class MapValoresMonetarios {
    /**
     * Método responsável por mapear as chaves e valores das taxas de conversão a partir de uma string JSON.
     *
     * @param deserializador Instância do Deserializador para desserializar a string JSON em um objeto DadosAPI.
     * @param objJson        String contendo o objeto JSON a ser desserializado.
     * @return Um mapa contendo as chaves como códigos de moeda e os valores como taxas de conversão.
     */
    public Map<String, Double> mapeandoChavesValores(Deserializador deserializador, String objJson) {
        // Desserializa a string JSON em um objeto DadosAPI
        DadosAPI strJson = deserializador.deserializandoJsonObjetoDadosAPI(objJson);
        // Retorna o mapa de taxas de conversão do objeto DadosAPI
        return strJson.getConversion_rates();
    }
}
