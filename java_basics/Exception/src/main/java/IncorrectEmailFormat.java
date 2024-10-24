public class IncorrectEmailFormat extends Exception{
    public IncorrectEmailFormat(String email) {
        super("Неверный формат email: " + email);
    }
}
