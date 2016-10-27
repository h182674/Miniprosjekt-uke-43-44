package no.hib.dat100.prosjekt.utsyn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.hib.dat100.prosjekt.kontroll.Kontroll;
import no.hib.dat100.prosjekt.modell.Kort;

public class FraBunkeButtonListener implements ActionListener {

	private Utsyn utsyn;

	public FraBunkeButtonListener(Utsyn utsyn) {
		this.utsyn = utsyn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		utsyn.getLogger().info("");

		Kontroll kontroll = utsyn.getKontroll();
		
		// kun syd kan trekke ved klikk fra bunken
		if (kontroll.erSydTur()) {
			
			Kort kort = kontroll.trekkFraBunke();

			if (kort != null) {
				utsyn.oppdater();
			} else {
				utsyn.spillLyd();
			}
		} else {
			utsyn.spillLyd();
		}

	}

}
