import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;

@Named
@RequestScoped

public class LoginBenutzer  {

    private String benutzername;
    private String passwort;
    private String loginFehlermeldung;

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
    
    public String getLoginFehlermeldung() {
        return loginFehlermeldung;
    }

    public void setLoginFehlermeldung(String loginFehlermeldung) {
        this.loginFehlermeldung = loginFehlermeldung;
    }
    
    public String login() {
    	if(benutzername.equals("admin") && passwort.equals("admin")) {
    		return "admin.xhtml";
    	}
    	else if (("wissenschaftlerin".equals(benutzername) || "wissenschaftler".equals(benutzername))
            && "wissen".equals(passwort)) {
        return "login.xhtml";
    	} 
    	else {
            loginFehlermeldung = "Login fehlerhaft";
            return ""; // Hier könnten Sie auch null zurückgeben, wenn die Seite nicht gewechselt werden soll
        }
    }
}

