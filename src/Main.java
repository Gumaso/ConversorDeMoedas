import Calculos.ConversorMoedas;
import Conexao.Requisicao;
import SerializadorDeserializador.Deserializador;
import Mapeadores.MapValoresMonetarios;
import SerializadorDeserializador.Serializador;
import Mapeadores.ValoresMonetarios;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import excecoes.ExcecaoOpcaoInvalida;
import excecoes.NumeroNegativo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";


    public static void main(String[] args) throws IOException, InterruptedException, InputMismatchException {
        System.out.println(ANSI_YELLOW + "=== Conversor de Moedas===" + ANSI_RESET);
        Scanner sc = new Scanner(System.in);
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        Serializador serializador = new Serializador();
        Requisicao requisicao = new Requisicao();
        Deserializador objJsonDeseralizado = new Deserializador();
        MapValoresMonetarios moedasValores = new MapValoresMonetarios();
        String filePath = "C:\\Users\\gusta\\IdeaProjects\\DesafioConversorDeMoedas\\src\\Arquivos\\IDsMonetarios.json";
        FileReader leitorIDsMonetarios = new FileReader(filePath);
        Map<String, String> mapaIDsMonetarios = gson.fromJson(leitorIDsMonetarios, Map.class);
        List<Integer> opcaoNumerosLista = new ArrayList<>();
        for (int i = 1; i < 12; i++) {
            opcaoNumerosLista.add(i);
        }
        String moedaDaRequisicao = "";
        String siglaMoedaSaida = "";
        String quantidadeSerConvertidaPergunta;
        double quantidadeSerConvertida;
        while (true) {
            System.out.println(ANSI_BLUE + "Valor a ser convertido: " + ANSI_RESET);
            quantidadeSerConvertidaPergunta = sc.next();
            try {
                quantidadeSerConvertida = Double.parseDouble(quantidadeSerConvertidaPergunta);
                if (quantidadeSerConvertida < 0) {
                    throw new NumeroNegativo(ANSI_RED + "Valor inválido, apenas valores positivos!");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Apenas números!" + ANSI_RESET);
            } catch (NumeroNegativo e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            String moedaEntadaPergunta;
            int moedaEntrada;
            try {
                System.out.println(ANSI_BLUE + """
                        **********************************
                        CONVERTER DE:""" + ANSI_YELLOW + """
                                                    
                        1.USD - Dólar Americano ($)
                        2.ARS - Peso Argentino ($)
                        3.EUR - Euro (€)
                        4.GBP - Libra Esterlina (£)
                        5.JPY - Iene (¥)
                        6.CAD - Dólar Canadense (C$)
                        7.AUD - Dólar Australiano (A$)
                        8.CHF - Franco Suíço (Fr.)
                        9.CNY - Yuan Chinês (¥)
                        10.BRL - Real Brasileiro (R$)
                        11. Sair
                        """ + ANSI_BLUE + """
                        Digite o número da opção desejada:
                        """ + ANSI_RESET);
                moedaEntadaPergunta = sc.next();
                moedaEntrada = Integer.parseInt(moedaEntadaPergunta);
                if (!opcaoNumerosLista.contains(moedaEntrada)) {
                    throw new ExcecaoOpcaoInvalida(ANSI_RED + "Apenas números entre 1 e 10" + ANSI_RESET);
                }
                if (moedaEntrada == 1) {
                    // USD
                    moedaDaRequisicao = mapaIDsMonetarios.get("1");
                    break;
                } else if (moedaEntrada == 2) {
                    // ARS
                    moedaDaRequisicao = mapaIDsMonetarios.get("2");
                    break;
                } else if (moedaEntrada == 3) {
                    // EUR
                    moedaDaRequisicao = mapaIDsMonetarios.get("3");
                    break;
                } else if (moedaEntrada == 4) {
                    // GBP
                    moedaDaRequisicao = mapaIDsMonetarios.get("4");
                    break;
                } else if (moedaEntrada == 5) {
                    // JPY
                    moedaDaRequisicao = mapaIDsMonetarios.get("5");
                    break;
                } else if (moedaEntrada == 6) {
                    // CAD
                    moedaDaRequisicao = mapaIDsMonetarios.get("6");
                    break;
                } else if (moedaEntrada == 7) {
                    // AUD
                    moedaDaRequisicao = mapaIDsMonetarios.get("7");
                    break;
                } else if (moedaEntrada == 8) {
                    // CHF
                    moedaDaRequisicao = mapaIDsMonetarios.get("8");
                    break;
                } else if (moedaEntrada == 9) {
                    // CNY
                    moedaDaRequisicao = mapaIDsMonetarios.get("9");
                    break;
                } else if (moedaEntrada == 10) {
                    //BRL
                    moedaDaRequisicao = mapaIDsMonetarios.get("10");
                    break;
                }
            }
            catch (ExcecaoOpcaoInvalida e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException exception) {
                System.out.println(ANSI_RED + "Apenas número!" + ANSI_RESET);
            }
        }
        String moedaSaidaPergunta;
        while (true) {
            int moedaSaida;
            try {
                System.out.println(ANSI_BLUE + """
                                **********************************
                                PARA :""" + ANSI_YELLOW + """
                                                            
                                1.USD - Dólar Americano ($)
                                2.ARS - Peso Argentino ($)
                                3.EUR - Euro (€)
                                4.GBP - Libra Esterlina (£)
                                5.JPY - Iene (¥)
                                6.CAD - Dólar Canadense (C$)
                                7.AUD - Dólar Australiano (A$)
                                8.CHF - Franco Suíço (Fr.)
                                9.CNY - Yuan Chinês (¥)
                                10.BRL - Real Brasileiro (R$)
                                11. Sair
                                """ + ANSI_BLUE + """
                                Digite o número da opção desejada:
                                """ + ANSI_RESET);
                moedaSaidaPergunta = sc.next();
                moedaSaida = Integer.parseInt(moedaSaidaPergunta);
                if (!opcaoNumerosLista.contains(moedaSaida)) {
                    throw new ExcecaoOpcaoInvalida(ANSI_RED + "Apenas números entre 1 e 10" + ANSI_RESET);
                }
                if (moedaSaida == 1) {
                    // USD
                    siglaMoedaSaida = mapaIDsMonetarios.get("1");
                    break;
                } else if (moedaSaida == 2) {
                    // ARS
                    siglaMoedaSaida = mapaIDsMonetarios.get("2");
                    break;
                } else if (moedaSaida == 3) {
                    // EUR
                    siglaMoedaSaida = mapaIDsMonetarios.get("3");
                    break;
                } else if (moedaSaida == 4) {
                    // GBP
                    siglaMoedaSaida = mapaIDsMonetarios.get("4");
                    break;
                } else if (moedaSaida == 5) {
                    // JPY
                    siglaMoedaSaida = mapaIDsMonetarios.get("5");
                    break;
                } else if (moedaSaida == 6) {
                    // CAD
                    siglaMoedaSaida = mapaIDsMonetarios.get("6");
                    break;
                } else if (moedaSaida == 7) {
                    // AUD
                    siglaMoedaSaida = mapaIDsMonetarios.get("7");
                    break;
                } else if (moedaSaida == 8) {
                    // CHF
                    siglaMoedaSaida = mapaIDsMonetarios.get("8");
                    break;
                } else if (moedaSaida == 9) {
                    // CNY
                    siglaMoedaSaida = mapaIDsMonetarios.get("9");
                    break;
                } else if (moedaSaida == 10) {
                    //BRL
                    siglaMoedaSaida = mapaIDsMonetarios.get("10");
                    break;
                } else if (moedaSaida == 11) {
                    System.out.println(ANSI_BLUE + "Programa encerrado!" + ANSI_RESET);
                    break;
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println(ANSI_RED + "Apenas números!" + ANSI_RESET);
            } catch (ExcecaoOpcaoInvalida e) {
                System.out.println(e.getMessage());
            }
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