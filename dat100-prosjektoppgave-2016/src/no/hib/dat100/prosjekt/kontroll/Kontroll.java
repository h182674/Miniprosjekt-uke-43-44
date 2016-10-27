package no.hib.dat100.prosjekt.kontroll;

import java.util.ArrayList;

import no.hib.dat100.prosjekt.modell.Kort;

public class Kontroll {

	private Dommer dommer;
	private Spill spill;

	public Kontroll() {
		spill = new Spill();
		dommer = new Dommer(spill);
	}

	public void startSpill() {

		spill.start();

		dommer.sjekkStart();

		Tur.velgSpiller();
	}

	//
	// metoder som gir info for oppdatering av grensesnitt
	//

	public int antallNord() {
		return spill.antallNord();
	}

	public int antallBunkeTil() {
		return spill.antallBunkeTil();
	}

	public int antallBunkeFra() {
		return spill.antallBunkeFra();
	}

	public boolean erSydTur() {
		return Tur.erSydTur();
	}

	public boolean erNordTur() {
		return Tur.erNordTur();
	}

	public Spillere aktivSpiller() {
		return Tur.tur();
	}

	private ISpiller turSpiller() {

		ISpiller spiller = null;

		if (erSydTur()) {
			spiller = spill.getSyd();
		} else if (erNordTur()) {
			spiller = spill.getNord();
		}

		return spiller;

	}

	public Kort hentOverste() {
		return spill.seOverste();
	}

	public boolean bunketilTom() {
		return spill.bunketilTom();
	}

	public boolean bunkefraTom() {
		return spill.bunkefraTom();
	}

	public Spillere vinner() {

		Spillere vinner = Regler.vinner(spill.getNord(), spill.getSyd());

		if (vinner != Spillere.INGEN) {
			Tur.ferdig();
		}

		return vinner;
	}

	public ArrayList<Kort> kortSyd() {
		return spill.getSydHand();
	}

	//
	// metoder som kaldes ved klikk på ikoner
	//

	// kaldes ved klikk på fra bunken med syd aktiv spiller
	public Kort trekkFraBunke() {

		Kort kort = null;

		ISpiller spiller = turSpiller();

		Handling handling = new Handling(HandlingsType.TREKK, null);

		if (spiller != null) {

			boolean ok = dommer.sjekkHandling(spiller, handling);

			if (ok) {
				kort = spill.trekkFraBunke(turSpiller());

				if (kort != null) {
					dommer.utforHandling(spiller, handling, kort);
				}
			}
		}

		return kort;
	}

	public void handlingSpiller(ISpiller spiller) {
		Handling handling = spill.nesteHandling(spiller);

		if (dommer.sjekkHandling(spiller, handling)) {
			Kort kort = spill.utforHandling(spiller, handling);
			dommer.utforHandling(spiller, handling, kort);
		}

		if (handling.skifteTur()) {
			Tur.skiftSpiller();
		}
	}

	// kaldes ved klikk på nord spiller ikon
	public void handlingNord() {
		ISpiller nord = spill.getNord();
		handlingSpiller(nord);
	}

	// kaldes ved klikk på tur ikon når syd sin tur
	public boolean sydForbi() {

		Handling handling = new Handling(HandlingsType.FORBI, null);

		ISpiller syd = spill.getSyd();

		boolean ok = dommer.sjekkHandling(syd, handling);

		if (ok) {
			spill.forbiSpiller(syd);
			dommer.utforHandling(syd, handling, null);
			Tur.skiftSpiller();
		}

		return ok;
	}

	// kaldes ved klikk på spillerikon for syd.
	public Kort foreslaaSyd() {
		return spill.foreslaaKortSyd();
	}

	// kaldes ved klikk på et kort hos syd.
	public boolean leggnedKortSyd(Kort kort) {

		boolean ok;

		ISpiller spiller = spill.getSyd();

		Handling handling = new Handling(HandlingsType.LEGGNED, kort);

		ok = dommer.sjekkHandling(spiller, handling);

		if (ok) {
			spill.nedkortSyd(kort);
			dommer.utforHandling(spiller, handling, null);
			Tur.skiftSpiller();
		}

		return ok;
	}

	//
	// metoder for automatisk spill uten feedback i GUI
	//

	// spiller spiller inntil tur skifter
	public void spillSpiller(ISpiller spiller) {

		Spillere hvem = spiller.hvem();

		while (aktivSpiller() == hvem) {
			handlingSpiller(spiller);
		}
	}

	public boolean harVinner() {

		Spillere vinner = Regler.vinner(spill.getNord(), spill.getSyd());

		return (vinner != Spillere.INGEN);
	}

	public void spillAuto() {

		while (!harVinner()) {

			ISpiller spiller = turSpiller();

			if (spiller != null) {
				spillSpiller(spiller);
			} else {
				System.out.println("Feil i spillAuto - ingen spiller aktiv");
			}
		}

	}
}
