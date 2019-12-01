package thread.stack;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyStack {

  private Logger logger = LoggerFactory.getLogger(MyStack.class);

  private List<String> list = new ArrayList<String>();

  synchronized public void push() {
    try {
      while (list.size() == 1) {
        this.wait(); // thread 從 blocked queue 中再回來時，從下面一行開始執行
      }/* 當有多個 thread 執行時，需用 while loop 檢查 list 條件(即時更新 list 資料)，檢核該 thread 是否繼續 wait ....   */

      /* 這一段模擬產生資料 */
      list.add("F");

      this.notifyAll();// 當有多個 thread 執行時，需用 notifyall()，避免只喚醒都是執行 push 的 thread，造成所有 thread 都在 wait...

      logger.info("push=" + list.size());

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  synchronized public void pop() {
    try {
      while (list.size() == 0) {
        logger.info(
            Thread.currentThread().getName() + " begin to wait ");
        this.wait(); // thread 從 blocked queue 中再回來時，從下面一行開始執行
      }

      /* 這一段模擬取資料 */
      for (int i = 0; i < list.size(); i++) {
        logger.info("pop: " + list.remove(i));
      }

      this.notifyAll();// 當有多個 thread 執行時，需用 notifyall()，避免只喚醒都是執行 pop 的 thread，造成所有 thread 都在 wait...

    } catch (InterruptedException e) {
      e.printStackTrace();
    }


  }

}
