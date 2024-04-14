package SerializadorDeserializador;

import ManipulacaoDados.DadosAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Serializador {
    public ValoresMonetarios serializandoEmClasse(Object object, String objJsonString) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        ValoresMonetarios valoresMonetarios = gson.fromJson(objJsonString, ValoresMonetarios.class);
        FileWriter escritor = new FileWriter("dadosAPI.json");
        escritor.write(gson.toJson(valoresMonetarios));
        escritor.close();
        return valoresMonetarios;
    }
}
