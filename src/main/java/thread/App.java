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
    p_thread.setName("producerThread1");
    ConsumerThread c_thread = new ConsumerThread(consumer);
    c_thread.setName("consumerThread1");
    p_thread.start();
    c_thread.start();

    MyStack myStack2 = new MyStack();
    Producer producer2 = new Producer(myStack2);
    Consumer consumer2 = new Consumer(myStack2);
    ProducerThread p_thread2 = new ProducerThread(producer2);
    p_thread2.setName("producerThread2");
    ConsumerThread c_thread2 = new ConsumerThread(consumer2);
    c_thread2.setName("consumerThread2");
    p_thread2.start();
    c_thread2.start();
  }
}
