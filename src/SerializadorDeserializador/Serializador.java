package SerializadorDeserializador;

import Conexao.Requisicao;
import Mapeadores.ValoresMonetarios;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

public class Serializador {
    public ValoresMonetarios serializandoValoresMonetarios(String objJsonString) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        ValoresMonetarios valoresMonetarios = gson.fromJson(objJsonString, ValoresMonetarios.class);
        FileWriter escritor = new FileWriter("valoresMonetarios.json");
        escritor.write(gson.toJson(valoresMonetarios));
        escritor.close();
        return valoresMonetarios;
    }
    public String objetoJson(Requisicao requisicao) throws IOException, InterruptedException {
        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
        return gson.toJson(requisicao.responseJson());
    }
}
