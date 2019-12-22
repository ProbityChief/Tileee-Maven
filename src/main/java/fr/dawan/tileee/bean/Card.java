package fr.dawan.tileee.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cards")
public class Card extends DbObject{	
	private String word;
	private String translation;
	private String starting_language;
	private String ending_language;
	private double value;
	@ManyToOne
	private User user;
	@ManyToMany(mappedBy="cards")
	private Set<Tag> tags = new HashSet<>();

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getTranslation() {
		return translation;
	}
	public void setTranslation(String translation) {
		this.translation = translation;
	}
	public String getStarting_language() {
		return starting_language;
	}
	public void setStarting_language(String starting_language) {
		this.starting_language = starting_language;
	}
	public String getEnding_language() {
		return ending_language;
	}
	public void setEnding_language(String ending_language) {
		this.ending_language = ending_language;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
}
