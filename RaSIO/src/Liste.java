/**
 * Classe qui contient la liste
 * @author Jeremy
 *
 */

import java.util.ArrayList;
public class Liste {
	private ArrayList<Contenu> listePrincipale;
	
	public Liste() {
		this.listePrincipale = new ArrayList<Contenu>();
	}
	
	public int getNombreInstruments() {
		return this.listePrincipale.size();
	}
	
	public void ajoutInstruments(Contenu unContenu) {
		this.listePrincipale.add(unContenu);
	}
	
	public ArrayList<Contenu> getlistePrincipale(){
		return this.listePrincipale;
	}
	
	public String recherche(String uneMatiere) {
		int index = 0;
		String result = "\nCet instrument n'est pas present";
		while(index < this.listePrincipale.size() && !this.listePrincipale.get(index).getMatiere().equals(uneMatiere)) {
			index = index + 1;
		}
		if (index < this.listePrincipale.size()) {
			result = "\nVoici l'instrument recherche :" + uneMatiere  + this.listePrincipale.get(index).toString();
		}
		return result;
	}
	
	public int rechercheInt(String uneMatiere) {
		int index = 0;
		int result = -1;
		while(index < this.listePrincipale.size() && !this.listePrincipale.get(index).getMatiere().equals(uneMatiere)) {
			index = index + 1;
		}
		if (index < this.listePrincipale.size()) {
			result = index;
		}
		return result;
	}
	
	public void supprimer(int indice) {
		this.listePrincipale.remove(indice);
	}
	
	public void supprimer(Contenu unContenu) {
		this.listePrincipale.remove(unContenu);
	}
	
	public boolean supprimer(String uneMatiere) {
		boolean rep = false;
		int index = this.rechercheInt(uneMatiere);
		if (index != -1) {
			this.listePrincipale.remove(index);
			rep = true;
		}
		return rep;
	}
	
	public String toString() {
		String entete = "**** PRESENTATION DE LA RASIO ****";
		String resultat = "";
		if (this.listePrincipale.size() == 0) {
			resultat = "\nRien de prévu.";
		}
		else {
			for(int i = 0 ; this.listePrincipale.size() > i ; i++) {
				resultat = resultat + i + this.listePrincipale.get(i).toString();
			}
			
		}
		return entete + resultat;
	}
}
