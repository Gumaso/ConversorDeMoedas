package SerializadorDeserializador;

import ManipulacaoDados.DadosAPI;
import com.google.gson.Gson;

public class Deserializador {


    public DadosAPI serializandoJsonEmString(String objJson){
        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
        return gson.fromJson(objJson, DadosAPI.class);
    };
}
