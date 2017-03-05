package by.htp.game.entity;

import java.util.Scanner;

public class Human extends Player{
	private Scanner sc = new Scanner(System.in);
	
	@Override
	public String giveAnswer(char letter) {
		System.out.println("¬ведите город на букву - "+letter);
		answer = sc.nextLine();
		return answer.toUpperCase().replaceAll("-", "_");
	}
	
	public void closeScanner(){
		sc.close();
	}
		
}
