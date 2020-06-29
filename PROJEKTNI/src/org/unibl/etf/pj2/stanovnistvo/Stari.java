package org.unibl.etf.pj2.stanovnistvo;

import org.unibl.etf.pj2.grad.Grad;
import org.unibl.etf.pj2.grad.KontrolniPunkt;

/**	@author Bosko Gogic
 *	@version java 1.8
 */

/**	Klasa Stari koja sluzi za reprezentaciju dijela stanovnistva koje ima starosnu granicu od 65+ godina,
 *	u kojoj se nalaze odredjeni potrebni atributi i metode. 
 */

import org.unibl.etf.pj2.stanovnistvo.*;


public class Stari extends Stanovnik {
	Grad matrica;
	int pozicijaVrsta;
	int pozicijaKolona;
	
	/**	Podrazumijevani konstruktor i konstruktor sa paramterima */
	public Stari() {
		
	}
	
	public Stari(String ID, String ime, String prezime, String godinaRodjenja, String pol, String kucaID, Grad matrica, int pozicijaVrsta, int pozicijaKolona ) {
		super(ID,ime,prezime,godinaRodjenja,pol,kucaID);
		this.matrica = matrica;
		this.pozicijaVrsta = pozicijaVrsta;
		this.pozicijaKolona = pozicijaKolona;
	}
	
	/** Preklopljena toString() metoda*/
	@Override
	public String toString() {
		return "Grupa stanovnistva : Stari \n " + super.toString();
	}
	
