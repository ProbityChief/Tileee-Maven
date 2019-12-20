package fr.dawan.tileee.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Card extends DbObject{

	
	private long user_id;
	private String word;
	private String translation;
	private String starting_language;
	private String ending_language;
	private double value;
	
	@ManyToMany(mappedBy="cards")
	private Set<Tag> tags = new HashSet<>();
	
	
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
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
