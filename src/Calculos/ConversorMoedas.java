package Calculos;

import java.io.FileReader;
import java.util.Map;

/**
 * Classe responsável por realizar a conversão de moedas e formatar a mensagem de saída.
 */
public class ConversorMoedas extends Cores {

    /**
     * Método para realizar a conversão de moedas e formatar a mensagem de saída.
     *
     * @param moedaEntradaSigla A sigla da moeda de entrada.
     * @param moedaSaidaSigla   A sigla da moeda de saída.
     * @param quantidadeMoeda   A quantidade da moeda a ser convertida.
     * @param moedaSaida        A taxa de câmbio da moeda de saída em relação à moeda de entrada.
     * @return A mensagem formatada com o resultado da conversão.
     */
    public String conversao(String moedaEntradaSigla, String moedaSaidaSigla, double quantidadeMoeda, double moedaSaida) {
        // Calcula o resultado da conversão
        double resultado = quantidadeMoeda * moedaSaida;

        // Formata a mensagem com a conversão
        String msg = String.format("""
                %s          X         %s
                ---------------------------
                %s      X      %.2f
                ---------------------------
                Conversão -> %.2f(%s)
                """, moedaEntradaSigla, moedaSaidaSigla, quantidadeMoeda, moedaSaida, resultado, moedaSaidaSigla);

        // Retorna a mensagem formatada
        return msg;
    }
}

