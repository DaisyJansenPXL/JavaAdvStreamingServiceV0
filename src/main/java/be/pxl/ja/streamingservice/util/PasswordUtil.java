package be.pxl.ja.streamingservice.util;

public class PasswordUtil {

	private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_-";

	public static int calculateStrength(String password) {

		int score = 0;

		if (password.length() < 6) {
			score = 0;
		}
		if (password.length() >= 6) {
			if (password.length() <= 10) {
				score = 1;
			}
			if (password.length() > 10) {
				score = 2;
			}

			boolean containsNumber = false;
			boolean containsLowercase = false;
			boolean containsUppercase = false;
			boolean containsSpecialCharacter = false;

			for (int i = 0; i < password.length(); i++) {
				if (Character.isDigit(password.charAt(i))) {
					containsNumber = true;
				}
				if (Character.isLowerCase(password.charAt(i))) {
					containsLowercase = true;
				}
				if (Character.isUpperCase(password.charAt(i))) {
					containsUppercase = true;
				}
				if (SPECIAL_CHARACTERS.indexOf(password.charAt(i)) != -1) {
					containsSpecialCharacter = true;
				}
			}

			if (containsNumber) {
				score += 2;
			}
			if (containsLowercase) {
				score += 2;
			}
			if (containsUppercase) {
				score += 2;
			}
			if (containsSpecialCharacter) {
				score += 2;
			}
		}

		return score;
	}
}
