package n1exercici3.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import n1exercici3.utils.Constants;
import n1exercici3.utils.ReaderUtils;

public class PartidaHandler {
	
	private Map<String,String> countries = null;
	private List<String> randomKeys = null;
	
	public PartidaHandler() {
		super();
		this.countries = new HashMap<>();
		this.randomKeys = new ArrayList<>();
		carregarDades();
	}
	
	private void carregarDades() {
		
		ReaderUtils.llegirArxius(Constants.File.PATH, Constants.File.COUNTRIES_FILE, countries);
	}
	
	     
	public String agafarKeyAleatoria(){
		
		Object[] countriesKeys = countries.keySet().toArray();
		Object key = countriesKeys[new Random().nextInt(countriesKeys.length)];
		
		
		while(randomKeys.contains(key)) {
			key = countriesKeys[new Random().nextInt(countriesKeys.length)];
		}
		
		String keyStr = key.toString();
		randomKeys.add(keyStr);
		
		return keyStr;	
	}
	
	public String trobarCapital(String keyStr) {
		
		String capital = "";
		if(countries.containsKey(keyStr)) {
			capital = countries.get(keyStr);	
		}	
		return capital;
	}
		
}
