 package no.hib.dat100.prosjekt.kontroll;

import no.hib.dat100.prosjekt.modell.Hand;
import no.hib.dat100.prosjekt.modell.Kort;

/**
 * Abstrakt klasse som implementerer alle metodene i kontrakten ISpiller,
 * bortsett fra nesteHandling(). Dette er grunnen til at klassen er abstrakt.
 * For Â lage "virkelige" spillere, mÂ vi arve fra denne klassen og implmentere
 * nesteHandling (fra ISpiller).
 * 
 * Klassen har objektvariablene hand (Hand), antalltrekk (heltall) og spiller
 * (Spillere). Den har to konstrukt¯rer. Se beskrivelse av disse.
 * 
 */
public abstract class Spiller implements ISpiller {

	// Hand for spilleren
	private Hand hand;
	
	// antall trekk spilleren har gjort fra fra-bunken
	private int antalltrekk;
	
	// hvem spilleren er (Nord,Syd,Ingen) - se oppramsklassen Spillere
	private Spillere spiller;

	/**
	 * Standard konstrukt¯r som oppretter en Spiller med en hÂnd uten kort,
	 * antalltrekk som 0 og setter spiller til Spillere.INGEN.
	 */
	public Spiller() {

		hand = new Hand();
		antalltrekk = 0;
		spiller = Spillere.INGEN;
		
		//throw new RuntimeException("Metode Spiller ikke implementert");
	}

	/**
	 * Konstrukt¯r der vi kan sette hvilken spiller det er (NORD, SYD eller
	 * INGEN).
	 * 
	 * @param spiller
	 *            hvilken spiller det er.
	 */
	public Spiller(Spillere spiller) {
		
		hand = new Hand();
		antalltrekk = 0;
		this.spiller = spiller;
		
		
		//throw new RuntimeException("Metode Spiller ikke implementert");
	}

	@Override
	public int getAntallKort() {
		
		return hand.getAntalKort();
		
		//throw new RuntimeException("Metode getAntallKort ikke implementert");
	}

	@Override
	public Hand getHand() {
		
		return hand;
		
		//throw new RuntimeException("Metode getHand ikke implementert");
	}

	public int getAntallTrekk() {
		
		return antalltrekk;
		
		//throw new RuntimeException("Metode getAntallTrekk ikke implementert");
	}

	public Spillere hvem() {
		
		if (spiller == Spillere.NORD) {
			return spiller;
		} else if (spiller == Spillere.SYD) {
			return spiller;
		} else {
			return spiller;
		}
		
		//throw new RuntimeException("Metode hvem ikke implementert");
	}

	public void setAntallTrekk(int t) {
		
		this.antalltrekk = t;
		
		//throw new RuntimeException("Metode setAntallTrekk ikke implementert");
	}

	@Override
	public boolean erFerdig() {
		
		return hand.erTom();
		
		//throw new RuntimeException("Metode erFerdig ikke implementert");
	}

	@Override
	public void leggTilKort(Kort kort) {
		
		hand.leggTil(kort);
		
		//throw new RuntimeException("Metode leggTilKort ikke implementert");
	}

	@Override
	public void fjernKort(Kort kort) {
			if (hand.har(kort)) {
				hand.fjern(kort);				
			}
		
		// TODO: M� bruka equals() metoden fra Kort-klassen til � finna kortet som skal fjernast
		
		//throw new RuntimeException("Metode fjernKort ikke implementert");
	}

	@Override
	public void fjernAlleKort() {
		
		hand.fjernAlle();
		
		//throw new RuntimeException("Metode fjernAlleKort ikke implementert");
	}

	@Override
	public void trekker(Kort kort) {
		
		hand.leggTil(kort);
		antalltrekk++;
		
		//throw new RuntimeException("Metode trekker ikke implementert");
	}
}
