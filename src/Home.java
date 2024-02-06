import com.mysql.cj.util.StringUtils;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Home {
    String url = "jdbc:mysql://localhost:3306/users_accounts";
    String username = "root";
    String password = "";
    ResultSet resultSet;
    static int i = -70;
    static int j = 565;
    static boolean slided = false;
    static Timer timer;
    static Timer timer2;
    static Timer timer3;
    static Timer timer4;

    static JLabel pfp;
    static JDBC sql = new JDBC();
    static JLabel label_slide;
    static JButton profile;
    static JPanel panelBookB;

    static void selectioneffects(JButton button) {
        button.setBackground(Color.lightGray);
        button.setBorderPainted(false);
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.lightGray);
            }
        });
    }
    static void selection_effects_2(JButton button,Color color) {
            button.setBackground(color);
            button.setBorderPainted(false);
            button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(color.getRed()+20,color.getGreen()+20,color.getBlue()+20));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(color);
            }
        });
    }

    static ImageIcon setpfp(String URL, int width, int height) {
        return new ImageIcon(new ImageIcon(URL).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    public Home() {


        String[] BooksCategories = {"Technogy", "Science", "History", "Physic", "Technogy", "Science", "History", "Physic"};
        Font font = new Font("Times new Roman", Font.PLAIN, 14);
        JFrame frame = new JFrame("Home");
        //----------------------Panels-----------------------
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panelCategorie = new JPanel();
        JPanel watchedBooks = new JPanel();
        JPanel addToBuy = new JPanel();
        JPanel Follow = new JPanel();
        JPanel user = new JPanel();
        JScrollPane spWatch = new JScrollPane(watchedBooks, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane spAddToBuy = new JScrollPane(addToBuy, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane spFollow = new JScrollPane(Follow, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane spUser = new JScrollPane(user, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        panelCategorie.setBackground(new Color(0xC2C3C5));


        JScrollPane spCategories = new JScrollPane(panelCategorie, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        spCategories.setBounds(0, 65, 400, 100);
        JScrollPane spPanel2 = new JScrollPane(panel2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        spPanel2.setBounds(0, 150, 400, 400);


        //---------------------SearchBar---------------------
        //---------------------testArea----------------------
        JTextField search = new JTextField();
        search.setBounds(50, 10, 300, 30);
        search.setBackground(new Color(0xDFDFE1));

        search.setFont(font);


        //--------------------search button------------------
        Icon iconBtn = new ImageIcon("image/search.png");
        JButton searchBtn = new JButton(iconBtn);
        searchBtn.setBounds(350, 10, 30, 30);
        searchBtn.setBackground(new Color(0xC2C3C5));


        //-------------------JPanel search-------------------
        JPanel searchPanel = new JPanel();
        JScrollPane spSearch = new JScrollPane(searchPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        searchPanel.setBounds(0, 150, 400, 400);
        spSearch.setBounds(0, 150, 400, 400);

        searchPanel.setBackground(new Color(62, 122, 117));
        spSearch.setBackground(new Color(248, 243, 243));
        searchPanel.setLayout(new GridLayout(20, 3, 10, 10));
        searchPanel.setVisible(false);
        //---------------------JLabel------------------------
        JLabel categories = new JLabel("categories");
        categories.setBounds(5, 35, 100, 30);
        categories.setForeground(new Color(255, 255, 255));
        categories.setFont(new Font("Times new Roman", Font.PLAIN, 18));
        JLabel books = new JLabel("books");

        //-------------------Image Icon----------------------
        ImageIcon icon1 = new ImageIcon("image/home.png");
        ImageIcon icon2 = new ImageIcon("image/book.png");
        ImageIcon icon3 = new ImageIcon("image/add.png");
        ImageIcon icon4 = new ImageIcon("image/heart.png");
        ImageIcon icon5 = new ImageIcon("image/user.png");
        //--------------------Categories image---------------
        String[] CategoriesImage = {
                "categories/relegion.PNG", "categories/science.PNG",
                "categories/history.PNG", "categories/science_fusion.PNG",
                "categories/relegion.PNG", "categories/science.PNG",
                "categories/history.PNG", "categories/science_fusion.PNG"
        };
        //ImageIcon categoryIcon;
        //--------------------JButton------------------------
        JButton home = new JButton(icon1);
        selection_effects_2(home,new Color(0xFFE6E6E6));
        JButton view = new JButton(icon2);
        selection_effects_2(view,new Color(0xFFE6E6E6));
        JButton buy = new JButton(icon3);
        selection_effects_2(buy,new Color(0xFFE6E6E6));
        JButton like = new JButton(icon4);
        selection_effects_2(like,new Color(0xFFE6E6E6));
        JButton account = new JButton(icon5);
        selection_effects_2(account,new Color(0xFFE6E6E6));


        //-------------------Buttons Components--------------

        //-------------------Panel1 components---------------
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 400, 150);
        panel1.setBackground(new Color(0xB8B8BB));

        panel1.add(searchBtn);

        panel1.add(categories);
        panel1.add(spCategories);

        //-------------------Panel2 components---------------
        //panel2.add(books);
        panel2.setBackground(new Color(0xB8BBB5));
        //panel2.setPreferredSize(new Dimension(400,400));
        panel2.setBounds(0, 150, 400, 400);
        panel2.setLayout(new GridLayout(30, 3, 10, 10));
        //panel2.setLayout(new FlowLayout());


        //-------------------add books-----------------------


        //-------------------Panel3 components---------------
        panel3.setBounds(0, 550, 400, 65);
        panel3.setLayout(new GridLayout(1, 5));
        panel3.setBackground(new Color(0xCACACB));
        panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
        panel3.add(home);
        panel3.add(view);
        panel3.add(buy);
        panel3.add(like);
        panel3.add(account);
        //------------------watchedBooks components----------
        watchedBooks.setBackground(new Color(0xB8BBB5));
        //panel2.setPreferredSize(new Dimension(400,400));
        watchedBooks.setBounds(0, 0, 400, 550);
        watchedBooks.setLayout(new GridLayout(3, 3, 10, 10));
        watchedBooks.setBackground(new Color(0x4FC299));
        spWatch.setBounds(0,0,400,550);

        //------------------addToBuy components--------------
        //panel2.setPreferredSize(new Dimension(400,400));
        addToBuy.setBounds(0, 0, 400, 550);
        addToBuy.setLayout(new GridLayout(3, 3, 10, 10));
        spAddToBuy.setBounds(0,0,400,550);
        addToBuy.setBackground(new Color(0x4FC299));
        //------------------Follow components------------
        //panel2.setPreferredSize(new Dimension(400,400));
        Follow.setBounds(0, 0, 400, 550);
        Follow.setLayout(new GridLayout(3, 3, 10, 10));
        spFollow.setBounds(0,0,400,550);
        Follow.setBackground(new Color(0x4FC299));
        //------------------user components--------------
        user.setBackground(new Color(0xB8BBB5));
        //panel2.setPreferredSize(new Dimension(400,400));
        user.setBounds(0, 150, 400, 400);
        user.setLayout(new GridLayout(30, 3, 10, 10));
        //spUser.setBounds(0,0,400,550);
        //spUser.setBackground(Color.BLUE);

        JLabel label;

        //-------------------Categories----------------------
        for (int i = 0; i < CategoriesImage.length; i++) {
            ImageIcon categoryIcon = new ImageIcon(CategoriesImage[i]);
            label = new JLabel();
            //label.setText(BooksCategories[i]);
            label.setIcon(categoryIcon);
            label.setPreferredSize(new Dimension(70, 80));
            label.setOpaque(true);

            panelCategorie.add(label);
            panelCategorie.setLayout(new FlowLayout());

        }
        //JPanel book;

        final JPanel details = new JPanel();
        details.setVisible(false);
        panel2.setBounds(0, 150, 400, 400);
        JLabel title;
        JButton add;
        JButton ILike;
        //-------------------Box-----------------------------

         for(int i=0; i<40;i++) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement prst = connection.prepareStatement("select * from books");

            resultSet = prst.executeQuery();
            boolean rs;

    while (resultSet.next()) {

        JPanel book = new JPanel();


         final JPanel details1 = new JPanel();
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(400, 50));
        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().createImage(resultSet.getBytes(3)));
        ImageIcon newicon = new ImageIcon(Toolkit.getDefaultToolkit().createImage(resultSet.getBytes(3)));
        ImageIcon addicon = new ImageIcon(Toolkit.getDefaultToolkit().createImage(resultSet.getBytes(3)));
        ImageIcon likeicon = new ImageIcon(Toolkit.getDefaultToolkit().createImage(resultSet.getBytes(3)));

        JLabel newtitle = new JLabel(resultSet.getString(2));
        JLabel addtitle = new JLabel(resultSet.getString(2));
        JLabel liketitle = new JLabel(resultSet.getString(2));


        JLabel img = new JLabel();
        img.setIcon(icon);
        img.setPreferredSize(new Dimension(85, 100));
        JLabel newimg = new JLabel();
        newimg.setIcon(newicon);
        JLabel addimg = new JLabel();
        addimg.setIcon(addicon);
        JLabel likeimg = new JLabel();
        likeimg.setIcon(likeicon);


        title = new JLabel(resultSet.getString(2));
        title.setFont(font);
        title.setPreferredSize(new Dimension(85, 30));
        JTextArea text = new JTextArea(  " Title : \n" + "   " + resultSet.getString(2) +
                "\n Authors \n:" + "   " + resultSet.getString(4) +
                "\n Language : \n" + "   " + resultSet.getString(5) +
                "\n Description : \n" + "   " + resultSet.getString(6) +
                "\n Categories : \n" + "   " + resultSet.getString(7) +
                "\n Publisher : \n" + "   " + resultSet.getString(8) +
                "\n Publish date : \n" + "   " + resultSet.getDate(9) +
                "\n Pages : \n" + "   " + resultSet.getInt(10) +
                "\n Format : \n" + "   " + resultSet.getString(11) +
                "\n ISBN : \n" + "   " + resultSet.getInt(12));

        JTextArea newtext = new JTextArea(" Title : \n" + "   " + resultSet.getString(2) +
                "\n Authors \n:" + "   " + resultSet.getString(4) +
                "\n Language : \n" + "   " + resultSet.getString(5) +
                "\n Description : \n" + "   " + resultSet.getString(6) +
                "\n Categories : \n" + "   " + resultSet.getString(7) +
                "\n Publisher : \n" + "   " + resultSet.getString(8) +
                "\n Publish date : \n" + "   " + resultSet.getDate(9) +
                "\n Pages : \n" + "   " + resultSet.getInt(10) +
                "\n Format : \n" + "   " + resultSet.getString(11) +
                "\n ISBN : \n" + "   " + resultSet.getInt(12));
        JTextArea addtext = new JTextArea(  " Title : \n" + "   " + resultSet.getString(2) +
                "\n Authors \n:" + "   " + resultSet.getString(4) +
                "\n Language : \n" + "   " + resultSet.getString(5) +
                "\n Description : \n" + "   " + resultSet.getString(6) +
                "\n Categories : \n" + "   " + resultSet.getString(7) +
                "\n Publisher : \n" + "   " + resultSet.getString(8) +
                "\n Publish date : \n" + "   " + resultSet.getDate(9) +
                "\n Pages : \n" + "   " + resultSet.getInt(10) +
                "\n Format : \n" + "   " + resultSet.getString(11) +
                "\n ISBN : \n" + "   " + resultSet.getInt(12));
        JTextArea liketext = new JTextArea(  " Title : \n" + "   " + resultSet.getString(2) +
                "\n Authors \n:" + "   " + resultSet.getString(4) +
                "\n Language : \n" + "   " + resultSet.getString(5) +
                "\n Description : \n" + "   " + resultSet.getString(6) +
                "\n Categories : \n" + "   " + resultSet.getString(7) +
                "\n Publisher : \n" + "   " + resultSet.getString(8) +
                "\n Publish date : \n" + "   " + resultSet.getDate(9) +
                "\n Pages : \n" + "   " + resultSet.getInt(10) +
                "\n Format : \n" + "   " + resultSet.getString(11) +
                "\n ISBN : \n" + "   " + resultSet.getInt(12));
        add = new JButton();
        JButton newadd = new JButton();
        JButton addadd = new JButton();
        JButton likeadd = new JButton();

        newadd.setIcon(new ImageIcon("image/cart.png"));
        newadd.setBackground(new Color(0xC2C3C5));
        addadd.setIcon(new ImageIcon("image/cart.png"));
        addadd.setBackground(new Color(0xC2C3C5));
        likeadd.setIcon(new ImageIcon("image/cart.png"));
        likeadd.setBackground(new Color(0xC2C3C5));
        JButton newILike = new JButton();
        JButton addILike = new JButton();
        JButton likeILike = new JButton();


        newILike.setIcon(new ImageIcon("image/heart.png"));
        addILike.setIcon(new ImageIcon("image/heart.png"));
        likeILike.setIcon(new ImageIcon("image/heart.png"));
        add.setIcon(new ImageIcon("image/cart.png"));
        add.setBackground(new Color(0xC2C3C5));
        add.setBorderPainted(false);

        ILike = new JButton();
        ILike.setIcon(new ImageIcon("image/heart.png"));
        book.setPreferredSize(new Dimension(85, 130));
        book.setLayout(new BorderLayout());
        book.add(img, BorderLayout.CENTER);
        book.add(title, BorderLayout.SOUTH);
        panel2.add(book);
        details1.setLayout(new BorderLayout());
        details1.add(text, BorderLayout.NORTH);
        details1.add(buttonPanel, BorderLayout.SOUTH);
        details1.setBounds(0, 150, 400, 400);
        //spPanel2.add(details, BorderLayout.CENTER);
        buttonPanel.add(add);
        buttonPanel.add(ILike);
        buttonPanel.setPreferredSize(new Dimension(400, 60));
        buttonPanel.setBackground(new Color(0xC2C3C5));
        buttonPanel.setLayout(new FlowLayout());
        details1.setBackground(Color.BLACK);
        //spPanel2.add(details);
        details1.setVisible(false);
        frame.add(details1);
        text.setEnabled(false);
        text.setFont(new Font("Times new Roman", Font.PLAIN, 14));
        text.setForeground(Color.BLACK);
        text.setPreferredSize(new Dimension(400, 340));




        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                book.revalidate();
                book.repaint();
                addToBuy.revalidate();
                addToBuy.repaint();
                //spAddToBuy.setVisible(false);
                spWatch.setVisible(false);
                spAddToBuy.setVisible(false);
                spFollow.setVisible(false);
                spUser.setVisible(false);

                details1.setVisible(true);
                panel2.setVisible(false);
                spPanel2.setVisible(false);
                spSearch.setVisible(false);
                searchPanel.setVisible(false);
                details1.repaint();
                details1.revalidate();
                JPanel addbook = new JPanel();
                addbook.setBackground(new Color(0xFFFFFF));
                addbook.setPreferredSize(new Dimension(85, 130));
                addbook.setLayout(new BorderLayout());


                final JPanel adddetails1 = new JPanel();
                adddetails1.setBackground(Color.PINK);
                JPanel addbuttonPanel = new JPanel();
                addbuttonPanel.setPreferredSize(new Dimension(400, 50));
                addToBuy.add(addbook);

                addimg.setPreferredSize(new Dimension(85, 100));

                addtitle.setFont(font);
                addtitle.setPreferredSize(new Dimension(85, 30));


                addadd.setBorderPainted(false);

                addbook.setLayout(new BorderLayout());
                addbook.add(addimg, BorderLayout.CENTER);
                addbook.add(addtitle, BorderLayout.SOUTH);
                //watchedBooks.add(newbook);
                adddetails1.setLayout(new BorderLayout());
                adddetails1.add(addtext, BorderLayout.NORTH);
                adddetails1.add(addbuttonPanel, BorderLayout.SOUTH);
                adddetails1.setBounds(0, 150, 400, 400);
                //spPanel2.add(details, BorderLayout.CENTER);
                addbuttonPanel.add(addadd);
                addbuttonPanel.add(addILike);
                addbuttonPanel.setPreferredSize(new Dimension(400, 60));
                addbuttonPanel.setBackground(new Color(0xC2C3C5));
                addbuttonPanel.setLayout(new FlowLayout());
                adddetails1.setBackground(Color.BLACK);
                //spPanel2.add(details);
                adddetails1.setVisible(false);
                frame.add(adddetails1);
                adddetails1.setBounds(0, 150, 400, 400);

                addtext.setEnabled(false);
                addtext.setFont(new Font("Times new Roman", Font.PLAIN, 14));
                addtext.setForeground(Color.BLACK);
                addtext.setPreferredSize(new Dimension(400, 340));



                home.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        adddetails1.setVisible(false);
                    }
                });
                view.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        adddetails1.setVisible(false);
                    }
                });
                buy.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        adddetails1.setVisible(false);
                    }
                });
                like.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        adddetails1.setVisible(false);
                    }
                });
                account.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        adddetails1.setVisible(false);
                    }
                });

                addbook.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        adddetails1.setVisible(true);
                        addToBuy.setVisible(false);
                        spAddToBuy.setVisible(false);
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

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                details1.setVisible(false);
            }
        });
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                details1.setVisible(false);
            }
        });
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                details1.setVisible(false);
            }
        });
        like.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                details1.setVisible(false);
            }
        });
        account.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                details1.setVisible(false);
            }
        });
        ILike.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                Follow.revalidate();
                Follow.repaint();
                // spFollow.setVisible(false);
                spWatch.setVisible(false);
                spAddToBuy.setVisible(false);
                spFollow.setVisible(false);
                spUser.setVisible(false);

                details1.setVisible(true);
                panel2.setVisible(false);
                spPanel2.setVisible(false);
                spSearch.setVisible(false);
                searchPanel.setVisible(false);
                details1.repaint();
                details1.revalidate();
                JPanel likebook = new JPanel();
                likebook.setBackground(Color.WHITE);
                likebook.setPreferredSize(new Dimension(85, 130));
                likebook.setLayout(new BorderLayout());


                final JPanel likedetails1 = new JPanel();
                likedetails1.setBackground(Color.PINK);
                JPanel likebuttonPanel = new JPanel();
                likebuttonPanel.setPreferredSize(new Dimension(400, 50));
                Follow.add(likebook);

                likeimg.setPreferredSize(new Dimension(85, 100));

                liketitle.setFont(font);
                liketitle.setPreferredSize(new Dimension(85, 30));


                likeadd.setBorderPainted(false);
                likebook.setLayout(new BorderLayout());
                likebook.add(likeimg, BorderLayout.CENTER);
                likebook.add(liketitle, BorderLayout.SOUTH);
                //watchedBooks.add(newbook);
                likedetails1.setLayout(new BorderLayout());
                likedetails1.add(liketext, BorderLayout.NORTH);
                likedetails1.add(likebuttonPanel, BorderLayout.SOUTH);
                likedetails1.setBounds(0, 150, 400, 400);
                //likepPanel2.add(details, BorderLayout.CENTER);
                likebuttonPanel.add(likeadd);
                likebuttonPanel.add(likeILike);
                likebuttonPanel.setPreferredSize(new Dimension(400, 60));
                likebuttonPanel.setBackground(new Color(0xC2C3C5));
                likebuttonPanel.setLayout(new FlowLayout());
                likedetails1.setBackground(Color.BLACK);
                //spPanel2.add(details);
                likedetails1.setVisible(false);
                frame.add(likedetails1);
                likedetails1.setBounds(0, 150, 400, 400);

                liketext.setEnabled(false);
                liketext.setFont(new Font("Times new Roman", Font.PLAIN, 14));
                liketext.setForeground(Color.BLACK);
                liketext.setPreferredSize(new Dimension(400, 340));



                home.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        likedetails1.setVisible(false);
                    }
                });
                view.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        likedetails1.setVisible(false);
                    }
                });
                buy.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        likedetails1.setVisible(false);
                    }
                });
                like.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        likedetails1.setVisible(false);
                    }
                });
                account.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        likedetails1.setVisible(false);
                    }
                });

                likebook.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        likedetails1.setVisible(true);
                        addToBuy.setVisible(false);
                        spAddToBuy.setVisible(false);
                        spFollow.setVisible(false);
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
        book.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {



                spWatch.setVisible(false);
                spAddToBuy.setVisible(false);
                spFollow.setVisible(false);
                spUser.setVisible(false);

                details1.setVisible(true);
                panel2.setVisible(false);
                spPanel2.setVisible(false);
                spSearch.setVisible(false);
                searchPanel.setVisible(false);

                //--------//
                JPanel newbook = new JPanel();
                newbook.setBackground(Color.WHITE);
                newbook.setPreferredSize(new Dimension(85, 130));
                newbook.setLayout(new BorderLayout());


                final JPanel newdetails1 = new JPanel();
                newdetails1.setBackground(Color.PINK);
                JPanel newbuttonPanel = new JPanel();
                newbuttonPanel.setPreferredSize(new Dimension(400, 50));
                watchedBooks.add(newbook);

                newimg.setPreferredSize(new Dimension(85, 100));

                    newtitle.setFont(font);
                    newtitle.setPreferredSize(new Dimension(85, 30));


                    newadd.setBorderPainted(false);

                    newbook.setLayout(new BorderLayout());
                    newbook.add(newimg, BorderLayout.CENTER);
                    newbook.add(newtitle, BorderLayout.SOUTH);
                    //watchedBooks.add(newbook);
                    newdetails1.setLayout(new BorderLayout());
                    newdetails1.add(newtext, BorderLayout.NORTH);
                    newdetails1.add(newbuttonPanel, BorderLayout.SOUTH);
                    newdetails1.setBounds(0, 150, 400, 400);
                    //spPanel2.add(details, BorderLayout.CENTER);
                    newbuttonPanel.add(newadd);
                    newbuttonPanel.add(newILike);
                    newbuttonPanel.setPreferredSize(new Dimension(400, 60));
                    newbuttonPanel.setBackground(new Color(0xC2C3C5));
                    newbuttonPanel.setLayout(new FlowLayout());
                    newdetails1.setBackground(Color.BLACK);
                    //spPanel2.add(details);
                    newdetails1.setVisible(false);
                    frame.add(newdetails1);
                    newdetails1.setBounds(0, 150, 400, 400);

                    newtext.setEnabled(false);
                    newtext.setFont(new Font("Times new Roman", Font.PLAIN, 14));
                    newtext.setForeground(Color.BLACK);
                    newtext.setPreferredSize(new Dimension(400, 340));

                    home.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            newdetails1.setVisible(false);
                        }
                    });
                    view.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            newdetails1.setVisible(false);
                        }
                    });
                    buy.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            newdetails1.setVisible(false);
                        }
                    });
                    like.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            newdetails1.setVisible(false);
                        }
                    });
                    account.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            newdetails1.setVisible(false);
                        }
                    });

                    newbook.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            newdetails1.setVisible(true);
                            watchedBooks.setVisible(false);
                            spWatch.setVisible(false);
                            spFollow.setVisible(false);

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
         connection.close();
        } catch (Exception e) {
        }
    }






            searchBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    spPanel2.setVisible(false);
                    panel2.setVisible(false);
                    details.setVisible(false);
                    watchedBooks.setVisible(false);
                    spAddToBuy.setVisible(false);
                    spFollow.setVisible(false);
                    spWatch.setVisible(false);
                    searchPanel.setVisible(true);
                    spSearch.setVisible(true);

                    searchPanel.revalidate();
                    searchPanel.repaint();
                    spSearch.repaint();
                    spSearch.revalidate();
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection(url, username, password);
                        PreparedStatement prst = connection.prepareStatement("select * from books where title = ?");
                        prst.setString(1, search.getText());
                        resultSet = prst.executeQuery();
                        while (resultSet.next()) {

                            JPanel book = new JPanel();


                            final JPanel details1 = new JPanel();
                            JPanel buttonPanel = new JPanel();
                            buttonPanel.setPreferredSize(new Dimension(400, 50));
                            ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().createImage(resultSet.getBytes(3)));
                            ImageIcon newicon = new ImageIcon(Toolkit.getDefaultToolkit().createImage(resultSet.getBytes(3)));
                            ImageIcon addicon = new ImageIcon(Toolkit.getDefaultToolkit().createImage(resultSet.getBytes(3)));
                            ImageIcon likeicon = new ImageIcon(Toolkit.getDefaultToolkit().createImage(resultSet.getBytes(3)));

                            JLabel newtitle = new JLabel(resultSet.getString(2));
                            JLabel addtitle = new JLabel(resultSet.getString(2));
                            JLabel liketitle = new JLabel(resultSet.getString(2));


                            JLabel img = new JLabel();
                            img.setIcon(icon);
                            img.setPreferredSize(new Dimension(85, 100));
                            JLabel newimg = new JLabel();
                            newimg.setIcon(newicon);
                            JLabel addimg = new JLabel();
                            addimg.setIcon(addicon);
                            JLabel likeimg = new JLabel();
                            likeimg.setIcon(likeicon);
                            JLabel title;

                            title = new JLabel(resultSet.getString(2));
                            title.setFont(font);
                            title.setPreferredSize(new Dimension(85, 30));
                            JTextArea text = new JTextArea(  " Title : \n" + "   " + resultSet.getString(2) +
                                    "\n Authors \n:" + "   " + resultSet.getString(4) +
                                    "\n Language : \n" + "   " + resultSet.getString(5) +
                                    "\n Description : \n" + "   " + resultSet.getString(6) +
                                    "\n Categories : \n" + "   " + resultSet.getString(7) +
                                    "\n Publisher : \n" + "   " + resultSet.getString(8) +
                                    "\n Publish date : \n" + "   " + resultSet.getDate(9) +
                                    "\n Pages : \n" + "   " + resultSet.getInt(10) +
                                    "\n Format : \n" + "   " + resultSet.getString(11) +
                                    "\n ISBN : \n" + "   " + resultSet.getInt(12));

                            JTextArea newtext = new JTextArea(" Title : \n" + "   " + resultSet.getString(2) +
                                    "\n Authors \n:" + "   " + resultSet.getString(4) +
                                    "\n Language : \n" + "   " + resultSet.getString(5) +
                                    "\n Description : \n" + "   " + resultSet.getString(6) +
                                    "\n Categories : \n" + "   " + resultSet.getString(7) +
                                    "\n Publisher : \n" + "   " + resultSet.getString(8) +
                                    "\n Publish date : \n" + "   " + resultSet.getDate(9) +
                                    "\n Pages : \n" + "   " + resultSet.getInt(10) +
                                    "\n Format : \n" + "   " + resultSet.getString(11) +
                                    "\n ISBN : \n" + "   " + resultSet.getInt(12));
                            JTextArea addtext = new JTextArea(  " Title : \n" + "   " + resultSet.getString(2) +
                                    "\n Authors \n:" + "   " + resultSet.getString(4) +
                                    "\n Language : \n" + "   " + resultSet.getString(5) +
                                    "\n Description : \n" + "   " + resultSet.getString(6) +
                                    "\n Categories : \n" + "   " + resultSet.getString(7) +
                                    "\n Publisher : \n" + "   " + resultSet.getString(8) +
                                    "\n Publish date : \n" + "   " + resultSet.getDate(9) +
                                    "\n Pages : \n" + "   " + resultSet.getInt(10) +
                                    "\n Format : \n" + "   " + resultSet.getString(11) +
                                    "\n ISBN : \n" + "   " + resultSet.getInt(12));
                            JTextArea liketext = new JTextArea(  " Title : \n" + "   " + resultSet.getString(2) +
                                    "\n Authors \n:" + "   " + resultSet.getString(4) +
                                    "\n Language : \n" + "   " + resultSet.getString(5) +
                                    "\n Description : \n" + "   " + resultSet.getString(6) +
                                    "\n Categories : \n" + "   " + resultSet.getString(7) +
                                    "\n Publisher : \n" + "   " + resultSet.getString(8) +
                                    "\n Publish date : \n" + "   " + resultSet.getDate(9) +
                                    "\n Pages : \n" + "   " + resultSet.getInt(10) +
                                    "\n Format : \n" + "   " + resultSet.getString(11) +
                                    "\n ISBN : \n" + "   " + resultSet.getInt(12));
                            JButton add = new JButton();
                            JButton newadd = new JButton();
                            JButton addadd = new JButton();
                            JButton likeadd = new JButton();

                            newadd.setIcon(new ImageIcon("image/cart.png"));
                            newadd.setBackground(new Color(0xC2C3C5));
                            addadd.setIcon(new ImageIcon("image/cart.png"));
                            addadd.setBackground(new Color(0xC2C3C5));
                            likeadd.setIcon(new ImageIcon("image/cart.png"));
                            likeadd.setBackground(new Color(0xC2C3C5));
                            JButton newILike = new JButton();
                            JButton addILike = new JButton();
                            JButton likeILike = new JButton();


                            newILike.setIcon(new ImageIcon("image/heart.png"));
                            addILike.setIcon(new ImageIcon("image/heart.png"));
                            likeILike.setIcon(new ImageIcon("image/heart.png"));
                            add.setIcon(new ImageIcon("image/cart.png"));
                            add.setBackground(new Color(0xC2C3C5));
                            add.setBorderPainted(false);

                            JButton ILike = new JButton();
                            ILike.setIcon(new ImageIcon("image/heart.png"));
                            book.setPreferredSize(new Dimension(85, 130));
                            book.setLayout(new BorderLayout());
                            book.add(img, BorderLayout.CENTER);
                            book.add(title, BorderLayout.SOUTH);
                            searchPanel.add(book);
                            details1.setLayout(new BorderLayout());
                            details1.add(text, BorderLayout.NORTH);
                            details1.add(buttonPanel, BorderLayout.SOUTH);
                            details1.setBounds(0, 150, 400, 400);
                            //spPanel2.add(details, BorderLayout.CENTER);
                            buttonPanel.add(add);
                            buttonPanel.add(ILike);
                            buttonPanel.setPreferredSize(new Dimension(400, 60));
                            buttonPanel.setBackground(new Color(0xC2C3C5));
                            buttonPanel.setLayout(new FlowLayout());
                            details1.setBackground(Color.BLACK);
                            //spPanel2.add(details);
                            details1.setVisible(false);
                            frame.add(details1);
                            text.setEnabled(false);
                            text.setFont(new Font("Times new Roman", Font.PLAIN, 14));
                            text.setForeground(Color.BLACK);
                            text.setPreferredSize(new Dimension(400, 340));




                            add.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    book.revalidate();
                                    book.repaint();
                                    addToBuy.revalidate();
                                    addToBuy.repaint();
                                    //spAddToBuy.setVisible(false);
                                    spWatch.setVisible(false);
                                    spAddToBuy.setVisible(false);
                                    spFollow.setVisible(false);
                                    spUser.setVisible(false);

                                    details1.setVisible(true);
                                    panel2.setVisible(false);
                                    spPanel2.setVisible(false);
                                    spSearch.setVisible(false);
                                    searchPanel.setVisible(false);
                                    details1.repaint();
                                    details1.revalidate();
                                    JPanel addbook = new JPanel();
                                    addbook.setBackground(Color.WHITE);
                                    addbook.setPreferredSize(new Dimension(85, 130));
                                    addbook.setLayout(new BorderLayout());


                                    final JPanel adddetails1 = new JPanel();
                                    adddetails1.setBackground(Color.PINK);
                                    JPanel addbuttonPanel = new JPanel();
                                    addbuttonPanel.setPreferredSize(new Dimension(400, 50));
                                    addToBuy.add(addbook);

                                    addimg.setPreferredSize(new Dimension(85, 100));

                                    addtitle.setFont(font);
                                    addtitle.setPreferredSize(new Dimension(85, 30));


                                    addadd.setBorderPainted(false);

                                    addbook.setLayout(new BorderLayout());
                                    addbook.add(addimg, BorderLayout.CENTER);
                                    addbook.add(addtitle, BorderLayout.SOUTH);
                                    //watchedBooks.add(newbook);
                                    adddetails1.setLayout(new BorderLayout());
                                    adddetails1.add(addtext, BorderLayout.NORTH);
                                    adddetails1.add(addbuttonPanel, BorderLayout.SOUTH);
                                    adddetails1.setBounds(0, 150, 400, 400);
                                    //spPanel2.add(details, BorderLayout.CENTER);
                                    addbuttonPanel.add(addadd);
                                    addbuttonPanel.add(addILike);
                                    addbuttonPanel.setPreferredSize(new Dimension(400, 60));
                                    addbuttonPanel.setBackground(new Color(0xC2C3C5));
                                    addbuttonPanel.setLayout(new FlowLayout());
                                    adddetails1.setBackground(Color.BLACK);
                                    //spPanel2.add(details);
                                    adddetails1.setVisible(false);
                                    frame.add(adddetails1);
                                    adddetails1.setBounds(0, 150, 400, 400);

                                    addtext.setEnabled(false);
                                    addtext.setFont(new Font("Times new Roman", Font.PLAIN, 14));
                                    addtext.setForeground(Color.BLACK);
                                    addtext.setPreferredSize(new Dimension(400, 340));



                                    home.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            adddetails1.setVisible(false);
                                        }
                                    });
                                    view.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            adddetails1.setVisible(false);
                                        }
                                    });
                                    buy.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            adddetails1.setVisible(false);
                                        }
                                    });
                                    like.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            adddetails1.setVisible(false);
                                        }
                                    });
                                    account.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            adddetails1.setVisible(false);
                                        }
                                    });

                                    addbook.addMouseListener(new MouseListener() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {
                                            adddetails1.setVisible(true);
                                            addToBuy.setVisible(false);
                                            spAddToBuy.setVisible(false);
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

                            home.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    details1.setVisible(false);
                                }
                            });
                            view.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    details1.setVisible(false);
                                }
                            });
                            buy.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    details1.setVisible(false);
                                }
                            });
                            like.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    details1.setVisible(false);
                                }
                            });
                            account.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    details1.setVisible(false);
                                }
                            });
                            ILike.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {


                                    Follow.revalidate();
                                    Follow.repaint();
                                    // spFollow.setVisible(false);
                                    spWatch.setVisible(false);
                                    spAddToBuy.setVisible(false);
                                    spFollow.setVisible(false);
                                    spUser.setVisible(false);

                                    details1.setVisible(true);
                                    panel2.setVisible(false);
                                    spPanel2.setVisible(false);
                                    spSearch.setVisible(false);
                                    searchPanel.setVisible(false);
                                    details1.repaint();
                                    details1.revalidate();
                                    JPanel likebook = new JPanel();
                                    likebook.setBackground(Color.WHITE);
                                    likebook.setPreferredSize(new Dimension(85, 130));
                                    likebook.setLayout(new BorderLayout());


                                    final JPanel likedetails1 = new JPanel();
                                    likedetails1.setBackground(Color.PINK);
                                    JPanel likebuttonPanel = new JPanel();
                                    likebuttonPanel.setPreferredSize(new Dimension(400, 50));
                                    Follow.add(likebook);

                                    likeimg.setPreferredSize(new Dimension(85, 100));

                                    liketitle.setFont(font);
                                    liketitle.setPreferredSize(new Dimension(85, 30));


                                    likeadd.setBorderPainted(false);
                                    likebook.setLayout(new BorderLayout());
                                    likebook.add(likeimg, BorderLayout.CENTER);
                                    likebook.add(liketitle, BorderLayout.SOUTH);
                                    //watchedBooks.add(newbook);
                                    likedetails1.setLayout(new BorderLayout());
                                    likedetails1.add(liketext, BorderLayout.NORTH);
                                    likedetails1.add(likebuttonPanel, BorderLayout.SOUTH);
                                    likedetails1.setBounds(0, 150, 400, 400);
                                    //likepPanel2.add(details, BorderLayout.CENTER);
                                    likebuttonPanel.add(likeadd);
                                    likebuttonPanel.add(likeILike);
                                    likebuttonPanel.setPreferredSize(new Dimension(400, 60));
                                    likebuttonPanel.setBackground(new Color(0xC2C3C5));
                                    likebuttonPanel.setLayout(new FlowLayout());
                                    likedetails1.setBackground(Color.BLACK);
                                    //spPanel2.add(details);
                                    likedetails1.setVisible(false);
                                    frame.add(likedetails1);
                                    likedetails1.setBounds(0, 150, 400, 400);

                                    liketext.setEnabled(false);
                                    liketext.setFont(new Font("Times new Roman", Font.PLAIN, 14));
                                    liketext.setForeground(Color.BLACK);
                                    liketext.setPreferredSize(new Dimension(400, 340));



                                    home.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            likedetails1.setVisible(false);
                                        }
                                    });
                                    view.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            likedetails1.setVisible(false);
                                        }
                                    });
                                    buy.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            likedetails1.setVisible(false);
                                        }
                                    });
                                    like.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            likedetails1.setVisible(false);
                                        }
                                    });
                                    account.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            likedetails1.setVisible(false);
                                        }
                                    });

                                    likebook.addMouseListener(new MouseListener() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {
                                            likedetails1.setVisible(true);
                                            addToBuy.setVisible(false);
                                            spAddToBuy.setVisible(false);
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
                            book.addMouseListener(new MouseListener() {
                                @Override
                                public void mouseClicked(MouseEvent e) {



                                    spWatch.setVisible(false);
                                    spAddToBuy.setVisible(false);
                                    spFollow.setVisible(false);
                                    spUser.setVisible(false);

                                    details1.setVisible(true);
                                    panel2.setVisible(false);
                                    spPanel2.setVisible(false);
                                    spSearch.setVisible(false);
                                    searchPanel.setVisible(false);

                                    //--------//
                                    JPanel newbook = new JPanel();
                                    newbook.setBackground(Color.WHITE);
                                    newbook.setPreferredSize(new Dimension(85, 130));
                                    newbook.setLayout(new BorderLayout());


                                    final JPanel newdetails1 = new JPanel();
                                    newdetails1.setBackground(Color.PINK);
                                    JPanel newbuttonPanel = new JPanel();
                                    newbuttonPanel.setPreferredSize(new Dimension(400, 50));
                                    watchedBooks.add(newbook);

                                    newimg.setPreferredSize(new Dimension(85, 100));

                                    newtitle.setFont(font);
                                    newtitle.setPreferredSize(new Dimension(85, 30));


                                    newadd.setBorderPainted(false);

                                    newbook.setLayout(new BorderLayout());
                                    newbook.add(newimg, BorderLayout.CENTER);
                                    newbook.add(newtitle, BorderLayout.SOUTH);
                                    //watchedBooks.add(newbook);
                                    newdetails1.setLayout(new BorderLayout());
                                    newdetails1.add(newtext, BorderLayout.NORTH);
                                    newdetails1.add(newbuttonPanel, BorderLayout.SOUTH);
                                    newdetails1.setBounds(0, 150, 400, 400);
                                    //spPanel2.add(details, BorderLayout.CENTER);
                                    newbuttonPanel.add(newadd);
                                    newbuttonPanel.add(newILike);
                                    newbuttonPanel.setPreferredSize(new Dimension(400, 60));
                                    newbuttonPanel.setBackground(new Color(0xC2C3C5));
                                    newbuttonPanel.setLayout(new FlowLayout());
                                    newdetails1.setBackground(Color.BLACK);
                                    //spPanel2.add(details);
                                    newdetails1.setVisible(false);
                                    frame.add(newdetails1);
                                    newdetails1.setBounds(0, 150, 400, 400);

                                    newtext.setEnabled(false);
                                    newtext.setFont(new Font("Times new Roman", Font.PLAIN, 14));
                                    newtext.setForeground(Color.BLACK);
                                    newtext.setPreferredSize(new Dimension(400, 340));

                                    newadd.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            addToBuy.add(newbook);
                                            newbook.revalidate();
                                            newbook.repaint();
                                            addToBuy.revalidate();
                                            addToBuy.repaint();
                                            //spAddToBuy.setVisible(false);
                                            spWatch.setVisible(false);
                                            spAddToBuy.setVisible(false);
                                            spFollow.setVisible(false);
                                            spUser.setVisible(false);

                                            newdetails1.setVisible(true);
                                            panel2.setVisible(false);
                                            spPanel2.setVisible(false);
                                            spSearch.setVisible(false);
                                            searchPanel.setVisible(false);
                                            newdetails1.repaint();
                                            newdetails1.revalidate();
                                        }
                                    });

                                    home.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            newdetails1.setVisible(false);
                                        }
                                    });
                                    view.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            newdetails1.setVisible(false);
                                        }
                                    });
                                    buy.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            newdetails1.setVisible(false);
                                        }
                                    });
                                    like.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            newdetails1.setVisible(false);
                                        }
                                    });
                                    account.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            newdetails1.setVisible(false);
                                        }
                                    });
                                    newILike.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            Follow.add(newbook);
                                            book.repaint();
                                            Follow.revalidate();
                                            Follow.repaint();
                                            // spFollow.setVisible(false);
                                            spWatch.setVisible(false);
                                            spAddToBuy.setVisible(false);
                                            spFollow.setVisible(false);
                                            spUser.setVisible(false);

                                            newdetails1.setVisible(true);
                                            panel2.setVisible(false);
                                            spPanel2.setVisible(false);
                                            spSearch.setVisible(false);
                                            searchPanel.setVisible(false);
                                            newdetails1.repaint();
                                            newdetails1.revalidate();
                                        }
                                    });
                                    newbook.addMouseListener(new MouseListener() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {
                                            newdetails1.setVisible(true);
                                            watchedBooks.setVisible(false);
                                            spWatch.setVisible(false);
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


                        connection.close();


                    } catch (Exception exp) {

                    }

                }
            });
            home.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    panel1.setVisible(true);
                    label_slide.setVisible(true);
                    spPanel2.setVisible(true);
                    panel2.setVisible(true);
                    searchPanel.setVisible(false);
                    spSearch.setVisible(false);
                    spCategories.setVisible(true);

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
            view.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    spWatch.setVisible(true);
                    watchedBooks.setVisible(true);
                    watchedBooks.revalidate();
                    watchedBooks.repaint();
                    label_slide.setVisible(false);
                    panel1.setVisible(false);
                    spPanel2.setVisible(false);
                    panel2.setVisible(false);
                    searchPanel.setVisible(false);
                    spSearch.setVisible(false);
                    details.setVisible(false);
                    spAddToBuy.setVisible(false);
                }
            });
            buy.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addToBuy.setVisible(true);
                    spAddToBuy.setVisible(true);

                    spAddToBuy.revalidate();
                    spAddToBuy.repaint();
                    addToBuy.revalidate();
                    addToBuy.repaint();
                    timer2.start();
                    label_slide.setVisible(false);
                    panel1.setVisible(false);
                    spPanel2.setVisible(false);
                    panel2.setVisible(false);
                    searchPanel.setVisible(false);
                    spSearch.setVisible(false);
                    details.setVisible(false);
                    spFollow.setVisible(false);
                    spWatch.setVisible(false);
                    Follow.setVisible(false);
                    watchedBooks.setVisible(false);
                }
            });
            like.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Follow.setVisible(true);
                    spFollow.setVisible(true);
                    Follow.repaint();
                    Follow.revalidate();
                    spFollow.repaint();
                    spFollow.revalidate();
                    timer2.start();
                    label_slide.setVisible(false);
                    panel1.setVisible(false);
                    spPanel2.setVisible(false);
                    panel2.setVisible(false);
                    searchPanel.setVisible(false);
                    spSearch.setVisible(false);
                    details.setVisible(false);
                    spAddToBuy.setVisible(false);
                    spWatch.setVisible(false);

                }
            });
            account.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    profile.doClick();
                    details.setVisible(false);
                    home.setVisible(true);
                }
            });

            search.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    search.getText();
                }

                @Override
                public void keyPressed(KeyEvent e) {

                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });


            //1//COMPONENTS
            //a//"frame
            //b1//sliding panel
            JPanel panel = new JPanel();


            frame.add(panel);

            //c//icons
            ImageIcon slide_icon = new ImageIcon("image/lines.png");
            ImageIcon settings_icon = new ImageIcon("image/white_mode.png");
            ImageIcon logout_icon = new ImageIcon("image/logout.png");
            ImageIcon pfp_image = new ImageIcon("image/user.png");//.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
            ImageIcon return_image = new ImageIcon(new ImageIcon("image/return.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
            ImageIcon image_background1 = new ImageIcon("image/slide_background1.png");
            JLabel slide_background1 = new JLabel(image_background1);
            ImageIcon image_background2 = new ImageIcon("image/slide_background2.png");
            JLabel slide_background2 = new JLabel(image_background2);
            ImageIcon image_background3 = new ImageIcon("image/slide_background3.png");
            JLabel slide_background3 = new JLabel(image_background3);
            ImageIcon image_background4 = new ImageIcon("image/slide_background4.png");
            JLabel slide_background4 = new JLabel(image_background4);

            label_slide = new JLabel(slide_icon);
            label_slide.setBounds(0, 0, 50, 50);

            //d//setting panel

            JPanel setting_panel = new JPanel();
            setting_panel.setBackground(Color.lightGray);
            setting_panel.setBounds(0, 0, 400, 650);
            setting_panel.setLayout(new GridLayout(10, 1));
            frame.add(setting_panel);
            setting_panel.setVisible(false);

            //b2//sliding panel options

            frame.add(label_slide);
            frame.repaint();

            //-//panels
            JPanel pfpanel = new JPanel();
            JPanel panel_small_icons = new JPanel();
            pfpanel.setLayout(new BoxLayout(pfpanel, BoxLayout.Y_AXIS));
            pfpanel.setBackground(new Color(0x66A6A0));
            JPanel pfp_options = new JPanel();


            panel_small_icons.setLayout(null);
            pfp_options.setBackground(Color.darkGray);

            pfp = new JLabel(pfp_image);
            JLabel pfp_label = new JLabel();
            JLabel logout = new JLabel(logout_icon);
            profile = new JButton("Profile");
            JButton bookmarks = new JButton("Bookmarks");
            JButton history = new JButton("History");
            JLabel settings = new JLabel(settings_icon);

            JButton chose_file = new JButton("Chose a file");
            chose_file.setFont(font);
            JButton check_profile = new JButton("Check profile");
            check_profile.setFont(font);

            //backgounds//
            profile.setIcon(image_background1);
            profile.setHorizontalTextPosition(JButton.CENTER);
            profile.setVerticalTextPosition(JButton.CENTER);

            bookmarks.setIcon(image_background2);
            bookmarks.setHorizontalTextPosition(JButton.CENTER);
            bookmarks.setVerticalTextPosition(JButton.CENTER);

            history.setIcon(image_background3);
            history.setHorizontalTextPosition(JButton.CENTER);
            history.setVerticalTextPosition(JButton.CENTER);

            //----//
            settings.setCursor(new Cursor(Cursor.HAND_CURSOR));
            logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
            pfp.setCursor(new Cursor(Cursor.HAND_CURSOR));
            pfp_label.setCursor(new Cursor(Cursor.HAND_CURSOR));
            pfpanel.add(pfp);
            pfpanel.add(pfp_label);
            pfp.setAlignmentX(Component.CENTER_ALIGNMENT);
            pfp_label.setAlignmentX(Component.CENTER_ALIGNMENT);

            frame.add(pfp_options);
            pfp_options.setLayout(new GridLayout(2, 1));
            pfp_options.setVisible(false);


            panel_small_icons.add(settings);
            panel_small_icons.add(logout);
            panel_small_icons.add(slide_background4);

            slide_background4.setBounds(0,0,100,162);
            settings.setBounds(2,10,50,50);
            logout.setBounds(52,10,50,50);

            JLabel mail;

            panel.setLayout(new GridLayout(5, 1));
            panel.add(pfpanel);
            panel.add(profile);
            panel.add(bookmarks);
            panel.add(history);
            panel.add(panel_small_icons);
            panel.repaint();
            panel.revalidate();
            //effects//
            selectioneffects(profile);
            selectioneffects(history);
            selectioneffects(bookmarks);


            pfp_options.add(chose_file);
            pfp_options.add(check_profile);

            selectioneffects(chose_file);
            selectioneffects(check_profile);

            //d2//setting panel options
            JPanel return_panel = new JPanel();
            return_panel.setBackground(Color.lightGray);
            return_panel.setLayout(null);
            JLabel return_ = new JLabel(return_image);
            return_panel.add(return_);
            return_.setBounds(0, 0, 50, 50);
            return_.setCursor(new Cursor(Cursor.HAND_CURSOR));
            JButton account2 = new JButton("Account");
            JButton theme = new JButton("Theme");
            JButton help = new JButton("Help");
            JButton about = new JButton("About");
            JLabel delete_account = new JLabel("Delete Account");
            delete_account.setForeground(new Color(201, 20, 20));
            setting_panel.add(return_panel);
            setting_panel.add(account2);
            account2.setFont(font);
            setting_panel.add(theme);
            theme.setFont(font);
            setting_panel.add(help);
            help.setFont(font);
            setting_panel.add(about);
            about.setFont(font);
            setting_panel.add(delete_account);
            delete_account.setFont(font);
            setting_panel.repaint();
            setting_panel.revalidate();
            //effects//
            selectioneffects(account2);
            selectioneffects(theme);
            selectioneffects(help);
            selectioneffects(about);

            //e//Account panel/options
            JPanel account_panel = new JPanel();
            JLabel account_return = new JLabel(return_image);
            account_panel.setBackground(Color.lightGray);
            frame.add(account_panel);
            account_panel.setVisible(false);
            account_panel.setBounds(0, 0, 400, 650);
            account_panel.setLayout(new GridLayout(10, 1));

            JButton change_username = new JButton("Change Username");
            JButton change_password = new JButton("Change Password");
            change_username.setFont(font);
            change_password.setFont(font);

            account_panel.add(change_username);
            account_panel.add(change_password);
            account_panel.add(account_return);


            //effects//
            selectioneffects(change_username);
            selectioneffects(change_password);

            //f//Profile Panel
            JPanel profile_panel = new JPanel();
            JPanel profile_small_panel = new JPanel();
            JPanel profile_small_panel2 = new JPanel();
            JLabel profile_return = new JLabel(return_image);
            profile_small_panel.setLayout(new BoxLayout(profile_small_panel, BoxLayout.Y_AXIS));
            profile_panel.setBackground(Color.lightGray);
            profile_small_panel2.setLayout(new GridLayout(3, 2));
            frame.add(profile_panel);
            profile_panel.setVisible(false);
            profile_panel.setBounds(0, 0, 400, 630);
            profile_panel.setLayout(new GridLayout(2, 1));
            ImageIcon profile_image = new ImageIcon(new ImageIcon("image/user.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));

            JLabel profile_pfp = new JLabel(profile_image);
            JLabel profile_name_label = new JLabel("Username : ");
            JLabel profile_email_label = new JLabel("Email : ");
            JLabel profile_name = new JLabel();
            JLabel profile_email = new JLabel();
            JLabel profile_small_name = new JLabel();
            profile_pfp.setAlignmentX(Component.CENTER_ALIGNMENT);
            profile_name.setAlignmentX(Component.CENTER_ALIGNMENT);

            profile_small_panel.add(profile_pfp);
            profile_small_panel.add(profile_small_name);
            profile_panel.add(profile_small_panel);
            profile_small_panel2.add(profile_name_label);
            profile_small_panel2.add(profile_name);
            profile_small_panel2.add(profile_email_label);
            profile_small_panel2.add(profile_email);
            profile_small_panel2.add(profile_return);
            profile_small_panel.setBackground(new Color(0x176861));
            profile_small_panel2.setBackground(new Color(0x176861));
            profile_panel.add(profile_small_panel2);


            //2//ACTION LISTENERS WITH TIMERS

            //a//three line listener
            label_slide.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (i != 0) {
                        home.setVisible(false);
                        pfp_label.setText(sql.getSQL(Login._username, "username"));
                        profile_name.setText(sql.getSQL(Login._username, "username"));
                        profile_email.setText(sql.getSQL(Login._username, "Email"));
                        profile_small_name.setText(sql.getSQL(Login._username, "username"));
                        if(Login._username != null && sql.getSQL_image(Login._username) != null)
                        {
                            profile_pfp.setIcon(new ImageIcon(sql.getSQL_image(Login._username).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                            pfp.setIcon(sql.getSQL_image(Login._username));
                        }


                        timer.start();
                        slided = true;
                        label_slide.setVisible(false);
                    }
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
            //b//slideback activation Mouselistener
            frame.addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent e) {

                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    if (slided && frame.getMousePosition().getX() > 100) {
                        timer2.start();
                    }
                }
            });

            //c++//slide action listener
            ActionListener slide_listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.setVisible(true);
                    i += 5;
                    panel.setBounds(i, 0, 100, 650);
                    frame.repaint();
                    frame.revalidate();
                    if (i == 0) {
                        timer.stop();
                        slided = true;
                    }

                }
            };
            //c--//slideback action listener
            ActionListener slideback_listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (i == 0) {
                        slided = false;
                        label_slide.setVisible(true);
                    }
                    i -= 5;
                    panel.setBounds(i, 0, 100, 650);
                    frame.repaint();
                    frame.revalidate();
                    if (i == -100) {
                        timer2.stop();
                    }
                    home.setVisible(true);

                }
            };
            ActionListener pfp_listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    j -= 5;
                    pfp_options.setBounds(0, j, 400, 100);
                    frame.repaint();
                    frame.revalidate();
                    if (j == 515) {
                        timer3.stop();
                    }

                }
            };
            ActionListener pfp_listener_back = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    j += 5;
                    pfp_options.setBounds(0, j, 400, 100);
                    frame.repaint();
                    frame.revalidate();
                    if (j == 615) {
                        timer4.stop();
                    }

                }
            };
            //d//settings click
            settings.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    panel.setVisible(false);
                    label_slide.setVisible(false);
                    setting_panel.setVisible(true);
                    details.setVisible(false);
                    panel3.setVisible(false);
                    panel1.setVisible(false);

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
            return_.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    panel.setVisible(true);
                    panel3.setVisible(true);
                    panel1.setVisible(true);
                    home.setVisible(true);
                    setting_panel.setVisible(false);

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
            account2.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    setting_panel.setVisible(false);
                    account_panel.setVisible(true);
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
            pfp.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (j != 465) {
                        pfp_options.setVisible(true);
                        //frame.getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,0.3f));
                        timer2.start();
                        timer3.start();
                    }
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
            chose_file.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new java.io.File("image"));
                    fileChooser.setDialogTitle("Chose a file");
                    fileChooser.setFont(font);
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG & JPG & GIF Images", "jpg", "gif", "png");
                    fileChooser.setFileFilter(filter);
                    fileChooser.setAcceptAllFileFilterUsed(false);
                    if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        pfp.setIcon(setpfp(fileChooser.getSelectedFile().getAbsolutePath(), 50, 50));
                        profile_pfp.setIcon(setpfp(fileChooser.getSelectedFile().getAbsolutePath(), 100, 100));
                        sql.change_pfp(fileChooser, Login._username);

                    }

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
                    if (frame.getMousePosition().getY() < 545) {
                        timer4.start();
                    }
                }
            });
            check_profile.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    details.setVisible(false);
                    panel3.setVisible(false);
                    profile_panel.setVisible(true);
                    label_slide.setVisible(false);
                    details.setVisible(false);
                    panel.setVisible(false);
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
            pfp_label.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    details.setVisible(false);
                    panel3.setVisible(false);
                    panel1.setVisible(false);
                    spCategories.setVisible(false);
                    spPanel2.setVisible(false);
                    profile_panel.setVisible(true);
                    label_slide.setVisible(false);
                    panel.setVisible(false);
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
            profile.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    profile_panel.setVisible(true);
                    label_slide.setVisible(false);
                    panel.setVisible(false);
                    details.setVisible(false);
                    spAddToBuy.setVisible(false);
                    spFollow.setVisible(false);
                    spUser.setVisible(false);
                    panel3.setVisible(false);
                    spCategories.setVisible(false);
                    panel1.setVisible(false);
                    spPanel2.setVisible(false);
                    slided = false;
                    panel.setBounds(-100, 0, 100, 650);
                    i = -100;

                }
            });
            change_username.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String username = JOptionPane.showInputDialog("Enter your new username");
                    sql.change_username(profile_name.getText(), username);
                    profile_name.setText(username);
                    profile_small_name.setText(username);
                    pfp_label.setText(username);
                }
            });
            change_password.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String confirm_password = JOptionPane.showInputDialog("Type your password to change your password");
                    if (confirm_password.equals(sql.getSQL(profile_name.getText(),"password"))) {
                        String confirm_password2 = JOptionPane.showInputDialog("Type your new password");
                        sql.change_password(confirm_password, confirm_password2);
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong password");
                    }
                }
            });
            logout.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //all panels that should be false
                    timer2.start();
                    new Login();
                    frame.setVisible(false);
                    //all panels that should be true
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
            help.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //add a panel with frequently asked questions
                    String help_ = JOptionPane.showInputDialog("Type your problem");

                }
            });
            delete_account.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //add a panel with frequently asked questions
                    String delete = JOptionPane.showInputDialog("Type your password to delete your account");
                    if (delete.equals(sql.getSQL(profile_name.getText(), "password"))) {
                        sql.delete_account(profile_name.getText());
                        new Login();
                        frame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong password");
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    delete_account.setForeground(new Color(201, 55, 55));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    delete_account.setForeground(new Color(201, 20, 20));
                }
            });
            bookmarks.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //change the filter of books to bookmarks
                    /*imaginary code JLabel heart = new JLabel(heart_image);
                     * heart.addMouseListener(new MouseListener)
                     * {{...}MouseClicked(MouseEvent e)
                     * {
                     * //add the book to the bookmarks list;}
                     * show_book(books);
                     * }
                     * }*/
                    details.setVisible(false);
                    spAddToBuy.setVisible(false);
                    spUser.setVisible(false);
                    like.doClick();
                }
            });
            history.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //change the filter of books to history
                    /*imaginary code JLabel clock = new JLabel(history_image);
                     * show_book(books);
                     * }
                     * }*/
                    view.doClick();
                }
            });
            about.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //add a panel with information about the app or developers
                    details.setVisible(false);
                    spAddToBuy.setVisible(false);
                    spFollow.setVisible(false);
                    spUser.setVisible(false);
                }
            });
            profile_return.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    panel3.setVisible(true);
                    panel1.setVisible(true);
                    profile_panel.setVisible(false);
                    label_slide.setVisible(true);
                    panel.setVisible(true);
                    details.setVisible(false);
                    spAddToBuy.setVisible(false);
                    spFollow.setVisible(false);
                    spUser.setVisible(false);
                    spPanel2.setVisible(true);
                    panel2.setVisible(true);
                    searchPanel.setVisible(false);
                    spSearch.setVisible(false);
                    spCategories.setVisible(true);
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
            account_return.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    account_panel.setVisible(false);
                    setting_panel.setVisible(true);
                    //all panels that should be true
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
            //e//timers
            timer = new Timer(5, slide_listener);
            timer2 = new Timer(5, slideback_listener);
            timer3 = new Timer(5, pfp_listener);
            timer4 = new Timer(5, pfp_listener_back);

            panel1.add(search);
            frame.setLayout(null);
            spSearch.setVisible(true);

            frame.add(panel1);
            frame.add(spPanel2);
            frame.add(panel3);
            frame.add(spAddToBuy);
            frame.add(spWatch);

            frame.add(spFollow);
            frame.add(spSearch);
            frame.add(details);





            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 650);
            frame.setVisible(true);
            spSearch.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

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



public static void main(String[] args) {
        Home home = new Home();
    }
}
