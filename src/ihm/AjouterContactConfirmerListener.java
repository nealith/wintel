package ihm;

import datas.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

/**
*class EcouteurItemAide. 
*Permet d'afficher un DialogAide
*@version 1.0
*@author <a href="mailto:sonet.e1301490@etud.univ-ubs.fr">Nicolas Sonet</a>
*/

class AjouterContactConfirmerListener implements ActionListener {

	private Wintel theWin;

	private WtDialogAjouter dialog;

// -----------------------------------------------------------------------------------

	public AjouterContactConfirmerListener(WtDialogAjouter dialog) {

		this.theWin = (Wintel) dialog.getOwner();

		this.dialog = dialog;

	}

// -----------------------------------------------------------------------------------

	public void actionPerformed(ActionEvent arg0) {

		System.out.println("Confirmer ajout...");

		WtDialogAjouter ajouter = theWin.getDialogAj();

		Fiche fiche = (Fiche) ajouter.getListeNoms().getSelectedItem();

		theWin.ajouterAbonne(fiche.getNom(), fiche.getPrenom(), fiche.getTelephone());

		System.out.println("fermer " + dialog.getClass().getName() + "...");

		dialog.setVisible(false);

	}

}
