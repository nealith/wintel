/**
*class Telephone
*@author <a href="mailto:sonet.e1301490@etud.univ-ubs.fr">Nicolas Sonet</a>
*@version 1.0
*/

public class Telephone {

	public static String getRandomNum() {

		String tel = "029";

		String tmp = Integer.toString(random(0, 9999999)); // chiffre de 1 a 7 caracteres

		while (tmp.length() < 7) { // ajouter des 0 jusqu'a avoir 7 caracteres

			tmp = "0" + tmp;

		}

		tel = tel + tmp;

		tel = tel.substring(0, 2) + "." + tel.substring(2, 4) + "." + tel.substring(4, 6) + "." + tel.substring(6, 8) + "." + tel.substring(8, 10);

		return tel;

	}

	private static int random(int min, int max) {

		return (int) (Math.random()*(max - min + 1) + min);

	}

}

