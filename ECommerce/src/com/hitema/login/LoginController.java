package com.hitema.login;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.hitema.beans.UserBean;
import com.hitema.db.DBUserController;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginController extends ActionSupport {
	
	private String pseudo;
	private DBUserController db = new DBUserController();
	private String motdepasse;
	private Boolean form=false;
	private ActionContext request =ActionContext.getContext();

	public String execute(){
		System.out.print("Passage dans login "+pseudo+" "+motdepasse);
		UserBean user=new UserBean();
		if(getForm()){
			db.init();
		    user=db.Connection(pseudo, motdepasse);
			db.close();
			if(user!=null){
				Map session = (Map) getRequest().get("session");
				session.put("User", user);
			
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

	public ActionContext getRequest() {
		return request;
	}

	public void setRequest(ActionContext request) {
		this.request = request;
	}

	
}
