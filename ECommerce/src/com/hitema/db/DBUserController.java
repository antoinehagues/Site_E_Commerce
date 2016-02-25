package com.hitema.db;

public class DBUserController {
	
	private DBController db ;
	private String Nom;
	private String Prenom;
	private String Id_User;
	private String Montant;
	private String Id_Historique;
	
	
	public void init(){
		db = new DBController();
	}
	
	public String Connexion (String pseudo , String motdepasse){
		
		String sql = "SELECT nom , prenom , id_historique , id_user , montant FROM user WHERE pseudo='"+pseudo+"' AND mdp='"+motdepasse+"'";
		Connection connection = db.getConnection();
		ResultSet resultat = connection.executeQuery(sql);
		Id_User=resultat.getString("id_ser");
		
		if(Id_User!=""){
			return Id_User;
		}
		else{
			return "Connexion KO";
		}
	}
	
	public String AddUser(String id_user){
		
		return "Test";

	}
	
	public String[] GetInfosUser(String id_user){
		
		String sql = "SELECT nom , prenom , id_historique , id_user , montant FROM user WHERE mdp='"+id_user+"'";
		Connection connection = db.getConnection();
		ResultSet resultat = connection.executeQuery(sql);
		String tableau[]={resultat.getString("nom"),resultat.getString("prenom"),resultat.getString("id_historique"),resultat.getString("id_user"),resultat.getString("montant")};
		return tableau;
	}
	
	public void close(){
		db.close();
	}
}
