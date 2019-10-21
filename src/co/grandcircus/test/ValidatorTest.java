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
      //isEmailValid(String email)
      fail("Not yet implemented.");
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
