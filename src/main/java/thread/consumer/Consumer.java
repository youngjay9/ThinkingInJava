package thread.consumer;

import thread.stack.MyStack;

public class Consumer {

  private MyStack myStack;

  public Consumer(MyStack myStack) {
    this.myStack = myStack;
  }

  public void popService(){
    myStack.pop();
  }
}
