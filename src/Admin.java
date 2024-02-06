import jakarta.mail.Folder;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.FileInputStream;

public class Admin {
    String url = "jdbc:mysql://localhost:3306/users_accounts";
    String username = "root";
    String password = "";
    ResultSet resultSet;
    Boolean insert = true;
    Admin(){
     String[] ColumnsName = {"id", "title","authors", "language", "description",
             "categories", "publisher","publish_date","pages", "format","ISBN"};
     String[][] Data = {};
     ArrayList<String> bookElements = new ArrayList<String>();

    JFrame frame = new JFrame();
    //-------------------JPanel-------------------------
    JPanel panelbar = new JPanel();
    JPanel panelBooks = new JPanel();
    JPanel panelUsers = new JPanel();
    JPanel panelButton = new JPanel();
    JPanel paneladdBook = new JPanel();
    //-------------------Button---------------------------
    JButton addBook = new JButton("Add book");
    JButton removeBook = new JButton("Remove book");
    JButton updateBook = new JButton("Update book");
    addBook.setBackground(new Color(0xC2C3C5));
    removeBook.setBackground(new Color(0xC2C3C5));
    updateBook.setBackground(new Color(0xC2C3C5));
    JButton addUser = new JButton("Add user");
    JButton removeUser = new JButton("Remove user");
    JButton updateUser = new JButton("Update user");
    JButton addBookOK =  new JButton("OK");
    JButton addBookCancel = new JButton("Cancel");
    JButton reset = new JButton("Reset");
    reset.setVisible(false);
    JButton imgBookButton = new JButton("choose image");


    //-------------------Image Icon-------------------------
        ImageIcon bookIcon = new ImageIcon("Image/book.png");
        ImageIcon userIcon = new ImageIcon("Image/user.png");
        ImageIcon logoutIcon = new ImageIcon("image/logout.png");
    //-------------------Label------------------------------
        JLabel book = new JLabel();
        JLabel user = new JLabel();
        JLabel logout = new JLabel();
        book.setBounds(40,5,50,50);
        user.setBounds(173,5,50,50);
        logout.setBounds(300,5,50,50);

        //-------------------File Chooser-----------------------
        JFileChooser imgBook = new JFileChooser();
        imgBook.setCurrentDirectory(new java.io.File("image"));

        //-------------------Table -----------------------------
    JTable bookTable = new JTable();
    bookTable.setBackground(new Color(0x65656C));
    bookTable.setForeground(new Color(0xE8E8EC));
    bookTable.setFont(new Font("Times new Roman", Font.PLAIN, 14));
    JScrollPane bookScroll = new JScrollPane(bookTable);
    JTable usersTable = new JTable();
    usersTable.setBackground(new Color(0x65656C));
    usersTable.setForeground(new Color(0xE8E8EC));
    usersTable.setFont(new Font("Times new Roman", Font.PLAIN, 14));
    JScrollPane userScroll = new JScrollPane(usersTable);




    // ------------------Panelbar components----------------
        panelbar.setLayout(null);
        panelbar.setPreferredSize(new Dimension(400, 70));
        panelbar.add(book);
        panelbar.add(user);
        panelbar.add(logout);
        panelbar.setBackground(new Color(0x6A6A6C));
    //------------------panelBook components --------------
        panelBooks.setLayout(new BorderLayout());
        panelBooks.setPreferredSize(new Dimension(400, 530));
        panelBooks.add(bookScroll, BorderLayout.CENTER);
        panelBooks.add(panelButton, BorderLayout.SOUTH);
    //------------------panelButton components-------------
        panelButton.setLayout(new FlowLayout());
        panelButton.setPreferredSize(new Dimension(400, 40));
        panelButton.add(addBook);
        panelButton.add(removeBook);
        panelButton.add(updateBook);
    //-----------------paneladdBook components-------------

     paneladdBook.setLayout(new GridLayout(13,2));
     paneladdBook.setPreferredSize(new Dimension(400, 530));
     paneladdBook.add(new JLabel("  Image : "));
     paneladdBook.add(imgBookButton);;
     //--------------------PanelUsers--------------------
        panelUsers.setLayout(new BorderLayout());
        panelUsers.setPreferredSize(new Dimension(400, 530));
        panelUsers.add(userScroll, BorderLayout.CENTER);
        panelUsers.setVisible(false);




      JLabel label = new JLabel("  "+ColumnsName[0]+" : ");
      JTextField text = new JTextField();
      label.setFont(new Font("Arial", Font.PLAIN, 14));
      paneladdBook.add(label);
      paneladdBook.add(text);

        JLabel label1 = new JLabel("  "+ColumnsName[1]+" : ");
        JTextField text1 = new JTextField();
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        paneladdBook.add(label1);
        paneladdBook.add(text1);

        JLabel label2 = new JLabel("  "+ColumnsName[2]+" : ");
        JTextField text2 = new JTextField();
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        paneladdBook.add(label2);
        paneladdBook.add(text2);

        JLabel label3 = new JLabel("  "+ColumnsName[3]+" : ");
        JTextField text3 = new JTextField();
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        paneladdBook.add(label3);
        paneladdBook.add(text3);

        JLabel label4 = new JLabel("  "+ColumnsName[4]+" : ");
        JTextField text4 = new JTextField();
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        paneladdBook.add(label4);
        paneladdBook.add(text4);

        JLabel label5 = new JLabel("  "+ColumnsName[5]+" : ");
        JTextField text5 = new JTextField();
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        paneladdBook.add(label5);
        paneladdBook.add(text5);

        JLabel label6 = new JLabel("  "+ColumnsName[6]+" : ");
        JTextField text6 = new JTextField();
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        paneladdBook.add(label6);
        paneladdBook.add(text6);

        JLabel label7 = new JLabel("  "+ColumnsName[7]+" : ");
        JTextField text7 = new JTextField();
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        paneladdBook.add(label7);
        paneladdBook.add(text7);

        JLabel label8 = new JLabel("  "+ColumnsName[8]+" : ");
        JTextField text8 = new JTextField();
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        paneladdBook.add(label8);
        paneladdBook.add(text8);

        JLabel label9 = new JLabel("  "+ColumnsName[9]+" : ");
        JTextField text9 = new JTextField();
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        paneladdBook.add(label9);
        paneladdBook.add(text9);

        JLabel label10 = new JLabel("  "+ColumnsName[10]+" : ");
        JTextField text10 = new JTextField();
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        paneladdBook.add(label10);
        paneladdBook.add(text10);





     paneladdBook.add(addBookCancel);
     paneladdBook.add(addBookOK);
     paneladdBook.add(reset);
     paneladdBook.setVisible(false);


        //--------------JLabel components------------------
        book.setIcon(bookIcon);

        user.setIcon(userIcon);
        logout.setIcon(logoutIcon);
    //-------------Buttons Actionlistener---------------
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              panelBooks.setVisible(false);
              paneladdBook.setVisible(true);
              reset.setVisible(false);
              paneladdBook.repaint();
              paneladdBook.revalidate();
            }
        });
        removeBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });
        updateBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset.setVisible(true);
                addBookOK.setVisible(false);
               panelBooks.setVisible(false);
               paneladdBook.setVisible(true);
               paneladdBook.repaint();
               paneladdBook.revalidate();

               text.setText(""+bookTable.getValueAt(bookTable.getSelectedRow(),0));
               text1.setText(""+bookTable.getValueAt(bookTable.getSelectedRow(),1));
               text2.setText(""+bookTable.getValueAt(bookTable.getSelectedRow(),3));
               text3.setText(""+bookTable.getValueAt(bookTable.getSelectedRow(),4));
               text4.setText(""+bookTable.getValueAt(bookTable.getSelectedRow(),5));
               text5.setText(""+bookTable.getValueAt(bookTable.getSelectedRow(),6));
               text6.setText(""+bookTable.getValueAt(bookTable.getSelectedRow(),7));
               text7.setText(""+bookTable.getValueAt(bookTable.getSelectedRow(),8));
               text8.setText(""+bookTable.getValueAt(bookTable.getSelectedRow(),9));
               text9.setText(""+bookTable.getValueAt(bookTable.getSelectedRow(),10));
               text10.setText(""+bookTable.getValueAt(bookTable.getSelectedRow(),11));


            }

        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ;

                    String query = "update  books set id = ?, title = ?, image = ? ,authors = ?, language = ?, description = ?, categories = ?, publisher = ?,publish_date = ?,pages = ?, format = ?,ISBN = ? where id = ?;";


                    InputStream in = new FileInputStream(imgBook.getSelectedFile());
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, username, password);
                    PreparedStatement ps = connection.prepareStatement(query);
                    ps.setInt(1, Integer.parseInt(text.getText()));
                    ps.setString(2, text1.getText() );
                    ps.setBlob(3, in);
                    ps.setString(4, text2.getText());
                    ps.setString(5, text3.getText());
                    ps.setString(6, text4.getText());
                    ps.setString(7, text5.getText());
                    ps.setString(8, text6.getText());
                    ps.setDate(9,  java.sql.Date.valueOf(text7.getText()));
                    ps.setInt(10, Integer.parseInt(text8.getText()));
                    ps.setString(11, text9.getText());
                    ps.setInt(12, Integer.parseInt(text10.getText()));
                    ps.setInt(13, bookTable.getSelectedRow()+1);
                    ps.executeUpdate();
                    connection.close();
                    JOptionPane.showMessageDialog(null,"Book info updated successfully.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        addUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        removeUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });
        updateUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        addBookCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paneladdBook.setVisible(false);
                panelBooks.setVisible(true);
            }
        });
        imgBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                imgBook.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("image JPG , GIF , PNG et JPEG ", "jpg", "gif","png", "jpeg");
                imgBook.addChoosableFileFilter(filter);
                imgBook.showOpenDialog(null);
                imgBookButton.setText(imgBook.getSelectedFile().getName());
            }
        });



        addBookOK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                   ;

                   String query = "insert into books (id, title, image,authors, language, description, categories, publisher,publish_date,pages, format,ISBN) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";


                    InputStream in = new FileInputStream(imgBook.getSelectedFile());
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, username, password);
                    PreparedStatement ps = connection.prepareStatement(query);
                    ps.setInt(1, Integer.parseInt(text.getText()));
                    ps.setString(2, text1.getText() );
                    ps.setBlob(3, in);
                    ps.setString(4, text2.getText());
                    ps.setString(5, text3.getText());
                    ps.setString(6, text4.getText());
                    ps.setString(7, text5.getText());
                    ps.setString(8, text6.getText());
                    ps.setDate(9,  java.sql.Date.valueOf(text7.getText()));
                    ps.setInt(10, Integer.parseInt(text8.getText()));
                    ps.setString(11, text9.getText());
                    ps.setInt(12, Integer.parseInt(text10.getText()));
                    ps.executeUpdate();
                    connection.close();
                    JOptionPane.showMessageDialog(null,"Book added successfully.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        //----------------display book data in the table-------------------
        DefaultTableModel model = new DefaultTableModel();
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from books");
            ResultSetMetaData rsmd = resultSet.getMetaData();
             model = (DefaultTableModel) bookTable.getModel();
            System.out.println("vjhvh");
            int cols = rsmd.getColumnCount();
            String[]  ColumnName = new String[cols];
            for(int i=0;i<cols;i++) {

                    ColumnName[i] = rsmd.getColumnName(i + 1);
            }
            model.setColumnIdentifiers(ColumnName);

            String  title,image,authors, language, description, categories, publisher,publish_date, format;
            String id, pages, ISBN;
            System.out.println("bkhbk j");
            while (resultSet.next()){
                id = resultSet.getString(1);
                title = resultSet.getString(2);
                image = "  ---";
                authors = resultSet.getString(4);
                language = resultSet.getString(5);
                description = resultSet.getString(6);
                categories = resultSet.getString(7);
                publisher = resultSet.getString(8);
                publish_date = resultSet.getString(9);
                pages = resultSet.getString(10);
                format = resultSet.getString(11);
                ISBN = resultSet.getString(12);
                String[] row = {id, title,image, authors, language, description, categories, publisher,publish_date,pages, format,ISBN};
                model.addRow(row);

            }

            connection.close();


            System.out.println("b ,n ,");
        }catch (Exception e){

        }
        bookTable.setModel(model);
        removeBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection connection = DriverManager.getConnection(url, username, password);

                    PreparedStatement prst = connection.prepareStatement("delete from books where id = ?");
                    prst.setInt(1,bookTable.getSelectedRow()+1);
                    prst.execute();
                    connection.close();
                    JOptionPane.showMessageDialog(null,"Book removed successfully.");
                      } catch (SQLException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                bookTable.revalidate();
                bookTable.repaint();
                System.out.println(bookTable.getSelectedRow());
            }
        });
        //----------display user information in the table-----------------
        DefaultTableModel modeluser = new DefaultTableModel();
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from login_table");
            ResultSetMetaData rsmd = resultSet.getMetaData();
            modeluser = (DefaultTableModel) usersTable.getModel();

            int cols = rsmd.getColumnCount();
            String[]  ColumnName = new String[cols];
            for(int i=0;i<cols;i++) {

                ColumnName[i] = rsmd.getColumnName(i + 1);
            }
            modeluser.setColumnIdentifiers(ColumnName);

            String  email, username, password;

            System.out.println("bkhbk j");
            while (resultSet.next()){
                email = resultSet.getString(1);
                username = resultSet.getString(2);
                password = resultSet.getString(3);
                String[] row = {email, username,password};
                modeluser.addRow(row);

            }

            connection.close();



        }catch (Exception e){

        }
        usersTable.setModel(modeluser);
        book.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelBooks.setVisible(true);
                panelUsers.setVisible(false);
                panelBooks.revalidate();
                panelBooks.repaint();

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {


            }
        });
        user.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelUsers.setVisible(true);
                panelBooks.setVisible(false);
                panelUsers.revalidate();
                panelUsers.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        logout.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Login();
                frame.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        frame.setLayout(new BorderLayout());
        frame.add(paneladdBook, BorderLayout.WEST);
        frame.add(panelBooks, BorderLayout.CENTER);
        frame.add(panelbar, BorderLayout.SOUTH);
        frame.add(panelUsers, BorderLayout.EAST);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,650);
        frame.setVisible(true);

}

    public static void main(String[] args) {
        Admin admin = new Admin();
    }
}
