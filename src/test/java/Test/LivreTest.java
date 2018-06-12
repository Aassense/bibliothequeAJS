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
		Livre l = new Livre(0, null, 0, null, null);
		l.setAnnee(1234);
		assertEquals(1234, l.getAnnee());	
	}


	@Test
	public void testGetAuteur() {
		Livre l = new Livre(0, null, 0, null, null);
		l.setAuteur("Jack Douglas");
		assertEquals("Jack Douglas", l.getAuteur());	
	}



	@Test
	public void testGetEditeur() {
		Livre l = new Livre(0, null, 0, null, null);
		l.setEditeur("First Edition");
		assertEquals("First Edition", l.getEditeur());	
	}


}