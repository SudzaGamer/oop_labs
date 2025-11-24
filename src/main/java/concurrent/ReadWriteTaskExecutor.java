package concurrent;


import functions.ConstantFunction;
import functions.LinkedListTabulatedFunction;

public class ReadWriteTaskExecutor {

    public static void main(String[] args) {

        ConstantFunction sourceFunction = new ConstantFunction(-1);
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(sourceFunction, 1, 50, 50);

        ReadTask readTask = new ReadTask(function);
        WriteTask writeTask = new WriteTask(function, 0.5);

        Thread readerThread = new Thread(readTask);
        Thread writerThread = new Thread(writeTask);

        readerThread.start();
        writerThread.start();
    }
}
