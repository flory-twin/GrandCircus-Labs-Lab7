package co.grandcircus.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import co.grandcircus.Validator;

class ValidatorTest
{
   public final String caseId = "ValidatorTest.";
   
   @Test
   public void testIsNameValid()
   {
      String methodId = "testIsNameValid(): ";
      
      Validator underTest = new Validator();
      assertFalse(underTest.isNameValid("6abc"),
            caseId + methodId + "Non-alphabetic names should not be valid.");
      assertFalse(underTest.isNameValid("Abedl*"),
            caseId + methodId + "Non-alphabetic names should not be valid.");
      assertFalse(underTest.isNameValid("abcdef"),
            caseId + methodId + "Names not starting with a capital letter (and continuing with lowercase letters) should not be valid.");
      assertFalse(underTest.isNameValid("aBCDEF"),
            caseId + methodId + "Names not starting with a capital letter (and continuing with lowercase letters) should not be valid.");
      assertFalse(underTest.isNameValid("Abcdefghijklmnopqrstuvwxyzabcde"),
            caseId + methodId + "Names longer than 30 characters should not be valid.");
      assertFalse(underTest.isNameValid(""),
            caseId + methodId + "The empty string should not be allowed.");
      assertTrue(underTest.isNameValid("K"),
            caseId + methodId + "A name having only alphabet characters, in Titlecase, with length 1 should have been valid.");
      assertTrue(underTest.isNameValid("Kevin"),
            caseId + methodId + "A name having only alphabet characters, in Titlecase, with length 5 should have been valid.");
   }
   
   @Test
   public void testIsEmailValid()
   {
String methodId = "testIsEmailValid(): ";
      Validator underTest = new Validator();
      
      assertFalse(underTest.isEmailValid("ab@abcde.com"),
            caseId + methodId + "An email having the first part less than 5 characters should not have been valid.");
      assertFalse(underTest.isEmailValid("abcdefghijklmnopqrstuvwxyzabcde@abcde.com"),
            caseId + methodId + "An email having the first part greater than 30 characters should not have been valid.");
      assertFalse(underTest.isEmailValid("ab$cde@abcde.com"),
            caseId + methodId + "An email having non-alphanumeric characters in the first part should not have been valid.");
      
      assertTrue(underTest.isEmailValid("abcde1@abcde.com"),
            caseId + methodId + "An otherwise valid email having digits in the first part should have been valid.");
      assertTrue(underTest.isEmailValid("abcdefghijklmnopqrstuvwxyzabcd@abcde.com"),
            caseId + methodId + "An otherwise valid email having 30 characters in the first part should have been valid.");
      
      assertFalse(underTest.isEmailValid("abcdefghijklmnop.com"),
            caseId + methodId + "An email lacking the @ symbol should not have been valid.");
      
      assertFalse(underTest.isEmailValid("abcde@fghi.com"),
            caseId + methodId + "An email having less than 5 characters in the second part should not have been valid.");
      assertFalse(underTest.isEmailValid("abcde@fghijklmnop.com"),
            caseId + methodId + "An email having more than 10 characters in the second part should not have been valid.");
      assertFalse(underTest.isEmailValid("abcde@fghijklmn$.com"),
            caseId + methodId + "An email with special characters in the second part should not have been valid.");

      assertTrue(underTest.isEmailValid("abcde@fghijklmno.com"),
            caseId + methodId + "An otherwise valid email with 10 characters in the second part should have been valid.");
      assertTrue(underTest.isEmailValid("abcde@fghijklmn1.com"),
            caseId + methodId + "An otherwise valid email with digits in the second part should have been valid.");
      
      assertFalse(underTest.isEmailValid("abcde@fghijklmno.c$a"),
            caseId + methodId + "An otherwise valid email with a special character in the top-level domain should not have been valid.");
      assertFalse(underTest.isEmailValid("abcde@fghijklmno.c"),
            caseId + methodId + "An otherwise valid email with a single-character top-level domain should not have been valid.");
      
      assertTrue(underTest.isEmailValid("abcde@fghijklmno.co1"),
            caseId + methodId + "An otherwise valid email with 3 alphanumerics in the top-level domain should have been valid.");
      assertTrue(underTest.isEmailValid("abcde@fghijklmno.0a"),
            caseId + methodId + "An otherwise valid email with 2 alphanumerics in the top-level domain should have been valid.");
   }
   
