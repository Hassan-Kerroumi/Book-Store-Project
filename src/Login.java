import com.mysql.cj.sasl.ScramShaSaslProvider;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.beans.beancontext.BeanContextContainerProxy;
import java.util.Arrays;
import java.sql.*;
import java.util.Properties;
import java.util.Random;

import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


public class Login {
    static  int randomCode;
    static  Connection con = null;
    static  PreparedStatement ps =null;
    static  ResultSet rs = null;
    public  String user;
    static public String _username;
    static public JLabel wrong_login;
    static String get_username(){
        return _username;
    }
    public Login(){

        Color background =Color.DARK_GRAY;
        Color backgroundp = new Color(0x252323);
        Color forground = new Color(0x3D3D41);
        Font font = new Font("Times new Roman", Font.PLAIN, 16);
        JFrame frame = new JFrame("Login");
        JLabel email1 = new JLabel("Email : ");
        JLabel password1 = new JLabel("Password : ");
        JLabel forget_password = new JLabel("Forget password?");
        JButton btn1 = new JButton("Log in ");
        JButton btn2 =  new JButton("Create an account");
        TextField email = new TextField();
        JPasswordField pw = new JPasswordField();
        ImageIcon icon = new ImageIcon("image/Back.png");
        wrong_login = new JLabel("*Wrong username or password");
        wrong_login.setForeground(new Color(0xD91720));
        wrong_login.setVisible(false);

        JLabel email2 = new JLabel("Email : ");
        JLabel userName = new JLabel("Username : ");
        JLabel password2 = new JLabel("Password : ");
        JLabel password3 = new JLabel("Confirm Password : "); // confirm password
        JLabel forgetmail = new JLabel("Enter email : ");
        JLabel labelVerifyCode = new JLabel("verify code : ");
        JLabel newPassword = new JLabel("New password : ");
        JLabel cfrNewpassword = new JLabel("Confirm your password : ");
        JLabel loginTitle = new JLabel("Login");
        JLabel frameImage = new JLabel();
        frameImage.setBounds(0,0, 400,650);
        frameImage.setIcon(new ImageIcon("image/login_background.jpg"));
        loginTitle.setFont(new Font("Times new Roman", Font.BOLD, 40));
        loginTitle.setBounds(140,50,150,50);
        loginTitle.setForeground(Color.WHITE);
        loginTitle.setBackground(background);
        wrong_login.setBounds(50,10,200,50);



        JButton btn3 = new JButton("Sign in ");
        JButton btn4 =  new JButton("Log in");
        JTextField textEmail = new JTextField();
        JTextField textUser = new JTextField();
        JTextField textforgetMail = new JTextField();
        JTextField textVerifyCode = new JTextField();
        JPasswordField textNewPassword = new JPasswordField();
        JPasswordField textCfrNewpassword = new JPasswordField();

        //-------------------------Send Email -----------------------------
        JButton sendEmail = new JButton("Send ");
        JButton verifyCode = new JButton("Verify code");
        JLabel back = new JLabel();
        JButton reset = new JButton("Reset");

        JPasswordField SiginPw1 = new JPasswordField("Enter Password");
        JPasswordField SiginPw2 = new JPasswordField();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        //--------------------JPassword---------------------------------------
        pw.setBounds(100 , 110, 180,30);
        pw.setEchoChar('*');
        //pw.setEchoChar((char)0);//Afficher password*
        // sigin pasword
        SiginPw1.setBounds(80 , 170, 200,30);
        SiginPw2.setBounds(80 , 240, 200,30);
        SiginPw1.setEchoChar((char)0);

        // -------------------------JLabel------------------------------------
        email1.setBounds(20,60,60,30);
        email1.setForeground(forground);
        email1.setFont(font);
        email.setBounds(100,60,180,30);
        email.setFont(font);
        email.setForeground(forground);
        password1.setBounds(20,110,80,30);
        password1.setFont(font);
        password1.setForeground(forground);
        forget_password.setBounds(40,150,120,30);
        forget_password.setFont(font);
        forget_password.setForeground(new Color(0x12C2D9));

        //-----------------------------SiginJLabel---------------------------
        email2.setBounds(20,80,60,30);
        email2.setForeground(forground);
        email2.setFont(font);
        userName.setBounds(20,20,   100, 30 );
        userName.setFont(font);
        userName.setForeground(forground);
        textEmail.setBounds(80,110,200,30);
        textUser.setBounds(80,50,200,30);
        password2.setBounds(20,140,150,30);
        password2.setFont(font);
        password2.setForeground(forground);
        password3.setBounds(20,210,150,30);
        password3.setFont(font);
        password3.setForeground(forground);

        // ____________________________JButton-------------------------------
        btn1.setBounds(50,205,200,30);
        btn2.setBounds(50,250,200,30);
        btn1.setForeground(Color.WHITE);
        btn2.setForeground(Color.WHITE);
        btn1.setBackground(background);
        btn2.setBackground(background);
        btn1.setFont(font);
        btn2.setFont(font);
        // Sigin buttons
        btn3.setBounds(50,290,200,30);
        btn4.setBounds(50,330,200,30);
        btn3.setForeground(Color.WHITE);
        btn4.setForeground(Color.WHITE);
        btn3.setBackground(background);
        btn4.setBackground(background);
        btn3.setFont(font);
        btn4.setFont(font);
        //---------------------------Panel3 components-----------------------

        forgetmail.setBounds(30,90,100,30);
        forgetmail.setFont(font);
        textforgetMail.setBounds(30,130,200,30);
        sendEmail.setBounds(80,180,150,30);
        sendEmail.setBackground(background);
        sendEmail.setFont(font);
        verifyCode.setBackground(background);
        verifyCode.setFont(font);
        sendEmail.setForeground(Color.WHITE);
        verifyCode.setForeground(Color.WHITE);
        back.setBounds(0,0,50,50);
        back.setIcon(icon);
        labelVerifyCode.setBounds(30,220,100,30);
        labelVerifyCode.setFont(font);
        textVerifyCode.setBounds(30,260,200,30);
        textVerifyCode.setFont(font);
        verifyCode.setBounds(80,300,150,30);

        //-------------------------------------Panel4 components----------------
        newPassword.setBounds(30, 40,160,30);
        newPassword.setFont(font);
        textNewPassword.setBounds(50, 80,200,30);
        cfrNewpassword.setBounds(30, 120,200,30);
        cfrNewpassword.setFont(font);
        textCfrNewpassword.setBounds(50, 160,200,30);
        reset.setBounds(120,200,150,30);
        reset.setFont(font);
        reset.setBackground(background);
        reset.setForeground(Color.WHITE);

        // ----------------------------JPanel-----------------------------------
        panel1.setBounds(40,100,300,400);
        panel1.setBackground(new Color(0xFFFFFF));
        panel1.add(pw);
        panel1.add(email1);
        panel1.add(password1);
        panel1.add(email);
        panel1.add(btn1);
        panel1.add(btn2);
        panel1.add(forget_password);
        panel1.setLayout(null);
        panel1.setVisible(true);
        // -----------------Panel2-------------------
        panel2.setBounds(40,100,300,400);
        panel2.setBackground(new Color(240, 243, 242));
        panel2.add(SiginPw1);
        panel2.add(SiginPw2);
        panel2.add(email2);
        panel2.add(password2);
        panel2.add(password3);
        panel2.add(textEmail);
        panel2.add(btn3);
        panel2.add(btn4);
        panel2.setLayout(null);
        panel2.setVisible(false);
        panel2.add(userName);
        panel2.add(textUser);

        //panel.setPreferredSize(new Dimension(200,200));
        //------------------------Panel3-----------------

        panel3.setBounds(40,100,300,400);
        panel3.setBackground(new Color(240, 243, 241));
        panel3.add(textforgetMail);
        panel3.add(forgetmail);
        panel3.add(back);
        panel3.add(sendEmail);
        panel3.setVisible(false);
        panel3.add(labelVerifyCode);
        panel3.add(textVerifyCode);
        panel3.add(verifyCode);
        panel3.setLayout(null);
        //------------------------Panel4--------------------------
        panel4.setBounds(40,100,300,400);
        panel4.setBackground(new Color(238, 243, 239));
        panel4.add(newPassword);
        panel4.add(cfrNewpassword);
        panel4.add(textNewPassword);
        panel4.add(textCfrNewpassword);
        panel4.add(reset);
        panel4.setVisible(false);
        panel4.setLayout(null);

        //-------------


        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(email.getText().equals("admin@gmail.com") && new JDBC().login(email.getText(),pw.getText())==1){
                      new Admin();
                      frame.setVisible(false);
                }
                if(new JDBC().login(email.getText(),pw.getText())==1 && !email.getText().equals("admin@gmail.com")){
                    new Home();
                    _username=email.getText();
                    frame.setVisible(false);
                }
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                panel2.setVisible(true);
                loginTitle.setText("Sign in");

            }
        });


        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(true);
                panel2.setVisible(false);
                loginTitle.setText("Login");

            }
        });

        back.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel1.setVisible(true);
                panel3.setVisible(false);
                loginTitle.setText("Login");
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

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JDBC jdbc = new JDBC();


                if( jdbc.my_update(textEmail.getText(), textUser.getText(), new String(SiginPw1.getPassword())) == -1) {
                    JOptionPane.showMessageDialog(null, "this in email is already used");

                }



                if(Arrays.equals(SiginPw1.getPassword(), SiginPw2.getPassword()) && SiginPw1.getPassword()!=null){
                    _username=textUser.getText();
                    System.out.println(textUser.getText());
                    new Home();
                    frame.setVisible(false);

                }
            }
        });


        sendEmail.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Random rand = new Random();
                randomCode = rand.nextInt(99999);

                String host = "smtp.gmail.com"; // Note the correct spelling of "smtp"
                String user = "data.python13@gmail.com"; // Your Gmail email address
                // Your Gmail password
                String subject = "Resetting password";
                String username = "data.python13";
                String password = "eypwnbmeqnuzicis";
                String to = textforgetMail.getText(); // Recipient's email address
                String message = "Hi  , \n" +
                        "\n" +
                        "Someone has requested a new password for the following account on Computer Vision Zone:\n" +
                        "\n" +
                        "If you didn't make this request, just ignore this email. If you'd like to proceed:\n" +
                        "\n" +
                        "use this code : "+randomCode+"\n" +
                        "\n" +
                        "Thank for reading ";

                Properties prop = System.getProperties();
                prop.put("mail.smtp.starttls.enable", "true");
                prop.put("mail.smtp.host", host); // Use the 'host' variable here
                prop.put("mail.smtp.port", "587");
                prop.put("mail.smtp.auth", "true");
                prop.put("mail.smtp.starttls.required", "true");


                Session mailSession = Session.getDefaultInstance(prop, new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
                mailSession.setDebug(true); // Set this to true for debugging

                try {
                    Message msg = new MimeMessage(mailSession);
                    msg.setFrom(new InternetAddress(user));
                    InternetAddress address = new InternetAddress(to);
                    msg.setRecipient(Message.RecipientType.TO, address);
                    msg.setSubject(subject);
                    msg.setText(message);

                    Transport.send(msg);

                    JOptionPane.showMessageDialog(null,"Email sent successfully.");
                } catch (MessagingException ex) {
                    ex.printStackTrace();
                }
            }});
        verifyCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(Integer.valueOf(textVerifyCode.getText()) == randomCode){
                    panel3.setVisible(false);
                    panel4.setVisible(true);
                    panel1.setVisible(false);
                    loginTitle.setText("Reset");
                }
            }
        });

        String UpdateQuery = "update login_table SET password = ? where Email = ? ";

        reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(Arrays.equals(textNewPassword.getPassword(), textCfrNewpassword.getPassword())){
                    try {
                        con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/users_accounts","root","");
                        ps=con.prepareStatement(UpdateQuery);
                        ps.setString(1, new String(textNewPassword.getPassword()));
                        ps.setString(2, textforgetMail.getText());
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Reset successfully");
                        con.close();
                        panel4.setVisible(false);
                        panel1.setVisible(true);
                        loginTitle.setText("Login");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }

            }
        });



        SiginPw1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SiginPw1.setText(null);
                SiginPw1.setEchoChar('•');
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
                panel2.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        //if (SiginPw1.getPassword() == null) {
                        SiginPw1.setText("Enter Password");
                        SiginPw1.setEchoChar((char)0);
                        //}
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
            }
        });
        forget_password.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel1.setVisible(false);
                panel3.setVisible(true);
                loginTitle.setText("Login");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                forget_password.setForeground(new Color(0x9BE5FF));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                forget_password.setForeground(new Color(0x12C2D9));
            }
        });

        frame.setLayout(null);

        frame.getContentPane().setBackground(background);
        frame.add(loginTitle);
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.add(frameImage);
        panel1.add(wrong_login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,600);
        frame.setVisible(true);


    }
    public static void main(String[] args) {
        new Login();
    }
}

