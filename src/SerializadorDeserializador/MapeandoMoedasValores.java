package SerializadorDeserializador;

import ManipulacaoDados.DadosAPI;

import java.util.HashMap;

public class MapeandoMoedasValores {

    public HashMap mapeandoChavesValores(Deserializador deserializador, String objJson){
        DadosAPI strJson = deserializador.serializandoJsonEmString(objJson);
        HashMap<String, Double> mapa = new HashMap<>(strJson.getConversion_rates());
        return mapa;
    }
}
