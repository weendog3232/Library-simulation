
public class Driver {
    public static void main(String[] args) {
        
        Repository r = new Repository();//create one repository object shared between the threads
        
        Counter counter = new Counter(r);
        Publisher publisher = new Publisher(r);//create counter and publisher threads that work on the repository
        
        
        counter.start();//start the threads
        publisher.start();
    }
}