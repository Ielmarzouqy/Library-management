package librarysystem;

public class Book {

	public int id;
	public Collection collection;
	public float price;
	public boolean available;
	public boolean lostBook;

	public Book(int id, Collection collection, float price, boolean available, boolean lostBook) {

		this.id = id;
		this.collection = collection;
		this.price = price;
		this.available = available;
		this.lostBook = lostBook;


	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCollection(Collection collection) {
		this.collection = collection;

	}
	public Collection getCollection(){
		return collection;
	}
	public float getPrice() {
		return price;
	}
	public boolean getAvailable() {
		return 	available;
	}
	public boolean getLostBook() {
		return lostBook;
	}

	public Book[] readBooks(String text) {
		if(text == null) {

		}else {

		}
		return null ;
	}
	public Book readBook(int id) {
		return null;
	}

	public Book readBook(String SBIN) {
		return null;
	}

	public void updateBook() {
		System.out.println("updated");
	}
	public void deleteBook() {

	}
	public void createBook() {

	}


}
