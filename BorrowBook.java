package librarysystem;

import java.util.Date;
public class BorrowBook {

    public int id;
    public Member member;
    public Book book;
    public int borrowedBook;
    public Date dateStart;
    public Date dateEnd;

    public BorrowBook(int id, Member member, Book book, int borrowedBook, Date dateStart, Date dateEnd) {
        this.id = id;
        this.member = member;
        this.book = book;
        this.borrowedBook = borrowedBook;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
    public int getborrowedBook() {
        return borrowedBook;
    }

    public void setborrowedBook(int borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

    public void setBook(Book book) {
        this.book = book;


    }




}
