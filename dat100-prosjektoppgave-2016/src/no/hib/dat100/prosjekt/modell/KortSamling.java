package no.hib.dat100.prosjekt.modell;

import java.util.ArrayList;
import java.util.Random;

/**
 * Struktur for Â lagre ei samling kort. Kan lagre hele kortstokken. Det finnes
 * konstanter i klassen som angir antall kort i hver av de 4 fargene. NÂr
 * programmet er ferdig settes denne til 13, men under utvikling / testing kan
 * det vÊre praktisk Â ha denne mindre.
 * 
 */
public abstract class KortSamling {

	public static final int MAKS_KORT_FARGE = 3;
	private final int MAKS_KORT = 4 * MAKS_KORT_FARGE;

	// tabell for representasjon av samling av kort
	private Kort[] samling;
	
	// index p� forste ledige plass
	private int forsteledig;

	/**
	 * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken).
	 */
	public KortSamling() {
		
		// TODO
		throw new RuntimeException("Metode KortSamling ikke implementert");
	}

	/**
	 * Sjekker om samlinga er tom.
	 * 
	 * @return true om samlinga er tom, false ellers.
	 */
	public boolean erTom() {
		
		// TODO
		throw new RuntimeException("Metode erTom ikke implementert");
	}

	/**
	 * Returnerer en tabell med kortene i samlinga. Tabellen trenger ikke vÊre
	 * full. Kortene ligger sammenhengende fra starten av tabellen. Kan fÂ
	 * tilgang til antallet ved Â bruke metoden getAntallKort(). Metoden er
	 * f¯rst og fremst ment Â brukes i eventuelle subklasser. Om man trenger
	 * kortene utenfor arvehierarkiet, anbefales metoden toArrayList().
	 * 
	 * @return tabell av kort.
	 */
	public Kort[] getSamling() {
		
		// TODO
		throw new RuntimeException("Metode getSamling ikke implementert");
	}

	/**
	 * Antall kort i samlingen.
	 * 
	 * @return antall kort i samlinga.
	 */
	public int getAntalKort() {
		
		// TODO
		
		throw new RuntimeException("Metode getAntalKort ikke implementert");
	}

	/**
	 * Legger alle korta (hele kortstokken) til samlnga. Korta vil vÊre sortert
	 * slik at de normalt mÂ stokkes f¯r bruk.
	 */
	public void leggTilAlle() {
		// Hint: Kortfarge.values() gir en tabell med alle kortfarger	
		
		// TODO
		
		throw new RuntimeException("Metode leggTilAlle ikke implementert");
	}

	/**
	 * Fjerner alle korta fra samlinga slik at den blir tom.
	 */
	public void fjernAlle() {
		
		// TODO
		
		throw new RuntimeException("Metode fjernAlle ikke implementert");
	}

	/**
	 * Legg et kort til samlinga.
	 * 
	 * @param kort
	 *            er kortet som skal leggast til.
	 */
	public void leggTil(Kort kort) {
		
		// TODO
		
		throw new RuntimeException("Metode leggTil ikke implementert");
	}

	/**
	 * Ser pÂ siste kortet i samlinga.
	 * 
	 * @return siste kortet i samlinga, men det blir ikke fjernet.
	 */
	public Kort seSiste() {
		
		// TODO
		
		throw new RuntimeException("Metode seSiste ikke implementert");
	}

	/**
	 * Tek ut siste kort fra samlinga.
	 * 
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort taSiste() {
		
		// TODO
		
		throw new RuntimeException("Metode taSiste ikke implementert");
	}

	/**
	 * Unders¯ker om et kort finst i samlinga.
	 * 
	 * @param kort.
	 * 
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	public boolean har(Kort kort) {
		
		// TODO
		
		throw new RuntimeException("Metode har ikke implementert");
	}

	/**
	 * Fjernar et kort frÂ samlinga. Dersom kortet ikke finnest i samlinga,
	 * skjer ingenting.
	 * 
	 * @param kort
	 *            kortet som skal fjernast. Dersom kortet ikke finnes, skjer
	 *            ingenting.
	 */
	public void fjern(Kort kort) {
		// Hint: finn forst ut hvor kortet er i samlingen hvis det finnes 
		
		// TODO
		
		// Hint: fjern kortet - men husk kortet kan sitte p� en plass i midten
		
		// TODO
		
		throw new RuntimeException("Metode fjernKort ikke implementert");
	}

	/**
	 * Stokkar en kortsamling ved å bytte rundt på kort 
	 */
	public void stokk() {
		// Hint: en mulighet er bruk av klassen Random for � generere tilfeldige index
		
		// TODO
		
		throw new RuntimeException("Metode stokk ikke implementert");
	}

	/**
	 * Gir kortene som en ArrayList.
	 * 
	 * @return samlinga av kort som en ArrayList. Korta vil ha samme rekkef¯lge
	 *         som i kortsamlinga.
	 */
	public ArrayList<Kort> toArrayList() {
		ArrayList<Kort> list = new ArrayList<Kort>();
		
		// Hint: legg hvert kort fra samling over i arraylisten list
		
		// TODO
		
		throw new RuntimeException("Metode ArrayList ikke implementert");
	}
}
