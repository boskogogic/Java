package org.unibl.etf.pj2.stanovnistvo;

/**	@author Bosko Gogic
*	@version java 1.8
*/

/**	Klasa Djeca koja sluzi za reprezentaciju dijela stanovnistva starosne granice do 18 godina sa svojim atributima 
 * 	i odredjenim metodama.
 */
import org.unibl.etf.pj2.stanovnistvo.*;
import org.unibl.etf.pj2.grad.*;

public class Djeca extends Stanovnik {
	Grad matrica;
	int pozicijaVrsta;
	int pozicijaKolona;
	
	/**	Podrazumijevani konstruktor i konstruktor sa paramterima */
	public Djeca() {
		
	}
	
	public Djeca(String ID, String ime, String prezime, String godinaRodjenja, String pol, String kucaID, Grad matrica, int pozicijaVrsta, int pozicijaKolona) {
		super(ID,ime,prezime,godinaRodjenja,pol,kucaID);
		this.matrica = matrica;
		this.pozicijaVrsta = pozicijaVrsta;
		this.pozicijaKolona = pozicijaKolona;
	}
	
	/** Preklopljena toString() metoda*/
	@Override
	public String toString() {
		return "Grupa stanovnistva : Djeca \n " + super.toString();
	}
	
	/**	Standardne get i set metode */
	public int getPozicijaVrsta() {
		return pozicijaVrsta;
	}
	
	public int getPozicijaKolona() {
		return pozicijaKolona;
	}
	
	public void setPozicijaVrsta(int i) {
		pozicijaVrsta = i;
	}
	
	public void setPozicijaKolona(int j) {
		pozicijaKolona = j;
	}
	
