package no.hib.dat100.prosjekt.kontroll;

import java.util.ArrayList;

import no.hib.dat100.prosjekt.modell.Bunke;
import no.hib.dat100.prosjekt.modell.Kort;

/**
 * Klassen har objektvariaber som er referanser til de spillerne, nord og syd
 * (type ISpiller). Den har ogsÂ en bunke man deler/trekker fra og en bunke man
 * spiller til.
 * 
 */
public class Spill {

	// objektvariable for et spill
	
	// de to spillere
	private ISpiller nord;
	private ISpiller syd;
	
	// de to bunker 
	private Bunke bunkeFra;
	private Bunke bunkeTil;

	/**
	 * Gir referanse/peker til syd.
	 * 
	 * @return referanse/peker til syd.
	 */
	public ISpiller getSyd() {
		
		return syd;
		
		//throw new RuntimeException("Metode getSyd ikke implementert");
	}

	/**
	 * Gir referanse/peker til nord.
	 * 
	 * @return referanse/peker til nord.
	 */
	public ISpiller getNord() {
		
		return nord;
		
		//throw new RuntimeException("Metode getNord ikke implementert");
	}

	/**
	 * Gir peker/referanse til til-bunken.
	 * 
	 * @return referanse/peker til til-bunken.
	 */
	public Bunke getBunkeTil() {
		
		return bunkeTil;
		
		//throw new RuntimeException("Metode getBunkeTil ikke implementert");
	}

	public Bunke getBunkeFra() {
		
		return bunkeFra;
		
		//throw new RuntimeException("Metode getBunkeFra ikke implementert");
	}

	/**
	 * Metoden oppretter to spillere, nord og syd. Det opprettes to bunker, fra
	 * og til. Alle kortene legges til fra. Bunken fra stokkes. Deretter deles
	 * det ut kort fra fra-bunken til nord og syd i henhold til regler. Til
	 * slutt tas ¯verste kortet fra fra-bunken og legges til til-bunken.
	 * 
	 * Nord har type RandomSpiller (som er forhÂndefinert). Syd vil til slutt vÊre spiller
	 * av en klasse laget av gruppen i oppgave 3.
	 */
	public void start() {
		
		// Hint: vurder om andre private metoder i klassen kan brukes her
        // i tilegg til metoder på bunker
		
		nord = new RandomSpiller(Spillere.NORD); //Dei to spelarane
		syd = new RandomSpiller(Spillere.SYD);
				
		bunkeTil = new Bunke(); //Dei to bunkene
		bunkeFra = new Bunke();
		
		bunkeFra.leggTilAlle(); //Legger til alle korta i bunkeFra
		
		
		
		bunkeFra.stokk(); //Stokker bunkeFra
		
		delutKort(); //deler ut kort til nord og syd
		
		vendOverste(); //vender det �verste kortet i fra-bunken og legger den i til-bunken
		
		
		//throw new RuntimeException("Metode start ikke implementert");
	}

	/**
	 * Deler ut kort til nord og syd.
	 * 
	 */
	private void delutKort() {

		// Husk: Klassen Regler angir hvor mange kort hver spiller skal ha
		
		for (int i = 0; i < Regler.antallKortVedStart(); i++) {
			nord.trekker(bunkeFra.taSiste());
			syd.trekker(bunkeFra.taSiste());
		}
		
		
		//throw new RuntimeException("Metode delutKort ikke implementert");
	}

	/**
	 * Tar ¯verste kortet fra fra-bunken og legger dettte til til-bunken (med
	 * billedsiden opp, men det trenger ikke gruppen tenke pÂ).
	 */
	private void vendOverste() {
		
		bunkeTil.leggTil(bunkeFra.taSiste());
		
		//throw new RuntimeException("Metode vendOverste ikke implementert");
	}

