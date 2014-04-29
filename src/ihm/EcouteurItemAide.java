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

class EcouteurItemAide implements ActionListener {

	private Wintel theWin;

// -----------------------------------------------------------------------------------

	public EcouteurItemAide(Wintel theWin) {

		this.theWin = theWin;

	}

// -----------------------------------------------------------------------------------

	public void actionPerformed(ActionEvent arg0) {

		System.out.println("Aide...");

		DialogAide da = theWin.getDialogAide();

		da.setVisible(true);

	}

}
