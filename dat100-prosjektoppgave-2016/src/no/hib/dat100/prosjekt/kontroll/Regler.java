package no.hib.dat100.prosjekt.kontroll;

import no.hib.dat100.prosjekt.modell.Kort;

public abstract class Regler {

	private final static int ANTALL_KORT_START = 3;
	private final static int MAKS_TREKK = 1;

	public static boolean kanLeggeNed(Kort kort, Kort topp) {
		return kort.sammeFarge(topp) || kort.sammeVerdi(topp) || atter(kort);
	}

	public static boolean atter(Kort kort) {
		return kort.getVerdi() == 8;
	}

	public static int antallKortVedStart() {
		return ANTALL_KORT_START;
	}

	public static int maksTrekk() {
		return MAKS_TREKK;
	}

	public static Spillere vinner(ISpiller spiller1, ISpiller spiller2) {

		Spillere vinner = Spillere.INGEN;

		if (spiller1.erFerdig()) {
			vinner = spiller1.hvem();
		} else if (spiller2.erFerdig()) {
			vinner = spiller2.hvem();
		}

		return vinner;
	}
}
