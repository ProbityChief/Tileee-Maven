package fr.dawan.tileee.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private Set<Card> cards = new HashSet<>();
	private String rand; 

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}

	public void addCard(Card card) {
		this.cards.add(card);
	}

	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
}
