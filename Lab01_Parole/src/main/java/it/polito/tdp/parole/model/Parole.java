package it.polito.tdp.parole.model;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Parole {
		
	TreeMap<String, String> parole = new TreeMap<String, String>();
	
	public Parole() {
		//TODO
	}
	
	public void addParola(String p) {
		parole.put(p, p);
	}
	
	public List<String> getElenco() {
		List<String> temp = new LinkedList<String>(parole.values());
		return temp;
	}
	
	public void reset() {
		parole.clear();
	}

	public void remove(String selectedText) {
		parole.remove(selectedText);
		
	}

}
