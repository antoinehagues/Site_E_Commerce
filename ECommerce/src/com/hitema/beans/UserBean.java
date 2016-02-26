package com.hitema.beans;

public class UserBean {
	
	private String nom;
	private String prenom;
	private String pseudo;
	private String montant;
	private String id;
	private String historique;
	@Override
	public String toString() {
		return "UserBean [nom=" + nom + ", prenom=" + prenom + ", pseudo=" + pseudo + ", montant=" + montant + ", id="
				+ id + "]";
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getMontant() {
		return montant;
	}
	public void setMontant(String montant) {
		this.montant = montant;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHistorique() {
		return historique;
	}
	public void setHistorique(String historique) {
		this.historique = historique;
	}

}
