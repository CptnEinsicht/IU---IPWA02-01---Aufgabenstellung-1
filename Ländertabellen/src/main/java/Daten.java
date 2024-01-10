import java.util.ArrayList;
import java.util.Collection;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class Daten
{
    private Collection<Benutzer> benutzerListe = new ArrayList<Benutzer>();

    public Daten()
    {
    	benutzerListe.add(new Benutzer("admin","admin"));
    	benutzerListe.add(new Benutzer("Wissenschaftlerin","Passwort"));
    	benutzerListe.add(new Benutzer("Wissenschaftler","Passwort"));
    }

    public Collection<Benutzer> getBenutzerListe()
    {
        return benutzerListe;
    }
}