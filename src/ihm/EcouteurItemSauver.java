package ihm;

import datas.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

/**
*class EcouteurItemSauver. 
*@version 1.0
*@author <a href="mailto:sonet.e1301490@etud.univ-ubs.fr">Nicolas Sonet</a>
*/

class EcouteurItemSauver implements ActionListener {

	private Wintel theWin;

// -----------------------------------------------------------------------------------

	public EcouteurItemSauver(Wintel theWin) {

		this.theWin = theWin;

	}

// -----------------------------------------------------------------------------------

	public void actionPerformed(ActionEvent arg0) {

		System.out.println("Sauver...");

		theWin.getAnnuaire().sauver();

	}

}