	/**
	 * NÂr fra-bunken blir tom, tar man vare pÂ kortet pÂ toppen av til-bunken.
	 * Deretter legges alle den andre kortene i til-bunken over i fra-bunken.
	 * Denne stokkes og kortet som man har tatt vare pÂ legges tilbake i
	 * til-bunken. Det vil nÂr vÊre det eneste kortet i til-bunken.
	 */
	public void snuTilBunken() {
			Kort snuKort = bunkeTil.topp();
			if (bunkeFra.erTom() == true) {
				for (int i = 0; i < bunkeTil.getAntalKort(); i++) {
					bunkeFra.leggTil(bunkeTil.taSiste());
				}
			}
			bunkeTil.leggTil(snuKort);
			bunkeFra.stokk();
			
			// TODO: bug
		
		
		//throw new RuntimeException("Metode snuTilBunken ikke implementert");
	}

	/**
	 * Trekker et kort fra fra-bunken til spilleren gitt som parameter. Om
	 * fra-bunken er tom, mÂ man "snu" til-bunken. Se info om metoden
	 * snuTilBunken().
	 * 
	 * @param spiller
	 *            spilleren som trekker.
	 * 
	 * @return kortet som trekkes.
	 */
	public Kort trekkFraBunke(ISpiller spiller) {
		Kort kort = null;
		if (bunkeFra.erTom()) {
			snuTilBunken();
			kort = bunkeFra.seSiste();
			spiller.trekker(bunkeFra.taSiste());
		} else {
			kort = bunkeFra.seSiste();
			spiller.trekker(bunkeFra.taSiste());
		}
		return kort;
		
		//TODO: bug
		
		
		//throw new RuntimeException("Metode trekkFraBunke ikke implementert");
	}

	/**
	 * Sjekker om til-bunken er tom.
	 * 
	 * @return true om til-bunken er tom, false ellers.
	 */
	public boolean bunketilTom() {
		
		return bunkeTil.erTom();
		
		//throw new RuntimeException("Metode bunkeTilTom ikke implementert");
	}

	/**
	 * Sjekker om fra-bunken er tom.
	 * 
	 * @return true om fra-bunken er tom, false ellers.
	 */
	public boolean bunkefraTom() {
		
		return bunkeFra.erTom();
		
		//throw new RuntimeException("Metode bunkefraTom ikke implementert");
	}

	/**
	 * Gir antall kort nord har pÂ hÂnden.
	 * 
	 * @return antall kort nord har pÂ hÂnden.
	 */
	public int antallNord() {
		
		return nord.getAntallKort();
		
		//throw new RuntimeException("Metode antallNord ikke implementert");
	}

	/**
	 * Gir antall kort i fra-bunken.
	 * 
	 * @return antall kort i fra-bunken.
	 */
	public int antallBunkeFra() {
		
		return bunkeFra.getAntalKort();
		
		//throw new RuntimeException("Metode antallBunkeFra ikke implementert");
	}

	/**
	 * Gir antall kort i til-bunken.
	 * 
	 * @return antall kort i til-bunken.
	 */
	public int antallBunkeTil() {
		
		return bunkeTil.getAntalKort();
		
		//throw new RuntimeException("Metode antallBunkeTil ikke implementert");
	}

	/**
	 * Metode som leser ¯verste kortet i til-bunken. Kortet vil fremdeles vÊre
	 * ¯verst i til-bunken etter at metoden er utf¯rt.
	 * 
	 * @return ¯verste kortet i til-bunken.
	 */
	public Kort seOverste() {
		
		return bunkeTil.seSiste();
		
		//throw new RuntimeException("Metode seOverste ikke implementert");
	}

	/**
	 * Gir syds hand som en ArrayList av Kort.
	 * 
	 * @return syds hand som en ArrayList av Kort.
	 */
	public ArrayList<Kort> getSydHand() {
		
		ArrayList<Kort> listSyd = new ArrayList<>();
		
		listSyd = syd.getHand().toArrayList(); 
		
		return listSyd;
		
		//throw new RuntimeException("Metode getSydHand ikke implementert");
	}

