public class IncorrectPhoneNumberFormat extends Exception{
    public IncorrectPhoneNumberFormat(String numberPhone) {
        super("Неверный формат номера телефона: " + numberPhone);
    }
}
