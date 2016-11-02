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

	// variabel som blir brukt til metodane har(Kort) og fjern(Kort)
	int indexSisteKortSjekket = -1;

	/**
	 * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken).
	 */
	public KortSamling() {
		samling = new Kort[MAKS_KORT];
		// throw new RuntimeException("Metode KortSamling ikke implementert");
	}

	/**
	 * Sjekker om samlinga er tom.
	 * 
	 * @return true om samlinga er tom, false ellerst.
	 */
	public boolean erTom() {
		boolean tom = true;
		for (int i = 0; i < samling.length; i++) {
			if (samling[i] != null) {
				tom = false;
				break;
			}
		}
		return tom;
		// throw new RuntimeException("Metode erTom ikke implementert");
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
		return samling;
		// throw new RuntimeException("Metode getSamling ikke implementert");
	}

	/**
	 * Antall kort i samlingen.
	 * 
	 * @return antall kort i samlinga.
	 */
	public int getAntalKort() {
		return forsteledig;

		// throw new RuntimeException("Metode getAntalKort ikke implementert");
	}

	/*
	 * Legger alle korta (hele kortstokken) til samlnga. Korta vil vÊre sortert
	 * slik at de normalt mÂ stokkes f¯r bruk.
	 */
	public void leggTilAlle() {
		// Hint: Kortfarge.values() gir en tabell med alle kortfarger

		 Kort[] fullKortStokk = new Kort[MAKS_KORT];
	        for (int i = 0; i < 4; i++) {
	            for (int y = 1; y <= MAKS_KORT_FARGE; y++) {
	                if (i == 0) {
	                    System.out.println("Hjerter");
	                    fullKortStokk[i] = new Kort(Kortfarge.Hjerter, y);
	                } else if (i == 1) {
	                    System.out.println("Klover");
	                    fullKortStokk[i] = new Kort(Kortfarge.Klover, y);
	                } else if (i == 2) {
	                    System.out.println("Ruter");
	                    fullKortStokk[i] = new Kort(Kortfarge.Ruter, y);
	                } else {
	                    System.out.println("Spar");
	                    fullKortStokk[i] = new Kort(Kortfarge.Spar, y);
	                }
	            }
	        }
	        samling = fullKortStokk;
	        forsteledig = -1; // Et tall som sier at det ikke er noen ledig.

		// throw new RuntimeException("Metode leggTilAlle ikke implementert");
	}

	/**
	 * Fjerner alle korta fra samlinga slik at den blir tom.
	 */
	public void fjernAlle() {

		for (int i = 0; i < samling.length; i++) {
			samling[i] = null;
			forsteledig--;
		}

		// throw new RuntimeException("Metode fjernAlle ikke implementert");
	}

	/**
	 * Legg et kort til samlinga.
	 * 
	 * @param kort
	 *            er kortet som skal leggast til.
	 */
	public void leggTil(Kort kort) {
		if (forsteledig < samling.length) {
			samling[forsteledig] = kort;
			forsteledig++;
		}

		// throw new RuntimeException("Metode leggTil ikke implementert");
	}

	/**
	 * Ser pÂ siste kortet i samlinga.
	 * 
	 * @return siste kortet i samlinga, men det blir ikke fjernet.
	 */
	public Kort seSiste() {
		Kort sisteKort = null;
		for (int i = 1; i < samling.length + 1; i++) {
			if (samling[samling.length - i] != null) {
				sisteKort = samling[samling.length - i];
				break;
			}
		}
		return sisteKort;

		// throw new RuntimeException("Metode seSiste ikke implementert");
	}

	/**
	 * Tek ut siste kort fra samlinga.
	 * 
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort taSiste() {
		if (erTom()) {
			return null;
		}

		forsteledig--;
		Kort kort = samling[forsteledig];
		samling[forsteledig] = null;
		return kort;

		// throw new RuntimeException("Metode taSiste ikke implementert");
	}

	/**
	 * Unders¯ker om et kort finst i samlinga.
	 * 
	 * @param kort.
	 * 
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	public boolean har(Kort kort) {
		for (int i = 0; i < forsteledig; i++) {
			if (samling[i].equals(kort)) {
				indexSisteKortSjekket = i;
				return true;
			}
		}
		return false;

		// throw new RuntimeException("Metode har ikke implementert");
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

		if (har(kort)) {
			samling[indexSisteKortSjekket] = null;
			indexSisteKortSjekket = -1;
			forsteledig--;
		}

		// Hint: fjern kortet - men husk kortet kan sitte p� en plass i midten

		for (int i = 0; i < forsteledig; i++) {
			if (samling[i] == null) {
				Kort temp = samling[i];
				samling[i] = samling[i + 1];
				samling[i + 1] = temp;
			}
		}

		// throw new RuntimeException("Metode fjernKort ikke implementert");
	}

	/**
	 * Stokkar en kortsamling ved å bytte rundt på kort
	 */
	public void stokk() {
		// Hint: en mulighet er bruk av klassen Random for � generere
		// tilfeldige index
		Random kort = new Random();
		for (int i = 0; i < samling.length; i++) {
			int stokkKort = kort.nextInt(samling.length);
			Kort temp = samling[i];
			samling[i] = samling[stokkKort];
			samling[stokkKort] = temp; 
		}

		// throw new RuntimeException("Metode stokk ikke implementert");
	}

	/**
	 * Gir kortene som en ArrayList.
	 * 
	 * @return samlinga av kort som en ArrayList. Korta vil ha samme rekkef¯lge
	 *         som i kortsamlinga.
	 */
	public ArrayList<Kort> toArrayList() {
		ArrayList<Kort> list = new ArrayList<>();

		for (int i = 0; i < samling.length; i++) {
			if (samling[i] == null) {
				break;
			}
			list.add(samling[i]);
		}
		return list;

		// Hint: legg hvert kort fra samling over i arraylisten list

		// throw new RuntimeException("Metode ArrayList ikke implementert");
	}
}
