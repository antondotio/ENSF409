import java.lang.reflect.Array;
import java.util.ArrayList;

public class RandomThread implements Runnable{
    RandomNumber randomNum;
    int value;

    public void run(){
        value = randomNum.random();
        System.out.println(value);
    }

    public int getValue() { return value; }

    public RandomThread(){
        randomNum = new RandomNumber();
    }

    public static void main(String[] args){
        Runnable ra = new RandomThread();
        Runnable rb = new RandomThread();
        Runnable rc = new RandomThread();
        Runnable rd = new RandomThread();
        Runnable re = new RandomThread();

        Thread a = new Thread(ra);
        Thread b = new Thread(rb);
        Thread c = new Thread(rc);
        Thread d = new Thread(rd);
        Thread e = new Thread(re);

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

        int sum = (((RandomThread) ra).getValue() + ((RandomThread) rb).getValue() + ((RandomThread) rc).getValue() +
                    ((RandomThread) rd).getValue() + ((RandomThread) re).getValue());

        System.out.println("The sum is " + sum);


    }
}
