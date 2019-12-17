package fr.dawan.tileee.bean;

import javax.persistence.Id;

public class Card extends DbObject{
	@Id
	private long card_id;
	private long user_id;
	private String word;
	private String translation;
	private String starting_language;
	private String ending_language;
	private double value;
	
	public long getCard_id() {
		return card_id;
	}
	public void setCard_id(long card_id) {
		this.card_id = card_id;
	}
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
