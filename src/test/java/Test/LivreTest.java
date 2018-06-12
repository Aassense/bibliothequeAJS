package Test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import bibliothequeAJS.service.*;

public class LivreTest {


	@Test
	public void testGetId() {
		Livre l = new Livre(0, null, 0, null, null);
		l.setId(5);
		assertEquals(5, l.getId());	
	}


	@Test
	public void testGetTitre() {
		Livre l = new Livre(0, null, 0, null, null);
		l.setTitre("bouh");
		assertEquals("bouh", l.getTitre());	
	}


	@Test
	public void testGetAnnee() {
		
	}



	@Test
	public void testGetAuteur() {
		
	}



	@Test
	public void testGetEditeur() {
		
	}

	@Test
	public void testSetEditeur(String editeur) {
		
	}

}