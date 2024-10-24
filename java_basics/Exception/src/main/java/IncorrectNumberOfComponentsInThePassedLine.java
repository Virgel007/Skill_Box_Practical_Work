public class IncorrectNumberOfComponentsInThePassedLine extends Exception{
    public IncorrectNumberOfComponentsInThePassedLine(int count) {
        super("Некорректное количество компонентов в переданной строке с данными: " + count);
    }
}
