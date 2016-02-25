package com.hitema.home;

import java.util.ArrayList;
import com.hitema.beans.ArticleBean;
import com.hitema.db.DBCommerceController;
import com.opensymphony.xwork2.ActionSupport;

public class HomeController extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private DBCommerceController db = new DBCommerceController();
	private ArrayList<ArticleBean> articles;
	
	public String execute(){
		db.init();
		setArticles((ArrayList<ArticleBean>)db.getAllArticles());
		db.close();
		return "home";
	}

	public ArrayList<ArticleBean> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<ArticleBean> articles) {
		this.articles = articles;
	}

}
