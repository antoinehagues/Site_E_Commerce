package com.hitema.panier;

import java.util.ArrayList;

import com.hitema.beans.ArticleBean;
import com.hitema.db.DBCommerceController;
import com.opensymphony.xwork2.ActionSupport;

public class PanierController extends ActionSupport{
	
	private DBCommerceController db = new DBCommerceController();
	private ArrayList<ArticleBean> articles;
	
	public String execute(){
		db.init();
		setArticles((ArrayList<ArticleBean>)db.getAllArticlesFromPanier());
		db.close();
		return "panier";
	}

	public ArrayList<ArticleBean> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<ArticleBean> articles) {
		this.articles = articles;
	}
}
