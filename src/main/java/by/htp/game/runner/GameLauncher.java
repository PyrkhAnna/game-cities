package by.htp.game.runner;

//import java.util.ResourceBundle;

import by.htp.game.logic.impl.CitiesGame;

public class GameLauncher {
	public static void main (String[] args) {
		//ResourceBundle.getBundle("log4j2");
		CitiesGame game= new CitiesGame();
		game.startGame();
		game.showResults();
	}

}
