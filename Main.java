package librarysystem;

public class Main {

    public static void main(String[] args){
        Author author = new Author(1, "Elmarzouqy");
        System.out.println("librarian name is:"+author.getName());

        Collection collection1 = new Collection(2, author, "tazmamart ", 10);
        Book book = new Book(1, collection1, 12, true, false );

        Author othcoll = collection1.getAuthor();

        Collection bookCollection = book.getCollection();
        //System.out.println( "\nauthor of collection " + othcoll.getName());
        System.out.println("\nISBN of this collection is: "+collection1.getIsbn()+"\nauthor of collection " + othcoll.getName() +"\nTitle of this collection is: "+ collection1.getTitle() + "\nquantity of this collection is: "+ collection1.getQuantity());

        System.out.println("book's isbn is: "+ bookCollection.getIsbn());

        System.out.println("book's author is: "+bookCollection.getAuthor().getName() +"\nbook's quantity is: "+bookCollection.getQuantity());

    }
}
