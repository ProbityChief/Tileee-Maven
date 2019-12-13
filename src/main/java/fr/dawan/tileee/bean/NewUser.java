package fr.dawan.tileee.bean;

public class NewUser {
	private String name;
	private String mail;
	private String password;
	private String rand;
    private boolean validation;

	public NewUser(String name, String mail, String password) {
		super();
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.rand = null;
		this.validation = false;
	}
	
	public String getRand() {
		return rand;
	}
	
	public void setRand(String rand) {
		this.rand = rand;
	}
	
	public Boolean getValidation() {
		return validation;
	}
	public void setValidation(Boolean validation) {
		this.validation = validation;
	}
	public NewUser() {
		// TODO Auto-generated constructor stub
	}

	public NewUser(String name2, String password2) {
		super();
		this.name = name2;
		this.mail = null;
		this.password = password2;
		this.validation = false;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
