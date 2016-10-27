package no.hib.dat100.prosjekt.main;

import javax.swing.SwingUtilities;

import no.hib.dat100.prosjekt.kontroll.Kontroll;
import no.hib.dat100.prosjekt.utsyn.*;

public class VriOtteSpil {

	public static void main(String[] args) {

		// opprett kontroll delen
		final Kontroll kontroll = new Kontroll();

		// start utsyn (Swing grensesnitt)
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Utsyn(kontroll);
			}
		});
	}
}
