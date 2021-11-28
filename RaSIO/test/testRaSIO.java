import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class testRaSIO {
	
	@Test
	public void testTailleCollectionEcurie() {
		Assert.assertEquals("Erreur sur la taille de l'�curie", 1, Modele.affichageEcurie().size());
	}
	
	@Test
	public void testToStringCourse() {
		ContenuCourse uneCourse = new ContenuCourse("test", "test", 1);
		String testToString = "test - test - 1 spectateurs.";
		Assert.assertEquals("Probl�me dans le toString",testToString, uneCourse.toString());
	}
	
	@Test
	public void testAffichageXML() {
		ContenuCourse uneCourse = new ContenuCourse("test", "test", 1);
		String testXML = "";
		testXML += "\n\t<course>";
		testXML += "\n\t\t<nom> test </nom>";
		testXML += "\n\t\t<type> test </type>";
		testXML += "\n\t\t<nbSpec> 1 </nbSpec>";
        //rep += "\n\t\t<nomCircuit> " + this.unCircuit + " </nomCircuit>";
		testXML += "\n\t</course>";
		Assert.assertEquals("Probl�me d'affichage du XML", testXML, uneCourse.toXML());
	}

}
