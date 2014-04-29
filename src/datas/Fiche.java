package datas;
import java.io.Serializable;
import java.util.*;

/**
*class Fiche
*@version 1.0
*@author <a href="mailto:sonet.e1301490@etud.univ-ubs.fr">Nicolas Sonet</a>
*/

public class Fiche implements Serializable {

	// Attributs privés

	private Cle laCle;

	private String nom;

	private String prenom;

	private String telephone;

	private static final long serialVersionUID = 0;

// -----------------------------------------------------------------------------------

	//Constructeur

	/**
	*Contruit un objet Fiche.
	*/

	public Fiche(String leNom, String lePrenom, String leTelephone) throws IllegalArgumentException {

		if (leNom == null || lePrenom == null || leTelephone == null) {

			throw new IllegalArgumentException("un des parametres n'est pas valide");

		}

		nom = leNom;

		prenom = lePrenom;

		telephone = leTelephone;

		laCle = new Cle(nom, prenom);

	}

// -----------------------------------------------------------------------------------

	public String getFicheComplete() {

		String ret = "nom = " + nom + '\n';

		ret = ret + "prenom = " + prenom + '\n';

		ret = ret + "telephone = " + telephone;

		return ret;

	}

// -----------------------------------------------------------------------------------

	public Cle getLaCle() {

		return laCle;

	}

// -----------------------------------------------------------------------------------

	public String getNom() {

		return nom;

	}

// -----------------------------------------------------------------------------------

	public String getPrenom() {

		return prenom;

	}

// -----------------------------------------------------------------------------------

	public String getTelephone() {

		return telephone;

	}

// -----------------------------------------------------------------------------------

	public String toString() {

		return getNom();

	}

// -----------------------------------------------------------------------------------

}
