package com.hitema.article;

import com.hitema.beans.ArticleBean;
import com.hitema.db.DBCommerceController;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleController extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private DBCommerceController db = new DBCommerceController();
	private ArticleBean article;
	
	public String execute(){
		db.init();
		setArticle(db.getArticleById(id));
		db.close();
		return "article";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArticleBean getArticle() {
		return article;
	}

	public void setArticle(ArticleBean article) {
		this.article = article;
	}
}
