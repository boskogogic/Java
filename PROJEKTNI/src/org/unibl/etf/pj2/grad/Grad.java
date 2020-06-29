package org.unibl.etf.pj2.grad;

/**@author Bosko Gogic
*  @version java 1.8
*/

/**	Klasa Grad koja predstavlja reprezentaciju grada u obliku kvadratne matrice koja se samostalno generise izmedju
 *	brojeva 15 i 30.
 */
import org.unibl.etf.pj2.grad.*;

public class Grad {
	private String[][] matricaGrada;
	private int brojVrsta;
	private int brojKolona;
	KontrolniPunkt kontrolniPunkt;
	
	/**	Podrazumijevani konstruktor i konstruktor sa parametrima*/
	public Grad() {
		
	}
	
	/**	U main metodi se na slucajan nacin generisu brojevi koji predstavljaju vrstu i kolonu*/
	public Grad(int brojVrsta, int brojKolona, KontrolniPunkt kontrolniPunkt) {
		this.brojVrsta = brojVrsta;
		this.brojKolona = brojKolona;
		matricaGrada = new String[brojVrsta][brojKolona];
		this.kontrolniPunkt = kontrolniPunkt;
	}
	
	/**	Standardne get i set metode */
	public String[][] getMatrica() {
		return matricaGrada;
	}
	
	public int getBrojVrsta() {
		return brojVrsta;
	}
	
	public int getBrojKolona() {
		return brojKolona;
	}
	
	public KontrolniPunkt getKontrolniPunkt() {
		return kontrolniPunkt;
	}
	
	public void setMatricaGrada(int vrsta, int kolona, String s) {
		matricaGrada[vrsta][kolona] = s;
	}
	/**	Metoda za pristup i - tom i j - tom mjestu u matrici */
	public String pristupiVrstiKoloni(int i, int j) {
		return matricaGrada[i][j];
	}
	
	/**	Redefinisana toString() metoda*/
	@Override
	public String toString() {
		return "Matrica grada" + "\nBroj vrsti: " + this.getBrojVrsta() + "\nBroj Kolona: " + this.getBrojKolona();
	}
	
}
