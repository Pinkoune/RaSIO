/**
 * Classe des Courses
 * @author Jeremy
 *
 */

public class ContenuCourse {
	//attributs prives
	private String nomCourse;
	private String typeCourse;
	private int nbSpec;

	
	//Constructeur
	public ContenuCourse(String unNomCourse, String unTypeCourse, int unNbSpec) {
		this.nomCourse = unNomCourse;
		this.typeCourse = unTypeCourse;
		this.nbSpec = unNbSpec;
	}
	
	//Accesseurs
	public String getNomCourse() {
		return this.nomCourse;
	}

	public void setNomCourse(String unNomCourse) {
		this.nomCourse = unNomCourse;
	}

	public String getTypeCourse() {
		return typeCourse;
	}

	public void setTypeCourse(String unTypeCourse) {
		this.typeCourse = unTypeCourse;
	}	
	
	public int getNbSpec() {
		return this.nbSpec;
	}
	
	public void setNbSpec(int unNbSpec) {
		this.nbSpec = unNbSpec;
	}
	
	public String toXML() {
		String rep = "";
		rep += "\n\t<course>";
        rep += "\n\t\t<nom> " + this.nomCourse + " </nom>";
        rep += "\n\t\t<type> " + this.typeCourse + " </type>";
        rep += "\n\t\t<nbSpec> " + this.nbSpec + " </nbSpec>";
        //rep += "\n\t\t<nomCircuit> " + this.unCircuit + " </nomCircuit>";
        rep += "\n\t</course>";
		return rep;
	}
	
	public String toString() {
		return this.getNomCourse() + " - " + this.getTypeCourse()+ " - "  + this.getNbSpec() + " spectateurs.";
	}
	
}
