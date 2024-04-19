package ManipulacaoDados;

import Calculos.Cores;
import excecoes.ExcecaoOpcaoInvalida;
import excecoes.NumeroNegativo;
import excecoes.OpcoesSimultaneas;

import java.util.*;

public class EntradaDeDados extends Cores {
    private String quantidadeSerConvertidaPergunta;
    private double quantidadeSerConvertida;

    private String moedaEntadaPergunta;
    private int moedaEntrada;
    private  String moedaDaRequisicao;
    private String moedaSaidaPergunta;
    private String siglaMoedaSaida;
    public double quantidadeConvertida(Scanner sc){
        while (true) {
            System.out.println(Cores.ANSI_BLUE + "Valor a ser convertido: " + Cores.ANSI_RESET);
            quantidadeSerConvertidaPergunta = sc.next();
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
    public String moedaRequisicao(Scanner sc, List<Integer> opcaoNumerosLista, Map<String, String> mapaIDsMonetarios){
        while (true) {
            try {
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
                var cortandomoedaEntadaPergunta = moedaSaidaPergunta.split("");
                if (cortandomoedaEntadaPergunta.length > 1){
                    throw new OpcoesSimultaneas(Cores.ANSI_RED + "Apenas uma opção" + Cores.ANSI_RESET);
                }
                moedaEntrada = Integer.parseInt(moedaEntadaPergunta);
                if (!opcaoNumerosLista.contains(moedaEntrada)) {
                    throw new ExcecaoOpcaoInvalida(Cores.ANSI_RED + "Apenas números entre 1 e 10" + Cores.ANSI_RESET);
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
                } else if (moedaEntrada == 11) {
                    System.out.println(Cores.ANSI_BLUE + "Programa encerrado!" + Cores.ANSI_RESET);
                    return "0";
                }
            }catch (ExcecaoOpcaoInvalida e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException exception) {
                System.out.println(Cores.ANSI_RED + "Apenas número!" + Cores.ANSI_RESET);
            }catch (IllegalFormatConversionException e){
                System.out.println(Cores.ANSI_RED + "Espaços em branco!" + Cores.ANSI_RESET);
            }catch (OpcoesSimultaneas e) {
                System.out.println(e.getMessage());;
            }
        }
        return moedaDaRequisicao;
}

    public String siglaMoedaSaida(Scanner sc, List<Integer> opcaoNumerosLista, Map<String, String> mapaIDsMonetarios){
        while (true) {
            int moedaSaida;
            try {
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
                var cortandoMoedaSaida = moedaSaidaPergunta.split("");
                if (cortandoMoedaSaida.length > 1){
                    throw new OpcoesSimultaneas(Cores.ANSI_RED + "Apenas uma opção" + Cores.ANSI_RESET);
                }
                moedaSaida = Integer.parseInt(moedaSaidaPergunta);
                if (!opcaoNumerosLista.contains(moedaSaida)) {
                    throw new ExcecaoOpcaoInvalida(Cores.ANSI_RED + "Apenas números entre 1 e 10" + Cores.ANSI_RESET);
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
                    System.out.println(Cores.ANSI_BLUE + "Programa encerrado!" + Cores.ANSI_RESET);
                    return "0";
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println(Cores.ANSI_RED + "Apenas números!" + Cores.ANSI_RESET);
            } catch (ExcecaoOpcaoInvalida e) {
                System.out.println(e.getMessage());
            }catch (IllegalFormatConversionException e){
                System.out.println(Cores.ANSI_RED + "Espaços em branco!" + Cores.ANSI_RESET);
            } catch (OpcoesSimultaneas e) {
                System.out.println(e.getMessage());;
            }
        }
        return siglaMoedaSaida;
    }
}