	/**	Metoda za provjeru da li se u okolnim poljima nalazi Kontrolni Punkt */
	public boolean provjeriKonPunkt(int vrsta, int kolona) {
		if((("KP").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) || (("KP").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona))) || (("KP").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona))) || (("KP").equals(matrica.pristupiVrstiKoloni(vrsta, kolona+1))) || (("KP").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona-1))) || (("KP").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona+1))) || (("KP").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona-1))) || (("KP").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona+1))) ) {
			return true;
		}
		return false;
	}
	
	//(("KP").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona+1)))
 	
	/**	Redefinisana metoda run za pokretanje niti Djeca*/
	@Override
	public void run() {
		System.out.println("Dijete " + super.getID() + " je na poziciji " + pozicijaVrsta + " " + pozicijaKolona + " i pocinje sa kretanjem!" ); //NAPOMENA -> Poziv metode super.metoda() !!
		int vrsta = pozicijaVrsta;
		int kolona = pozicijaKolona;
		int brojPolja = 0;
		/**	Objasnjenje -> smjer kretanja 1 - dole, 2 - lijevo, 3 - desno, 4 - gore */
		int smjerKretanja;
		smjerKretanja = (int)(Math.random() * 4);
		
		/**	Slucaj kada izlazi iz kuce i pocinje kretanje prema dole! */
		if(smjerKretanja == 1) {
			/**	Demonstrativno postavio sam da se dijete krece 5 polja */
			while(brojPolja < 5) {
				/**	Provjera za Kontrolni Punkt */
				if((this.provjeriKonPunkt(vrsta, kolona))) {
					matrica.getKontrolniPunkt().provjeriTemperaturu(this);
				}
				/**	Provjera da li je dijete na slobodnom polju, da li je KP(kontrolni punkt) polje od njega*/
				if((("1").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) /*&& !(this.provjeriKonPunkt(vrsta, kolona))*/) {
					System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + vrsta+1 + " " + kolona + " krece se prema dole");
					vrsta++;
					brojPolja++;
					}
				
				/**	Provjera da li je na sledecem polju i datom smjeru kuca ili ambulanta */
				else if((("K").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) || (("A").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona)))) {
					/**	Preusmjeri ako je to moguce lijevo */
					if(!(("K").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1))) && !(("A").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1))) ) {
						System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + vrsta + " " + (kolona-1) + " krece se lijevo");
						kolona--;
						brojPolja++;
					}
					/**	Ako je nemoguce lijevo onda idi desno */
					else {
						System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + vrsta + " " + kolona+1 + " krece se desno");
						kolona++;
						brojPolja++;
					}
				}
				
				/**	Provjeri da li je dosao do rubnih dijelova matrice -> da li je ispred rubni dio, da li je lijevo ukoso da li je desno ukoso */
				if(("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona)) || ("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona-1)) || ("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona+1))) {
						if(("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) {
							System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + vrsta+1 + " " + kolona + " krece se dole");
							vrsta++;
							brojPolja++;
						}
						
						/**	Ako ne moze vise dole ali moze lijevo */
						else if(!(("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) && ("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona-1)) ) {
							System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + vrsta + " " + (kolona-1) + " krece se lijevo");
							kolona--;
							brojPolja++;
						}
						/**	Ako ne moze vise ni dole ni lijevo - moze desno */
						else {
							System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + vrsta + " " + kolona+1 + " krece se desno");
							kolona++;
							brojPolja++;
						}
					}
				}
			}
		
		
		
		/**	Slucaj kada dijete izlazi iz kuce i zapocinje kretanje lijevo */
		if(smjerKretanja == 2) {
				/**	Demonstrativno postavio sam da se dijete krece 5 polja */
				while(brojPolja < 5) {
					/** Provjerava da li je u blizini Kontrolni Punkt */
					if((this.provjeriKonPunkt(vrsta, kolona))) {
						System.out.println("Dijete " + super.getID() + " je naislo na kontrolni punkt!");
						matrica.getKontrolniPunkt().provjeriTemperaturu(this);
					}
					
					/**	Provjera da li je sledece polje slobodno polje*/
					if((("1").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1))) /*&& !(this.provjeriKonPunkt(vrsta, kolona))*/) {
						System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + vrsta + " " + (kolona-1) + " krece se lijevo!");
						kolona--;
						brojPolja++;
						}
					
					/**	Provjera da li je na sledecem polju i datom smjeru kuca ili ambulanta */
					else if((("K").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1))) || (("A").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1)))) {
						/**	Preusmjeri ako je to moguce dole */
						if(!(("K").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) && !(("A").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) ) {
							System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + vrsta+1 + " " + kolona + " krece se dole");
							vrsta++;
							brojPolja++;
						}
						/**	Ako je nemoguce dole onda idi gore*/
						else {
							System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + (vrsta-1) + " " + kolona + " krece se gore");
							vrsta--;
							brojPolja++;
						}
					}
					/**	Provjeri da li je dosao do rubnih dijelova matrice -> da li je ispred rubni dio, da li je lijevo dole da li je desno gore */
					if(("2").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1)) || ("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona+1)) || ("2").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona+1))) {
							if(("2").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1))) {
								System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + vrsta+1 + " " + kolona + " krece se dole");
								kolona--;
								brojPolja++;
							}
							
							/**	Ako ne moze vise lijevo ali moze dole*/
							else if(!(("2").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1))) && ("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona)) ) {
								System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + vrsta + " " + (kolona-1) + " krece se dole");
								vrsta++;
								brojPolja++;
							}
							/**	Ako ne moze vise ni lijevo ni dole nego samo gore */
							else {
								System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + (vrsta-1) + " " + kolona + " krece se gore");
								vrsta--;
								brojPolja++;
							}
						}
					}
				}
		
		/**	Slucaj kada dijete izlazi iz kuce i zapocinje kretanje desno */
		if(smjerKretanja == 3) {
				/**	Demonstrativno postavio sam da se dijete krece 5 polja */
				while(brojPolja < 5) {
					
					/** Provjerava da li je u blizini Kontrolni Punkt */
					if((this.provjeriKonPunkt(vrsta, kolona))) {
						matrica.getKontrolniPunkt().provjeriTemperaturu(this);
					}
					
					/**	Provjera da li je sledece polje slobodno polje*/
					if((("1").equals(matrica.pristupiVrstiKoloni(vrsta, kolona+1))) /*&& !(this.provjeriKonPunkt(vrsta, kolona))*/) {
						System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + vrsta + " " + (kolona+1) + " krece se desno!");
						kolona++;
						brojPolja++;
						}
					
					/**	Provjera da li je na sledecem polju i datom smjeru kuca ili ambulanta */
					else if((("K").equals(matrica.pristupiVrstiKoloni(vrsta, kolona+1))) || (("A").equals(matrica.pristupiVrstiKoloni(vrsta, kolona+1)))) {
						/**	Preusmjeri ako je to moguce dole */
						if(!(("K").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) && !(("A").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona))) ) {
							System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + vrsta+1 + " " + kolona + " krece se dole");
							vrsta++;
							brojPolja++;
						}
						
						/**	Ako je nemoguce dole onda idi gore*/
						else {
							System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + (vrsta-1) + " " + kolona + " krece se gore");
							vrsta--;
							brojPolja++;
						}
					}
					/**	Provjeri da li je dosao do rubnih dijelova matrice -> da li je ispred rubni dio, da li je lijevo gore da li je desno dole */
					if(("2").equals(matrica.pristupiVrstiKoloni(vrsta, kolona+1)) || ("2").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona+1)) || ("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona+1))) {
							if(("2").equals(matrica.pristupiVrstiKoloni(vrsta, kolona+1))) {
								System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + vrsta + " " + kolona+1 + " krece se desno");
								kolona++;
								brojPolja++;
							}
							
							/**	Ako ne moze vise desno ali moze dole*/
							else if(!(("2").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1))) && ("2").equals(matrica.pristupiVrstiKoloni(vrsta+1, kolona)) ) {
								System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + vrsta+1 + " " + kolona + " krece se dole");
								vrsta++;
								brojPolja++;
							}
							/**	Ako ne moze vise ni lijevo ni dole nego samo gore */
							else {
								System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + (vrsta-1) + " " + kolona + " krece se desno");
								vrsta--;
								brojPolja++;
							}
						}
					}
				}
		
		/**	Kada je smjer kretanja gore */
		if(smjerKretanja == 4) {
			/**	Demonstrativno postavio sam da se dijete krece 5 polja */
			while(brojPolja < 5) {
				/**	Provjera za Kontrolni Punkt */
				if((this.provjeriKonPunkt(vrsta, kolona))) {
					matrica.getKontrolniPunkt().provjeriTemperaturu(this);
				}
				
				/**	Provjera da li je kontrolni punkt u blizini */
				if((("1").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona))) /*&& !(this.provjeriKonPunkt(vrsta, kolona))*/) {
					System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + (vrsta-1) + " " + kolona + " krece se prema gore");
					vrsta--;
					brojPolja++;
					}
				
				/**	Provjera da li je na sledecem polju i datom smjeru kuca ili ambulanta */
				else if((("K").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona))) || (("A").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona)))) {
					/**	Preusmjeri ako je to moguce lijevo */
					if(!(("K").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1))) && !(("A").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1))) ) {
						System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + vrsta + " " + (kolona-1) + " krece se lijevo");
						kolona--;
						brojPolja++;
					}
					/**	Ako je nemoguce lijevo onda idi desno */
					else {
						System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + vrsta + " " + kolona+1 + " krece se desno");
						kolona++;
						brojPolja++;
					}
				}
				/**	Provjeri da li je dosao do rubnih dijelova matrice -> da li je ispred rubni dio, da li je lijevo ukoso da li je desno ukoso */
				if(("2").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona)) || ("2").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona-1)) || ("2").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona+1))) {
						if(("2").equals(matrica.pristupiVrstiKoloni(vrsta-1, kolona))) {
							System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + (vrsta-1) + " " + kolona + " krece se gore");
							vrsta--;
							brojPolja++;
						}
						
						/**	Ako ne moze vise gore ali moze lijevo */
						else if(!(("2").equals(matrica.pristupiVrstiKoloni(vrsta, kolona))) && ("2").equals(matrica.pristupiVrstiKoloni(vrsta, kolona-1)) ) {
							System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + vrsta + " " + (kolona-1) + " krece se lijevo");
							kolona--;
							brojPolja++;
						}
						/**	Ako ne moze vise ni dole ni lijevo - moze desno */
						else {
							System.out.println("Dijete " + super.getID() + " se nalazi na polju: " + vrsta + " " + kolona+1 + " krece se desno");
							kolona++;
							brojPolja++;
						}
					}
				}
			}
		}
}


	

