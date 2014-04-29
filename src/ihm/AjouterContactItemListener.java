package ihm;

import datas.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

/**
*class AjouterContactItemListener. 
*@version 1.0
*@author <a href="mailto:sonet.e1301490@etud.univ-ubs.fr">Nicolas Sonet</a>
*/

class AjouterContactItemListener implements ItemListener {

	private WtDialogAjouter dialogAjouter;

// -----------------------------------------------------------------------------------

	public AjouterContactItemListener(WtDialogAjouter dialogAjouter) {

		this.dialogAjouter = dialogAjouter;

	}

// -----------------------------------------------------------------------------------

	/**
	*Met a jour les champs de texte par rapport a la fiche selectionnee.
	*/

	public void itemStateChanged(ItemEvent e) {

			Fiche laFiche;

			laFiche = (Fiche) dialogAjouter.getListeNoms().getSelectedItem();

			JTextField nom = dialogAjouter.getFieldNom();

			nom.setText(laFiche.getNom());

			JTextField prenom = dialogAjouter.getFieldPrenom();

			prenom.setText(laFiche.getPrenom());

			JTextField num = dialogAjouter.getFieldNumero();

			num.setText(laFiche.getTelephone());

	}

// -----------------------------------------------------------------------------------

}
