package org.unibl.etf.pj2.stanovnistvo;

/**	@author Bosko Gogic
*	@version java 1.8	 
*/

/** Klasa Stanovnik koja sluzi za reprezentaciju jednog stanovnika, a koju ce nasljedjivati specificniji tipovi
 *	klasa kao sto su klasa Djeca, Odrasli ili Stari. Ovo ce biti standardna Java - bin klasa. 
 *	
 *	NAPOMENA! -> DOPUNITI klasu sa temperaturom tj. tredom!!
 */

import org.unibl.etf.pj2.stanovnistvo.*;

public class Stanovnik extends Thread {
	private String ID;
	private String ime;
	private String prezime;
	private String godinaRodjenja; //ili moze neki tip Date ?
	private String pol; //ili bi moglo tipa boolean -> true muskarac false zena
	private String kucaID;
	private Temperatura temperatura; //temperatura ce biti tred - nit!
	
	/**	Podrazumijevani konstruktor i konstruktor sa parametrima */
	public Stanovnik() {
		
	}
	
	/**	Sta uraditi sa temperaturomom, sto se tice konstruktora i svega ? */
	public Stanovnik(String ID, String ime, String prezime, String godinaRodjenja, String pol, String kucaID) {
		this.ID = ID;
		this.ime = ime;
		this.prezime = prezime;
		this.godinaRodjenja = godinaRodjenja;
		this.pol = pol;
		this.kucaID = kucaID;
	}
	
	/**	Standardne get i set metode */
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	
	public void setGodinaRodjenja(String godinaRodjenja) {
		this.godinaRodjenja = godinaRodjenja;
	}
	
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	public void setKucaID(String kucaID) {
		this.kucaID = kucaID;
	}
	
	public String getID() {
		return ID;
	}
	
	
	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}
	
	public String getGodinaRodjenja() {
		return godinaRodjenja;
	}
	
	public String getPol() {
		return pol;
	}
	
	public String getKucaID() {
		return kucaID;
	}
	
	public double getTemperatura() {
		return temperatura.getTrenutnaTemperatura();
	}
	
	/**	Preklopljena toString() metoda */
	@Override
	public String toString() {
		return "ID: " + ID + "\nIme: " + ime + "\nPrezime " + prezime + "\nGodina rodjenja: " + godinaRodjenja + "\nPol: " + pol + "\nTemperatura " + "\nKuca ID: " + kucaID;
	}
	
	/**	Preklopljena equals metoda zajedno sa hash code metodom*/
	@Override
	public boolean equals(Object obj) {
		boolean rezultat = false;
		if(obj == this) {
			return true;
		}
		
		if(!(obj instanceof Stanovnik)) {
			return false;
		}
		else {
			Stanovnik s = (Stanovnik)obj;
			rezultat = ID.equals(s.ID) && ime.equals(s.ime) && prezime.equals(s.prezime) && godinaRodjenja.equals(s.godinaRodjenja) && pol.equals(s.pol) && kucaID.equals(s.kucaID);
		}
		return rezultat;
	}
	
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 7 * hash + ID.hashCode();
		hash = 7 * hash + ime.hashCode();
		hash = 7 * hash + prezime.hashCode();
		hash = 7 * hash + godinaRodjenja.hashCode();
		hash = 7 * hash + pol.hashCode();
		hash = 7 * hash + kucaID.hashCode();
		return hash;
	}
	
	/**	Implementacija metode run koja nece imati konkretnu svrhu u ovoj klasi
	 *	ali cu je redefinisati u klasama nasljednicama (Djeca, Stari, Odrasli)
	 */
	public void run() {
		System.out.println("Pokretanje...");
	}
}
	
	


