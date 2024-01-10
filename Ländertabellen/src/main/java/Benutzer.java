public class Benutzer {
	
    private String name;
    private String passwort;

    public Benutzer(String name, String passwort)
    {
        this.name = name;
        this.passwort = passwort;
    }

    public String getName()
    {
        return name;
    }

    public String getPasswort()
    {
        return passwort;
    }
    
    @Override public boolean equals(Object obj) {
    	if (obj instanceof Benutzer) {
    		Benutzer b = (Benutzer) obj;
    		if (b.getName().equals(this.name)&& b.getPasswort().equals(this.passwort))
    			return true;
    	}
    	return false;
    }
}


