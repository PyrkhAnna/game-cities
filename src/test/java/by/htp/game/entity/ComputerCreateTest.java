package by.htp.game.entity;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import by.htp.game.logic.impl.FileCitiesReader;
import by.htp.game.logic.impl.PlayerAnswerChecker;


public class ComputerCreateTest {
	private static PlayerAnswerChecker checker;
	private static Set<String> answer;
	
	@BeforeClass
	public static void initComputer(){
		ResourceBundle bundleRu = ResourceBundle.getBundle("log4j2");
		FileCitiesReader rf=new FileCitiesReader();
		String path = bundleRu.getString("path.read");
		answer = new HashSet<String>(rf.readCities(path));
		checker = new PlayerAnswerChecker(answer);
	}
	@Test
	public void testComputerCreate() {
		Computer comp = new Computer(checker);
		assertNotNull(comp);
	}

}
