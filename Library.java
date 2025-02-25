import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
 class Library
{  ArrayList<Book>books;
    //ArrayList<Library>library;
  

public Library(){ 
    books=new ArrayList<Book>();
   // library=new ArrayList<Library>();
}
public int findBookIndex(String isbn){

    
    for (int i = 0; i < books.size(); i++) {
       
        Book b = books.get(i);
        
        if (b.getIsbn().equals(isbn)) {
            
            return i;
        }
    }
   
    return -1;
}

    

public Book loanBook(int i){
	 if (i < 0 || i >= books.size()) {
	       
	        return null;
	        
	    }
	 return books.remove(i);
	    
	    
	    
	
}
public void returnBook(Book book){
	  books.add(book);
}
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        Library L= new Library();
        Book b; 
        String authorFirstName,authorSurname,isbn;
        int publishYear;
        System.out.println("input author first name");
        authorFirstName = scan.nextLine();
        System.out.println("input author last name");
        authorSurname=scan.nextLine();
         System.out.println("input the publishing year");
         publishYear=scan.nextInt();
         scan.nextLine();
         isbn="Ab11228";
        b = new Book(authorFirstName,authorSurname,isbn,
        publishYear);
        L.books.add(b);
        
        
        Member M1 = new Member(L);
        Member M2 = new Member(L);
        M1.start();
        M2.start();
        }
}
    class Member extends Thread {
         Library library;//library instance variable
         String isbn = "Ab11228";//hardcoded ISBN value

      
        public Member(Library library) { //constructor 
            this.library = library;
        }

     
        
        public void run() {
           
            int i = library.findBookIndex("Ab11228");//call findBookIndex using the hardcoded ISBN
            
            
            if (i!= -1) { //if index is not negative(invalid)
                Book b= library.loanBook(i);//if the index is valid loan the book
                if (b != null) {//if book is not empty
                    System.out.println("member has loaned the book: " + "Ab11228");
                    
                    
                    try {
                        Thread.sleep(5000);//sleep for 5000 milliseconds to simulate memebr reading book
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                  
                    library.returnBook(b);//return the book to the library
                    System.out.println("member has returned the book: " + b.getIsbn());
                }
            } else {
                System.out.println("the book with isbn " + isbn + "  was not found in the library.");
            }
        }
    }
    
        