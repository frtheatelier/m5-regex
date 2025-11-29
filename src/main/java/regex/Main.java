package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    /**
     * The Main method for this assignment.
     * You can optionally run this to interactively try the three methods.
     * @param args parameters are unused
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        final String userInput = scanner.nextLine();
        scanner.close();
        System.out.println("You entered \"" + userInput + "\"");
        System.out.println(checkForPassword(userInput, 6));
        System.out.println(extractEmails(userInput));
        System.out.println(checkForDoubles(userInput));
    }

    // Method 1 for checking if a string matches a regex: using Pattern.matches
    // TODO: Modify this code to check if the given string is non-empty, contains at least
    //       one lower case letter, at least one upper case letter, and at least one digit. If the
    //       string has all of these properties, the method should return true. If it is missing one
    //       or more properties, it should return false.

    /**
     * Returns whether a given string is non-empty, contains one lower case letter,
     * at least one upper case letter, at least one digit, and meets the minimum length.
     * @param str the string to check for the properties in
     * @param minLength the minimum length required for the password
     * @return whether the string satisfies the password requirements
     */
    public static boolean checkForPassword(String str, int minLength) {
        final boolean propertyOne = Pattern.matches("REPLACE WITH CORRECT REGEX", str);
        // as needed, modify this code.
        return propertyOne;
    }

    // Method 2 for checking if a string conforms to a regex: using Matcher.find
    // TODO: Modify this method to return a list of all email addresses contained in the
    //       input string that end with "@mail.utoronto.ca" or "@utoronto.ca" with at least one
    //       character before the "@" symbol. The email addresses should be in the order they
    //       appear in the string.

    /**
     * Returns a list of email addresses that occur in a given string.
     * @param str the string to look for email addresses in
     * @return a list containing the email addresses in the string.
     */
    public static List<String> extractEmails(String str) {
        final Pattern pattern = Pattern.compile("REPLACE WITH CORRECT REGEX");
        final Matcher matcher = pattern.matcher(str);
        final List<String> result = new ArrayList<>();
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    // Method 3 for checking if a string conforms to a regex: using String.matches

    // TODO: Modify this method to check whether or not the string contains the same capital letter
    //       twice. For example "Amazing Apple" contains "A" twice. If the string does repeat the same
    //       capital letter twice, the method should return true. Otherwise it should return false.

    /**
     * Checks whether a given string contains the same capital letter twice.
     * @param str the string to look for doubles in
     * @return whether str contains the same capital letter twice.
     */
    public static boolean checkForDoubles(String str) {
        return str.matches("replace with correct regex");
    }
}
