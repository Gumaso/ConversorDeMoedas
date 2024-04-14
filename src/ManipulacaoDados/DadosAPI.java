package ManipulacaoDados;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;
/**
 * A classe DadosAPI representa os dados retornados por uma API de conversão de moedas.
 * Contém informações como resultados, documentação, termos de uso, códigos de base e taxas de conversão.
 */
public class DadosAPI {

    /**
     * Retorna o resultado da operação da API.
     *
     * @return Uma string contendo o resultado da operação.
     */
    public String getResult() {
        return result;
    }

    /**
     * Retorna a documentação da API.
     *
     * @return Uma string contendo a documentação da API.
     */
    public String getDocumentation() {
        return documentation;
    }

    /**
     * Retorna os termos de uso da API.
     *
     * @return Uma string contendo os termos de uso da API.
     */
    public String getTerms_of_use() {
        return terms_of_use;
    }

    /**
     * Retorna o tempo da última atualização (UTC) dos dados.
     *
     * @return Uma string representando o tempo da última atualização em UTC.
     */
    public String getTime_last_update_utc() {
        return time_last_update_utc;
    }

    /**
     * Retorna o tempo da próxima atualização (UTC) dos dados.
     *
     * @return Uma string representando o tempo da próxima atualização em UTC.
     */
    public String getTime_next_update_utc() {
        return time_next_update_utc;
    }

    /**
     * Retorna o código base da moeda.
     *
     * @return Uma string contendo o código base da moeda.
     */
    public String getBase_code() {
        return base_code;
    }

    /**
     * Retorna um mapa contendo as taxas de conversão.
     *
     * @return Um mapa onde as chaves são códigos de moeda e os valores são as taxas de conversão.
     */
    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    /**
     * Representação em string dos dados da API.
     *
     * @return Uma string contendo todas as informações dos dados da API.
     */
    @Override
    public String toString() {
        return "DadosAPI{" +
                "result='" + result + '\'' +
                ", documentation='" + documentation + '\'' +
                ", terms_of_use='" + terms_of_use + '\'' +
                ", time_last_update_utc='" + time_last_update_utc + '\'' +
                ", time_next_update_utc='" + time_next_update_utc + '\'' +
                ", base_code='" + base_code + '\'' +
                ", conversion_rates=" + conversion_rates +
                '}';
    }

    // Atributos da classe com anotações Expose para controle de serialização/desserialização
    @Expose(serialize = false, deserialize = false)
    private String result;

    @Expose(serialize = false, deserialize = false)
    private String documentation;

    @Expose(serialize = false, deserialize = false)
    private String terms_of_use;

    @Expose(serialize = true, deserialize = true)
    private String time_last_update_utc;

    @Expose(serialize = true, deserialize = true)
    private String time_next_update_utc;

    @Expose(serialize = true, deserialize = true)
    private String base_code;

    @Expose(serialize = true, deserialize = true)
    private Map<String, Double> conversion_rates;
}
