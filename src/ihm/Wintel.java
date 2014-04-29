package ihm;

import datas.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

/**
*class Wintel. 
*Fenetre de gestion de contacts.
*@version 1.0
*@author <a href="mailto:sonet.e1301490@etud.univ-ubs.fr">Nicolas Sonet</a>
*/

public class Wintel extends JFrame implements Serializable {

	private static final long serialVersionUID = 0;

	private JList<Fiche> listeGche;

	private JTextField fieldNom;

	private JTextField fieldPrenom;

	private JTextField fieldTelephone;

	private WtDialogAjouter dialogAj;

	private WtDialogModifier dialogMod;

	private WtDialogSupprimer dialogSup;

	private DialogAide dialogAide;

	private Annuaire monAnnuaire;

	private JMenuItem itemCharger;

	private JMenuItem itemSauver;

	private JMenuItem itemQuitter;

	private JMenuItem itemAjouter;

	private JMenuItem itemModifier;

	private JMenuItem itemSupprimer;

	private JMenuItem itemAide;

	//private JPanel panelCentre;

	private DefaultListModel<Fiche> monTab;

// -----------------------------------------------------------------------------------

	/**
	*Construit un objet Wintel
	*/

	public Wintel(String titre) {

		super(titre);

		//this.setTitle(titre);

		this.init(); // création de l’annuaire (+ des 3 WtDialog

		this.creerInterface(); // mise en place du décor

		this.attacherReactions(); // écouteurs des événements utilisateurs

		this.setMinimumSize(new Dimension(500,500));

		this.setSize( 500, 500 ); // dimensionnement de la fenêtre

		this.setLocationRelativeTo(null);

		//this.setResizable(false);

		this.setVisible( true ); // rendre la fenêtre visible

		this.setDefaultCloseOperation ( EXIT_ON_CLOSE ); // clic sur la croix

	}

// -----------------------------------------------------------------------------------

	public DialogAide getDialogAide() {

		return dialogAide;

	}

// -----------------------------------------------------------------------------------

	public WtDialogAjouter getDialogAj() {

		return dialogAj;

	}

// -----------------------------------------------------------------------------------

	public JList<Fiche> getListeGche() {

		return listeGche;

	}

// -----------------------------------------------------------------------------------

	public JTextField getFieldNom() {

		return fieldNom;

	}

// -----------------------------------------------------------------------------------

	public JTextField getFieldPrenom() {

		return fieldPrenom;

	}

// -----------------------------------------------------------------------------------

	public JTextField getFieldNumero() {

		return fieldTelephone;

	}

// -----------------------------------------------------------------------------------

	public Annuaire getAnnuaire() {

		return monAnnuaire;

	}

// -----------------------------------------------------------------------------------

	/**
	*Construit l'interface de l'application.
	*/

	private void creerInterface() {

		this.setLayout(new BorderLayout());

		JPanel container = new JPanel(new BorderLayout());

		this.add(container, BorderLayout.CENTER);

		JPanel panelNord = new JPanel();

		panelNord.setLayout(new GridLayout(1, 2));

		panelNord.setBackground(Color.YELLOW);

		JLabel j1 = new JLabel("Contacts");

		j1.setHorizontalAlignment(JLabel.CENTER);

		j1.setVerticalAlignment(JLabel.CENTER);

		panelNord.add(j1);

		JLabel j2 = new JLabel("Caractéristiques");

		j2.setHorizontalAlignment(JLabel.CENTER);

		j2.setVerticalAlignment(JLabel.CENTER);

		panelNord.add(j2);

		container.add(panelNord, BorderLayout.NORTH);

		JPanel panelCentre = new JPanel();

		panelCentre.setLayout(new GridLayout(1, 2, 40, 0));

		listeGche = new JList<Fiche>();

		listeGche.setModel(new DefaultListModel<Fiche>());

		monTab = (DefaultListModel<Fiche>) listeGche.getModel();

		this.intialiserJList();

		panelCentre.add(listeGche);

		JPanel panelCaract = new JPanel();

		GridLayout gl = new GridLayout(0,1);

		gl.setVgap(10);

		panelCaract.setLayout(gl);

		JLabel l1 = new JLabel("Nom");

		Font fontLabel = new Font("Arial", Font.BOLD, 16);

		l1.setFont(fontLabel);

		l1.setHorizontalAlignment(JLabel.CENTER);

		l1.setVerticalAlignment(JLabel.CENTER);

		panelCaract.add(l1);

		fieldNom = new JTextField();

		fieldNom.setHorizontalAlignment(JLabel.CENTER);

		Font font = new Font("Arial", Font.PLAIN, 19); // font pour les champs nom, prenom et telephone

		fieldNom.setFont(font);

		fieldNom.setBackground(Color.WHITE);

		fieldNom.setForeground(Color.BLUE);

		fieldNom.setEditable(false);

		panelCaract.add(fieldNom);

		JLabel l2 = new JLabel("Prénom");

		l2.setFont(fontLabel);

		l2.setHorizontalAlignment(JLabel.CENTER);

		l2.setVerticalAlignment(JLabel.CENTER);

		panelCaract.add(l2);

		fieldPrenom = new JTextField();

		fieldPrenom.setHorizontalAlignment(JLabel.CENTER);

		fieldPrenom.setFont(font);

		fieldPrenom.setBackground(Color.WHITE);

		fieldPrenom.setForeground(Color.BLUE);

		fieldPrenom.setEditable(false);

		panelCaract.add(fieldPrenom);

		JLabel l3 = new JLabel("Numéro");

		l3.setFont(fontLabel);

		l3.setHorizontalAlignment(JLabel.CENTER);

		l3.setVerticalAlignment(JLabel.CENTER);

		panelCaract.add(l3);

		fieldTelephone = new JTextField();

		fieldTelephone.setHorizontalAlignment(JLabel.CENTER);

		fieldTelephone.setFont(font);

		fieldTelephone.setBackground(Color.WHITE);

		fieldTelephone.setForeground(Color.BLUE);

		fieldTelephone.setEditable(false);

		panelCaract.add(fieldTelephone);

		panelCaract.add(new JButton("Composer"));

		panelCentre.add(panelCaract);

		container.add(panelCentre, BorderLayout.CENTER);

		JMenuBar myBar = new JMenuBar();

		JMenu menuFicher = new JMenu("Fichier");

		myBar.add(menuFicher);

		JMenu menuAbonnes = new JMenu("Contacts");

		myBar.add(menuAbonnes);

		JMenu menuAide = new JMenu("Aide");

		myBar.add(menuAide);

		itemCharger = new JMenuItem("Charger");

		itemSauver = new JMenuItem("Sauver");

		itemQuitter = new JMenuItem("Quitter");

		itemAjouter = new JMenuItem("Ajouter");

		itemModifier = new JMenuItem("Modifier");

		itemSupprimer = new JMenuItem("Supprimer");

		itemAide = new JMenuItem("Aide");

		menuFicher.add(itemQuitter);

		menuFicher.add(itemSauver);

		menuFicher.add(itemCharger);

		menuAbonnes.add(itemAjouter);

		menuAbonnes.add(itemModifier);

		menuAbonnes.add(itemSupprimer);

		menuAide.add(itemAide);

		setJMenuBar(myBar);

		GridLayout g = new GridLayout(1 ,5);

		g.setHgap(5); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)

