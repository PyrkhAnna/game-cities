package by.htp.game.logic;

public interface AnswerChecker {
	boolean answerAlreadyWasGiven(String answer);
	boolean answerExist(String answer);
	boolean answerBeginsWell(String answer);
}
