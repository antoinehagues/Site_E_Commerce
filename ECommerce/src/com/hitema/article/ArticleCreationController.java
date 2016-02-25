package com.hitema.article;

import com.hitema.db.DBCommerceController;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleCreationController extends ActionSupport{

	private String name;
	private Boolean form = false;
	private DBCommerceController db = new DBCommerceController();
	
	public String execute(){
		int status = 0;
		if(getForm()){
			db.init();
			status = db.addArticle(this.getName());  
			db.close();
		}
	    if(status>0){
	    	return "success";
	    }
	    return "createArticle";
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Boolean getForm() {
		return form;
	}

	public void setForm(Boolean form) {
		this.form = form;
	}
}
