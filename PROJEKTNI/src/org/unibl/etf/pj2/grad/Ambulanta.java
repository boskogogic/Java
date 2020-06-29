package org.unibl.etf.pj2.grad;

/**	@author Bosko Gogic
 *	@version java 1.8
 */

/**	Klasa Ambulanta koja sluzi za predstavljanje Ambulante sa svojim atributima i metodama
 * (kapacitet ambulante, broj zarazenih, broj oporavljenih i slicno).
 */

import java.io.*;
import java.io.FileWriter;
import org.unibl.etf.pj2.stanovnistvo.*;

public class Ambulanta {
	private int brojStanovnika;
	private int brojZarazenih;
	private long kapacitet;
	private PrintWriter upis;
	
	/**	Podrazumijevani konstruktor i konstruktor sa parametrima */
	public Ambulanta() {
		
	}
	
	public Ambulanta(int brojStanovnika, int brojZarazenih, int kapacitet, String fajl) {
		this.brojStanovnika = brojStanovnika;
		//da li staviti unutar kosntruktora try blok ili kada se bude pravio objekat  ?
		upis = new PrintWriter(new BufferedWriter(new FileWriter(fajl)));
	}
	
	/**	Standardne set i get metode */
	public void setBrojStanovnika(int brojStanovnika) {
		this.brojStanovnika = brojStanovnika;
	}
	
	public void setBrojZarazenih(int brojZarazenih) {
		this.brojZarazenih = brojZarazenih;
	}
	
	public void setKapacitet(long kapacitet) {
		this.kapacitet = kapacitet;
	}
	public void setUpis(PrintWriter upis) {
		this.upis = upis;
	}
	
	public int getBrojStanovnika() {
		return brojStanovnika;
	}
	
	public int getBrojZarazenih() {
		return brojZarazenih;
	}
	
	public long getKapacitet() {
		return kapacitet;
	}
	
	public PrintWriter getUpis() {
		return upis;
	}
	
	/**	Metoda za racunanje i incijalizaciju kapacita */
	public void postaviKapacitet() {
		float x = 0f; 
		float y = 0f; /* pomocne promjenljive za racunanje postotka */
		
		int donjaGranica;
		int gornjaGranica;
		
		x = brojStanovnika / 10;
		y = brojStanovnika / 15;
		
		donjaGranica = Math.round(x);
		gornjaGranica = Math.round(y);
		
		kapacitet = Math.round((Math.random() * (gornjaGranica - donjaGranica) + donjaGranica));
	}
	
	/**	Metoda za upisivanje zarazenih u datoteku */
	public void upisiUDatoteku(Stanovnik s) {
		upis.print("Zarazen je: ");
		upis.print(s.getID() + " ");
		upis.print(s.getIme() + " ");
		upis.print(s.getPrezime() + " ");
		upis.print(s.getGodinaRodjenja() + " ");
		upis.print(s.getPol() + " ");
		upis.print(s.getKucaID() + " ");
		upis.println();
	}
	
	/*this.ID = ID;
		this.ime = ime;
		this.prezime = prezime;
		this.godinaRodjenja = godinaRodjenja;
		this.pol = pol;
		this.kucaID = kucaID;*/
}
	
	
	

