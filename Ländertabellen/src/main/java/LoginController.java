/*import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class LoginController {

    @Inject
    private Daten daten;

    private Benutzer benutzer = new Benutzer();

    public String login() {
        List<Benutzer> benutzerListe = daten.getBenutzerListe();
        for (Benutzer b : benutzerListe) {
            if (b.getName().equals(this.benutzer.getName()) && b.getPasswort().equals(this.benutzer.getPasswort())) {
                return "login.xhtml";
            }
        }
        return "index.xhtml";
    }

    public Benutzer getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }
}
*/