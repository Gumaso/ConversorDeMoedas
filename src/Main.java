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
        // Imprime o título do programa em amarelo
        System.out.println(ANSI_YELLOW + "=== Conversor de Moedas===" + ANSI_RESET);

        // Inicialização de scanners e outras classes necessárias
        Scanner sc = new Scanner(System.in);  // Scanner para entrada de dados
        Scanner sc2 = new Scanner(System.in); // Scanner adicional para entrada de dados
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create(); // Gson para serialização/desserialização de objetos JSON
        Requisicao requisicao = new Requisicao(); // Objeto para fazer requisições
        Serializador serializador = new Serializador(); // Objeto para serializar/desserializar objetos
        Deserializador objJsonDeseralizado = new Deserializador(); // Objeto para desserializar JSON
        MapValoresMonetarios moedasValores = new MapValoresMonetarios(); // Objeto para mapear valores monetários
        EntradaDeDados entradaDeDados = new EntradaDeDados(); // Objeto para tratar a entrada de dados do usuário

        // Caminho do arquivo JSON contendo IDs monetários
        String filePath = "C:\\Users\\gusta\\IdeaProjects\\DesafioConversorDeMoedas\\src\\Arquivos\\IDsMonetarios.json";

        // Leitura do arquivo JSON para um mapa
        FileReader leitorIDsMonetarios = new FileReader(filePath);
        Map<String, String> mapaIDsMonetarios = gson.fromJson(leitorIDsMonetarios, Map.class);

        // Lista de números de opções para entrada do usuário
        List<Integer> opcaoNumerosLista = new ArrayList<>();
        for (int i = 1; i < 12; i++) {
            opcaoNumerosLista.add(i);
        }

        // Loop principal do programa
        while (true) {
            // Entrada da quantidade a ser convertida
            double quantidadeSerConvertida = entradaDeDados.quantidadeConvertida(sc);

            // Entrada da moeda de requisição
            String moedaDaRequisicao = entradaDeDados.moedaRequisicao(sc, opcaoNumerosLista, mapaIDsMonetarios);

            // Verifica se o usuário deseja sair
            if (moedaDaRequisicao.equalsIgnoreCase("0")) {
                break;
            }

            // Entrada da sigla da moeda de saída
            String siglaMoedaSaida = entradaDeDados.siglaMoedaSaida(sc2, opcaoNumerosLista, mapaIDsMonetarios);

            // Verifica se o usuário deseja sair
            if (siglaMoedaSaida.equalsIgnoreCase("0")) {
                break;
            }

            // Faz uma requisição para obter o JSON de valores de conversão
            var retornoRequisicao = requisicao.responseJson(moedaDaRequisicao);

            // Mapeia as chaves e valores do JSON retornado
            Map<String, Double> valoresMonetarios = moedasValores.mapeandoChavesValores(objJsonDeseralizado, retornoRequisicao);

            // Converte o mapa de valores para JSON
            String retornoMapConversionRatesJson = gson.toJson(valoresMonetarios);

            // Serializa o JSON e filtra para obter um objeto de ValoresMonetarios
            ValoresMonetarios valoresMonetariosFiltrado = serializador.serializandoValoresMonetarios(retornoMapConversionRatesJson);

            // Caminho para salvar o JSON filtrado
            String caminhovaloresMonetariosFiltrado = "C:\\Users\\gusta\\IdeaProjects\\DesafioConversorDeMoedas\\src\\Arquivos\\valoresFiltrado.json";

            // Escreve o JSON filtrado em um arquivo
            FileWriter escritor = new FileWriter(caminhovaloresMonetariosFiltrado);
            escritor.write(gson.toJson(valoresMonetariosFiltrado));
            escritor.close();

            // Lê o JSON filtrado de volta para um mapa
            FileReader leitorValoresFiltrados = new FileReader(caminhovaloresMonetariosFiltrado);
            Map<String, String> mapaValoresFiltrados = gson.fromJson(leitorValoresFiltrados, Map.class);

            // Cria um objeto ConversorMoedas e realiza a conversão
            ConversorMoedas conversorMoedas = new ConversorMoedas();
            double moedaSaida = Double.parseDouble(mapaValoresFiltrados.get(siglaMoedaSaida));
            System.out.println(conversorMoedas.conversao(moedaDaRequisicao, siglaMoedaSaida, quantidadeSerConvertida, moedaSaida));
        }
    }
}