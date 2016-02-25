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
	
	public List<ArticleBean> getAllArticles(){
		List<ArticleBean> articles = new ArrayList<ArticleBean>();
		try {
			String sql = "SELECT * FROM article";
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
	
	public int addArticle(String name) {
		int status = 0;
		try {
			String sql = "INSERT INTO article (ref,prix,nom,img,description) VALUES ('',25,?,'','TESTDESCRIPT')";
			Connection connection = db.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, name);
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

}
