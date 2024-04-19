import Calculos.ConversorMoedas;
import Calculos.Cores;
import Conexao.Requisicao;
import ManipulacaoDados.EntradaDeDados;
import SerializadorDeserializador.Deserializador;
import Mapeadores.MapValoresMonetarios;
import SerializadorDeserializador.Serializador;
import Mapeadores.ValoresMonetarios;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main extends Cores {
    public static void main(String[] args) throws IOException, InterruptedException, InputMismatchException {
        System.out.println(ANSI_YELLOW + "=== Conversor de Moedas===" + ANSI_RESET);
        Scanner sc = new Scanner(System.in);
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        Serializador serializador = new Serializador();
        Requisicao requisicao = new Requisicao();
        Deserializador objJsonDeseralizado = new Deserializador();
        MapValoresMonetarios moedasValores = new MapValoresMonetarios();
        EntradaDeDados entradaDeDados = new EntradaDeDados();
        String filePath = "C:\\Users\\gusta\\IdeaProjects\\DesafioConversorDeMoedas\\src\\Arquivos\\IDsMonetarios.json";
        FileReader leitorIDsMonetarios = new FileReader(filePath);
        Map<String, String> mapaIDsMonetarios = gson.fromJson(leitorIDsMonetarios, Map.class);
        List<Integer> opcaoNumerosLista = new ArrayList<>();
        for (int i = 1; i < 12; i++) {
            opcaoNumerosLista.add(i);
        }
        while (true) {
            double quantidadeSerConvertida = entradaDeDados.quantidadeConvertida(sc);
            String moedaDaRequisicao = entradaDeDados.moedaRequisicao(sc, opcaoNumerosLista, mapaIDsMonetarios);
            if (moedaDaRequisicao.equalsIgnoreCase("0")){
                break;
            }
            String siglaMoedaSaida = entradaDeDados.siglaMoedaSaida(sc, opcaoNumerosLista, mapaIDsMonetarios);
            if (siglaMoedaSaida.equalsIgnoreCase("0")){
                break;
            }
            var retornoRequisicao = requisicao.responseJson(moedaDaRequisicao);
            Map<String, Double> valoresMonetarios = moedasValores.mapeandoChavesValores(objJsonDeseralizado, retornoRequisicao);
            String retornoMapConversionRatesJson = gson.toJson(valoresMonetarios);
            ValoresMonetarios valoresMonetariosFiltrado = serializador.serializandoValoresMonetarios(retornoMapConversionRatesJson);
            String caminhovaloresMonetariosFiltrado = "C:\\Users\\gusta\\IdeaProjects\\DesafioConversorDeMoedas\\src\\Arquivos\\valoresFiltrado.json";
            FileWriter escritor = new FileWriter(caminhovaloresMonetariosFiltrado);
            escritor.write(gson.toJson(valoresMonetariosFiltrado));
            escritor.close();
            FileReader leitorValoresFiltrados = new FileReader(caminhovaloresMonetariosFiltrado);
            Map<String, String> mapaValoresFiltrados = gson.fromJson(leitorValoresFiltrados, Map.class);
            ConversorMoedas conversorMoedas = new ConversorMoedas();
            double moedaSaida = Double.parseDouble(mapaValoresFiltrados.get(siglaMoedaSaida));
            System.out.println(conversorMoedas.conversao(moedaDaRequisicao, siglaMoedaSaida, quantidadeSerConvertida, moedaSaida));
        }

    }
}