package regex;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    // helpers to ensure tests initially fail for the given starter code
    void starterTestPasswordValidator() {
        assertFalse(Main.checkForPassword("REPLACE WITH CORRECT REGEX", 6));
    }

    void starterTestExtractEmails() {
        assertTrue(Main.extractEmails("REPLACE WITH CORRECT REGEX").isEmpty());
    }

    void starterTestCheckForDoubles() {
        assertFalse(Main.checkForDoubles("replace with correct regex"));
    }




    // Tests for checkForPassword
    @Test
    void testPasswordValid() {
        assertTrue(Main.checkForPassword("Abc123", 6));
        assertTrue(Main.checkForPassword("XyZ9abc", 6));
    }

    @Test
    void testPasswordTooShort() {
        starterTestPasswordValidator();
        assertFalse(Main.checkForPassword("Ab1", 6));
    }

    @Test
    void testPasswordMissingUppercase() {
        starterTestPasswordValidator();
        assertFalse(Main.checkForPassword("abc123", 6));
    }

    @Test
    void testPasswordMissingLowercase() {
        starterTestPasswordValidator();
        assertFalse(Main.checkForPassword("ABC123", 6));
    }

    @Test
    void testPasswordMissingDigit() {
        starterTestPasswordValidator();
        assertFalse(Main.checkForPassword("Abcdef", 6));
    }

    @Test
    void testPasswordNull() {
        assertFalse(Main.checkForPassword(null, 6));
    }

    @Test
    void testPasswordValidWithDifferentMinLength() {
        // minLength = 8, password meets requirements and is long enough
        assertTrue(Main.checkForPassword("Abcdef12", 8));

        // minLength = 8, password meets character requirements but is too short
        assertFalse(Main.checkForPassword("Abc123", 8));
    }

    // Tests for extractEmails
    @Test
    void testExtractEmailsValid() {
        String input = "Contact me at john@mail.utoronto.ca or jane@utoronto.ca.";
        List<String> emails = Main.extractEmails(input);
        assertEquals(List.of("john@mail.utoronto.ca", "jane@utoronto.ca"), emails);
    }

    @Test
    void testExtractEmailsInvalidDomain() {
        starterTestExtractEmails();
        String input = "Email: bob@gmail.com";
        List<String> emails = Main.extractEmails(input);
        assertTrue(emails.isEmpty());
    }

    @Test
    void testExtractEmailsEmptyString() {
        starterTestExtractEmails();
        assertTrue(Main.extractEmails("").isEmpty());
    }

    @Test
    void testExtractEmailsNull() {
        assertTrue(Main.extractEmails(null).isEmpty());
    }

    @Test
    void testExtractEmailsDuplicates() {
        String input = "john@mail.utoronto.ca john@mail.utoronto.ca";
        List<String> emails = Main.extractEmails(input);
        assertEquals(List.of("john@mail.utoronto.ca", "john@mail.utoronto.ca"), emails);
    }

    // Tests for checkForDoubles
    @Test
    void testCheckForDoublesTrueOne() {
        assertTrue(Main.checkForDoubles("Amazing Apple"));
    }

    @Test
    void testCheckForDoublesTrueTwo() {
        assertTrue(Main.checkForDoubles("ABBA"));
    }

    @Test
    void testCheckForDoublesFalseOne() {
        starterTestCheckForDoubles();
        assertFalse(Main.checkForDoubles("Hello World"));
    }

    @Test
    void testCheckForDoublesFalseTwo() {
        starterTestCheckForDoubles();
        assertFalse(Main.checkForDoubles("abc def"));
    }

    @Test
    void testCheckForDoublesNull() {
        assertFalse(Main.checkForDoubles(null));
    }

    @Test
    void testCheckForDoublesEdgeCaseSingleCapital() {
        starterTestCheckForDoubles();
        assertFalse(Main.checkForDoubles("A"));
    }
}