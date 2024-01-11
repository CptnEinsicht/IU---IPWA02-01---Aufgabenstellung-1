import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class Tabelle implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Inhalt> liste = new ArrayList<>();
    private List<Inhalt> neueEintraege = new ArrayList<>();
    private String augewaehltesLand;
    private String neuesLand;
    private String neuesCo2;

    public Tabelle() 
    {
    	liste.add(new Inhalt("Deutschland","665,9 Millionen Tonnen"));
    	liste.add(new Inhalt("USA","5000 Millionen Tonnen"));
    	liste.add(new Inhalt("Frankreich","297,5 Millionen Tonnen"));
    	liste.add(new Inhalt("Japan","1060 Millionen Tonnen"));
    	liste.add(new Inhalt("China","11000 Millionen Tonnen"));
    	liste.add(new Inhalt("Thailand","279 Millionen Tonnen"));
    	liste.add(new Inhalt("Polen","322,1 Millionen Tonnen"));
    	liste.add(new Inhalt("Argentinien","186,5 Millionen Tonnen"));
    }

    public List<Inhalt> getListe() {
        return liste;
    }

    public String getAugewaehltesLand() {
        return augewaehltesLand;
    }

    public void setAugewaehltesLand(String augewaehltesLand) {
        this.augewaehltesLand = augewaehltesLand;
    }

    public String getCo2ZumLand() {
        for (Inhalt inhalt : liste) {
            if (augewaehltesLand != null && augewaehltesLand.equals(inhalt.getLand())) {
                return inhalt.getCo2();
            }
        }
        return "";
    }
    public String getNeuesLand() {
        return neuesLand;
    }

    public void setNeuesLand(String neuesLand) {
        this.neuesLand = neuesLand;
    }

    public String getNeuesCo2() {
        return neuesCo2;
    }

    public void setNeuesCo2(String neuesCo2) {
        this.neuesCo2 = neuesCo2;
    }

    public void neuerEintrag() {
        // Prüfen, ob neuesLand und neuesCo2 nicht leer sind
        if (neuesLand != null && neuesCo2 != null && !neuesLand.isEmpty() && !neuesCo2.isEmpty()) {
            // Neuen Eintrag zur Liste der neuen Einträge hinzufügen
            neueEintraege.add(new Inhalt(neuesLand, neuesCo2));
            // Neue Einträge zurücksetzen
            neuesLand = null;
            neuesCo2 = null;
        }
    }

    public List<Inhalt> getNeueEintraege() {
        return neueEintraege;
    }

    public void freigeben() {
        // Füge neue Einträge zur Hauptliste hinzu
        liste.addAll(neueEintraege);
        // Leere die Liste der neuen Einträge
        neueEintraege.clear();
    }

    public void loeschen() {
        // Leere die Liste der neuen Einträge
        neueEintraege.clear();
    }
}