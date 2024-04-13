package SerializadorDeserializador;

import ManipulacaoDados.DadosAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Serializador {

    public DadosAPI serializandoEmClasse(String objJsonString) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        DadosAPI dadosAPI = gson.fromJson(objJsonString, DadosAPI.class);
        FileWriter escritor = new FileWriter("dadosAPI.json");
        escritor.write(gson.toJson(dadosAPI));
        escritor.close();
        return dadosAPI;
    }
}
