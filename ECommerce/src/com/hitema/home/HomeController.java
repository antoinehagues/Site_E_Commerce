package com.hitema.home;

import com.hitema.beans.ArticleBean;
import com.hitema.db.DBCommerceController;

public class HomeController {

	DBCommerceController db = new DBCommerceController();
	
	public String execute(){
		ArticleBean article;
		db.init();
		article = db.getArticleById("1");
		db.close();
		System.out.println(article.toString());
		return "home";
	}
}
