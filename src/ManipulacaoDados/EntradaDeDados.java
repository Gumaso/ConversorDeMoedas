package ManipulacaoDados;

import Calculos.Cores;
import excecoes.ExcecaoOpcaoInvalida;
import excecoes.NumeroNegativo;
import excecoes.OpcoesSimultaneas;

import java.util.*;

/**
 * Classe responsável por gerenciar a entrada de dados do usuário.
 */
public class EntradaDeDados extends Cores {

    // Variáveis para armazenar valores de entrada do usuário
    private String quantidadeSerConvertidaPergunta;
    private double quantidadeSerConvertida;
    private String moedaEntadaPergunta;
    private int moedaEntrada;
    private String moedaDaRequisicao;
    private String moedaSaidaPergunta;
    private String siglaMoedaSaida;

    /**
     * Método para obter a quantidade a ser convertida pelo usuário.
     * @param sc Scanner para leitura de entrada do usuário.
     * @return A quantidade a ser convertida.
     */
    public double quantidadeConvertida(Scanner sc) {
        while (true) {
            System.out.println(Cores.ANSI_BLUE + "Valor a ser convertido: " + Cores.ANSI_RESET);
            quantidadeSerConvertidaPergunta = sc.nextLine();
            try {
                quantidadeSerConvertida = Double.parseDouble(quantidadeSerConvertidaPergunta);
                if (quantidadeSerConvertida < 0) {
                    throw new NumeroNegativo(Cores.ANSI_RED + "Valor inválido, apenas valores positivos!");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(Cores.ANSI_RED + "Apenas números!" + Cores.ANSI_RESET);
            } catch (NumeroNegativo e) {
                System.out.println(e.getMessage());
            }
        }
        return quantidadeSerConvertida;
    }

    /**
     * Método para obter a moeda de entrada desejada pelo usuário.
     * @param sc Scanner para leitura de entrada do usuário.
     * @param opcaoNumerosLista Lista de opções válidas.
     * @param mapaIDsMonetarios Mapa de IDs e moedas.
     * @return A moeda de entrada selecionada.
     */
    public String moedaRequisicao(Scanner sc, List<Integer> opcaoNumerosLista, Map<String, String> mapaIDsMonetarios) {
        while (true) {
            try {
                // Exibe as opções de moedas disponíveis
                System.out.println(Cores.ANSI_BLUE + """
                        **********************************
                        CONVERTER DE:""" + Cores.ANSI_YELLOW + """
                                                    
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
                        """ + Cores.ANSI_BLUE + """
                        Digite o número da opção desejada:
                        """ + Cores.ANSI_RESET);
                moedaEntadaPergunta = sc.nextLine();
                String[] listaMoedaEntrada = moedaEntadaPergunta.split(" ");

                // Verifica se foi inserida mais de uma opção
                if (listaMoedaEntrada.length > 1){
                    throw new OpcoesSimultaneas(Cores.ANSI_RED + "Apenas 1 opção, e entre 1 e 11" + Cores.ANSI_RESET);
                }

                moedaEntrada = Integer.parseInt(moedaEntadaPergunta);

                // Verifica se a opção é válida
                if (!opcaoNumerosLista.contains(moedaEntrada)) {
                    throw new ExcecaoOpcaoInvalida(Cores.ANSI_RED + "Apenas números entre 1 e 11" + Cores.ANSI_RESET);
                }

                // Mapeia a opção selecionada para a moeda correspondente
                moedaDaRequisicao = mapaIDsMonetarios.get(String.valueOf(moedaEntrada));
                break;

            } catch (ExcecaoOpcaoInvalida e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException exception) {
                System.out.println(Cores.ANSI_RED + "Apenas número!" + Cores.ANSI_RESET);
            } catch (OpcoesSimultaneas e) {
                System.out.println(e.getMessage());
            }
        }
        return moedaDaRequisicao;
    }

    /**
     * Método para obter a sigla da moeda de saída desejada pelo usuário.
     * @param sc Scanner para leitura de entrada do usuário.
     * @param opcaoNumerosLista Lista de opções válidas.
     * @param mapaIDsMonetarios Mapa de IDs e moedas.
     * @return A sigla da moeda de saída selecionada.
     */
    public String siglaMoedaSaida(Scanner sc, List<Integer> opcaoNumerosLista, Map<String, String> mapaIDsMonetarios) {
        while (true) {
            int moedaSaida;
            try {
                // Exibe as opções de moedas disponíveis
                System.out.println(Cores.ANSI_BLUE + """
                                **********************************
                                PARA :""" + Cores.ANSI_YELLOW + """
                       
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
                                """ + Cores.ANSI_BLUE + """
                                Digite o número da opção desejada:
                                """ + Cores.ANSI_RESET);
                moedaSaidaPergunta = sc.nextLine();
                String[] listaMoedaSaida = moedaSaidaPergunta.split(" ");

                // Verifica se foi inserida mais de uma opção
                if (listaMoedaSaida.length > 1){
                    throw new OpcoesSimultaneas(Cores.ANSI_RED + "Apenas 1 opção, e entre 1 e 11" + Cores.ANSI_RESET);
                }

                moedaSaida = Integer.parseInt(moedaSaidaPergunta);

                // Verifica se a opção é válida
                if (!opcaoNumerosLista.contains(moedaSaida)) {
                    throw new ExcecaoOpcaoInvalida(Cores.ANSI_RED + "Apenas números entre 1 e 10" + Cores.ANSI_RESET);
                }

                // Mapeia a opção selecionada para a sigla da moeda correspondente
                siglaMoedaSaida = mapaIDsMonetarios.get(String.valueOf(moedaSaida));
                break;

            } catch (NumberFormatException e) {
                System.out.println(Cores.ANSI_RED + "Apenas números!" + Cores.ANSI_RESET);
            } catch (ExcecaoOpcaoInvalida e) {
                System.out.println(e.getMessage());
            } catch (OpcoesSimultaneas e) {
                System.out.println(e.getMessage());
            }
        }
        return siglaMoedaSaida;
    }
}
