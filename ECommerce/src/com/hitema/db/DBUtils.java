package com.hitema.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hitema.beans.ArticleBean;
import com.hitema.beans.UserBean;

public class DBUtils {

	protected final static String ARTICLE_ID = "id_article";
	protected final static String ARTICLE_REF = "ref";
	protected final static String ARTICLE_PRIX = "prix";
	protected final static String ARTICLE_NAME = "nom";
	protected final static String ARTICLE_IMGURL = "img";
	protected final static String ARTICLE_DESCRIPTION = "description";
	protected final static String USER_NOM = "nom";
	protected final static String USER_PRENOM = "prenom";
	protected final static String USER_MONTANT = "montant";
	protected final static String USER_PSEUDO= "pseudo";
	protected final static String USER_ID= "id";
	protected final static String USER_HISTORIQUE = "historique";
	
	public static ArticleBean getArticleFromResultSet(ResultSet rs) throws SQLException {
		ArticleBean article = new ArticleBean();
		while (rs.next()) {
			article.setId(rs.getString(ARTICLE_ID));
			article.setRef(rs.getString(ARTICLE_REF));
			article.setPrix(rs.getString(ARTICLE_PRIX));
			article.setNom(rs.getString(ARTICLE_NAME));
			article.setImgURL(rs.getString(ARTICLE_IMGURL));
			article.setDescription(rs.getString(ARTICLE_DESCRIPTION));
		}
		return article;
	}

	public static List<ArticleBean> getAllArticlesFromResultSet(ResultSet rs) throws SQLException {
		List<ArticleBean> articles = new ArrayList<ArticleBean>();
		while(rs.next()){
			ArticleBean article = new ArticleBean();
			article.setId(rs.getString(ARTICLE_ID));
			article.setRef(rs.getString(ARTICLE_REF));
			article.setPrix(rs.getString(ARTICLE_PRIX));
			article.setNom(rs.getString(ARTICLE_NAME));
			article.setImgURL(rs.getString(ARTICLE_IMGURL));
			article.setDescription(rs.getString(ARTICLE_DESCRIPTION));
			articles.add(article);
		}
		return articles;
	}

	public static UserBean getUserFromResultSet(ResultSet rs) throws SQLException{
		UserBean user= new UserBean();
		while (rs.next()) {
			user.setNom(rs.getString(USER_NOM));
			user.setPrenom(rs.getString(USER_PRENOM));
			user.setPseudo(rs.getString(USER_PSEUDO));
			user.setId(rs.getString(USER_ID));
			user.setMontant(rs.getString(USER_MONTANT));
			user.setHistorique(rs.getString(USER_HISTORIQUE));
		}
		return user;
	}

}
