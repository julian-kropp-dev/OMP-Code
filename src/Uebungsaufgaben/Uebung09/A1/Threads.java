package Uebungsaufgaben.Uebung09.A1;

public class Threads extends Thread{
    private final int[] array;
    private final int eingabe;
    private final int startIndex;
    private final int endIndex;
    private boolean found = false;

    public Threads(int[] array, int eingabe, int startIndex, int endIndex) {
        this.array = array;
        this.eingabe = eingabe;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex - 1; i++) {
            if (array[i] == eingabe) {
                found = true;
                System.out.println(this.getName() + " : found");
                return;
            }
        }
        System.out.println(this.getName() + " : not found");
    }


    public static void main(String[] args) {
        int[] array = { 2, 7, 3, 9, 23 };
        arraySearch(array,7);
    }

    private static void arraySearch(int[] array, int value) {
        Threads thread1 = new Threads(array, value, 0, array.length/2);
        Threads thread2 = new Threads(array, value, array.length/2, array.length);
        thread1.setName("Thread 1");
        thread2.setName("Thread 2");
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
            if (thread1.getFound() || thread2.getFound()) {
                System.out.println("Found: true");
            } else {
                System.out.println("Found: false");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean getFound() {
        return found;
    }

}

