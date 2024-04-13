import Conexao.Requisicao;
import ManipulacaoDados.DadosAPI;
import SerializadorDeserializador.Deserializador;
import SerializadorDeserializador.MapeandoMoedasValores;
import SerializadorDeserializador.Serializador;
import com.google.gson.internal.LinkedTreeMap;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        var objJson = "{\n" +
                "  \"result\": \"success\",\n" +
                "  \"documentation\": \"https://www.exchangerate-api.com/docs\",\n" +
                "  \"terms_of_use\": \"https://www.exchangerate-api.com/terms\",\n" +
                "  \"time_last_update_unix\": 1712880001,\n" +
                "  \"time_last_update_utc\": \"Fri, 12 Apr 2024 00:00:01 +0000\",\n" +
                "  \"time_next_update_unix\": 1712966401,\n" +
                "  \"time_next_update_utc\": \"Sat, 13 Apr 2024 00:00:01 +0000\",\n" +
                "  \"base_code\": \"USD\",\n" +
                "  \"conversion_rates\": {\n" +
                "    \"USD\": 1,\n" +
                "    \"AED\": 3.6725,\n" +
                "    \"AFN\": 71.5490,\n" +
                "    \"ALL\": 94.2408,\n" +
                "    \"AMD\": 390.9931,\n" +
                "    \"ANG\": 1.7900,\n" +
                "    \"AOA\": 844.3464,\n" +
                "    \"ARS\": 864.7500,\n" +
                "    \"AUD\": 1.5308,\n" +
                "    \"AWG\": 1.7900,\n" +
                "    \"AZN\": 1.7009,\n" +
                "    \"BAM\": 1.8233,\n" +
                "    \"BBD\": 2.0000,\n" +
                "    \"BDT\": 109.7989,\n" +
                "    \"BGN\": 1.8233,\n" +
                "    \"BHD\": 0.3760,\n" +
                "    \"BIF\": 2854.2547,\n" +
                "    \"BMD\": 1.0000,\n" +
                "    \"BND\": 1.3533,\n" +
                "    \"BOB\": 6.9143,\n" +
                "    \"BRL\": 5.0762,\n" +
                "    \"BSD\": 1.0000,\n" +
                "    \"BTN\": 83.3596,\n" +
                "    \"BWP\": 13.7194,\n" +
                "    \"BYN\": 3.2656,\n" +
                "    \"BZD\": 2.0000,\n" +
                "    \"CAD\": 1.3685,\n" +
                "    \"CDF\": 2743.7146,\n" +
                "    \"CHF\": 0.9106,\n" +
                "    \"CLP\": 952.5004,\n" +
                "    \"CNY\": 7.2472,\n" +
                "    \"COP\": 3787.6767,\n" +
                "    \"CRC\": 505.0308,\n" +
                "    \"CUP\": 24.0000,\n" +
                "    \"CVE\": 102.7946,\n" +
                "    \"CZK\": 23.6578,\n" +
                "    \"DJF\": 177.7210,\n" +
                "    \"DKK\": 6.9594,\n" +
                "    \"DOP\": 59.4992,\n" +
                "    \"DZD\": 134.6269,\n" +
                "    \"EGP\": 47.5585,\n" +
                "    \"ERN\": 15.0000,\n" +
                "    \"ETB\": 56.8692,\n" +
                "    \"EUR\": 0.9323,\n" +
                "    \"FJD\": 2.2488,\n" +
                "    \"FKP\": 0.7968,\n" +
                "    \"FOK\": 6.9594,\n" +
                "    \"GBP\": 0.7968,\n" +
                "    \"GEL\": 2.6675,\n" +
                "    \"GGP\": 0.7968,\n" +
                "    \"GHS\": 13.5047,\n" +
                "    \"GIP\": 0.7968,\n" +
                "    \"GMD\": 65.2369,\n" +
                "    \"GNF\": 8592.0642,\n" +
                "    \"GTQ\": 7.7802,\n" +
                "    \"GYD\": 209.1711,\n" +
                "    \"HKD\": 7.8373,\n" +
                "    \"HNL\": 24.6670,\n" +
                "    \"HRK\": 7.0240,\n" +
                "    \"HTG\": 132.5326,\n" +
                "    \"HUF\": 363.4445,\n" +
                "    \"IDR\": 15968.5759,\n" +
                "    \"ILS\": 3.7400,\n" +
                "    \"IMP\": 0.7968,\n" +
                "    \"INR\": 83.3597,\n" +
                "    \"IQD\": 1308.9112,\n" +
                "    \"IRR\": 41980.9765,\n" +
                "    \"ISK\": 140.0700,\n" +
                "    \"JEP\": 0.7968,\n" +
                "    \"JMD\": 154.4700,\n" +
                "    \"JOD\": 0.7090,\n" +
                "    \"JPY\": 153.1193,\n" +
                "    \"KES\": 130.0488,\n" +
                "    \"KGS\": 89.3300,\n" +
                "    \"KHR\": 4037.7891,\n" +
                "    \"KID\": 1.5308,\n" +
                "    \"KMF\": 458.6372,\n" +
                "    \"KRW\": 1367.7469,\n" +
                "    \"KWD\": 0.3079,\n" +
                "    \"KYD\": 0.8333,\n" +
                "    \"KZT\": 448.0280,\n" +
                "    \"LAK\": 21037.9635,\n" +
                "    \"LBP\": 89500.0000,\n" +
                "    \"LKR\": 298.2726,\n" +
                "    \"LRD\": 193.8282,\n" +
                "    \"LSL\": 18.7400,\n" +
                "    \"LYD\": 4.8292,\n" +
                "    \"MAD\": 10.0241,\n" +
                "    \"MDL\": 17.6679,\n" +
                "    \"MGA\": 4348.9274,\n" +
                "    \"MKD\": 56.5921,\n" +
                "    \"MMK\": 2098.3472,\n" +
                "    \"MNT\": 3414.1861,\n" +
                "    \"MOP\": 8.0726,\n" +
                "    \"MRU\": 39.6812,\n" +
                "    \"MUR\": 45.8602,\n" +
                "    \"MVR\": 15.4168,\n" +
                "    \"MWK\": 1743.8601,\n" +
                "    \"MXN\": 16.4421,\n" +
                "    \"MYR\": 4.7474,\n" +
                "    \"MZN\": 63.9953,\n" +
                "    \"NAD\": 18.7400,\n" +
                "    \"NGN\": 1242.7046,\n" +
                "    \"NIO\": 36.7939,\n" +
                "    \"NOK\": 10.8297,\n" +
                "    \"NPR\": 133.3753,\n" +
                "    \"NZD\": 1.6677,\n" +
                "    \"OMR\": 0.3845,\n" +
                "    \"PAB\": 1.0000,\n" +
                "    \"PEN\": 3.7072,\n" +
                "    \"PGK\": 3.8034,\n" +
                "    \"PHP\": 56.4792,\n" +
                "    \"PKR\": 278.1635,\n" +
                "    \"PLN\": 3.9711,\n" +
                "    \"PYG\": 7355.6190,\n" +
                "    \"QAR\": 3.6400,\n" +
                "    \"RON\": 4.6336,\n" +
                "    \"RSD\": 109.1926,\n" +
                "    \"RUB\": 93.4102,\n" +
                "    \"RWF\": 1300.4849,\n" +
                "    \"SAR\": 3.7500,\n" +
                "    \"SBD\": 8.5111,\n" +
                "    \"SCR\": 13.6447,\n" +
                "    \"SDG\": 586.9044,\n" +
                "    \"SEK\": 10.7331,\n" +
                "    \"SGD\": 1.3532,\n" +
                "    \"SHP\": 0.7968,\n" +
                "    \"SLE\": 22.5923,\n" +
                "    \"SLL\": 22592.3183,\n" +
                "    \"SOS\": 570.9058,\n" +
                "    \"SRD\": 34.9268,\n" +
                "    \"SSP\": 1558.5535,\n" +
                "    \"STN\": 22.8401,\n" +
                "    \"SYP\": 12992.7239,\n" +
                "    \"SZL\": 18.7400,\n" +
                "    \"THB\": 36.5334,\n" +
                "    \"TJS\": 10.9425,\n" +
                "    \"TMT\": 3.4983,\n" +
                "    \"TND\": 3.1128,\n" +
                "    \"TOP\": 2.3445,\n" +
                "    \"TRY\": 32.3131,\n" +
                "    \"TTD\": 6.7676,\n" +
                "    \"TVD\": 1.5308,\n" +
                "    \"TWD\": 32.2304,\n" +
                "    \"TZS\": 2565.0520,\n" +
                "    \"UAH\": 39.1934,\n" +
                "    \"UGX\": 3799.6191,\n" +
                "    \"UYU\": 39.0062,\n" +
                "    \"UZS\": 12653.2884,\n" +
                "    \"VES\": 36.2804,\n" +
                "    \"VND\": 24957.7496,\n" +
                "    \"VUV\": 120.3912,\n" +
                "    \"WST\": 2.7171,\n" +
                "    \"XAF\": 611.5163,\n" +
                "    \"XCD\": 2.7000,\n" +
                "    \"XDR\": 0.7585,\n" +
                "    \"XOF\": 611.5163,\n" +
                "    \"XPF\": 111.2473,\n" +
                "    \"YER\": 250.1284,\n" +
                "    \"ZAR\": 18.7405,\n" +
                "    \"ZMW\": 24.8083,\n" +
                "    \"ZWL\": 13.4542\n" +
                "  }\n" +
                "}";;

        Deserializador objJsonDeseralizado = new Deserializador();

        MapeandoMoedasValores moedasValores = new MapeandoMoedasValores();
        var mapa = moedasValores.mapeandoChavesValores(objJsonDeseralizado, objJson);
        for (String chave:moedasValores.)
        FileWriter escritor = new FileWriter("novo.txt");
        escritor.write(strJson.toString());
        escritor.close();
        Serializador serializador = new Serializador();
        DadosAPI teste = serializador.serializandoEmClasse(objJson);
        System.out.println(teste.toString());
        System.out.println(teste.getConversion_rates().get("BRL"));

    }
}