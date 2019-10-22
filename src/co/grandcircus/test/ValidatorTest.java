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
            caseId + methodId + "An email lacking the @ symbol should not have been valid.")
      
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
      
      //Still need to test requirements on domain.
      
   }
   
   @Test
   public void testIsPhoneNumberValid() {
      //isPhoneNumberValid(String phoneNumber)
      fail("Not yet implemented.");
      
   }
   
   @Test
   public void testIsDateValid()
   {
      //isDateValid(String date)
      fail("Not yet implemented.");
   }
}
