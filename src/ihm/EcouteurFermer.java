package ihm;

import datas.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
*class EcouteurFermer. 
*Permet de fermer un JDialog.
*@version 1.0
*@author <a href="mailto:sonet.e1301490@etud.univ-ubs.fr">Nicolas Sonet</a>
*/

class EcouteurFermer implements ActionListener {

	private JDialog dialog;

// -----------------------------------------------------------------------------------

	public EcouteurFermer (JDialog dialog) {

		this.dialog = dialog;

	}

// -----------------------------------------------------------------------------------

	/**
	*Ferme le JDialog si une action est detectee.
	*@see #dialog
	*/

	public void actionPerformed(ActionEvent arg0) {

		System.out.println("fermer " + dialog.getClass().getName() + "...");

		//dialog.dispose();

		dialog.setVisible(false);

	}

// -----------------------------------------------------------------------------------

}
