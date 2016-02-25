package com.hitema.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hitema.beans.ArticleBean;

public class DBUtils {

	protected final static String ARTICLE_ID = "id_article";
	protected final static String ARTICLE_REF = "ref";
	protected final static String ARTICLE_PRIX = "prix";
	protected final static String ARTICLE_NAME = "nom";
	protected final static String ARTICLE_IMGURL = "img";
	
	public static ArticleBean getArticleFromResultSet(ResultSet rs) throws SQLException {
		ArticleBean article = new ArticleBean();
		while (rs.next()) {
			article.setId(rs.getString(ARTICLE_ID));
			article.setRef(rs.getString(ARTICLE_REF));
			article.setPrix(rs.getString(ARTICLE_PRIX));
			article.setNom(rs.getString(ARTICLE_NAME));
			article.setImgURL(rs.getString(ARTICLE_IMGURL));
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
			articles.add(article);
		}
		return articles;
	}

}
