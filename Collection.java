package librarysystem;

public class Collection {

	public int isbn;
	public String title;
	public Author author;
	public int quantity;

	public  Collection(int isbn, Author author,  String title, int quantity) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.quantity = quantity;
	}

	public void setAuthor(Author author) {
		this.author = author;

	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;

	}
	public Author getAuthor() {
		return author;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setTitle(String title) {
		this.title = title;

	}
	public String getTitle() {
		return title;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;

	}
	public int getQuantity() {
		return quantity;
	}


	public Collection[] readCollectios(String text) {
		if(text == null) {

		}else {

		}
		return null ;
	}


}
