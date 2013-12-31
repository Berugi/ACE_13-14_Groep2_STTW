package tests.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import utils.Datum;
import model.baseclasses.Opdracht;
import model.enums.*;
import model.*;


public class OpdrachtTest {
	
	private Opdracht opdracht;
	private Opdracht opdracht2;
	private String[] hints;
	private Quiz quiz;
	private Leerling leerling1;
	private Leerling leerling2;
	private QuizDeelname deelname;
	private OpdrachtAntwoord oa;
	private QuizOpdracht qo;
	private OpdrachtCatalogus opdrachtCatalogus;

	@Before
	public void setUp() throws Exception {
		leerling1 = new Leerling("Pieterke",1);
		leerling2 = new Leerling("Charlotte",2);
		opdrachtCatalogus = new OpdrachtCatalogus();
	}

	@Test
	public void Test_OpdrachtBase_Default_Constructor_Object_aangemaakt() {
		opdracht = new Opdracht();
	}

	@Test
	public void Test_OpdrachtBase_Parameter_Constructor_Object_aangemaakt() {
		String[] hints = {"Simpel","Antwoord"};
		opdracht = new Opdracht("Wat is het antwoord","Dit is het antwoord",1,30,Leraar.PIETER,OpdrachtCategorie.AARDRIJKSKUNDE,hints);
		opdracht2 = new Opdracht("Wat is een tekstbestand","flat file van ascii tekens",3,60,Leraar.JEAN,OpdrachtCategorie.AARDRIJKSKUNDE,"");
		opdrachtCatalogus.add(opdracht);
		opdrachtCatalogus.add(opdracht2);
		assertEquals("Wat is het antwoord",opdracht.getVraag());
		assertEquals(Leraar.PIETER,opdracht.getAuteur());
		assertTrue(opdracht.IsJuisteAntwoord("Dit is het antwoord"));
		assertEquals(1,opdracht.getMaxAantalPogingen());
		assertEquals(30l,opdracht.getMaxAntwoordTijd());
		assertEquals(OpdrachtCategorie.AARDRIJKSKUNDE,opdracht.getOpdrachtCategorie());
		assertEquals(hints,opdracht.getAntwoordHints());
		/*
		try{
		opdrachtCatalogus.WegschrijvenAlsTekstbestand("bestanden\\opdrachten.txt");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		*/
	}
	
	@Test
	public void Test_Opdracht_Wijzigen_OK(){
		//aanmaken van een nieuwe Quiz met een QuizOpdracht die deze opdracht bevat zonder beantwoord te zijn door een leerling
		int[] ljr ={1,2};
		quiz = new Quiz("Test Quiz",ljr,false, false, Leraar.AN,new Datum());
		String[] hints = {"Simpel","Antwoord"};
		opdracht = new Opdracht("Wat is het antwoord","Dit is het antwoord",1,30,Leraar.PIETER,OpdrachtCategorie.AARDRIJKSKUNDE,hints);
		quiz.quizOpdrachtToevoegen(new QuizOpdracht(5,quiz,opdracht));
		//we hebben nu een opdracht die behoort tot een Quiz die nog nooit werd uitgevoerd
		//proberen deze nu te wijzigen
		assertTrue(opdracht.Opdracht_wijzigen("Wat is het alternatieve antwoord", "Het andere antwoord", 1, 30, Leraar.PIETER,OpdrachtCategorie.AARDRIJKSKUNDE,hints));
		assertEquals("Wat is het alternatieve antwoord",opdracht.getVraag());
		assertTrue(opdracht.IsJuisteAntwoord("Het andere antwoord"));
	}
	
	@Test
	public void Test_Opdracht_Wijzigen_Gewijgerd_al_uitgevoerd(){
		//aanmaken van een nieuwe Quiz met een QuizOpdracht die deze opdracht bevat zonder beantwoord te zijn door een leerling
		int[] ljr ={1,2};
		String[] hints = {"Simpel","Antwoord"};
		quiz = new Quiz("Test Quiz",ljr,false, false, Leraar.AN,new Datum());
		opdracht = new Opdracht("Wat is het antwoord","Dit is het antwoord",1,30,Leraar.PIETER,OpdrachtCategorie.AARDRIJKSKUNDE,hints);
		qo = new QuizOpdracht(5,quiz,opdracht);	
		quiz.quizOpdrachtToevoegen(qo);
		deelname = new QuizDeelname(leerling1,quiz);		
		oa = new OpdrachtAntwoord("ik weet het niet",1,11,qo,deelname);

		//we hebben nu een opdracht die behoort tot een Quiz die werd uitgevoerd
		//proberen deze nu te wijzigen
		assertTrue(!opdracht.Opdracht_wijzigen("Wat is het alternatieve antwoord", "Het andere antwoord", 1, 30, Leraar.PIETER,OpdrachtCategorie.AARDRIJKSKUNDE,hints));
	}
}
