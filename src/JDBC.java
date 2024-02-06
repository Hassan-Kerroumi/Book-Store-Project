
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.*;

public class JDBC {


    int  my_update(String str1, String str2, String str3){

        InputStream in = null;
        try {
            in = new FileInputStream("image/user.png");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/users_accounts";
        String username = "root";
        String password ="";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            String createDB = "create database users_accounts";
            String createTable = "create table login_table Email varchar, username varchar, password varchar";

            PreparedStatement ps = connection.prepareStatement("insert into login_table (Email,username, password, userImage) VALUES (?,?,?,?)");

            ps.setString(1,str1);
            ps.setString(2,str2);
            ps.setString(3,str3);
            ps.setBlob(4, in);
            ps.executeUpdate();

            connection.close();
        }
        catch(Exception e){

            if(  e.getMessage().contains("Duplicate entry") ){
                System.out.println("Erorr ");
                return -1;
            }
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());


        }
        return 0;
    }
    int login(String str1, String str2){
        String query = "select * from login_table where (email =? OR username=?) AND password=?";


        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_accounts", "root", "");
            PreparedStatement ps;
            ResultSet rs = null;
            ps = con.prepareStatement(query);
            ps.setString(1,str1);
            ps.setString(2, str1);
            ps.setString(3,str2);
            rs = ps.executeQuery();
            if(rs.next()){
                System.out.println(rs.next());
                return 1;
            }else{
                Login.wrong_login.setVisible(true);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;

    }
    int setPassword(){

        return 1;
    }

    String getSQL(String str1,String str2) {
        String query = "select * from login_table where username=? OR email=?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_accounts", "root", "");
            PreparedStatement ps;
            ResultSet rs = null;
            ps = con.prepareStatement(query);

            ps.setString(1, str1);
            ps.setString(2, str1);

            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("username"));
                return rs.getString(str2);
            } else {
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "None";

    }
    ImageIcon getSQL_image(String str1) {
        String query = "select * from login_table where username=? OR email=?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_accounts", "root", "");
            PreparedStatement ps;
            ResultSet rs = null;
            ps = con.prepareStatement(query);

            ps.setString(1, str1);
            ps.setString(2, str1);

            rs = ps.executeQuery();
            if (rs.next()) {
                ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().createImage(rs.getBytes(4)));
                return icon;
            } else {

            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;

    }

    void change_username(String str1, String str2) {
        String query = "update login_table set username=? where username=?";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_accounts", "root", "");
            PreparedStatement ps;
            ResultSet rs = null;
            ps = con.prepareStatement(query);
            ps.setString(1, str2);
            ps.setString(2, str1);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void change_password(String str1, String str2) {
        String query = "update login_table set password=? where password=?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_accounts", "root", "");
            PreparedStatement ps;
            ResultSet rs = null;
            ps = con.prepareStatement(query);
            ps.setString(1, str2);
            ps.setString(2, str1);
            ps.executeUpdate();
        } catch (SQLException|ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    void change_pfp(JFileChooser chooser, String str){
        String query = "update login_table set userImage=? where username=?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_accounts", "root", "");
            PreparedStatement ps;
            ResultSet rs = null;
            InputStream in = new FileInputStream(chooser.getSelectedFile());
            ps = con.prepareStatement(query);
            ps.setBlob(1, in);
            ps.setString(2, str);

            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    void delete_account(String str1){
        String query = "delete from login_table where username=?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_accounts", "root", "");
            PreparedStatement ps;
            ResultSet rs = null;
            ps = con.prepareStatement(query);
            ps.setString(1, str1);
            ps.executeUpdate();
        } catch (SQLException |ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}







