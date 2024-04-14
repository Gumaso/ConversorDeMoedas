import Conexao.Requisicao;
import SerializadorDeserializador.Deserializador;
import Mapeadores.MapValoresMonetarios;
import SerializadorDeserializador.Serializador;
import Mapeadores.ValoresMonetarios;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        Serializador serializador = new Serializador();
        Requisicao requisicao = new Requisicao();
        Deserializador objJsonDeseralizado = new Deserializador();
        MapValoresMonetarios moedasValores = new MapValoresMonetarios();
        var retornoRequisicao = requisicao.responseJson();
        Map<String, Double> valoresMonetarios = moedasValores.mapeandoChavesValores(objJsonDeseralizado, retornoRequisicao);
        String retornoMapConversionRatesJson = gson.toJson(valoresMonetarios);
        ValoresMonetarios valoresMonetarios1 = gson.fromJson(retornoMapConversionRatesJson, ValoresMonetarios.class);
    }
}