	/**	Metoda za provjeru da li se u okolnim poljima nalazi Kontrolni Punkt */
	public boolean provjeriKonPunkt(int vrsta, int kolona) {
		if((("KP").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) || (("KP").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona))) || (("KP").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona))) || (("KP").equals(matrica.pristupiVrstiKoloni(vrsta, kolona+1))) || (("KP").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona-1))) || (("KP").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona+1))) || (("KP").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona-1))) || (("KP").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona+1))) ) {
			return true;
		}
		return false;
	}
	
	
	
	/**	Metoda za provjeru da li je negdje u blizini na nedozvoljenoj poziciji stanovnik */
	public boolean provjeriBlizinuStanovnika(int vrsta, int kolona) {
		if((("S").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona))) || (("KP").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta, kolona+1))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona-1))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona+1))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona-1))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona+1))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta+2, kolona+2))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta-2, kolona))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta+2, kolona))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-2))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta, kolona+2))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta-2, kolona-2))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta+2, kolona-2))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta-2, kolona+2))) ) {
			return true;
		}
		return false;
	}
	
	/**	Specificirane metode za provjere da li je stanovnik u blizini nekog od stanovnika u pravcu trenutnog smjera kretanja */
	public boolean provjeriLijevo(int vrsta, int kolona) {
		if((("S").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-2))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta-2, kolona-2))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta+2, kolona-2))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona-1))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona-1)))) {
			return true;
		}
		
		return false;
	}
	
	public boolean provjeriDesno(int vrsta, int kolona) {
		if((("S").equals(matrica.pristupiVrstiKoloni(vrsta, kolona+2))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta-2, kolona+2))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta+2, kolona+2))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta, kolona+1))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona+1))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona+1)))) {
			return true;
		}
		
		return false;
	}
	
	public boolean provjeriDole(int vrsta, int kolona) {
		if((("S").equals(matrica.pristupiVrstiKoloni(vrsta+2, kolona))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta+2, kolona-2))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta+2, kolona+2))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona-1))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona+1)))) {
			return true;
		}
		
		return false;
	}
	
	public boolean provjeriGore(int vrsta, int kolona) {
		if((("S").equals(matrica.pristupiVrstiKoloni(vrsta-2, kolona))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta-2, kolona+2))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta+2, kolona-2))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona-1))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona+1))) || (("S").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona)))) {
			return true;
		}
		
		return false;
	}
	

	/**	Redefinisana run metoda */
	@Override 
	public void run() {
		int vrsta = pozicijaVrsta;
		int kolona = pozicijaKolona;
		System.out.println("Stari " + super.getID() + " je na poziciji " + pozicijaVrsta + " " + pozicijaKolona + " i pocinje sa kretanjem!" ); //NAPOMENA -> Poziv metode super.metoda() !!
		int brojPredjenihPolja = 0;
		
		/**	Racunanje procenta koliko se moze kretati odredjeni stanovnik - PROVJERENO */
		int brojPolja = 3;
		
		/**	Objasnjenje -> smjer kretanja 1 - dole, 2 - lijevo, 3 - desno, 4 - gore */
		int smjerKretanja;
		smjerKretanja = (int)(Math.random() * 4);
		matrica.setMatricaGrada(vrsta, kolona, "S");
		
		/**	Slucaj kada izlazi iz kuce i pocinje kretanje dole! */
		if(smjerKretanja == 1) {
			while(brojPredjenihPolja < brojPolja) {
				int trenutnaVrsta = vrsta;
				int trenutnaKolona = kolona;
				
				/**	Provjera da li je u blizini kontrolni punkt */
				if((this.provjeriKonPunkt(vrsta, kolona))) {
					System.out.println("Stari " + super.getID() + " je naisao na Kontrolni punkt!");
					matrica.getKontrolniPunkt().provjeriTemperaturu(this);
				}
				
				/**	Provjera da li ima stanovnika u njegovoj neposrednoj blizini (ako se kojim slucajem nasao na 1 mjesto od trenutnog stanovnika */
				if((this.provjeriBlizinuStanovnika(vrsta, kolona))){				
					
					/**	Isti princip kao i sa promjenom smjera u slucaju da je ispred ambulanta ili kuca*/
					//if((("K").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) || (("A").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona)))) {
						/**	Preusmjeri ako je to moguce lijevo */
						if( (!(("K").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1))) && !(("A").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1)))) && !(this.provjeriLijevo(vrsta, kolona-1)) ) {
							System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta + " " + (kolona-1) + " krece se lijevo");
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "1"); // postavi proslo mjesto na slobodno!
							kolona--;
							brojPredjenihPolja++;
							trenutnaVrsta = vrsta;
							trenutnaKolona = kolona;
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //postavi novo mjesto na zauzeto!
						}
						
						/**	Ako je nemoguce lijevo onda probaj desno */
						else if ( (!(("K").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1))) && !(("A").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1)))) && !(this.provjeriDesno(vrsta, kolona-1))) {
							System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta + " " + kolona+1 + " krece se desno");
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "1"); //postavi proslo mjesto na slobodno!
							kolona++;
							brojPredjenihPolja++;
							trenutnaVrsta = vrsta;
							trenutnaKolona = kolona;
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //postavi novo mjesto na zauzeto
						}
						
						/*	U slucaju da je nemoguce ni u jednom smjeru ici */
						else {
							System.out.println("Stari " + super.getID() + " ne moze da nastavi kretanje!");
							brojPredjenihPolja = brojPolja;
						}
					}
				
				/**	Provjera da li je sledece polje slobodno polje*/
				if( (("1").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) && !(this.provjeriDole(vrsta, kolona)) ) {
					System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta+1 + " " + kolona + " krece se dole! ");
					vrsta++;
					matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "1"); //postavi proslo mjesto na slobodno!
					trenutnaVrsta = vrsta;
					trenutnaKolona = kolona;
					matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //postavi novo mjesto na zauzeto!
					brojPredjenihPolja++;
				}
				
				/**	Provjera da li je na sledecem polju i datom smjeru kuca ili ambulanta  */
				else if((("K").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) || (("A").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona)))) {
					/**	Preusmjeri ako je to moguce lijevo */
					if( (!(("K").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1))) && !(("A").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1)))) && !(this.provjeriLijevo(vrsta, kolona-1)) ) {
						System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta + " " + (kolona-1) + " krece se lijevo");
						matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "1"); // postavi proslo mjesto na slobodno!
						kolona--;
						brojPredjenihPolja++;
						trenutnaVrsta = vrsta;
						trenutnaKolona = kolona;
						matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //postavi novo mjesto na zauzeto!
					}
					
					/**	Ako je nemoguce lijevo onda probaj desno */
					else if ( (!(("K").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1))) && !(("A").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1)))) && !(this.provjeriDesno(vrsta, kolona-1))) {
						System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta + " " + kolona+1 + " krece se desno");
						matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "1"); //postavi proslo mjesto na slobodno!
						kolona++;
						brojPredjenihPolja++;
						trenutnaVrsta = vrsta;
						trenutnaKolona = kolona;
						matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //postavi novo mjesto na zauzeto
					}
					
					/*	U slucaju da je nemoguce ni u jednom smjeru ici */
					else {
						System.out.println("Stari " + super.getID() + " ne moze da nastavi kretanje!");
						brojPredjenihPolja = brojPolja;
					}
				}
				
				/**	Provjeri da li je dosao do rubnih dijelova matrice -> da li je ispred rubni dio, da li je lijevo ukoso da li je desno ukoso */
				if(("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona)) || ("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona-1)) || ("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona+1))) {
						if(("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) {
							System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta+1 + " " + kolona + " krece se dole");
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "2");//oslobodi proslo polje
							vrsta++;
							trenutnaVrsta = vrsta;
							trenutnaKolona=kolona;
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S");//zauzmi sledece polje
							brojPolja++;
						}
						
						/**	Ako ne moze vise dole ali moze lijevo */
						else if(!(("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) && ("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona-1)) ) {
							System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta + " " + (kolona-1) + " krece se lijevo");
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "2");//oslobodi proslo polje
							kolona--;
							trenutnaVrsta = vrsta;
							trenutnaKolona=kolona;
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S");//zauzmi sledece polje
							
							brojPolja++;
						}
						/**	Ako ne moze vise ni dole ni lijevo - moze desno */
						else {
							System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta + " " + kolona+1 + " krece se desno");
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "2");//oslobodi proslo polje
							kolona++;
							trenutnaVrsta = vrsta;
							trenutnaKolona=kolona;
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S");//zauzmi sledece polje
							brojPolja++;
						}
					}
				}
		
			
		
		/**	Slucaj kada izlazi iz kuce i pocinje kretanje lijevo! */
		if(smjerKretanja == 2) {
			while(brojPredjenihPolja < brojPolja) {
				int trenutnaVrsta = vrsta;
				int trenutnaKolona = kolona;
				
				/**	Provjera da li je u blizini kontrolni punkt */
				if((this.provjeriKonPunkt(vrsta, kolona))) {
					System.out.println("Stari " + super.getID() + " je naisao na Kontrolni punkt!");
					matrica.getKontrolniPunkt().provjeriTemperaturu(this);
				}
				
				/**	Provjera da li ima stanovnika u njegovoj neposrednoj blizini (ako se kojim slucajem nasao na 1 mjesto od trenutnog stanovnika */
				if((this.provjeriBlizinuStanovnika(vrsta, kolona))){				
					
						/**	Isti princip kao i sa promjenom smjera u slucaju da je ispred ambulanta ili kuca*/
						/**	Preusmjeri ako je to moguce dole */
						if( (!(("K").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) && !(("A").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona)))) && !(this.provjeriDole(vrsta+1, kolona)) ) {
							System.out.println("Stari" + super.getID() + " se nalazi na polju: " + vrsta+1 + " " + kolona + " krece se dole!");
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "1"); // postavi proslo mjesto na slobodno!
							vrsta++;
							brojPredjenihPolja++;
							trenutnaVrsta = vrsta;
							trenutnaKolona = kolona;
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //postavi novo mjesto na zauzeto!
						}
						
						/**	Ako je nemoguce dole onda probaj gore */
						else if ( (!(("K").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona))) && !(("A").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona)))) && !(this.provjeriDesno(vrsta-1, kolona))) {
							System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta + " " + kolona+1 + " krece se gore");
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "1"); //postavi proslo mjesto na slobodno!
							vrsta--;
							brojPredjenihPolja++;
							trenutnaVrsta = vrsta;
							trenutnaKolona = kolona;
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //postavi novo mjesto na zauzeto
						}
						
						/*	U slucaju da je nemoguce ni u jednom smjeru ici */
						else {
							System.out.println("Stari " + super.getID() + " ne moze da nastavi kretanje!");
							brojPredjenihPolja = brojPolja;
						}
					}
				
				/**	Provjera da li je sledece polje slobodno polje*/
				if( (("1").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1))) && !(this.provjeriLijevo(vrsta, kolona)) ) {
					System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta + " " + (kolona-1) + " krece se lijevo! ");
					kolona--;
					matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "1"); //postavi proslo mjesto na slobodno!
					trenutnaVrsta = vrsta;
					trenutnaKolona = kolona;
					matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //postavi novo mjesto na zauzeto!
					brojPredjenihPolja++;
				}
				
				/**	Ovde mozda i nisam morao provjeravati vezano za stanovnike jer vec na pocetku provjerim da li ima stanovnika u blizini */
				/**	Provjera da li je na sledecem polju i datom smjeru kuca ili ambulanta  */
				else if((("K").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1))) || (("A").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1)))) {
					/**	Preusmjeri ako je to moguce dole */
					if( (!(("K").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) && !(("A").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona)))) && !(this.provjeriDole(vrsta, kolona)) ) {
						System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta+1 + " " + kolona + " krece se lijevo");
						matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "1"); // postavi proslo mjesto na slobodno!
						vrsta++;
						brojPredjenihPolja++;
						trenutnaVrsta = vrsta;
						trenutnaKolona = kolona;
						matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //postavi novo mjesto na zauzeto!
					}
					
					/**	Ako je nemoguce dole onda probaj gore */
					else if ( (!(("K").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona))) && !(("A").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona)))) && !(this.provjeriDesno(vrsta, kolona))) {
						System.out.println("Stari " + super.getID() + " se nalazi na polju: " + (vrsta-1) + " " + kolona + " krece se desno");
						matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "1"); //postavi proslo mjesto na slobodno!
						vrsta--;
						brojPredjenihPolja++;
						trenutnaVrsta = vrsta;
						trenutnaKolona = kolona;
						matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //postavi novo mjesto na zauzeto
					}
					
					/*	U slucaju da je nemoguce ni u jednom smjeru ici */
					else {
						System.out.println("Stari " + super.getID() + " ne moze da nastavi kretanje!");
						brojPredjenihPolja = brojPolja;
					}
				}
				
				/**	Provjeri da li je dosao do rubnih dijelova matrice -> da li je ispred rubni dio, da li je lijevo ukoso da li je desno ukoso */
				if(("2").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1)) || ("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona-1)) || ("2").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona-1))) {
						if(("2").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1))) {
							System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta + " " + (kolona-1) + " krece se lijevo");
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "2");//oslobodi proslo polje
							kolona--;
							trenutnaVrsta = vrsta;
							trenutnaKolona=kolona;
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S");//zauzmi sledece polje
							brojPolja++;
						}
						
						/**	Ako ne moze vise lijevo preusmjeri dole */
						else if(!(("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) && ("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona)) ) {
							System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta + " " + (kolona-1) + " krece se dole");
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "2");//da se postavi proslo polje na slobodno
							vrsta++;
							trenutnaVrsta = vrsta;
							trenutnaKolona = kolona;
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S");//da se novo polje postavi na zauzeto
							brojPolja++;
						}
						/**	Ako ne moze vise ni dole ni lijevo - moze gore */
						else {
							System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta+1 + " " + kolona + " krece se gore");
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "2");//da se postavi proslo polje na slobodno
							vrsta--;
							trenutnaVrsta = vrsta;
							trenutnaKolona = kolona;
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //da se novo polje postavi na zauzeto
							brojPolja++;
						}
					}
				}
			}
		
		/**	Slucaj kada izlazi iz kuce i pocinje kretanje desno! */
		if(smjerKretanja == 3) {
			while(brojPredjenihPolja < brojPolja) {
				int trenutnaVrsta = vrsta;
				int trenutnaKolona = kolona;
				
				/**	Provjera da li je u blizini kontrolni punkt */
				if((this.provjeriKonPunkt(vrsta, kolona))) {
					System.out.println("Stari " + super.getID() + " je naisao na Kontrolni punkt!");
					matrica.getKontrolniPunkt().provjeriTemperaturu(this);
				}
				
				/**	Provjera da li ima stanovnika u njegovoj neposrednoj blizini (ako se kojim slucajem nasao na 1 mjesto od trenutnog stanovnika */
				if((this.provjeriBlizinuStanovnika(vrsta, kolona))){				
					
						/**	Isti princip kao i sa promjenom smjera u slucaju da je ispred ambulanta ili kuca*/
						/**	Preusmjeri ako je to moguce dole */
						if( (!(("K").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) && !(("A").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona)))) && !(this.provjeriDole(vrsta+1, kolona)) ) {
							System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta+1 + " " + kolona + " krece se dole!");
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "1"); // postavi proslo mjesto na slobodno!
							vrsta++;
							brojPredjenihPolja++;
							trenutnaVrsta = vrsta;
							trenutnaKolona = kolona;
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //postavi novo mjesto na zauzeto!
						}
						
						/**	Ako je nemoguce dole onda probaj gore */
						else if ( (!(("K").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona))) && !(("A").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona)))) && !(this.provjeriDesno(vrsta-1, kolona))) {
							System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta + " " + kolona+1 + " krece se gore");
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "1"); //postavi proslo mjesto na slobodno!
							vrsta--;
							brojPredjenihPolja++;
							trenutnaVrsta = vrsta;
							trenutnaKolona = kolona;
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //postavi novo mjesto na zauzeto
						}
						
						/*	U slucaju da je nemoguce ni u jednom smjeru ici */
						else {
							System.out.println("Stari " + super.getID() + " ne moze da nastavi kretanje!");
							brojPredjenihPolja = brojPolja;
						}
					}
				
				/**	Provjera da li je sledece polje slobodno polje*/
				if( (("1").equals(matrica.pristupiVrstiKoloni(vrsta, kolona+1))) && !(this.provjeriLijevo(vrsta, kolona)) ) {
					System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta + " " + (kolona+1) + " krece se lijevo! ");
					kolona++;
					matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "1"); //postavi proslo mjesto na slobodno!
					trenutnaVrsta = vrsta;
					trenutnaKolona = kolona;
					matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //postavi novo mjesto na zauzeto!
					brojPredjenihPolja++;
				}
				
				/**	Ovde mozda i nisam morao provjeravati vezano za stanovnike jer vec na pocetku provjerim da li ima stanovnika u blizini */
				/**	Provjera da li je na sledecem polju i datom smjeru kuca ili ambulanta  */
				else if((("K").equals(matrica.pristupiVrstiKoloni(vrsta, kolona+1))) || (("A").equals(matrica.pristupiVrstiKoloni(vrsta, kolona+1)))) {
					/**	Preusmjeri ako je to moguce dole */
					if( (!(("K").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) && !(("A").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona)))) && !(this.provjeriDole(vrsta, kolona)) ) {
						System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta+1 + " " + kolona + " krece se lijevo");
						matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "1"); // postavi proslo mjesto na slobodno!
						vrsta++;
						brojPredjenihPolja++;
						trenutnaVrsta = vrsta;
						trenutnaKolona = kolona;
						matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //postavi novo mjesto na zauzeto!
					}
					
					/**	Ako je nemoguce dole onda probaj gore */
					else if ( (!(("K").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona))) && !(("A").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona)))) && !(this.provjeriDesno(vrsta, kolona))) {
						System.out.println("Stari " + super.getID() + " se nalazi na polju: " + (vrsta-1) + " " + kolona + " krece se desno");
						matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "1"); //postavi proslo mjesto na slobodno!
						vrsta--;
						brojPredjenihPolja++;
						trenutnaVrsta = vrsta;
						trenutnaKolona = kolona;
						matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //postavi novo mjesto na zauzeto
					}
					
					/*	U slucaju da je nemoguce ni u jednom smjeru ici */
					else {
						System.out.println("Stari " + super.getID() + " ne moze da nastavi kretanje!");
						brojPredjenihPolja = brojPolja;
					}
				}
				
				/**	Provjeri da li je dosao do rubnih dijelova matrice -> da li je ispred rubni dio, da li je lijevo ukoso da li je desno ukoso */
				if(("2").equals(matrica.pristupiVrstiKoloni(vrsta, kolona+1)) || ("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona+1)) || ("2").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona+1))) {
						if(("2").equals(matrica.pristupiVrstiKoloni(vrsta, kolona+1))) {
							System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta + " " + (kolona+1) + " krece se lijevo");
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "2");//oslobodi proslo polje
							kolona++;
							trenutnaVrsta = vrsta;
							trenutnaKolona=kolona;
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S");//zauzmi sledece polje
							brojPolja++;
						}
						
						/**	Ako ne moze vise desno preusmjeri dole */
						else if(!(("2").equals(matrica.pristupiVrstiKoloni(vrsta, kolona+1))) && ("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona)) ) {
							System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta + " " + (kolona-1) + " krece se dole");
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "2");//da se postavi proslo polje na slobodno
							vrsta++;
							trenutnaVrsta = vrsta;
							trenutnaKolona = kolona;
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S");//da se novo polje postavi na zauzeto
							brojPolja++;
						}
						/**	Ako ne moze vise ni dole ni lijevo - moze gore */
						else {
							System.out.println("Stari " + super.getID() + " se nalazi na polju: " + (vrsta-1) + " " + kolona + " krece se gore");
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "2");//da se postavi proslo polje na slobodno
							vrsta--;
							trenutnaVrsta = vrsta;
							trenutnaKolona = kolona;
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //da se novo polje postavi na zauzeto
							brojPolja++;
						}
					}
				}
			}
		
		/**	Slucaj kada izlazi iz kuce i pocinje kretanje gore! */
		if(smjerKretanja == 4) {
			while(brojPredjenihPolja < brojPolja) {
				int trenutnaVrsta = vrsta;
				int trenutnaKolona = kolona;
				
				/**	Provjera da li je u blizini kontrolni punkt */
				if((this.provjeriKonPunkt(vrsta, kolona))) {
					System.out.println("Stari " + super.getID() + " je naisao na Kontrolni punkt!");
					matrica.getKontrolniPunkt().provjeriTemperaturu(this);
				}
				
				/**	Provjera da li ima stanovnika u njegovoj neposrednoj blizini (ako se kojim slucajem nasao na 1 mjesto od trenutnog stanovnika */
				if((this.provjeriBlizinuStanovnika(vrsta, kolona))){				
					
					/**	Isti princip kao i sa promjenom smjera u slucaju da je ispred ambulanta ili kuca*/
					//if((("K").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) || (("A").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona)))) {
						/**	Preusmjeri ako je to moguce lijevo */
						if( (!(("K").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1))) && !(("A").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1)))) && !(this.provjeriLijevo(vrsta, kolona-1)) ) {
							System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta + " " + (kolona-1) + " krece se lijevo");
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "1"); // postavi proslo mjesto na slobodno!
							kolona--;
							brojPredjenihPolja++;
							trenutnaVrsta = vrsta;
							trenutnaKolona = kolona;
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //postavi novo mjesto na zauzeto!
						}
						
						/**	Ako je nemoguce lijevo onda probaj desno */
						else if ( (!(("K").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1))) && !(("A").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1)))) && !(this.provjeriDesno(vrsta, kolona-1))) {
							System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta + " " + kolona+1 + " krece se desno");
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "1"); //postavi proslo mjesto na slobodno!
							kolona++;
							brojPredjenihPolja++;
							trenutnaVrsta = vrsta;
							trenutnaKolona = kolona;
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //postavi novo mjesto na zauzeto
						}
						
						/*	U slucaju da je nemoguce ni u jednom smjeru ici */
						else {
							System.out.println("Stari " + super.getID() + " ne moze da nastavi kretanje!");
							brojPredjenihPolja = brojPolja;
						}
					}
				
				/**	Provjera da li je sledece polje slobodno polje*/
				if( (("1").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona))) && !(this.provjeriGore(vrsta, kolona)) ) {
					System.out.println("Stari " + super.getID() + " se nalazi na polju: " + (vrsta-1) + " " + kolona + " krece se dole! ");
					vrsta--;
					matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "1"); //postavi proslo mjesto na slobodno!
					trenutnaVrsta = vrsta;
					trenutnaKolona = kolona;
					matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //postavi novo mjesto na zauzeto!
					brojPredjenihPolja++;
				}
				
				/**	Provjera da li je na sledecem polju i datom smjeru kuca ili ambulanta  */
				else if((("K").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona))) || (("A").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona)))) {
					/**	Preusmjeri ako je to moguce lijevo */
					if( (!(("K").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1))) && !(("A").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1)))) && !(this.provjeriLijevo(vrsta, kolona-1)) ) {
						System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta + " " + (kolona-1) + " krece se lijevo");
						matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "1"); // postavi proslo mjesto na slobodno!
						kolona--;
						brojPredjenihPolja++;
						trenutnaVrsta = vrsta;
						trenutnaKolona = kolona;
						matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //postavi novo mjesto na zauzeto!
					}
					
					/**	Ako je nemoguce lijevo onda probaj desno */
					else if ( (!(("K").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1))) && !(("A").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1)))) && !(this.provjeriDesno(vrsta, kolona-1))) {
						System.out.println("Odrasli " + super.getID() + " se nalazi na polju: " + vrsta + " " + kolona+1 + " krece se desno");
						matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "1"); //postavi proslo mjesto na slobodno!
						kolona++;
						brojPredjenihPolja++;
						trenutnaVrsta = vrsta;
						trenutnaKolona = kolona;
						matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S"); //postavi novo mjesto na zauzeto
					}
					
					/*	U slucaju da je nemoguce ni u jednom smjeru ici */
					else {
						System.out.println("Stari " + super.getID() + " ne moze da nastavi kretanje!");
						brojPredjenihPolja = brojPolja;
					}
				}
				
				/**	Provjeri da li je dosao do rubnih dijelova matrice -> da li je ispred rubni dio, da li je lijevo ukoso da li je desno ukoso */
				if(("2").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona)) || ("2").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona-1)) || ("2").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona+1))) {
						if(("2").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona))) {
							System.out.println("Stari " + super.getID() + " se nalazi na polju: " + (vrsta-1) + " " + kolona + " krece se dole");
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "2");//oslobodi proslo polje
							vrsta--;
							trenutnaVrsta = vrsta;
							trenutnaKolona=kolona;
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S");//zauzmi sledece polje
							brojPolja++;
						}
						
						/**	Ako ne moze vise dole ali moze lijevo */
						else if(!(("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) && ("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona-1)) ) {
							System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta + " " + (kolona-1) + " krece se lijevo");
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "2");//oslobodi proslo polje
							kolona--;
							trenutnaVrsta = vrsta;
							trenutnaKolona=kolona;
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S");//zauzmi sledece polje
							
							brojPolja++;
						}
						/**	Ako ne moze vise ni dole ni lijevo - moze desno */
						else {
							System.out.println("Stari " + super.getID() + " se nalazi na polju: " + vrsta + " " + kolona+1 + " krece se desno");
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "2");//oslobodi proslo polje
							kolona++;
							trenutnaVrsta = vrsta;
							trenutnaKolona=kolona;
							matrica.setMatricaGrada(trenutnaVrsta, trenutnaKolona, "S");//zauzmi sledece polje
							brojPolja++;
						}
					}
				}
			}
	
		
		}
	}
}
