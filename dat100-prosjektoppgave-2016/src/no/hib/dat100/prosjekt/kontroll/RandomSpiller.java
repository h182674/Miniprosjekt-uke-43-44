package no.hib.dat100.prosjekt.kontroll;

import java.util.ArrayList;
import java.util.Random;

import no.hib.dat100.prosjekt.modell.Kort;

public class RandomSpiller extends Spiller {

	public RandomSpiller(Spillere spiller) {
		super(spiller);
	}

	@Override
	public Handling nesteHandling(Kort topp) {
		
		// liste med kort svarende til hand for spiller
		ArrayList<Kort> h = getHand().toArrayList();
		
		// lister til å samle opp lovlige kort og åttere for spilleren
		
		ArrayList<Kort> lovlige = new ArrayList<Kort>();
		ArrayList<Kort> attere = new ArrayList<Kort>();

		// itererer over handen h og legg til lovlige kort i åttere eller lovlige
		for (Kort k : h) {
			if (Regler.kanLeggeNed(k, topp)) {
				if (Regler.atter(k)) {
					attere.add(k);
				} else {
					lovlige.add(k);
				}
			}
		}

		// finn om der skal spilles fra listen av åttere eller lovlige
		Kort kort = null;
		ArrayList<Kort> spillFra = null;

		if (!lovlige.isEmpty()) {
			spillFra = lovlige;
		} else if (!attere.isEmpty()) {
			spillFra = attere;
		}

		// finn ut hvilken handling spilleren skal gjøre og returner den
		Handling handling = null;
		
		if (spillFra != null) {
			
			// velg et tilfeldigt kort, legg det ned og nullstill antall trekk.
			
			Random r = new Random();
			int p = r.nextInt(spillFra.size());
			kort = spillFra.get(p);
			handling = new Handling(HandlingsType.LEGGNED, kort);
			setAntallTrekk(0);
		} else if (getAntallTrekk() < Regler.maksTrekk()) {
			
			// trekk fra bunken hvis vi ikker nådd grensen for å trekke
			
			handling = new Handling(HandlingsType.TREKK, null);
		} else {
			
			// ikke noe kort spiller og kan ikke trekk mer
			// da må vi si forbi og nullstille antall trekk.
			
			handling = new Handling(HandlingsType.FORBI, null);
			setAntallTrekk(0);
		}

		return handling;
	}

}
