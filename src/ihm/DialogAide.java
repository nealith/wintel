package ihm;

import datas.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

/**
*class Wintel
*@version 1.0
*@author <a href="mailto:sonet.e1301490@etud.univ-ubs.fr">Nicolas Sonet</a>
*/

public class DialogAide extends JDialog implements Serializable {

	private static final long serialVersionUID = 0;

	private Wintel theWin;

	private JButton fermer;

// -----------------------------------------------------------------------------------

	public DialogAide(Wintel theWin) {

		super(theWin, "Aide", true);

		this.theWin = theWin;

		this.creerInterface(); // mise en place du décor (voir Figure 5)

		this.attacherReactions(); // écouteurs sur les boutons et JComboBox

		this.setSize ( 550, 400 );

		this.setResizable(false);

		this.setLocationRelativeTo(null);

		this.setVisible (false); // invisible à la création

	}

// -----------------------------------------------------------------------------------

	private void creerInterface() {

		this.setLayout(new BorderLayout());

		JPanel center = new JPanel();

		String texte = "Ceci est l'aide de l'application Wintel" + '\n' + '\n';

		texte = texte + "L'aplication consiste à gérer une liste de personnes enregistrées dans un " + '\n' + "annuaire téléphonique." + '\n';

		texte = texte + "Le premier menu Fichier permet de :" + '\n';

		texte = texte + "-charger l'annuaire de personnes;" + '\n';

		texte = texte + "-sauvegarder sur le disque l'annuaire;" + '\n';

		texte = texte + "-quitter l'application." + '\n' + '\n';

		texte = texte + "La cle de recherche dans l'annuaire est consistée du \"nom_prenom\" de la " + '\n';

		texte = texte + "personne et on n'autorise pas l'ajout d'une personne de la même clé." + '\n' + '\n';

		texte = texte + "Le second menu, nommé \"Contacts\" permet :" + '\n';

		texte = texte + "-d'ajouter une nouvelle personne à l'annuaire;" + '\n';

		texte = texte + "-de modifier le numero de téléphone dune personne existante;" + '\n';

		texte = texte + "-de supprimer une personne de 'annuaire." + '\n' + '\n';

		texte = texte + "Enfin, en cliquant sue la liste des personnes, on peut obtenir des " + '\n' + "informations détaillées sur la personne sélectionnée.";

		JTextArea aide = new JTextArea(texte);

		aide.setEditable(false);

		aide.setFont(new Font("Verdana", Font.BOLD, 12));

		aide.setForeground(Color.BLUE);

		aide.setBackground(Color.CYAN);

		center.add(aide);

		center.setBackground(Color.CYAN);

		this.add(center, BorderLayout.CENTER);

		JPanel south = new JPanel(new GridLayout(1, 3));

		south.add(new JLabel());

		fermer = new JButton("Fermer");

		south.add(fermer);

		south.add(new JLabel());

		this.add(south, BorderLayout.SOUTH);

	}

// -----------------------------------------------------------------------------------

	private void attacherReactions() {

		fermer.addActionListener(new EcouteurFermer(this));

	}

// -----------------------------------------------------------------------------------

}

