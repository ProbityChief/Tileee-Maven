package fr.dawan.tileee.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User extends DbObject {
	
	
	private String login;
	private String password;
	private String mail;
	private Date registrationdate;
	private boolean validation;
	private String hashcode;
	
   
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getRegistrationdate() {
		return registrationdate;
	}
	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}
	public boolean isValidation() {
		return validation;
	}
	public void setValidation(boolean validation) {
		this.validation = validation;
	}
	public String getHashcode() {
		return hashcode;
	}
	public void setHashcode(String hashcode) {
		this.hashcode = hashcode;
	}
}
