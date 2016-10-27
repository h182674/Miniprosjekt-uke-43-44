package no.hib.dat100.prosjekt.utsyn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.hib.dat100.prosjekt.kontroll.Kontroll;
import no.hib.dat100.prosjekt.modell.Kort;

public class SydKortButtonListener implements ActionListener {
	
	private Kort kort;
	private Utsyn utsyn;

	SydKortButtonListener(Kort kort, Utsyn utsyn) {
		this.kort = kort;
		this.utsyn = utsyn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		utsyn.getLogger().info("");

		Kontroll kontroll = utsyn.getKontroll();
		
		if (kontroll.erSydTur()) {
			if (kontroll.leggnedKortSyd(kort)) {
				utsyn.oppdater();
			} else {
				utsyn.spillLyd();
			}
		} else {
			utsyn.spillLyd();
		}
	}

}
