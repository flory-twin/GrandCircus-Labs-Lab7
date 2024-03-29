package co.grandcircus;

public class Validator
{
   public boolean isNameValid(String name)
   {
      
      return name.matches("[A-Z][a-zA-Z]{0,29}");
   }
   
   public boolean isEmailValid(String email)
   {
      return email.matches("[a-zA-Z0-9]{5,30}@[a-zA-Z0-9]{5,10}\\.[a-zA-Z0-9]{2,3}");
   }
   
   public boolean isPhoneNumberValid(String phoneNumber)
   {
      return phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}");
   }
   
   public boolean isDateValid(String date)
   {
      return date.matches("(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}");
   }
}
