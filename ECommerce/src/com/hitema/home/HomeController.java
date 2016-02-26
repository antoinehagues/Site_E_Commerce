package com.hitema.home;

import java.util.ArrayList;
import java.util.Map;

import com.hitema.beans.ArticleBean;
import com.hitema.beans.UserBean;
import com.hitema.db.DBCommerceController;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HomeController extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private DBCommerceController db = new DBCommerceController();
	private ArrayList<ArticleBean> articles;
	private ActionContext request =ActionContext.getContext();
	
	public String execute(){
		db.init();
		setArticles((ArrayList<ArticleBean>)db.getAllArticles("2"));
		db.close();
		Map session = (Map) getRequest().get("session");
		UserBean user = (UserBean) session.get("User");
		System.out.println(session.toString());
		
		if(user != null){
			System.out.println("User :"+user.getNom());
		}
		return "home";
	}

	public ArrayList<ArticleBean> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<ArticleBean> articles) {
		this.articles = articles;
	}

	public ActionContext getRequest() {
		return request;
	}

	public void setRequest(ActionContext request) {
		this.request = request;
	}

}
