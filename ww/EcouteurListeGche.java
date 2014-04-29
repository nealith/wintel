package ihm;

import datas.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class EcouteurListeGche extends MouseAdapter {

	// La référence sur Wintel
	private Wintel theWin;

	// Constructeur : lui donner la référence sur Wintel
	// sinon l’accès aux méthodes de Wintel est impossible.
	public EcouteurListeGche ( Wintel monWin ) {

		this.theWin = monWin;

	}

// Méthode de REACTION au clic souris sur un élément de la JList

	public void mouseClicked ( MouseEvent e ) {
		System.out.println("1");
		Fiche laFiche;
		// Accès à la JList
		JList maListe = theWin.getListeGche();
		// getListeGche accesseur de Wintel
		// Récupération de l’endroit (index) où l’utilisateur a cliqué
		int index = maListe.locationToIndex(e.getPoint());
		// Récupération du tableau qui mémorise les éléments de la JList
		DefaultListModel tab = (DefaultListModel)maListe.getModel();
		// L’index correspond précisément à la case du tableau contenant la donnée
		// sélectionnée par l’utilisateur avec la souris
		laFiche = (Fiche)tab.get(index);
		// Affichage des informations de la fiche dans les 3 champs textuels
		// de droite
		JTextField nom = theWin.getFieldNom();
		// accesseur de Wintel
		nom.setText(laFiche.getNom());
		JTextField prenom = theWin.getFieldPrenom();
		// accesseur de Wintel
		prenom.setText(laFiche.getPrenom());
		JTextField num = theWin.getFieldNumero();
		num.setText(laFiche.getTelephone());
	}
}
