package Models;
import Controllers.BookController;
import DbConnection.Myjdbc;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;

public class BorrowBook {
    Myjdbc conn = new Myjdbc();
        public int id;
        public Member member;
        public Book borrowedBook;
        //public int borrowedBook;
        public Date dateStart;
        public Date dateEnd;

        /*public BorrowBook(int id, Member member, Book borrowedBook, int borrowedBook, Date dateStart, Date dateEnd) {
            this.id = id;
            this.member = member;
            this.borrowedBook = borrowedBook;
            //this.borrowedBook = borrowedBook;
            this.dateStart = dateStart;
            this.dateEnd = dateEnd;

        }*/

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
       /* public int getborrowedBook() {
            return borrowedBook;
        }

        public void setborrowedBook(int borrowedBook) {
            this.borrowedBook = borrowedBook;
        }*/

        public void setBook(Book borrowedBook) {
            this.borrowedBook = borrowedBook;
        }
    public Book getBook(){
        return borrowedBook;
    }
       public void borrowingBook() {
           try {
               Book book = new Book();
               Date date = new Date();
               Scanner scanner = new Scanner(System.in);
               java.sql.Date dateStart = new java.sql.Date(date.getTime());
               SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

               System.out.println("Choose the id of the Book");
               int borrowedBook = scanner.nextInt();
               System.out.println("Choose the member");
               int member = scanner.nextInt();
               scanner.nextLine(); // Consume the newline character

               String duedate;
               Date dateEnd = null;
               java.sql.Date sqlDateEnd = null;

               // Input validation loop
               boolean validInput = false;
               while (!validInput) {
                   System.out.println("Write the due date (yyyy-MM-dd)");
                   duedate = scanner.nextLine();

                   try {
                       dateEnd = dateFormat.parse(duedate);
                       sqlDateEnd = new java.sql.Date(dateEnd.getTime());
                       validInput = true; // Set to true if parsing succeeds
                   } catch (ParseException e) {
                       System.err.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
                   }
               }

               String sql = "INSERT INTO `borrowbook`(`bookborrowed`, `memberid`, `dateStart`, `dateEnd`, `islosted`) VALUES (?, ?, ?, ?, ?)";

               try (
                       Connection connection = conn.database();
                       PreparedStatement preparedStatement = connection.prepareStatement(sql);
               ) {
                   preparedStatement.setInt(1, borrowedBook);
                   preparedStatement.setInt(2, member);
                   preparedStatement.setDate(3, dateStart);
                   preparedStatement.setDate(4, sqlDateEnd);
                   preparedStatement.setBoolean(5, false);

                   int rowsAffected = preparedStatement.executeUpdate();
                   if (rowsAffected > 0) {
                       System.out.println("Book is borrowed successfully");
                         String updateStatusBook = "UPDATE book SET available = ? WHERE id =?";
                         try(
                                 PreparedStatement updateStatus = connection.prepareStatement(updateStatusBook)

                                 ){updateStatus.setBoolean(1, false);
                                    updateStatus.setInt(2, borrowedBook);
                            int statusupdated = updateStatus.executeUpdate();
                            if(statusupdated>0){
                                System.out.println("status of book updeted");

                            }else {
                                System.out.println("failed to update status");
                            }
                         }
                   } else {
                       System.out.println("Failed to borrow book");
                   }
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
        public void returnBook(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("wich book you want returned");
           // borrowedBooks.getNonAvailableBooks();
            int bookreturned = scanner.nextInt();
           BookController  borrowedBooks = new BookController();


        String returnBook = "UPDATE book SET available = ? WHERE id = ?";
        try(
                Connection connection = conn.database();
                PreparedStatement returnB = connection.prepareStatement(returnBook)
                ){
            returnB.setBoolean(1, true);
            returnB.setInt(2, bookreturned);
            int rowsAffected = returnB.executeUpdate();
            if(rowsAffected>0){
                System.out.println("book is returned successfuly");
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        }

    public void lostBooks(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("wich book is losted?");
        Connection connection = conn.database();

        int bookLosted = scanner.nextInt();

        String lostBook = "UPDATE borrowbook SET islosted = ? WHERE id = ?";
        try(
                PreparedStatement lostB = connection.prepareStatement(lostBook)
        ){
            lostB.setBoolean(1, true);
            lostB.setInt(2, bookLosted);
            int rowsAffected = lostB.executeUpdate();
            if(rowsAffected>0){
                System.out.println("book is losted");

               String updatelostBooksql = "Update book set lostbook = ? where id = ? ";
               try(
                      PreparedStatement updatelostBook = connection.prepareStatement(updatelostBooksql);
                       ){

                   updatelostBook.setBoolean(1, true);
                   updatelostBook.setInt(2,bookLosted );
                   int res = updatelostBook.executeUpdate();
                   if(res>0){
                       System.out.println("lost book in book is updated");
                   }
               }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
