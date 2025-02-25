public class Publisher extends Thread {
    private Repository r;

   
    public Publisher(Repository r) {//constructor has a repository object
        this.r = r;
    }
 public synchronized void run() {
       
       
        while (true) {
        	 int value = r.getValue();  // Wait for a new value and then get it
             System.out.println("Current value: " + value);
             
            }
           
    }
}

 //public final void wait() {


