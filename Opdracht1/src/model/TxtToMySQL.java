package model;
import java.sql.*;
/**
 * 
 * @author Sander Van der Borght
 * @version 20140104 - initial commit
 *
 */
public class TxtToMySQL {

	String DB_URL = "jdbc:mysql://localhost/quiz";
	String password ="";
	String username ="";
	 
	//setters en getters
	public String getDB_URL() {
		return DB_URL;
	}

	public void setDB_URL(String dB_URL) {
		DB_URL = dB_URL;
	}

	 
	 public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	//Constructors
	public TxtToMySQL(){
		
	}	
	public TxtToMySQL(String _dbUrl){
		this.DB_URL = _dbUrl;
	}
	public TxtToMySQL(String dB_URL, String _usrname, String _password) {
		DB_URL = dB_URL;
		this.password = _password;
		this.username = _usrname;
	}
	
	
	//Functions
	public void quizToMySQL(String _pathToTxtFile, Quiz quiz) throws SQLException{
		
		//use txtEncoderDecoder to load all data, then use a foreach and store every quiz in the MySQl database
		
		 try{
			 Connection con  = DriverManager.getConnection(DB_URL, "root","");
			 Statement st = con.createStatement();
			 
			 ResultSet quizQuery = st.executeQuery("insert into Quiz.Quizen (QuizID,Onderwerp,IsTest,IsUniekeDeelname,Auteur,DatumRegistratie,QuizStatus)" +
			 		"values ("+quiz.getQuizID()+","+quiz.getOnderwerp()+","+quiz.getIsTest()+","+quiz.getIsUniekeDeelname()+","+quiz.getAuteur()+","+quiz.getDatumRegistratie().toString()+","+quiz.getQuizStatus()+")");
			 
			 for(int leerjaar : quiz.getLeerjaren()){
					ResultSet leerjarenQuery = st.executeQuery("insert into Quiz.Leerjaren (QuizID,Leerjaar)" +
					 		"values ("+quiz.getQuizID()+","+leerjaar+")");
				 }
			 
			 for(QuizOpdracht quizOpdracht : quiz.getQuizOpdrachten()){
				 ResultSet quizOpdrachtQuery = st.executeQuery("insert into Quiz.QuizOpdrachten (QuizID,OpdrachtID,MaxScore)" +
					 		"values ("+quizOpdracht.getQuiz().getQuizID()+","+quizOpdracht.getOpdracht().getOpdrachtID()+","+quizOpdracht.getMaxScore()+")");
				 
				 ResultSet opdrachtQuery = st.executeQuery("insert into Quiz.Opdrachten (OpdrachtID,Vraag,MaxAantalPogingen,MaxAntwoordtijd,JuisteAntwoord,Auteur,Categorie,DatumRegistratie)" +
					 		"values ("+quizOpdracht.getOpdracht().getOpdrachtID()+","+quizOpdracht.getOpdracht().getVraag()+","+quizOpdracht.getOpdracht().getMaxAantalPogingen()+","+quizOpdracht.getOpdracht().getMaxAntwoordTijd()+","+quizOpdracht.getOpdracht().getJuisteAntwoord()+","+quizOpdracht.getOpdracht().getAuteur()+","+quizOpdracht.getOpdracht().getOpdrachtCategorie()+","+quizOpdracht.getOpdracht().getDatumRegistratie().toString()+")");	
					 
				 for(String hint : quizOpdracht.getOpdracht().getAntwoordHints()){
					 ResultSet AntwoordhintsQuery = st.executeQuery("insert into Quiz.AntwoordHints (OpdrachtID,Hint)" +
						 		"values ("+quizOpdracht.getOpdracht().getOpdrachtID()+","+hint+")");
				 }
			 }
			 
		 }
		 catch(SQLException ex){
			 throw ex;
		 }
	 }
	public void writeData() throws SQLException{
		try{
			Connection con  = DriverManager.getConnection(DB_URL, this.username,this.password);
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("select * from Quiz.Quizen");
			 while (res.next()){
				 System.out.println(res.getString(2));
			 }	
		}
		catch(SQLException ex){
			 throw ex;
		 }
	}
}

