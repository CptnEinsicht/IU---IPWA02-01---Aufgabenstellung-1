import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class Tabelle implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Inhalt> liste = new ArrayList<>();
    private List<Inhalt> neueEintraege = new ArrayList<>();
    private List<Inhalt> geaenderteEintraege = new ArrayList<>();
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
        if (neuesLand != null && neuesCo2 != null && !neuesLand.isEmpty() && !neuesCo2.isEmpty()) {
            Iterator<Inhalt> iterator = liste.iterator(); // Überprüfen, ob das Land bereits existiert
            while (iterator.hasNext()) {
                Inhalt eintrag = iterator.next();
                if (eintrag.getLand().equals(neuesLand)) { 
                    geaenderteEintraege.add(new Inhalt(neuesLand, neuesCo2)); // Wenn Land bereits existiert, wird bisheriger Wert aktualisiert
                    neuesLand = null; 	// Neue Einträge zurücksetzen
                    neuesCo2 = null;	// Neue Einträge zurücksetzen
                    return;
                }
            }
            neueEintraege.add(new Inhalt(neuesLand, neuesCo2)); // Wenn Land nicht existiert, neuer Eintrag
            neuesLand = null; 	// Neue Einträge zurücksetzen
            neuesCo2 = null;	// Neue Einträge zurücksetzen
        }
    }

    public List<Inhalt> getNeueEintraege() {
        List<Inhalt> alleNeuenEintraege = new ArrayList<>(neueEintraege);
        alleNeuenEintraege.addAll(geaenderteEintraege);
        return alleNeuenEintraege;
    }

    public void freigeben() {
        for (Inhalt geaenderterEintrag : geaenderteEintraege) {
            int index = -1;
            for (int i = 0; i < liste.size(); i++) {
                Inhalt bestehenderEintrag = liste.get(i);
                if (geaenderterEintrag.getLand().equals(bestehenderEintrag.getLand())) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                liste.set(index, geaenderterEintrag); 	// Falls Eintrag bereits existiert, aktualisiere ihn
            } else {
                liste.add(geaenderterEintrag);	 // Falls Eintrag noch nicht existiert, füge ihn hinzu
            }
        }
        
        for (Inhalt neuerEintrag : neueEintraege) {
            if (!liste.contains(neuerEintrag)) {
                liste.add(neuerEintrag);
            }
        }
        neueEintraege.clear();
        geaenderteEintraege.clear();
    }

    public void loeschen() {
        neueEintraege.clear();
        geaenderteEintraege.clear();
    }
}