package com.hitema.article;

import com.hitema.db.DBCommerceController;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleCreationController extends ActionSupport{

	private String name;
	private String ref;
	private String prix;
	private String description;
	private Boolean form = false;
	private DBCommerceController db = new DBCommerceController();
	
	public String execute(){
		int status = 0;
		if(getForm()){
			db.init();
			status = db.addArticle(this.getName(), this.getRef(), this.getPrix(), this.getDescription());  
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


	public String getRef() {
		return ref;
	}


	public void setRef(String ref) {
		this.ref = ref;
	}


	public String getPrix() {
		return prix;
	}


	public void setPrix(String prix) {
		this.prix = prix;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
}
