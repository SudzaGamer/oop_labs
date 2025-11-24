package concurrent;

import functions.UnitFunction;
import functions.LinkedListTabulatedFunction;

import java.util.ArrayList;
import java.util.List;

public class MultiplyingTaskExecutor {

    public static void main(String[] args) throws InterruptedException {
        UnitFunction unitFunction = new UnitFunction();
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(unitFunction, 1, 1000, 1000);

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            MultiplyingTask task = new MultiplyingTask(function);
            Thread thread = new Thread(task);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        Thread.sleep(2000);

        System.out.println("Final function values:");
        for (int i = 0; i < function.getCount(); i++) {
            System.out.printf("x = %.6f, y = %.6f%n", function.getX(i), function.getY(i));
        }
    }
}