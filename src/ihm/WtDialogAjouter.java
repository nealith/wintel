package ihm;

import datas.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.util.Hashtable;

/**
*class Wintel
*@version 1.0
*@author <a href="mailto:sonet.e1301490@etud.univ-ubs.fr">Nicolas Sonet</a>
*/

public class WtDialogAjouter extends JDialog implements Serializable {

	private static final long serialVersionUID = 0;

	private Wintel theWin;

	private JComboBox<Fiche> listeNoms;

	private JTextField fieldNom;

	private JTextField fieldPrenom;

	private JTextField fieldTelephone;

	private JButton boutonAnnuler;

	private JButton boutonConfirmer;

// -----------------------------------------------------------------------------------

	public WtDialogAjouter(Wintel theWin) {

		super ( theWin, "Ajouter un nouveau contact", true ); // appel constructeur JDialog

		this.theWin = theWin;

		this.lireTableFiches(); // lecture des fiches à partir du fichier

		this.initialiserFields();

		this.creerInterface(); // mise en place du décor (voir Figure 5)

		this.attacherReactions(); // écouteurs sur les boutons et JComboBox

		this.setSize ( 400, 400 );

		this.setResizable(false);

		this.setLocationRelativeTo(null);

		this.setVisible (false); // invisible à la création

	}

// -----------------------------------------------------------------------------------

	public JComboBox<Fiche> getListeNoms() {

		return listeNoms;

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

	/**
	*Initialise les champs de texte avec le nom, prenom et telephone de la personne a l'index 0 de la liste des noms.
	*@see #listeNoms
	*/

	private void initialiserFields() {

		Fiche fiche = listeNoms.getItemAt(0);

		fieldNom = new JTextField(fiche.getNom());

		fieldPrenom = new JTextField(fiche.getPrenom());

		fieldTelephone = new JTextField(fiche.getTelephone());

	}

// -----------------------------------------------------------------------------------

	private void lireTableFiches() {

		ArrayList<Fiche> fiches = new ArrayList<Fiche>();

		try {

			ObjectInputStream os = new ObjectInputStream(new FileInputStream("../ww/table.bin"));

			while (true) {

				Fiche fiche = (Fiche) os.readObject();

				fiches.add(fiche);

			}

		} catch (Exception e) {

			Fiche[] tabFiches = new Fiche[fiches.size()];

			Iterator<Fiche> iter = fiches.iterator();

			int i = 0;

			while (iter.hasNext()) {

				tabFiches[i] = iter.next();

				i++;

			}

			listeNoms = new JComboBox<Fiche>(tabFiches);

		}

	}

// -----------------------------------------------------------------------------------

	/*
	*Interface du JDialog.
	*/

	private void creerInterface() {

		this.setLayout(new BorderLayout());

		JPanel center = new JPanel();

		JPanel[] paneaux = new JPanel[4];

		for (int i = 0 ; i < 4 ; i++) {

			paneaux[i] = new JPanel();

			//panneaux[i].setBackground();

		}

		this.add(center, BorderLayout.CENTER);

		this.add(paneaux[0], BorderLayout.WEST);

		this.add(paneaux[1], BorderLayout.EAST);

		this.add(paneaux[2], BorderLayout.NORTH);

		this.add(paneaux[3], BorderLayout.SOUTH);

		GridLayout g1 = new GridLayout(9, 1);

		g1.setHgap(5); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)

		g1.setVgap(5); 

		center.setLayout(g1);

		JLabel labelQuestion = new JLabel("Veuiller choisir un nouveau contact dans la liste");

		labelQuestion.setHorizontalAlignment(JLabel.CENTER);

		labelQuestion.setVerticalAlignment(JLabel.CENTER);

		Font font = new Font("Arial", Font.BOLD, 14);

		labelQuestion.setFont(new Font("Arial", Font.BOLD, 13));

		labelQuestion.setForeground(Color.BLUE);

		center.add(labelQuestion);

		listeNoms.setFont(font);

		DefaultListCellRenderer centr = new DefaultListCellRenderer(); // --------------------|
		//										      |
		centr.setHorizontalAlignment(JLabel.CENTER); //permet de centrer le texte du JComboBox|
		//										      |
		listeNoms.setRenderer(centr); // -----------------------------------------------------|

		center.add(listeNoms);

		JLabel labelNom = new JLabel("Nom");

		labelNom.setHorizontalAlignment(JLabel.CENTER);

		labelNom.setVerticalAlignment(JLabel.CENTER);

		labelNom.setFont(font);

		center.add(labelNom);

		fieldNom.setHorizontalAlignment(JLabel.CENTER);

		fieldNom.setFont(font);

		fieldNom.setBackground(Color.WHITE);

		fieldNom.setForeground(Color.BLUE);

		fieldNom.setEditable(false);

		center.add(fieldNom);

		JLabel labelPrenom = new JLabel("Prenom");

		labelPrenom.setHorizontalAlignment(JLabel.CENTER);

		labelPrenom.setVerticalAlignment(JLabel.CENTER);

		labelPrenom.setFont(font);

		center.add(labelPrenom);

		fieldPrenom.setHorizontalAlignment(JLabel.CENTER);

		fieldPrenom.setFont(font);

		fieldPrenom.setBackground(Color.WHITE);

		fieldPrenom.setForeground(Color.BLUE);

		fieldPrenom.setEditable(false);

		center.add(fieldPrenom);

		JLabel labelTelephone = new JLabel("Telephone");

		labelTelephone.setHorizontalAlignment(JLabel.CENTER);

		labelTelephone.setVerticalAlignment(JLabel.CENTER);

		labelTelephone.setFont(font);

		center.add(labelTelephone);

		fieldTelephone.setHorizontalAlignment(JLabel.CENTER);

		fieldTelephone.setFont(font);

		fieldTelephone.setBackground(Color.WHITE);

		fieldTelephone.setForeground(Color.BLUE);

		fieldTelephone.setEditable(false);

		center.add(fieldTelephone);

		GridLayout g2 = new GridLayout(1, 2);

		g2.setHgap(5);

		g2.setVgap(5); 

		JPanel south = new JPanel(g2);

		boutonConfirmer = new JButton("Confirmer");

		south.add(boutonConfirmer);

		boutonAnnuler = new JButton("Annuler");

		south.add(boutonAnnuler);

		center.add(south);

	}

// -----------------------------------------------------------------------------------

	private void attacherReactions() {

		listeNoms.addItemListener(new AjouterContactItemListener(this));

		boutonAnnuler.addActionListener(new EcouteurFermer(this));

		boutonConfirmer.addActionListener(new AjouterContactConfirmerListener(this));

	}

// -----------------------------------------------------------------------------------

}

