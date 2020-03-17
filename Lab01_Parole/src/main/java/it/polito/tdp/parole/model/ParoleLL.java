package it.polito.tdp.parole.model;

import java.util.LinkedList;
import java.util.List;

public class ParoleLL implements Comparable<String>{

	List<String> parole = new LinkedList<String>();

	public ParoleLL() {
		// TODO
	}

	public void addParola(String p) {
		parole.add(p);
	}

	public List<String> getElenco() {
		return parole;
	}

	public void reset() {
		parole.clear();
	}

	public void remove(String selectedText) {
		parole.remove(selectedText);

	}

	@Override
	public int compareTo(String o) {
		return this.compareTo(o);
	}

}
