package be.pxl.ja.streamingservice.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

	private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_-";
	private static final String ALGORITHM = "MD5";

	public static String encodePassword(String password) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance(ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException(e);
		}
		messageDigest.update(password.getBytes(), 0, password.length());
		return new BigInteger(1, messageDigest.digest()).toString(16);
	}

	public static boolean isValid(String providedPassword, String securedPassword) {
		return encodePassword(providedPassword).equals(securedPassword);
	}

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
