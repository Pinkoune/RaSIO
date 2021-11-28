/**
 * Classe des Ecuries
 * @author Jeremy
 *
 */

public class ContenuCircuit {
	//attributs prives
	private String nomCircuit;
	private float tailleCircuit;
	private String paysCircuit;

	
	//Constructeur
	public ContenuCircuit(String unNomCircuit, float uneTailleCircuit, String unPaysCircuit) {
		this.nomCircuit = unNomCircuit;
		this.tailleCircuit = uneTailleCircuit;
		this.paysCircuit = unPaysCircuit;
	}
	
	//Accesseurs
	public String getNomCircuit() {
		return this.nomCircuit;
	}

	public void setNomCircuit(String unNomCircuit) {
		this.nomCircuit = unNomCircuit;
	}

	public float getTailleCircuit() {
		return tailleCircuit;
	}

	public void setTailleCircuit(float uneTailleCircuit) {
		this.tailleCircuit = uneTailleCircuit;
	}	
	
	public String getPaysCircuit() {
		return this.paysCircuit;
	}
	
	public void setPaysCircuit(String unPaysCircuit) {
		this.paysCircuit = unPaysCircuit;
	}
	
	public String toJSON() {
		String rep = "";
		rep += "\n\t{";
        rep += "\n\t\t'nom': '" + this.nomCircuit + "',";
        rep += "\n\t\t'taille': '" + this.tailleCircuit + "',";
        rep += "\n\t\t'pays'; '" + this.paysCircuit + "',";
        rep += "\n\t}";
		return rep;
	}
	
	public String toString() {
		return this.getNomCircuit() + " - " + this.getTailleCircuit()+ " km - "  + this.getPaysCircuit();
	}
	
}
