public class CalculatorModel {
    private int value;
    public void addTwoNumbers(int first, int sec) {
        value = first + sec;
    }

    public int getValue() {
        return value;
    }
}
