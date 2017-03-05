package by.htp.game.logic.impl;

import java.util.ResourceBundle;
import by.htp.game.entity.Computer;
import by.htp.game.entity.Human;
import by.htp.game.entity.Player;
import by.htp.game.logic.Game;

public class CitiesGame implements Game {
	private Human human;
	private Computer computer;
	private PlayerAnswerChecker checker;
	private int mistakes;
	private int round;
	private int relay;
	private String answer;
	
	public CitiesGame() {
		ResourceBundle bundleRu = ResourceBundle.getBundle("log4j2");
		FileCitiesReader rf=new FileCitiesReader();
		String path = bundleRu.getString("path.read");
		human = new Human();
		checker = new PlayerAnswerChecker(rf.readCities(path));
		computer = new Computer(checker);
		mistakes=0;
		round=0;
		relay=1;
	}
	
	@Override
	public void startGame(){
		welcomToGame();
		boolean flag = false;
		do{
			System.out.println("Назовите город на букву - "+checker.getLetter());
			relayPlayer();
			if (mistakes>=3||answer==null) {
				gameOver();
				flag = true;
			}
		}while(!flag);
		
	}

	@Override
	public void showResults(){
		System.out.println("Города были названы:"+checker.getCitiesWasAnswered().toString());
		System.out.println("Сыграно раундов:"+round);
	}
	private void oneMove(Player player){
		answer = getCorrectAnswerOrDie(checker.getLetter(), player);
		char lastLetter = player.returnLetterForNextAnswerer(answer);
		checker.removeCity(answer);
		checker.setLetter(lastLetter);
		System.out.println("Ответ игрока: "+answer);
	}
	private void welcomToGame(){
		System.out.println("Начнем игру! Первый город будет - Ангора! Для выхода сделайте 3 ошибки!");
		checker.answerAlreadyWasGiven("АНГОРА");
		checker.setLetter('А');
	}
	private String getCorrectAnswerOrDie(char letter, Player player) {
		boolean flag = false;
		do {
			answer = player.giveAnswer(letter);
			if (answer!=null&&!checkAnswer(answer)&&relay==2) mistakes++;
				else flag = true;
		}while (mistakes<3&&!flag);
		return answer;
	}
	
	private boolean checkAnswer(String answer){
		if (!checker.answerBeginsWell(answer)) {
			System.out.println("Не соответствует предыдущему городу! Попробуйте еще раз!");
			return false;
		} 
		if (checker.answerAlreadyWasGiven(answer)) {
			System.out.println("Такой город уже был! Попробуйте еще раз!");
			return false;
		}
		if (!checker.answerExist(answer)) {
			System.out.println("Такого города нет в базе! Попробуйте еще раз!");
			return false;
		} else return true;
		
	}
	private void relayPlayer(){
		switch(relay){
			case 1: 
				oneMove(computer);
				relay=2;
				break;
			case 2:
				oneMove(human);
				relay=1;
				round++;
				break;
		}
	}		
	private void gameOver(){
		System.out.println("Игра окончена!");
		human.closeScanner();
	}
}
