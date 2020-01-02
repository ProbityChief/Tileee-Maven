package fr.dawan.tileee.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invitations")
public class Invitation extends DbObject{
	private int issuer_id;
	private int receiver_id;
	private String tag_name;
	private String rand;
	
	public int getIssuer_id() {
		return issuer_id;
	}
	public void setIssuer_id(int issuer_id) {
		this.issuer_id = issuer_id;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	public String getRand() {
		return rand;
	}
	public void setRand(String rand) {
		this.rand = rand;
	}
	public int getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(int receiver_id) {
		this.receiver_id = receiver_id;
	}
	
}
