package Models;
import DbConnection.Myjdbc;

import java.sql.*;
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

        public void borrowingBook(){
            try{
                Scanner scanner = new Scanner(System.in);

                System.out.println("Choose the id of the Book");
                int borrowedBook = scanner.nextInt();
                System.out.println("Choose the member");
                int member = scanner.nextInt();
                //System.out.println("write the due date");
               // String dateEnd = scanner.nextLine();
                String sql = "INSERT INTO `borrowbook`( `bookborrowed`, `memberid`, `islosted`) VALUES (?,?,false) ";
                try(
                        Connection connection = conn.database();
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                       // ResultSet resultSet = preparedStatement.executeQuery();
                ) {
                    preparedStatement.setInt(1, borrowedBook);
                    preparedStatement.setInt(2,member);
                    //preparedStatement.setString(3,dateEnd);
                    int rowsAffected = preparedStatement.executeUpdate();
                    if(rowsAffected>0){
                        System.out.println("book is borrowed successfuly");
                    }else{
                        System.out.println("Failed to borrow book");
                    }
                } }catch(SQLException e){
                    e.printStackTrace();
                }
        }

        public void returnBook(){

        }
}
