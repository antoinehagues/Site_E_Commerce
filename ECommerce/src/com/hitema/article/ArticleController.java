package com.hitema.article;

import com.hitema.beans.ArticleBean;
import com.hitema.db.DBCommerceController;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleController extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private int articleNumber;
	private DBCommerceController db = new DBCommerceController();
	private ArticleBean article;
	
	public String execute(){
		db.init();
		setArticle(db.getArticleById(id));
		db.close();
		return "article";
	}

	public String addToPanier(){
		db.init();
		int status = db.addArticleToPanier(id, (int)articleNumber, "1");
		db.close();
		if(status > 0){
			return "addToPanier";
		}
		return "addToPanier";
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

	public int getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}
}
