package by.htp.game.entity;

import java.util.HashSet;
//import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import by.htp.game.logic.impl.PlayerAnswerChecker;

public class Computer extends Player{
	private PlayerAnswerChecker checker;
	private Set<String> citiesBase;
	private Set<String> citiesWasAnswered;
	public Computer(PlayerAnswerChecker checker){
		this.checker=checker;
		//citiesBase= new HashSet<String>();
		
	}
	@Override
	public String giveAnswer(char letter) {
		citiesBase=new HashSet<String>(checker.getCitiesBase());
		citiesWasAnswered=new HashSet<String>(checker.getCitiesWasAnswered());
		Iterator<String> iterator = citiesBase.iterator();
		boolean flag=false;
		while (iterator.hasNext()&&!flag){
			answer=iterator.next();
			citiesWasAnswered.add(answer);
			if (answer.charAt(0)==letter) {
				flag=true; 
				
				
				//checker.setCitiesBase(citiesBase);
				}
			iterator.remove();
		}
		if (flag==false) answer = null;
		//checker.setCitiesBase(citiesBase);
		return answer;
	}
	

	

	
}
