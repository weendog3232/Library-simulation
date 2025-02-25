public class Counter extends Thread {
    Repository r;
public Counter(Repository r) {
        this.r = r;
    }
public synchronized void run() {
    int count = 0;
    while (true) {
        r.setValue(count);//set value of repo to counter
        count++;//increment counter     
        try {
        	wait(500);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
            break;//exit if interrupted
        }
    }
    }
//public final void wait()  try
   
//} catch (InterruptedException e) {
   // e.printStackTrace();
  //  break;}
}
