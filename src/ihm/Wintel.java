package ihm;

import datas.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
/*import java.io.*;
import java.util.Hashtable;*/

/**
*class Wintel
*@version 1.0
*@author Nicolas Sonet
*/

public class Wintel extends JFrame {

	private JList listeGche;

	private WtDialogAjouter dialogAj;

	private WtDialogModifier dialogMod;

	private WtDialogSupprimer dialogSup;

	private Annuaire monAnnuaire;

// -----------------------------------------------------------------------------------

	/**
	*Construit un objet Wintel
	*/

	public Wintel(String titre) {

		super(titre);

		//this.setTitle(titre);

		this.creerInterface();
		// mise en place du décor
		this.attacherReactions(); // écouteurs des événements utilisateurs
		this.init();
		// création de l’annuaire (+ des 3 WtDialog
		this.setSize( 500, 500 ); // dimensionnement de la fenêtre
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible( true ); // rendre la fenêtre visible
		this.setDefaultCloseOperation ( EXIT_ON_CLOSE ); // clic sur la croix

	}

// -----------------------------------------------------------------------------------

	private void creerInterface() {

		this.setLayout(new BorderLayout());

		JPanel panelNord = new JPanel();

		panelNord.setLayout(new GridLayout(1, 2));

		panelNord.setBackground(Color.YELLOW);

		JLabel j1 = new JLabel("Abonnés");

		j1.setHorizontalAlignment(JLabel.CENTER);

		j1.setVerticalAlignment(JLabel.CENTER);

		panelNord.add(j1);

		JLabel j2 = new JLabel("Caractéristiques");

		j2.setHorizontalAlignment(JLabel.CENTER);

		j2.setVerticalAlignment(JLabel.CENTER);

		panelNord.add(j2);

		this.add(panelNord, BorderLayout.NORTH);

		JPanel panelCentre = new JPanel();

		panelCentre.setLayout(new GridLayout(1, 2, 40, 0));

		listeGche = new JList();

		//listeGche.setModel(new DefaultListModel());

		panelCentre.add(listeGche);

		JPanel panelCaract = new JPanel();

		panelCaract.setLayout(new GridLayout(0,1));

		JLabel l1 = new JLabel("Nom");

		l1.setFont(new Font("Arial", Font.PLAIN, 16).deriveFont(Font.BOLD));

		l1.setHorizontalAlignment(JLabel.CENTER);

		l1.setVerticalAlignment(JLabel.CENTER);

		panelCaract.add(l1);

		JTextField jt1 = new JTextField();

		jt1.setFont(new Font("Arial", Font.PLAIN, 18));

		jt1.setForeground(Color.BLUE);

		panelCaract.add(jt1);

		JLabel l2 = new JLabel("Prénom");

		l2.setFont(new Font("Arial", Font.PLAIN, 16).deriveFont(Font.BOLD));

		l2.setHorizontalAlignment(JLabel.CENTER);

		l2.setVerticalAlignment(JLabel.CENTER);

		panelCaract.add(l2);

		JTextField jt2 = new JTextField();

		jt2.setFont(new Font("Arial", Font.PLAIN, 18));

		jt2.setForeground(Color.BLUE);

		panelCaract.add(jt2);

		JLabel l3 = new JLabel("Numéro");

		l3.setFont(new Font("Arial", Font.PLAIN, 16).deriveFont(Font.BOLD));

		l3.setHorizontalAlignment(JLabel.CENTER);

		l3.setVerticalAlignment(JLabel.CENTER);

		panelCaract.add(l3);

		JTextField jt3 = new JTextField();

		jt3.setFont(new Font("Arial", Font.PLAIN, 18));

		jt3.setForeground(Color.BLUE);

		panelCaract.add(jt3);

		panelCaract.add(new JButton("Composer"));

		panelCentre.add(panelCaract);

		this.add(panelCentre, BorderLayout.CENTER);

		JMenuBar myBar = new JMenuBar();

		JMenu menuFicher = new JMenu("Fichier");

		myBar.add(menuFicher);

		JMenu menuAbonnes = new JMenu("Contacts");

		myBar.add(menuAbonnes);

		JMenu menuAide = new JMenu("Aide");

		myBar.add(menuAide);

		JMenuItem itemCharger = new JMenuItem("Charger");

		JMenuItem itemSauver = new JMenuItem("Sauver");

		JMenuItem itemQuitter = new JMenuItem("Quitter");

		JMenuItem itemAjouter = new JMenuItem("Ajouter");

		JMenuItem itemModifier = new JMenuItem("Modifier");

		JMenuItem itemSupprimer = new JMenuItem("Supprimer");

		JMenuItem itemAide = new JMenuItem("Aide");

		menuFicher.add(itemQuitter);

		menuFicher.add(itemSauver);

		menuFicher.add(itemCharger);

		menuAbonnes.add(itemAjouter);

		menuAbonnes.add(itemModifier);

		menuAbonnes.add(itemSupprimer);

		menuAide.add(itemAide);

		setJMenuBar(myBar);

	}

// -----------------------------------------------------------------------------------

	private void attacherReactions() {

	}

// -----------------------------------------------------------------------------------

	private void init() {

		monAnnuaire = new Annuaire();

		dialogAj = new WtDialogAjouter();

		dialogMod = new WtDialogModifier();

		dialogSup = new WtDialogSupprimer();

	}

// -----------------------------------------------------------------------------------

	public void ajouterAbonne(String nom, String prenom, String numTel) {

		try {

			Fiche f1 = new Fiche(nom, prenom, numTel);

			monAnnuaire.ajouter(new Cle(nom, prenom), f1);

			listeGche.add(new JLabel(nom));

			/*DefaultListModel monTab = (DefaultListModel) monAnnuaire.cles().getModel();
			monTab.addElement ( f1 );*/

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}

// -----------------------------------------------------------------------------------

	public static void main(String[] args) {

		Wintel w1 = new Wintel("Wintel");

	}

// -----------------------------------------------------------------------------------

}

