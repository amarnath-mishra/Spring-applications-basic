
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseConnection {

    public Statement stmt;
    public ResultSet res;
    public Connection conn;
    public PreparedStatement insert;


    public DatabaseConnection() {

    }

    @SuppressWarnings("CallToThreadDumpStack")
    public Connection setConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/onlineexam?user=root&password=amarnath");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public ResultSet getResult(String query, Connection conn) {
        this.conn = conn;
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e+"\nnot addded in the getResult\n");
        }
        return res;
    }

    public void setvalue(int ID, String username, String pass, String first, String last, String email, Connection conn, String query) {
        this.conn = conn;
        try {
            insert = conn.prepareStatement(query);
            insert.setInt(1, ID);
            insert.setString(2, username);
            insert.setString(3, pass);
            insert.setString(4, first);
            insert.setString(5, last);
            insert.setString(6, email);
            insert.executeUpdate();
        } catch (Exception e) {
        }

    }

    public void setvalue2(int ID1, int ID2, int ID3, String date, Connection conn, String query) {
        this.conn = conn;
        try {
            insert = conn.prepareStatement(query);
            insert.setInt(1, ID1);
            insert.setInt(2, ID2);
            insert.setInt(3, ID3);
            insert.setString(4, date);
            insert.executeUpdate();
        } catch (Exception e) {
        }

    }

    public void setvalue3(int ID, String title, String author, String publi, int quantity, int price, String image, Connection conn, String query) {
        this.conn = conn;
        try {
            insert = conn.prepareStatement(query);
            insert.setInt(1, ID);
            insert.setString(2, title);
            insert.setString(3, author);
            insert.setString(4, publi);
            insert.setInt(5, price);
            insert.setInt(6, quantity);
            insert.setString(7, image);
            insert.executeUpdate();
        } catch (Exception e) {
        }

    }


    public void setvalue5(int store, String examname, String department, String subject1, String subject2, String subject3, int examtotal, int examlevel, int duration, Connection conn, String query)
    {

        this.conn = conn;
        try {
            insert = conn.prepareStatement(query);
            insert.setInt(1, store);
            insert.setString(2, examname);
            insert.setString(3, department);
            insert.setString(4, subject1);
            insert.setString(5, subject2);
            insert.setString(6, subject3);
            insert.setInt(7, examtotal);
            insert.setInt(8, examlevel);
            insert.setInt(9, duration);
            insert.executeUpdate();
        } catch (Exception e) {


        }
    }

    public void setvalue4(int store, int marks, String question, String option1, String option2, String option3, String option4, int right_option, int difficulty, String subject, String fac_name, Connection conn, String query) {


        this.conn = conn;
        try {
            insert = conn.prepareStatement(query);
            insert.setInt(1, store);
            insert.setInt(2, marks);
            insert.setString(3, question);

            insert.setString(4, option1);
            insert.setString(5, option2);
            insert.setString(6, option3);
            insert.setString(7, option4);
            insert.setInt(8, right_option);
            insert.setInt(9, difficulty);
            insert.setString(10, subject);
            insert.setString(11,fac_name);

            insert.executeUpdate();
        } catch (Exception e) {

System.out.println(e+"\nnot addded in the database\n");
        }

    }

    public void setvalue7(int student_id, int exam_id, int score, Connection conn, String query) {

        this.conn = conn;
        try {
            insert = conn.prepareStatement(query);
            insert.setInt(1, student_id);
            insert.setInt(2, exam_id);
            insert.setInt(3, score);
            insert.executeUpdate();

        } catch (Exception e) {
        }

    }
}