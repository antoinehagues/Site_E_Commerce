package com.hitema.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hitema.beans.UserBean;

public class DBUserController {
	
	private DBController db ;
	
	public void init(){
		db = new DBController();
	}
	
	public UserBean Connection (String pseudo , String motdepasse){
		String Id_User;
		UserBean user=new UserBean();
		try {
		String sql = "SELECT * FROM user WHERE pseudo=? AND mdp=?";
		Connection connection = db.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, pseudo);
        ps.setString(2, motdepasse);
        ResultSet rs = ps.executeQuery();
		Id_User=rs.getString("id_user");
		if(Id_User!=""){
			UserBean userBean = DBUtils.getUserFromResultSet(rs);
			rs.close();
			return userBean;
		}
		
		} catch (SQLException e) {}
		return null;
		
	}
	
	public String AddUser(String pseudo,String mdp,String nom,String prenom){
		try {
		String sql="SELECT id_user FROM user WHERE pseudo=?";
		Connection connection = db.getConnection();
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1,pseudo);
		ResultSet rs = ps.executeQuery();
		if(rs.getString(pseudo)!=""){
			String sql1="INSERT INTO User(pseudo,mdp,nom,prénom,montant) VALUES(?,?,?,?,5000);";
			Connection connection1=db.getConnection();
			PreparedStatement ps1=connection1.prepareStatement(sql1);
			ps1.setString(1,pseudo);
			ps1.setString(2,mdp);
			ps1.setString(3,nom);
			ps1.setString(4,prenom);
			ps1.executeUpdate();
			rs.close();
			return "Ajout dans la base OK";
		}
		else{
			return "Erreur , le pseudo existe deja !";
		}
		}
		catch (SQLException e) {}
		
		return null;
	}
	
	public String[] GetInfosUser(String id_user){
		try{
		String sql = "SELECT nom , prenom , id_historique , id_user , montant FROM user WHERE mdp=1";
		Connection connection = db.getConnection();
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1,id_user);
		ResultSet rs=ps.executeQuery();
		String tableau[]={rs.getString("nom"),rs.getString("prenom"),rs.getString("id_historique"),rs.getString("id_user"),rs.getString("montant")};
		rs.close();
		return tableau;
		}
		catch (SQLException e) {}
		
		return null;
		
	}
	
	public void close(){
		db.close();
	}
}
