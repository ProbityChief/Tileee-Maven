package fr.dawan.tileee.bean;

import javax.persistence.Id;

public class Invitation extends DbObject{
	@Id
	private int issuer_id;
	private int receiver_id;
	private String tag_name;
	
	public int getIssuer_id() {
		return issuer_id;
	}
	public void setIssuer_id(int issuer_id) {
		this.issuer_id = issuer_id;
	}
	public int getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(int receiver_id) {
		this.receiver_id = receiver_id;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
}