		g.setVgap(5); 

		JPanel contacts = new JPanel(g);

		contacts.add(new JButton("Ajouter"));

		contacts.add(new JButton("Modifier"));

		//contacts.add(new JButton("Supprimer"));

		JPanel barreNord = new JPanel(new GridLayout(1 ,2));

		barreNord.add(contacts);

		barreNord.add(new JTextField());

		this.add(barreNord, BorderLayout.NORTH);

	}

// -----------------------------------------------------------------------------------

	private void attacherReactions() {

		listeGche.addMouseListener(new EcouteurListeGche(this));

		itemCharger.addActionListener(new EcouteurItemCharger(this));

		itemSauver.addActionListener(new EcouteurItemSauver(this));

		itemAide.addActionListener(new EcouteurItemAide(this));

		itemAjouter.addActionListener(new EcouteurItemAjouter(this));

	}

// -----------------------------------------------------------------------------------

	/**
	*Initialise les attributs de Wintel.
	*/

	private void init() {

		monAnnuaire = new Annuaire();

		monAnnuaire = Annuaire.charger();

		dialogAj = new WtDialogAjouter(this);

		dialogMod = new WtDialogModifier(this);

		dialogSup = new WtDialogSupprimer(this);

		dialogAide = new DialogAide(this);

	}

// -----------------------------------------------------------------------------------

	public void chargerEtAfficherAnnuaire() {

		System.out.println("chargerEtAfficherAnnuaire");

		monAnnuaire = Annuaire.charger();

		this.intialiserJList();

	}

// -----------------------------------------------------------------------------------

	private void intialiserJList() {

		monTab.clear();

		Enumeration<Cle> cles = monAnnuaire.cles();

		try {

			while (cles.hasMoreElements()) {

				monTab.addElement(monAnnuaire.consulter(cles.nextElement()));

			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}

// -----------------------------------------------------------------------------------

	/**
	*Permet d'ajouter un contact.
	*@param nom Nom du contact
	*@param prenom Prenom du contact
	*@param numTel Numero de telephone du contact
	*/

	public void ajouterAbonne(String nom, String prenom, String numTel) {

		try {

			Fiche f1 = new Fiche(nom, prenom, numTel);

			monAnnuaire.ajouter(new Cle(nom, prenom), f1);

			listeGche.add(new JLabel(nom));

			monTab.addElement ( f1 );

		} catch (Exception e) {

			System.out.println(e.getMessage());

			JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);

		}

	}

// -----------------------------------------------------------------------------------

	/**
	*Lanceur de la classe.
	*/

	public static void main(String[] args) {

		Wintel w1 = new Wintel("Wintel");

	}

// -----------------------------------------------------------------------------------

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
			Fiche laFiche;
			// Accès à la JList
			JList<Fiche> maListe = theWin.getListeGche();
			// getListeGche accesseur de Wintel
			// Récupération de l’endroit (index) où l’utilisateur a cliqué
			int index = maListe.locationToIndex(e.getPoint());
			// Récupération du tableau qui mémorise les éléments de la JList
			DefaultListModel<Fiche> tab = (DefaultListModel<Fiche>) maListe.getModel();
			// L’index correspond précisément à la case du tableau contenant la donnée
			// sélectionnée par l’utilisateur avec la souris
			laFiche = tab.get(index);
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

}

