package assignment1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This programs run a simple madlib game in an infinite loop
 * 
 * @author Michael Daly
 * @version 1.0
 * @since 2019-09-23 CST8110 Introduction to Programming
 */

public class JavaAssign1Daly0100 {

	private enum MadLibTypes {
		SILLYWORD("Silly word"), LASTNAME("Last name"), ILLNESS("Illness"), PLURALNOUN("Plural Noun"),
		ADJECTIVE("Adjective"), PLACE("Place"), NUMBER("Number");

		private String typeText;

		private MadLibTypes(String type) {
			this.typeText = type;
		}

		@Override
		public String toString() {
			return typeText;
		}
	}

	public static void main(String args[]) {

		MadLibTypes[] inputTypes = { MadLibTypes.SILLYWORD, MadLibTypes.LASTNAME, MadLibTypes.ILLNESS,
				MadLibTypes.PLURALNOUN, MadLibTypes.ADJECTIVE, MadLibTypes.ADJECTIVE, MadLibTypes.SILLYWORD,
				MadLibTypes.PLACE, MadLibTypes.NUMBER, MadLibTypes.ADJECTIVE };

		String[] madLibOutput = { "\nDear School Nurse: \n%s", " %s will not be attending school today.",
				"He/she has come down with\na case of %s", " and has horrible %s", " and a\\an %s fever.",
				"We have made\nan appointment with the %s ", "Dr.%s,", "who studied for many years in \n%s",
				" and has %s degrees in pediatrics.",
				" He will send you all \nthe information you need.Thank you!\nSincerely \nMrs. %s." };

		ArrayList<String> expectedInput = new ArrayList<String>();

		try (Scanner input = new Scanner(System.in)) {
			while (true) {

				for (int i = 0; i < inputTypes.length; i++) {
					System.out.format("Please enter a %s:", inputTypes[i]);
					expectedInput.add(input.nextLine());
				}

				for (int i = 0; i < madLibOutput.length; i++) {
					System.out.format(madLibOutput[i], expectedInput.get(i));
				}

				System.out.println("\n\nThank you for playing a Mad Lib with me!\n");
			}
		}

	}

}
