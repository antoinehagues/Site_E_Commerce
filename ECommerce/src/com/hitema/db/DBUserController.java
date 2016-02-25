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
		
		String sql = "SELECT nom , prenom , id_historique , id_user , montant FROM user WHERE pseudo=? AND mdp=?";
		Connection connection = db.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, pseudo);
        ps.setString(2, motdepasse);
        ResultSet rs = ps.executeQuery();
		Id_User=rs.getString("id_ser");
		
		if(Id_User!=""){
			return Id_User;
		}
		else{
			return "Erreur de connection Pseudo / Mot De Passe";
		}
	}
	
	public String AddUser(String pseudo,String mdp,String nom,String prenom){
		
		String sql="SELECT id_user FROM user WHERE pseudo=?";
		Connection connection = db.getConnection();
		PrepareStatement ps=connection.prepareStatement(sql);
		ps.setString(1,pseudo);
		ResultSet rs = ps.executeQuery();
		if(rs.pseudo!=""){
			String sql="INSERT INTO User(pseudo,mdp,nom,prénom,montant) VALUES(?,?,?,?,5000);";
			Connection connection=db.getConnection();
			PrepareStatement ps=connection.prepareStatement(sql);
			ps.setString(1,pseudo);
			ps.setString(2,mdp);
			ps.setString(3,nom);
			ps.setString(4,prenom);
			ps.executeUpdate();
			return "Ajout dans la base OK";
		}
		else{
			return "Erreur , le pseudo existe deja !";
		}
		
		
		return "Test";

	}
	
	public String[] GetInfosUser(String id_user){
		
		String sql = "SELECT nom , prenom , id_historique , id_user , montant FROM user WHERE mdp=1";
		Connection connection = db.getConnection();
		PrepareStatement ps=connection.prepareStatement(sql);
		ps.setString(1,id_user);
		ResultSet rs=ps.executeQuery();
		String tableau[]={rs.getString("nom"),rs.getString("prenom"),rs.getString("id_historique"),rs.getString("id_user"),rs.getString("montant")};
		return tableau;
	}
	
	public void close(){
		db.close();
	}
}
