package no.hib.dat100.prosjekt.utsyn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.hib.dat100.prosjekt.kontroll.Kontroll;

public class NordKortButtonListener implements ActionListener {

	private Utsyn utsyn;

	public NordKortButtonListener(Utsyn utsyn) {
		this.utsyn = utsyn;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		utsyn.getLogger().info("");

		Kontroll kontroll = utsyn.getKontroll();
		if (kontroll.erNordTur()) {
			kontroll.handlingNord();
			utsyn.oppdater();

		} else {
			utsyn.spillLyd();
		}
	}

}
