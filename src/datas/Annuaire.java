package datas;
//import java.io.Serializable;
import java.util.*;
import java.io.*;
import java.util.Hashtable;

/**
*class Annuaire
*@version 1.0
*@author Nicolas Sonet
*/

public class Annuaire implements Serializable {

	// Attributs privés

	private Hashtable<Cle, Fiche> tabFiches;

	private static final long serialVersionUID = 0;

// -----------------------------------------------------------------------------------

	//Constructeur

	/**
	*Contruit un objet Annuaire.
	*/

	public Annuaire() {

		tabFiches = new Hashtable<Cle, Fiche>();

	}

// -----------------------------------------------------------------------------------

	/**
	*Charge l'Annuaire qui se trouve dans le fichier ../data/annuaire.out
	*@return Annuaire charge
	*/

	public static Annuaire charger() {

		Annuaire ret = null;

		try {

			ObjectInputStream flux = new ObjectInputStream(new FileInputStream("../data/annuaire.out"));

			ret = (Annuaire) flux.readObject();

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		return ret;

	}

// -----------------------------------------------------------------------------------

	/**
	*Ajoute une personne a la liste des contacts.
	*@param cle 
	*@param personne 
	*@throws IllegalArgumentException si la cle == null
	*@throws Exception si la cle existe deja
	*/

	public void ajouter(Cle cle, Fiche personne) throws IllegalArgumentException, Exception {

		if (cle == null) {

			throw new IllegalArgumentException("cle non valide");

		}

		if (existe(cle)) {

			throw new Exception("La cle existe deja");

		}

		tabFiches.put(cle, personne);

	}

// -----------------------------------------------------------------------------------

	/**
	*Retourne une Enumeration des cles.
	*@return Enumeration<Cle>
	*/

	public Enumeration<Cle> cles() {

		return tabFiches.keys();

	}

// -----------------------------------------------------------------------------------

	/**
	*Permet de consulter une Fiche a partir d'une Cle.
	*@param cle 
	*@return Fiche qui contient la cle
	*@throws IllegalArgumentException si la cle == null
	*/

	public Fiche consulter(Cle cle) throws IllegalArgumentException {

		if (cle == null) {

			throw new IllegalArgumentException("cle non valide");

		}

		return tabFiches.get(cle);

	}

// -----------------------------------------------------------------------------------

	/**
	*Retourne l'existance de la cle dans l'Annuaire.
	*@return vrai si cle existe
	*/

	public boolean existe(Cle cle) {

		return tabFiches.containsKey(cle);

	}

// -----------------------------------------------------------------------------------

	/**
	*Permet de modifier la fiche d'une personne.
	*@param cle
	*@param personne
	*/

	public void modifier(Cle cle, Fiche personne) throws IllegalArgumentException, NoSuchElementException, Exception {

		if (cle == null) {

			throw new IllegalArgumentException("cle non valide");

		}

		if (!existe(cle)) {

			throw new NoSuchElementException("La cle n'est pas dans l'annuaire");

		}

		if (cle.equals(personne.getLaCle())) {

			throw new Exception("La cle de la fiche ne correspond pas a la cle en parametre");

		}

		ajouter(cle, personne);

	}

// -----------------------------------------------------------------------------------

	public void sauver() {

		try {

			ObjectOutputStream flux = new ObjectOutputStream(new FileOutputStream("../data/annuaire.out"));

			flux.writeObject(this);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}

// -----------------------------------------------------------------------------------

	public void supprimer(Cle cle) throws IllegalArgumentException, NoSuchElementException {

		if (cle == null) {

			throw new IllegalArgumentException("cle non valide");

		}

		if (!existe(cle)) {

			throw new NoSuchElementException("La cle n'est pas dans l'annuaire");

		}

		tabFiches.remove(cle);

	}

// -----------------------------------------------------------------------------------

	public int taille(Cle cle) {

		Enumeration<Cle> enu = cles();

		int ret = 0;

		while (enu.hasMoreElements()) {

			ret++;

			enu.nextElement();

		}

		return ret;

	}

// -----------------------------------------------------------------------------------

}
