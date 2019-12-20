package fr.dawan.tileee.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "tags")
public class Tag extends DbObject{
	private String tag_name;
	private long card_id;
	@ManyToMany
	private Set<Card> cards = new HashSet<>();

	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	public long getCard_id() {
		return card_id;
	}
	public void setCard_id(long card_id) {
		this.card_id = card_id;
	}
}
