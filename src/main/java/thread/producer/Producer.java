package thread.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import thread.stack.MyStack;

public class Producer {
  private Logger logger = LoggerFactory.getLogger(Producer.class);

  private MyStack myStack;

  public Producer(MyStack myStack) {
    this.myStack = myStack;
  }

  public void pushService(){
    myStack.push();
  }
}
