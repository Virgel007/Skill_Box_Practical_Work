public class IncorrectNameFormat extends Exception{
    public IncorrectNameFormat(String name){
        super("Неверный формат имени: " + name);
    }
}
