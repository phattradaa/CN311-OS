import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Thread16 extends Thread{
    private int threadNum;
    final double MAX_VALUE=1_000_000_000;
    static int winner;
    static List<Integer> winnerList = new ArrayList<Integer>();

    public Thread16(int i) {
        this.threadNum = i;
    }

    public void run() {
        int count=0;
        for (int j = 0; j < (1 + MAX_VALUE); j++) {
            count++;
        }
        winner++;
        winnerList.add(threadNum);
        
        if (winner == 3) {
            for (int i = 0; i < 3; i++) {
                System.out.println("The Winner Number " + (i+1) + " is " + "Thread Number " + winnerList.get(i));
            }
        }

    }
    public static void main(String[] args) {
        for (int i = 1; i < 17; i++) {
            Thread16 thread = new Thread16(i);
            System.out.println("Thread " + i + " is running...");
            thread.start();
        }

    }
}
