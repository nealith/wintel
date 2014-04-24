import datas.*;
import java.util.*;

/**
*class test Annuaire
*@see Annuaire
*@author Nicolas Sonet
*@version 1.0
*/

public class TestAnnuaire {

	public static void main ( String[] args ) {

		String[][] data = new String[6][3];

		data[0][0] = "Sonet";
		data[0][1] = "Nicolas";
		data[0][2] = Telephone.getRandomNum();
		data[1][0] = "Ferrenbach";
		data[1][1] = "Theo";
		data[1][2] = Telephone.getRandomNum();
		data[2][0] = "Deverre";
		data[2][1] = "Aymeric";
		data[2][2] = Telephone.getRandomNum();
		data[3][0] = "LaCroix";
		data[3][1] = "Thomas";
		data[3][2] = Telephone.getRandomNum();
		data[4][0] = "Daniel";
		data[4][1] = "Maxime";
		data[4][2] = Telephone.getRandomNum();
		data[5][0] = "Conan";
		data[5][1] = "Sylvain";
		data[5][2] = Telephone.getRandomNum();

		Cle[] tab = new Cle[6];

		Fiche[] fiches = new Fiche[6];

		Annuaire a1 = new Annuaire();

		for (int i = 0 ; i < tab.length ; i++) {

			tab[i] = new Cle(data[i][0], data[i][1]);

			fiches[i] = new Fiche(data[i][0], data[i][1], data[i][2]);

			try {

				a1.ajouter(tab[i], fiches[i]);

			} catch (Exception e) {

				System.out.println(e.getMessage());

			}

		}

		a1.sauver();

		Annuaire a2 = Annuaire.charger();

		Enumeration<Cle> cles = a2.cles();

		Fiche tmp;

		while (cles.hasMoreElements()) {

			tmp = a2.consulter(cles.nextElement());

			System.out.println(tmp + " " + tmp.getPrenom() + " " + tmp.getTelephone());

		}

		/*for (int i = 0 ; i < tab.length ; i++) {

			System.out.println(fiches[i] + " " + fiches[i].getPrenom() + " " + fiches[i].getTelephone());

		}*/

	}

}