   @Test
   public void testIsPhoneNumberValid() {
      String methodId = "testIsPhoneNumberValid(): ";
      Validator underTest = new Validator();
      
      assertFalse(underTest.isPhoneNumberValid("1a3-456-7890"),
            caseId + methodId + "An otherwise valid phone number with an alphabetic character in the numbering plan area code should not have been valid.");
      assertFalse(underTest.isPhoneNumberValid("1%3-456-7890"),
            caseId + methodId + "An otherwise valid phone number with a special character in the numbering plan area code should not have been valid.");
      assertFalse(underTest.isPhoneNumberValid("13-456-7890"),
            caseId + methodId + "An otherwise valid phone number with less than 3 digits in the numbering plan area code should not have been valid.");
      assertFalse(underTest.isPhoneNumberValid("1230-456-7890"),
            caseId + methodId + "An otherwise valid phone number with more than 3 digits in the numbering plan area code should not have been valid.");
      
      assertFalse(underTest.isPhoneNumberValid("123-4a6-7890"),
            caseId + methodId + "An otherwise valid phone number with an alphabetic character in the exchange code should not have been valid.");
      assertFalse(underTest.isPhoneNumberValid("123-4)6-7890"),
            caseId + methodId + "An otherwise valid phone number with a special character in the exchange code should not have been valid.");
      assertFalse(underTest.isPhoneNumberValid("123-46-7890"),
            caseId + methodId + "An otherwise valid phone number with less than 3 digits in the exchange code should not have been valid.");
      assertFalse(underTest.isPhoneNumberValid("123-4560-7890"),
            caseId + methodId + "An otherwise valid phone number with more than 3 digits in the exchange code should not have been valid.");
      
      assertFalse(underTest.isPhoneNumberValid("123-456-7a90"),
            caseId + methodId + "An otherwise valid phone number with an alphabetic character in the line number should not have been valid.");
      assertFalse(underTest.isPhoneNumberValid("123-456-7-90"),
            caseId + methodId + "An otherwise valid phone number with a special character in the line number should not have been valid.");
      assertFalse(underTest.isPhoneNumberValid("123-456-789"),
            caseId + methodId + "An otherwise valid phone number with less than 4 digits in the line number should not have been valid.");
      assertFalse(underTest.isPhoneNumberValid("1230-456-78901"),
            caseId + methodId + "An otherwise valid phone number with more than 4 digits in the line number should not have been valid.");
      
      assertFalse(underTest.isPhoneNumberValid("1234567890"),
            caseId + methodId + "An otherwise valid phone number without divider symbols should not have been valid.");
      assertFalse(underTest.isPhoneNumberValid("123.456.7890"),
            caseId + methodId + "An otherwise valid phone number with a divider symbol other than '-' should not have been valid.");
      
      assertTrue(underTest.isPhoneNumberValid("123-456-7890"),
            caseId + methodId + "A phone number having a 3-digit numbering plan area code, a 3-digit exchange code, and a 4-digit line number should have been valid.");      
   }
   
   @Test
   public void testIsDateValid()
   {
      String methodId = "testIsDateValid(): ";
      Validator underTest = new Validator();
      
      assertFalse(underTest.isDateValid("123/12/6789"),
            caseId + methodId + "An otherwise valid date with three digits for the day should not have been valid.");
      assertFalse(underTest.isDateValid("1/12/6789"),
            caseId + methodId + "An otherwise valid date with one digit for the day should not have been valid.");
      assertFalse(underTest.isDateValid("1a/12/6789"),
            caseId + methodId + "An otherwise valid date with an alphabetic character in the day should not have been valid.");
      assertFalse(underTest.isDateValid("00/12/6789"),
            caseId + methodId + "An otherwise valid date with a day less than 01 should not have been valid.");
      assertFalse(underTest.isDateValid("32/12/6789"),
            caseId + methodId + "An otherwise valid date with a day greater than 31 should not have been valid.");
      
      assertFalse(underTest.isDateValid("12/123/6789"),
            caseId + methodId + "An otherwise valid date with three digits for the month should not have been valid.");
      assertFalse(underTest.isDateValid("01/1/6789"),
            caseId + methodId + "An otherwise valid date with one digit for the month should not have been valid.");
      assertFalse(underTest.isDateValid("11/a2/6789"),
            caseId + methodId + "An otherwise valid date with an alphabetic character in the month should not have been valid.");
      assertFalse(underTest.isDateValid("01/00/6789"),
            caseId + methodId + "An otherwise valid date with a month less than 01 should not have been valid.");
      assertFalse(underTest.isDateValid("30/13/6789"),
            caseId + methodId + "An otherwise valid date with a month greater than 13 should not have been valid.");

      assertFalse(underTest.isDateValid("12/12/67890"),
            caseId + methodId + "An otherwise valid date with five digits for the year should not have been valid.");
      assertFalse(underTest.isDateValid("01/01/789"),
            caseId + methodId + "An otherwise valid date with three digits for the year should not have been valid.");
      assertFalse(underTest.isDateValid("11/12/a789"),
            caseId + methodId + "An otherwise valid date with an alphabetic character in the month should not have been valid.");
      
      assertFalse(underTest.isDateValid("01016789"),
            caseId + methodId + "An otherwise valid date without dividers should not have been valid.");
      assertFalse(underTest.isDateValid("01-01-6789"),
            caseId + methodId + "An otherwise valid date with '-' for the dividers should not have been valid.");
      
      assertTrue(underTest.isDateValid("01/01/6789"),
            caseId + methodId + "A date with a day from 01 to 31, a month from 01 to 12, and a year greater than 0 should have been valid.");
   }
}
