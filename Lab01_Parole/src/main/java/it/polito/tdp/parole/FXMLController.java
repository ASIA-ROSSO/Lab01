package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;
import it.polito.tdp.parole.model.ParoleAL;
import it.polito.tdp.parole.model.ParoleLL;

import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Parole elenco;
	ParoleLL elencoLL;
	ParoleAL elencoAL;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextArea txtTempo;

	@FXML
	private Button btnCancella;

	@FXML
	private TextField txtParola;

	@FXML
	private Button btnInserisci;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnReset;

	@FXML
	void doInsert(ActionEvent event) {
		//elenco.addParola(txtParola.getText());
		//elencoLL.addParola(txtParola.getText());
		
		double start = System.nanoTime();
		elencoAL.addParola(txtParola.getText());
		double stop = System.nanoTime();
		
		List<String> temp = new LinkedList<String>(elencoAL.getElenco());
		Collections.sort(temp);
		
		String s1 = "";
		for (String s : temp) {
			if (s1.equals("")) {
				s1 += s;
			} else {
				s1 += "\n" + s;
			}
		}
		txtParola.clear();
		txtResult.setText(s1);
		
		//Long l = System.nanoTime();
		txtTempo.setText(""+(stop-start)/1e9);
	}

	@FXML
	void doReset(ActionEvent event) {
		elencoAL.reset();
		txtResult.clear();
		
		Long l = System.nanoTime();
		txtTempo.setText(Long.toString(l));
	}

	@FXML
    void holdCancella(ActionEvent event) {
    elencoAL.remove(txtResult.getSelectedText());
    String s1 = "";
	for (String s : elencoAL.getElenco()) {
		if (s1.equals("")) {
			s1 += s;
		} else {
			s1 += "\n" + s;
		}
	}
	txtParola.clear();
	txtResult.setText(s1);
	
	Long l = System.nanoTime();
	txtTempo.setText(Long.toString(l));
    
    }

	@FXML
	void initialize() {
		assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'Scene.fxml'.";
		elenco = new Parole();
		elencoLL = new ParoleLL();
		elencoAL = new ParoleAL();
	}
}
