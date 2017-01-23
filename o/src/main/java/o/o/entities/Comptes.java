package o.o.entities;

public class Comptes {
public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
private String identifiant;
public Comptes(String identifiant, String motdepasse) {
	super();
	this.identifiant = identifiant;
	this.motdepasse = motdepasse;
}
private String motdepasse;

}
