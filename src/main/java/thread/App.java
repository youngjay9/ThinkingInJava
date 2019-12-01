package thread;

import thread.consumer.Consumer;
import thread.extthread.ConsumerThread;
import thread.extthread.ProducerThread;
import thread.producer.Producer;
import thread.stack.MyStack;

public class App {
  public static void main(String[] args) {
    MyStack myStack = new MyStack();
    Producer producer = new Producer(myStack);
    Consumer consumer = new Consumer(myStack);
    ProducerThread p_thread = new ProducerThread(producer);
    ConsumerThread c_thread = new ConsumerThread(consumer);
    p_thread.start();
    c_thread.start();
  }
}
