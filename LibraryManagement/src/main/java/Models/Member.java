package Models;

public class Member {
        public int id;
        public String name;

        public Member(int id, String name) {

            this.id = id;
            this.name = name;
        }
    public Member( String name) {


        this.name = name;
    }
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
            System.out.println("created member");
        }
}
