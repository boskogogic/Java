package org.unibl.etf.pj2.grad;

/**	@author Bosko Gogic
 *	@version 1.8 
 */

/** Klasa KontrolniPunkt koja ce mi posluziti za reprezentaciju kontrolnih punktova u gradu, sa svojim atributima i metodama */

import org.unibl.etf.pj2.stanovnistvo.*;

public class KontrolniPunkt {
	private double normalnaTemperatura;
	private double ocitanaTemperatura;
	// da li bi mogao ovde cuvati i poziciju Kontrolnog Punkta?
	
	/**	Podrazumijevani konstruktor i konstruktor sa parametrima */
	public KontrolniPunkt() {
	
	}
	
	public KontrolniPunkt(double normalnaTemperatura) {
		this.normalnaTemperatura = normalnaTemperatura;
		this.ocitanaTemperatura = 0;
	}
	
	/**	Standardne get i set metode */
	public void setNormalnaTemperatura(double normalnaTemperatura) {
		this.normalnaTemperatura = normalnaTemperatura;
	}
	
	public void setOcitanaTemperatura(double ocitanaTemperatura) {
		this.ocitanaTemperatura = ocitanaTemperatura;
	}
	
	public double getNormalnaTemperatura() {
		return normalnaTemperatura;
	}
	
	public double getOcitanaTemperatura() {
		return ocitanaTemperatura;
	}
	
	/**	Redefinisana toString metoda */
	public String toString() {
		return "Na kontrolnom punktu izmjerena je temperatura : " + ocitanaTemperatura;
	}
	//	DA li je u ovom slucaju uopste potrebno redefinisati to string, equals i hashcode metode?
	
	/**	Metoda koja sluzi za mjerenje temperature odredjenog stanovnika 
	*	Malo je problematicno bilo pisati ovu metodu s obzirom da mi je potrebna
	*	temperatura stanovnika, a to je tred, pa ga nemam unutar klase Stanovnik */

	public void provjeriTemperaturu(Stanovnik s) {
		this.ocitanaTemperatura = s.getTemperatura(); //da li ce ovde 'pokupiti' i dijete i odrasle i stare ? 
		
		try {
			if(ocitanaTemperatura > normalnaTemperatura) {
				System.out.println("Stanovnik " + s.getIme() + " " + s.getPrezime() + " " + s.getID() + " ima povisenu temperaturu!" );
				s.wait();
				System.out.println("Pozivamo ambulantna kola!");
			}
		
			else {
				System.out.println("Stanovnik " + s.getIme() + " " + s.getPrezime() + " " + s.getID() + " ima dozvoljenu temperaturu tijela!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	}

