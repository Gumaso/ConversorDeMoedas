package ManipulacaoDados;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class DadosAPI {
    public String getResult() {
        return result;
    }

    public String getDocumentation() {
        return documentation;
    }

    public String getTerms_of_use() {
        return terms_of_use;
    }

    public long getTime_last_update_unix() {
        return time_last_update_unix;
    }

    public long getTime_next_update_unix() {
        return time_next_update_unix;
    }

    public String getTime_last_update_utc() {
        return time_last_update_utc;
    }

    public String getTime_next_update_utc() {
        return time_next_update_utc;
    }

    public String getBase_code() {
        return base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    @Expose(serialize = true, deserialize = true)
    private String result;

    @Expose(serialize = true, deserialize = true)
    private String documentation;

    @Expose(serialize = true, deserialize = true)
    private String terms_of_use;

    @Expose(serialize = true, deserialize = true)
    private long time_last_update_unix;
    @Expose(serialize = true, deserialize = true)

    private long time_next_update_unix;
    @Expose(serialize = true, deserialize = true)

    private String time_last_update_utc;

    @Expose(serialize = true, deserialize = true)

    private String time_next_update_utc;
    @Expose(serialize = true, deserialize = true)

    private String base_code;

    @Expose(serialize = true, deserialize = true)

    private Map<String, Double> conversion_rates;
    @Override
    public String toString() {
        return "DadosAPI{" +
                "result='" + result + '\'' +
                ", documentation='" + documentation + '\'' +
                ", terms_of_use='" + terms_of_use + '\'' +
                ", time_last_update_unix=" + time_last_update_unix +
                ", time_next_update_unix=" + time_next_update_unix +
                ", time_last_update_utc='" + time_last_update_utc + '\'' +
                ", time_next_update_utc='" + time_next_update_utc + '\'' +
                ", base_code='" + base_code + '\'' +
                ", conversion_rates=" + conversion_rates +
                '}';
    }




}
