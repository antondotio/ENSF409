
public class RandomNumber {

    public RandomNumber(){}

    public int random(){
        int max = 100;
        int min = 1;
        int range = (max - min) + 1;
        int value = (int)(Math.random() * range) + min;

        return value;
    }
}
