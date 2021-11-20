
public class Main {

	public static void main(String[] args) {
		
		Modele.connexion();
		
		Liste maListe = new Liste();
		FenetreIHM uneFenetre = new FenetreIHM(maListe);
		
	}

}
