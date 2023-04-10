import java.lang.Runnable;
public class HW2 extends Thread{
    private int threadNum;

    public HW2(int i) {
        this.threadNum = i;
    }

    public void run() {
        String fullname;
        fullname = "Phattrada " + "Mikota";
        int count;
        if (threadNum == 1) {
            System.out.println("Phattrada");
        } else if (threadNum == 2) {
            System.out.println("Mikota");
        } else if (threadNum == 3) {
            StringBuilder fullnameReverse = new StringBuilder(fullname);
            fullnameReverse.reverse();
            System.out.println(fullnameReverse);
        } else if (threadNum == 4) {
            count = fullname.length();
            System.out.println(count - 1);
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            HW2 thread = new HW2(i);
            System.out.println("Thread " + i + " is running...");
            thread.start();
        }
    }
}