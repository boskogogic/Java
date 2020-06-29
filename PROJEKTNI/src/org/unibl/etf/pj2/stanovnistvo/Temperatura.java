package org.unibl.etf.pj2.stanovnistvo;

/**	@author Bosko Gogic
*	@version java 1.8	 
*/

/**	Klasa Temperatura koja predstavlja odvojenu nit za generisanje temperature kod svakog stanovnika.
 *	Temperatura se slucajno generise na svako 30 sekundi.
 */

public class Temperatura extends Thread {
	private double trenutnaTemperatura;
	
	/**	Podrazumijevani konstruktor*/
	public Temperatura() {
		
	}
	
	/**	Standardna get metoda */
	public double getTrenutnaTemperatura() {
		return trenutnaTemperatura;
	}
	
	/**	Metoda run koja sluzi za pokretanje treda */
	public void run() {
		int min = 36;
		int max = 43;
		/**	Provjereno u odvojenom zadatku! */
		double randomDouble = ((Math.random() * (max - min))) + min;
					//System.out.println("Random generisan broj je: " + randomInt);
		trenutnaTemperatura = randomDouble;
		try {
			Thread.sleep(30_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	//Da li je ovo pametno uraditi ? Jer je ovo predlozio kompajler!
	} 
	
	
}
