package no.hib.dat100.prosjekt.utsyn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.hib.dat100.prosjekt.kontroll.Kontroll;

public class TurButtonListener implements ActionListener {

	private Utsyn utsyn;

	TurButtonListener(Utsyn utsyn) {
		this.utsyn = utsyn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		utsyn.getLogger().info("");

		Kontroll kontroll = utsyn.getKontroll();

		if (kontroll.erSydTur()) {
			if (kontroll.sydForbi()) {
				utsyn.oppdater();
			} else {
				utsyn.spillLyd();
			}
		} else {
			utsyn.spillLyd();
		}
	}
}
