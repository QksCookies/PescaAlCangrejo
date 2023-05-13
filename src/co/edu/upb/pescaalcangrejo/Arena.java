package co.edu.upb.pescaalcangrejo;

import javax.swing.JLabel;

public class Arena extends JLabel{
	private int indice = 0; 
		
	public int getIndice() {
		return indice;
	}
	
	public Arena(int indice) {
		super();
		this.indice = indice;
		this.setText("");
	}
}
