package tests.model;

import model.OpdrachtCatalogus;
import model.OpdrachtCategorieOverzicht;
import model.baseclasses.Opdracht;
import model.enums.Leraar;
import model.enums.OpdrachtCategorie;

import org.junit.Before;
import org.junit.Test;

public class OpdrachtCategorieOverzichtTest {

	OpdrachtCatalogus catalogus;
	
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testPrintCategories() {
		this.catalogus = new OpdrachtCatalogus();
		this.catalogus.add(new Opdracht("vraag", "juisteAntwoord",10,25, Leraar.AN, OpdrachtCategorie.AARDRIJKSKUNDE,	"antwoordHints","antwoordHints2"));
		
		OpdrachtCategorieOverzicht.printCategories(this.catalogus);
	}

}
