package thread.extthread;

import thread.producer.Producer;

public class ProducerThread extends Thread {

  private Producer producer;

  public ProducerThread(Producer p) {
    this.producer = p;
  }

  @Override
  public void run() {
    while(true){
      producer.pushService();
    }
  }
}
