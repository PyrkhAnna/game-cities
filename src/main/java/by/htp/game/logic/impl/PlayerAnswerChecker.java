package by.htp.game.logic.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//import java.util.TreeSet;
import by.htp.game.logic.AnswerChecker;

public class PlayerAnswerChecker implements  AnswerChecker{
	private Set<String> citiesBase ;//= new HashSet<String>();
	private Set<String> citiesWasAnswered;
	private char letter;
	//firstLetterIsTheSame()
	
	public PlayerAnswerChecker(Set<String> citiesBase) {
		this.citiesBase = citiesBase;
		citiesWasAnswered = new HashSet<String>();
	}
	@Override
	public boolean answerBeginsWell(String answer) {
		return answer.charAt(0)== letter;
	}
	@Override
	public boolean answerAlreadyWasGiven(String answer) {
		return !citiesWasAnswered.add(answer);
	}
	@Override
	public boolean answerExist(String answer) {
		return !citiesBase.add(answer);
	}
	
	public void removeCity(String city) {
		Iterator<String> iterator = citiesBase.iterator();
		while (iterator.hasNext()){
			if(iterator.next().equals(city)) {
				iterator.remove();break;
			}
		}
	}
	public Set<String> getCitiesBase() {
		return citiesBase;
	}
	public void setCitiesBase(Set<String> citiesBase) {
		this.citiesBase = citiesBase;
	}
	public Set<String> getCitiesWasAnswered() {
		return citiesWasAnswered;
	}
	public void setCitiesWasAnswered(Set<String> citiesWasAnswered) {
		this.citiesWasAnswered = citiesWasAnswered;
	}
	public char getLetter() {
		return letter;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}
	
	
	

}
