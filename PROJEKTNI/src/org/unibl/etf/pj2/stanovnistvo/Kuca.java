package org.unibl.etf.pj2.stanovnistvo;

/**	@author Bosko Gogic
 *	@version java 1.8
 */


/**	Klasa Kuca koja sluzi za predstavljanje kuce u kojoj zivi odredjena porodica. 
*/

import org.unibl.etf.pj2.stanovnistvo.*;
import java.util.*;


public class Kuca {
	private String kucaID;
	private int brojUkucana;
	//private ArrayList<Stanovnik> ukucani; mozda bude mozda i ne bude trebalo
	
	/**	Podrazumijevani konstruktor i konstruktor sa parametrima */
	public Kuca() {
		
	}
	
	public Kuca(String kucaID, int brojacUkucana) {
		this.kucaID = kucaID;
		this.brojUkucana = brojacUkucana;
		//this.ukucani = new ArrayList();
	}
	
	/**	Standardne get i set metode */
	public String getKucaID() {
		return kucaID;
	}
	
	public int getBrojUkucana() {
		return brojUkucana;
	}
	
	public void setKucaID(String kucaID) {
		this.kucaID = kucaID;
	}
	
	public void setBrojUkucana(int brojUkucana) {
		this.brojUkucana = brojUkucana;
	}
	
	/** Redefinisana toString metoda */
	@Override
	public String toString() {
		return "ID kuce: " + kucaID + "\nTrenutni broj ukucana: " + brojUkucana;
	}
	
	/**	Redefinisana equals zajedno sa hashCode metodom*/
	@Override
	public boolean equals(Object obj) {
		boolean rezultat = false;
		
		if(obj == this) {
			return true;
		}
		if(!(obj instanceof Kuca)) {
			return false;
		}
		else {
			Kuca k = (Kuca)obj;
			rezultat = kucaID.equals(k.kucaID);
		}
		
		return rezultat;
	}
	
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 7 * hash + kucaID.hashCode();
		return hash;
	}
}
	

	

	
	


