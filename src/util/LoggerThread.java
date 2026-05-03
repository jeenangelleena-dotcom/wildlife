package util;

public class LoggerThread extends Thread {
    String msg;

    public LoggerThread(String m) {
        msg = m;
    }

    public void run() {
        synchronized(System.out) {
            System.out.println("\n " + msg);
        }
    }
}
//hi