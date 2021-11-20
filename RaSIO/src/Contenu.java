/**
 * Classe Abstraite des instruments
 * @author Jeremy
 *
 */

public abstract class Contenu {
	//attributs priv�s
	private String marque;
	private String matiere;
	private String type;

	
	//Constructeur
	public Contenu(String unType, String uneMarque, String unMatiere) {
		this.type = unType;
		this.marque = uneMarque;
		this.matiere = unMatiere;
	}
	
	//Accesseurs
	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setModele(String matiere) {
		this.matiere = matiere;
	}	
	
	public String getType() {
		return this.type;
	}
	
}
