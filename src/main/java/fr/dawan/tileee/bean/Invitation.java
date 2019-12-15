package fr.dawan.tileee.bean;

public class Invitation{
	private int idgiver;
	private String tag;
	
	public int getIdGiver() {
		return idgiver;
	}

	public void setIdGiver(int idgiver) {
		this.idgiver = idgiver;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public Invitation(int idgiver, String tag) {
		super();
		this.idgiver = idgiver;
		this.tag = tag;
	}

	public Invitation() {
		super();
	}
}
