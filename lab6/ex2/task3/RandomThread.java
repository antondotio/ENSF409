import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RandomThread implements Runnable{
    RandomNumber randomNum;
    ArrayList<Integer> numbers;

    synchronized public void run(){
        numbers.add(randomNum.random());
    }


    public RandomThread(){
        randomNum = new RandomNumber();
        numbers = new ArrayList<>();
    }

    public static void main(String[] args){
        int sum = 0;
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Runnable r = new RandomThread();

        for(int i = 0; i < 5; i++){
            executor.execute(r);
        }
        executor.shutdown();

        while(!executor.isTerminated()){
        }

        for(Integer i: ((RandomThread) r).numbers){
            System.out.println(i);
            sum += i;
        }

        System.out.println("Sum is " + sum);
    }
}
