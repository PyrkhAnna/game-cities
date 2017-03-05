package by.htp.game.logic.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
//import java.util.TreeSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.htp.game.logic.CitiesReader;

public class FileCitiesReader implements CitiesReader{
	private final static Logger Log  = LogManager.getLogger();
	private Set<String> cities = new HashSet<String>();
	
	@Override
	public Set<String> readCities(String path) {
		Log.info("Cities is read from file");
		File file = new File(path);
		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)){
	  		String line;
	  		while((line = br.readLine())!= null){
	  			citiesFill(line);
	  		}
		} catch (FileNotFoundException e) {
			Log.info("File not found", e);
		} catch (IOException e) {
			Log.info("Exception at FileCitiesReader", e);
		}
		return cities;
	}
	
	private void citiesFill(String line) {
		String[]str = line.split(",");  
		for (int i = 0; i<str.length ;i++){
  			str[i]=str[i].trim();
  			cities.add(str[i]);
  		}
	}
}
