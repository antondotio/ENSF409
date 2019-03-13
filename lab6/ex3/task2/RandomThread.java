import java.util.ArrayList;

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
        Runnable r = new RandomThread();

        Thread a = new Thread(r);
        Thread b = new Thread(r);
        Thread c = new Thread(r);
        Thread d = new Thread(r);
        Thread e = new Thread(r);

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();

        try {
            a.join();
            b.join();
            c.join();
            d.join();
            e.join();
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }

        for(Integer i: ((RandomThread) r).numbers){
            System.out.println(i);
            sum += i;
        }

        System.out.println("Sum is " + sum);
    }
}