	/**
	 * Bestemmer neste handling for en spiller (spilt et kort, trekker et kort, forbi)
	 * 
	 * @param spiller
	 *            spiller som handle.
	 * 
	 * @return handlingen som skal utf¯res av spillet.
	 */
	public Handling nesteHandling(ISpiller spiller) {
		
		// Hint: bruk nesteHandling metoden på en spiller
		
		return spiller.nesteHandling(seOverste());
		
		
		//throw new RuntimeException("Metode nesteHandling ikke implementert");
	}

	/**
	 * Metoden spiller et kort. Den sjekker at spiller har kortet. Dersom det er
	 * tilfelle, fjernes kortet fra spilleren og legges til til-bunken. Metoden
	 * nulltiller ogsÂ antall ganger spilleren har trukket kort.
	 * 
	 * @param spiller
	 *            den som spiller.
	 * @param kort
	 *            kort som spilles.
	 * 
	 * @return true dersom spilleren har kortet, false ellers.
	 */
	public boolean leggnedKort(ISpiller spiller, Kort kort) {
		if (spiller.getHand().har(kort) == true) {
			spiller.getHand().fjern(kort);
			bunkeTil.leggTil(kort);
			spiller.setAntallTrekk(0);
			return true;
		} else {
			return false;
		}
		
		//throw new RuntimeException("Metode leggnedKort ikke implementert");
	}

	/**
	 * Metode for Â si forbi. MÂ nullstille antall ganger spilleren har trukket
	 * kort.
	 * 
	 * @param spiller
	 *            spilleren som er i tur.
	 */
	public void forbiSpiller(ISpiller spiller) {
		
		spiller.setAntallTrekk(0);
		
		//throw new RuntimeException("Metode forbiSpiller ikke implementert");
	}

	/**
	 * Metode for Â utf¯re en handling (trekke, spille, forbi). Dersom handling
	 * er kort, blir kortet ogsÂ spilt.
	 * 
	 * @param spiller
	 *            spiller som utf¯rer handlingen.
	 * @param handling
	 *            handling som utf¯res.
	 * 
	 * @return kort som trekkes, kort som spilles eller null ved forbi.
	 */
	public Kort utforHandling(ISpiller spiller, Handling handling) {

		Kort kort = handling.getKort();
		
		if(handling.getType().equals(HandlingsType.FORBI)){
			forbiSpiller(spiller);
		} else if(handling.getType().equals(HandlingsType.LEGGNED)){
			leggnedKort(nord, kort);
		} else {
			kort = trekkFraBunke(spiller);
		}

		return kort;
		
		
		// Hint: del opp i de tre mulige handlinger og vurder 
		// om noen andre private metoder i klassen kan brukes
		// til å implementere denne metoden
		
		//throw new RuntimeException("Metode utforHandling ikke implementert");
	}

	/**
	 * Spiller et kort fra syd.
	 * 
	 * @param kort
	 *            kort som spilles.
	 * 
	 * @return true dersom kortet er lovlig Â spille, false ellers.
	 */
	public boolean nedkortSyd(Kort kort) {
		
		return leggnedKort(syd, kort);
		
		//throw new RuntimeException("Metode nedkortSyd ikke implementert");
	}

	/**
	 * ForeslÂr hva syd skal spille.
	 * 
	 * @return kort som blir foreslÂtt.
	 */
	public Kort foreslaaKortSyd() {
		ArrayList<Kort> sydHand = getSydHand();
		Kort[] bunkePaaBordet = bunkeTil.getSamling();
		Kort kort = bunkePaaBordet[bunkeTil.getAntalKort() - 1];

		for(int i = 0; i < sydHand.size(); i++){
				if(sydHand.get(i).getFarge().equals(kort.getFarge())) {
					return sydHand.get(i);
				}
			if(sydHand.get(i).getVerdi() == kort.getVerdi()){
				return sydHand.get(i);
			}
		}
		return null;
		
		// Hint: bruk nesteHandling metoden for en spiller
		
		//throw new RuntimeException("Metode foreslqqKortSyd ikke implementert");
	}
}