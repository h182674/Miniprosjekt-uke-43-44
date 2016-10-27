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

		// TODO
		
		throw new RuntimeException("Metode Spiller ikke implementert");
	}

	/**
	 * Konstrukt¯r der vi kan sette hvilken spiller det er (NORD, SYD eller
	 * INGEN).
	 * 
	 * @param spiller
	 *            hvilken spiller det er.
	 */
	public Spiller(Spillere spiller) {
		
		// TODO
		throw new RuntimeException("Metode Spiller ikke implementert");
	}

	@Override
	public int getAntallKort() {
		
		// TODO
		
		throw new RuntimeException("Metode getAntallKort ikke implementert");
	}

	@Override
	public Hand getHand() {
		
		// TODO
		
		throw new RuntimeException("Metode getHand ikke implementert");
	}

	public int getAntallTrekk() {
		
		// TODO
		
		throw new RuntimeException("Metode getAntallTrekk ikke implementert");
	}

	public Spillere hvem() {
		
		// TODO
		
		throw new RuntimeException("Metode hvem ikke implementert");
	}

	public void setAntallTrekk(int t) {
		
		// TODO
		
		throw new RuntimeException("Metode setAntallTrekk ikke implementert");
	}

	@Override
	public boolean erFerdig() {
		
		// TODO
		
		throw new RuntimeException("Metode erFerdig ikke implementert");
	}

	@Override
	public void leggTilKort(Kort kort) {
		
		// TODO
		
		throw new RuntimeException("Metode leggTilKort ikke implementert");
	}

	@Override
	public void fjernKort(Kort kort) {
		
		// TODO
		
		throw new RuntimeException("Metode fjernKort ikke implementert");
	}

	@Override
	public void fjernAlleKort() {
		
		// TODO
		
		throw new RuntimeException("Metode fjernAlleKort ikke implementert");
	}

	@Override
	public void trekker(Kort kort) {
		
		// TODO
		
		throw new RuntimeException("Metode trekker ikke implementert");
	}
}
