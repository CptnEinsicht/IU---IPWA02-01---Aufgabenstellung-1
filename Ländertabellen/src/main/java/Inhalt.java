import java.io.Serializable;

public class Inhalt implements Serializable {
    private static final long serialVersionUID = 1L;

    private String land;
    private String co2;

    public Inhalt(String land, String co2) {
        this.land = land;
        this.co2 = co2;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getCo2() {
        return co2;
    }

    public void setCo2(String co2) {
        this.co2 = co2;
    }
}
