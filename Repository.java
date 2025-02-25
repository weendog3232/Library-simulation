public class Repository {
	 private int value;
	 private int result;
	private boolean sparevalue = false;//to check if it can print a number

	    public synchronized int getValue() {
	    	 while (sparevalue = false) {
	             try {
	                 wait();
	             } catch (InterruptedException e) {
	            	 break;
	             }
	         }
	        result = this.value;
	        sparevalue = false;
	        notifyAll();
	        return result;
	        
	    }

	    public synchronized void setValue(int value) {
	        this.value = value;
	        while (sparevalue=false) {
	        	try {
	        		wait();
	        	} catch (InterruptedException e) {
	        		break;
	        	}
	        }
	    }{this.value = value;
        sparevalue = true;//new value available for repo
        notifyAll(); {
		}//notify publisher
    }
}
	
