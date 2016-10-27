package no.hib.dat100.prosjekt.utsyn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.hib.dat100.prosjekt.kontroll.Kontroll;

public class AutospillButtonListener implements ActionListener {

	private Utsyn utsyn;

	public AutospillButtonListener(Utsyn utsyn) {
		this.utsyn = utsyn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		utsyn.getLogger().info("");

		Kontroll kontroll = utsyn.getKontroll();

		kontroll.spillAuto();
		utsyn.oppdater();
	}

}
