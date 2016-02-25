package com.hitema.beans;

public class ArticleBean {
	
	public ArticleBean() {
	}
	
	private String id;
	private String ref;
	private String prix;
	private String nom;
	private String imgURL;
	private String description;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	
	@Override
	public String toString() {
		return "ArticleBean [id=" + id + ", ref=" + ref + ", prix=" + prix + ", nom=" + nom + ", imgURL=" + imgURL
				+ "]";
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
