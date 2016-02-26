package com.hitema.login;

import com.hitema.beans.UserBean;
import com.hitema.db.DBUserController;
import com.opensymphony.xwork2.ActionSupport;

public class LoginController extends ActionSupport {
	
	private String pseudo;
	private DBUserController db = new DBUserController();
	private String motdepasse;
	private Boolean form=false;

	public String execute(){
		System.out.print("Passage dans login "+pseudo+" "+motdepasse);
		UserBean user=new UserBean();
		if(getForm()){
			db.init();
		    user=db.Connection(pseudo, motdepasse);
			db.close();
			if(user!=null){
				return "success";
			}
		}
		
	    return "loginUser";

		
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public boolean getForm() {
		return form;
	}

	public void setForm(boolean form) {
		this.form = form;
	}
}
