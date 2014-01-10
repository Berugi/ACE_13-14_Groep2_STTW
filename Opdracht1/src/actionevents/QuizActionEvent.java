package actionevents;

import java.awt.event.ActionEvent;

import model.enums.Leraar;
import model.enums.QuizStatus;
import utils.Datum;
import model.Quiz;

public class QuizActionEvent extends ActionEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int quizID;
	private String onderwerp;
	private int[] leerjaren;
	private Boolean isTest;
	private Boolean isUniekeDeelname;
	private Leraar auteur;
	private Datum regDatum;
	private QuizStatus status;
	private Quiz quiz;
	
	private void setQuizID(int quizID){
		this.quizID=quizID;
	}

	private void setOnderwerp(String onderwerp) {
		this.onderwerp = onderwerp;
	}

	private void setLeerjaren(int[] leerjaren) {
		this.leerjaren = leerjaren;
	}

	private void setIsTest(Boolean isTest) {
		this.isTest = isTest;
	}

	private void setIsUniekeDeelname(Boolean isUniekeDeelname) {
		this.isUniekeDeelname = isUniekeDeelname;
	}

	private void setAuteur(Leraar auteur) {
		this.auteur = auteur;
	}

	private void setRegDatum(Datum regDatum) {
		this.regDatum = regDatum;
	}

	private void setStatus(QuizStatus status) {
		this.status = status;
	}
	public int getQuizID() {
		return quizID;
	}

	public String getOnderwerp() {
		return onderwerp;
	}

	public int[] getLeerjaren() {
		return leerjaren;
	}

	public Boolean getIsTest() {
		return isTest;
	}

	public Boolean getIsUniekeDeelname() {
		return isUniekeDeelname;
	}

	public Leraar getAuteur() {
		return auteur;
	}

	public Datum getRegDatum() {
		return regDatum;
	}

	public QuizStatus getStatus() {
		return status;
	}
	
	public void setQuiz(Quiz q){
		this.quiz=q;
	}
	
	public Quiz getQuiz(){
		return this.quiz;
	}

	public QuizActionEvent(Object source, int id, String command,int quizID, String onderwerp,int[] leerjaren, Boolean isTest,
			Boolean isUniekeDeelname, Leraar auteur, Datum regDatum, QuizStatus status) {
		super(source, id, command);
		this.setOnderwerp(onderwerp);
		this.setLeerjaren(leerjaren);
		this.setIsTest(isTest);
		this.setIsUniekeDeelname(isUniekeDeelname);
		this.setAuteur(auteur);
		this.setRegDatum(regDatum);
		this.setStatus(status);
	}
	
	public QuizActionEvent(Object source, int id,String command,Quiz q){
		super(source,id,command);
		
	}

	@Override
	public String getActionCommand() {

		return super.getActionCommand();

	}
	
	@Override
	public Object getSource() {

		return super.getSource();

	}
}
