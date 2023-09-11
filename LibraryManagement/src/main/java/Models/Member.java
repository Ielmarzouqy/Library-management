package Models;

import DbConnection.Myjdbc;

import javax.sound.midi.Soundbank;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Member {
    Myjdbc conn1 = new Myjdbc();
    Scanner scanner = new Scanner(System.in);
    Connection connection = conn1.database();
        public int id;
        public String name;

       /* public Member(int id, String name) {

            this.id = id;
            this.name = name;
        }*/

        public void setId(int id) {
            this.id = id;
        }
        public int getId() {
            return id;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public Member readMember(int id) {
            return null;
        }
public Member get(){
            String sql = "SELECT * FROM member where name = this.name";
            return this;
}
        public Member readMember(String name) {
            return null;
        }

        public void createMemeber() {
            System.out.println("Write the name of  member");
            String nameMember = scanner.nextLine();
            String sql = "insert into member (name) value (?)";
            try(PreparedStatement stm = connection.prepareStatement(sql);
                    ){
                stm.setString(1,nameMember);
                int member = stm.executeUpdate();
                if(member>0){
                    System.out.println("member added successfuly");
                }else{
                    System.out.println("Failed to add member");
                }

            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        public void updateMember(){
            Scanner scanner = new Scanner(System.in);
            System.out.println(" add id of member20");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("write the name of member");
            String name = scanner.nextLine();
            String sql = "update member set name=? where id= ?";
            try(
                    PreparedStatement stm = connection.prepareStatement(sql);
                    ){
                    stm.setString(1, name);
                    stm.setInt(2,id);
                    int member = stm.executeUpdate();
                    if(member>0){
                        System.out.println("member is updated");
                    }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
}
