package by.htp.game.entity;

public abstract class Player {
	protected String answer;
	
	public abstract  String giveAnswer(char letter);
	
	public char returnLetterForNextAnswerer (String city){
		int index= city.length()-1;;
		if (city.charAt(index)=='�'&&city.charAt(index)=='�'&&city.charAt(index)=='�')
			 index = city.length()-2;
		return city.charAt(index);
	}
}
