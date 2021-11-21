/**
 * Classe des Ecuries
 * @author Jeremy
 *
 */

public class ContenuEcurie {
	//attributs prives
	private String nomEcurie;
	private String sponsorEcurie;
	private String motoristeEcurie;

	
	//Constructeur
	public ContenuEcurie(String unNomEcurie, String unSponsorEcurie, String unMotoristeEcurie) {
		this.nomEcurie = unNomEcurie;
		this.sponsorEcurie = unSponsorEcurie;
		this.motoristeEcurie = unMotoristeEcurie;
	}
	
	//Accesseurs
	public String getNomEcurie() {
		return this.nomEcurie;
	}

	public void setNomEcurie(String unNomEcurie) {
		this.nomEcurie = unNomEcurie;
	}

	public String getSponsorEcurie() {
		return sponsorEcurie;
	}

	public void setSponsorEcurie(String unSponsorEcurie) {
		this.sponsorEcurie = unSponsorEcurie;
	}	
	
	public String getMotoristeEcurie() {
		return this.motoristeEcurie;
	}
	
	public void setMotoristeEcurie(String unMotoristeEcurie) {
		this.motoristeEcurie = unMotoristeEcurie;
	}
	
	public String toString() {
		return this.getNomEcurie() + " - " + this.getSponsorEcurie()+ " - "  + this.getMotoristeEcurie();
	}
	
}
