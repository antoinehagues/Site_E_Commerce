package com.hitema.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		} catch (SQLException e) {
		}
		return article;
	}
	
	public void close() {
		db.close();
	}
}
