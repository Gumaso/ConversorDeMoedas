package Mapeadores;

import com.google.gson.annotations.Expose;

import java.util.Map;

public class ValoresMonetarios {
    @Expose(serialize = true, deserialize = true)
    private  String USD;  // Dólar (United States Dollar)
    @Expose(serialize = true, deserialize = true)
    private  String ARS;  // Peso argentino (Argentine Peso)
    @Expose(serialize = true, deserialize = true)
    private  String BRL;  // Real brasileiro (Brazilian Real)
    @Expose(serialize = true, deserialize = true)
    private  String COP;  // Peso colombiano (Colombian Peso)
    @Expose(serialize = true, deserialize = true)
    private String EUR;  // Euro
    @Expose(serialize = true, deserialize = true)
    private String CNY; // Moeda da China
    public String getUSD() {
        return USD;
    }

    public String getARS() {
        return ARS;
    }

    public String getBRL() {
        return BRL;
    }

    public String getCOP() {
        return COP;
    }

    @Override
    public String toString() {
        return "ValoresMonetarios{" +
                "USD='" + USD + '\'' +
                ", ARS='" + ARS + '\'' +
                ", BRL='" + BRL + '\'' +
                ", COP='" + COP + '\'' +
                ", EUR='" + EUR + '\'' +
                ", CNY='" + CNY + '\'' +
                '}';
    }

    public String getEUR() {
        return EUR;
    }

    public String getCNY() {
        return CNY;
    }


}
