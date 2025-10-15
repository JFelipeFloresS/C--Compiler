package parser;

import java.util.List;

public class LexerHelper {

	private static final String PRINT_IN_RED = "\u001B[31m";
	
	public static int lexemeToInt(String str) {
		try {
            return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(PRINT_IN_RED + "Lexeme to Int Error: invalid integer, " + e.getMessage());
		}
		return -1;
	}

	public static char lexemeToChar(String str) {
		// lexeme needs to start and end with '
		if (str.charAt(0) != '\'' || str.charAt(str.length() - 1) != '\'') {
			System.out.println(PRINT_IN_RED + "Lexeme to Char Error: invalid character detected in input " + str + ". Expected \"'\"");
			return '\0';
		}

		// remove the surrounding '
		str = str.substring(1, str.length() - 1);

		// if the length is greater than 1, the first char must be a backslash
		// otherwise it is an invalid char
		if (str.length() > 1 && str.charAt(0) != '\\') {
			System.out.println(PRINT_IN_RED + "Lexeme to Char Error: invalid special character detected in input " + str);
		}

		// handle normal chars
		if (str.length() == 1) {
			return str.charAt(0);
		}

		// handle escaped chars
		if (str.length() == 2) {
			char escapedChar = str.charAt(1);
            switch (escapedChar) {
                case 'n' -> {
                    return '\n';
                }
                case 't' -> {
                    return '\t';
                }
                case '\'' -> {
                    return '\'';
                }
                case '\"' -> {
                    return '\"';
                }
                case '\\' -> {
                    return '\\';
                }
                default -> {
                    System.out.println(PRINT_IN_RED + "Lexeme to Char Error: invalid escaped character detected in input " + str);
                    return '\0';
                }
            }
		}

		// handle ascii chars
		if (str.substring(1, str.length() - 1).matches("[0-9]+")) {
			int asciiCode = Integer.parseInt(str.substring(1)); // skip the backslash
			// following the ascii codes from this table https://www.ascii-code.com the highest number is 255 and some codes are not used
			if (asciiCode > 255 ||
					List.of(129, 141, 143, 144, 157).contains(asciiCode)) {
				System.out.println(PRINT_IN_RED + "Lexeme to Char Error: invalid ASCII character detected in input " + str);
				return '\0';
			}
            return (char) asciiCode;
		}

		// if we reach this point, the char is invalid
		System.out.println(PRINT_IN_RED + "Invalid char: " + str);
		return '\0';
	}

	public static double lexemeToDouble(String str) {
		try {
            return Double.parseDouble(str);
		} catch (NumberFormatException e) {
			System.out.println(PRINT_IN_RED + "Lexeme to Real Error: invalid double, " + e.getMessage());
		}
		return -1;
	}
	
}
