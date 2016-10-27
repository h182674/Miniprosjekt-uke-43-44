package no.hib.dat100.prosjekt.kontroll;

import java.util.ArrayList;
import java.util.logging.Logger;

import no.hib.dat100.prosjekt.modell.Kort;

public class Dommer {

	// gjøre dommer uavhengig av bunke og hand implementasjon som er oppgaven
	private ArrayList<Kort> nordHand;
	private ArrayList<Kort> sydHand;

	private int antalltrekk;
	private Kort overste;

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private Spill spill;

	public Dommer(Spill spill) {
		this.spill = spill;
	}

	public boolean sjekkStart() {
		antalltrekk = 0;

		return (sjekkUtdeling() && sjekkOverste() && sjekkAntall());
	}

	private boolean sjekkAntall() {
		return true; // TODO: sjekke der er nok kort jvf. config i regler og
						// samling
	}

	private boolean sjekkUtdeling() {
		boolean korrekt = false;

		nordHand = spill.getNord().getHand().toArrayList();
		sydHand = spill.getSyd().getHand().toArrayList();

		LOGGER.info("Nord har " + nordHand.toString() + " ved start.");
		LOGGER.info("Syd har " + sydHand.toString() + " ved start.");

		korrekt = (nordHand.size() == Regler.antallKortVedStart()) && (nordHand.size() == Regler.antallKortVedStart());

		if (!korrekt) {
			LOGGER.warning(": kort ikke korrekt delt ut");
		}

		return korrekt;
	}

	private boolean sjekkOverste() {
		boolean korrekt = false;

		korrekt = (spill.getBunkeTil().getAntalKort() == 1);

		if (korrekt) {
			overste = spill.getBunkeTil().topp();
		} else {
			LOGGER.warning(": ikke korrekt antall kort i tilbunke ved start");
		}

		return korrekt;
	}

	private void trekkFraBunke(Spillere spiller, Kort kort) {

		if (spiller == Spillere.NORD) {
			nordHand.add(kort);
			antalltrekk++;
		} else if (spiller == Spillere.SYD) {
			sydHand.add(kort);
			antalltrekk++;
		}

		LOGGER.info(spiller + " trekker " + kort + " fra bunken med " + antalltrekk + "trekk");
	}

	private ArrayList<Kort> getHand(ISpiller spiller) {
		ArrayList<Kort> hand = null;

		if (spiller.hvem() == Spillere.SYD) {
			hand = sydHand;
		} else if (spiller.hvem() == Spillere.NORD) {
			hand = nordHand;
		}

		return hand;
	}

	private boolean harKort(ISpiller spiller, Kort kort) {
		ArrayList<Kort> hand = getHand(spiller);
		boolean ok = false;

		if (hand != null) {
			ok = hand.contains(kort);
		}

		return ok;

	}

	private void fjernKort(ISpiller spiller, Kort kort) {
		ArrayList<Kort> hand = getHand(spiller);

		if (hand != null) {
			hand.remove(kort);
		}

	}

	public boolean sjekkHandling(ISpiller spiller, Handling handling) {

		boolean ok = false;
		String handlingstr = "[ " + spiller.hvem() + " " + handling + " med " + antalltrekk + " trekk ] ";

		LOGGER.info("Sjekker " + handlingstr);

		switch (handling.getType()) {
		case TREKK:
			ok = antalltrekk < Regler.maksTrekk();
			break;
		case FORBI:
			ok = antalltrekk > 0;
			break;
		case LEGGNED:
			Kort kort = handling.getKort();
			ok = harKort(spiller, kort) && Regler.kanLeggeNed(kort, spill.seOverste());
		}

		if (!ok) {
			LOGGER.warning("Ulovlig " + handlingstr);
		}

		return ok;
	}

	public void utforHandling(ISpiller spiller, Handling handling, Kort kort) {

		String handlingstr = "[ " + spiller.hvem() + " " + handling + " med " + antalltrekk + " trekk ] ";

		switch (handling.getType()) {
		case TREKK:
			if (kort != null) {
				trekkFraBunke(spiller.hvem(), kort);
				LOGGER.info("Utfører " + "[ " + spiller.hvem() + " " + handling + " " + kort + " med " + antalltrekk
						+ " trekk ] ");
			} else {
				LOGGER.severe("Utfører " + "[ " + spiller.hvem() + " " + handling + " (null) med " + antalltrekk
						+ " trekk ] ");
			}
			break;
		case FORBI:
			LOGGER.info("Utfører " + handlingstr);
			antalltrekk = 0;
			break;
		case LEGGNED:
			LOGGER.info("Utfører " + handlingstr);
			Kort kortned = handling.getKort();
			overste = kortned;
			antalltrekk = 0;
			fjernKort(spiller, kortned);
			break;
		}

		LOGGER.info("Nord har " + nordHand.toString());
		LOGGER.info("Syd har " + sydHand.toString());
		LOGGER.info("Toppen er " + overste); // TODO: kunne her sjekke at
												// overste var lig det som er i
												// spill sin tilbunke.
	}

}
