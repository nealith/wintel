package datas;
import java.io.Serializable;

/**
*class CLe
*@version 1.0
*@author <a href="mailto:sonet.e1301490@etud.univ-ubs.fr">Nicolas Sonet</a>
*/

public class Cle implements Serializable {

	// Attributs privés

	private String key;

	private static final long serialVersionUID = 0;

// -----------------------------------------------------------------------------------

	//Constructeur

	/**
	*Contruit un objet Cle.
	*/

	public Cle(String nom, String prenom) {

		key = nom + "_" + prenom;

	}

// -----------------------------------------------------------------------------------

	public boolean equals(Object obj) {

		boolean ret = false;

		if (obj != null) {

			if (this.hashCode() == obj.hashCode()) { // check le hashcode

				if (obj.getClass().getName().equals(this.getClass().getName())) { // check le nom de la classe

					Cle tmp = (Cle) obj;

					if (this.getKey().equals(tmp.getKey())) { // check les clés

						ret = true;

					}

				}

			}

		}

		return ret;

	}

// -----------------------------------------------------------------------------------

	public String getKey() {

		return key;

	}

// -----------------------------------------------------------------------------------

	public int hashCode() {

		return 135290;

	}

// -----------------------------------------------------------------------------------

}
