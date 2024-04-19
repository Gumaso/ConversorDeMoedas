package Mapeadores;

import com.google.gson.annotations.Expose;

public class ValoresMonetarios {
    @Expose(serialize = true, deserialize = true)
    private String USD;  // Dólar (United States Dollar)
    @Expose(serialize = true, deserialize = true)
    private String ARS;  // Peso argentino (Argentine Peso)
    @Expose(serialize = true, deserialize = true)
    private String EUR;  // Euro
    @Expose(serialize = true, deserialize = true)
    private String GBP;  // Libra Esterlina (British Pound)
    @Expose(serialize = true, deserialize = true)
    private String JPY;  // Iene (Japanese Yen)
    @Expose(serialize = true, deserialize = true)
    private String CAD;  // Dólar Canadense (Canadian Dollar)
    @Expose(serialize = true, deserialize = true)
    private String AUD;  // Dólar Australiano (Australian Dollar)
    @Expose(serialize = true, deserialize = true)
    private String CHF;  // Franco Suíço (Swiss Franc)
    @Expose(serialize = true, deserialize = true)
    private String CNY;  // Yuan Chinês (Chinese Yuan)
    @Expose(serialize = true, deserialize = true)
    private String BRL;  // Real brasileiro (Brazilian Real)

    public String getUSD() {
        return USD;
    }

    public String getARS() {
        return ARS;
    }

    public String getEUR() {
        return EUR;
    }

    public String getGBP() {
        return GBP;
    }

    public String getJPY() {
        return JPY;
    }

    public String getCAD() {
        return CAD;
    }

    public String getAUD() {
        return AUD;
    }

    public String getCHF() {
        return CHF;
    }

    public String getCNY() {
        return CNY;
    }

    public String getBRL() {
        return BRL;
    }

    @Override
    public String toString() {
        return "ValoresMonetarios{" +
                "USD='" + USD + '\'' +
                ", ARS='" + ARS + '\'' +
                ", EUR='" + EUR + '\'' +
                ", GBP='" + GBP + '\'' +
                ", JPY='" + JPY + '\'' +
                ", CAD='" + CAD + '\'' +
                ", AUD='" + AUD + '\'' +
                ", CHF='" + CHF + '\'' +
                ", CNY='" + CNY + '\'' +
                ", BRL='" + BRL + '\'' +
                '}';
    }
}

