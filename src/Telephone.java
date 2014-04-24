/**
*class Telephone
*@author Nicolas Sonet
*@version 1.0
*/

public class Telephone {

	public static String getRandomNum() {

		String tel = "02";

		String tmp = Integer.toString(random(0, 999999)); // chiffre de 1 a 6 caracteres

		while (tmp.length() < 6) { // ajouter des 0 jusqu'a avoir 6 caracteres

			tmp = "0" + tmp;

		}

		tel = tel + tmp;

		return tel;

	}

	private static int random(int min, int max) {

		return (int) (Math.random()*(max - min + 1) + min);

	}

}

