package com.hitema.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hitema.beans.ArticleBean;

public class DBCommerceController{

	private DBController db;
	
	public void init(){
		db = new DBController();
	}
	
	public ArticleBean getArticleById(String id){
		ArticleBean article = new ArticleBean();
		try {
			String sql = "SELECT * FROM article WHERE id_article = ?";
			Connection connection = db.getConnection();
	        PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			article = DBUtils.getArticleFromResultSet(rs);
			rs.close();
			connection.close();
		} catch (SQLException e) {
		}
		return article;
	}
	
	public List<ArticleBean> getAllArticles(String userId){
		List<ArticleBean> articles = new ArrayList<ArticleBean>();
		try {
			String sql = "SELECT * FROM article WHERE id_user = ?";
			Connection connection = db.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			articles = DBUtils.getAllArticlesFromResultSet(rs);
			rs.close();
			connection.close();
		} catch (SQLException e) {
		}
		return articles;
	}
	
	public int addArticle(String name, String ref, String prix, String description) {
		int status = 0;
		try {
			String sql = "INSERT INTO article (ref,prix,nom,img,description) VALUES (?,?,?,'',?)";
			Connection connection = db.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, ref);
			ps.setString(2, prix);
			ps.setString(3, name);
			ps.setString(4, description);
			status=ps.executeUpdate(); ;
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public void close() {
		db.close();
	}

	public int addArticleToPanier(String id, int articleNumber, String userId) {
		int status = 0;
		try {
			String sql = "INSERT INTO panier (id_article,id_user,qte) VALUES (?,?,?)";
			Connection connection = db.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, userId);
			ps.setString(3, "2");
			status=ps.executeUpdate(); ;
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public ArrayList<ArticleBean> getAllArticlesFromPanier() {
		List<ArticleBean> articles = new ArrayList<ArticleBean>();
		try {
			String sql = "SELECT * FROM panier WHERE";
			Connection connection = db.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			articles = DBUtils.getAllArticlesFromResultSet(rs);
			rs.close();
			connection.close();
		} catch (SQLException e) {
		}
		return articles;
	}

}
