
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;




public class Main {

    new Login();

    static Fonts Fonts = new Fonts();
    static Colours Colours = new Colours();
    static Strings Strings = new Strings();

    public static void main(String[] args) {


  

        // ======================================== G U I=============================================================

        //=================================== HOME PAGE ==============================================
        JFrame homeFrame = new JFrame("Home Page"); // get new frame and set title to be home page
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        homeFrame.setSize(screensize.width, screensize.height);
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the home page
        homeFrame.setVisible(true); //to see the home page
        homeFrame.setResizable(true); // the home page doesn't have a fixed size
        homeFrame.setLayout(new BorderLayout());

        //----------------------------------Title panel------------------------------
        JPanel TitlePanel = new JPanel(); // created a new jpanel for the title at the top of the screen - default layout is flow layout
        TitlePanel.setBackground(Colours.titlePanel_color); // set background color to black

        JLabel title_label = new JLabel(); //create a new jlabel for the title
        title_label.setText(Strings.title_string); // set text for the title
        title_label.setFont(Fonts.title_font); // set font of the text
        title_label.setForeground(Colours.titleText_color);

        TitlePanel.add(title_label); // add label into the panel

        homeFrame.add(TitlePanel, BorderLayout.PAGE_START); //adding panel into the frame

        //-------------------------------Navigation panel------------------------------

        JPanel NavigationPanel = new JPanel(); // created a new jpanel for the title at the top of the screen - default layout is flow layout
        NavigationPanel.setLayout(new BoxLayout(NavigationPanel, BoxLayout.Y_AXIS));

        NavigationPanel.setBackground(Colours.navigationPanel_color); // set background color to black
        //ADD IMAGE FOR NAV------
        JLabel iconLabel = new JLabel();
        iconLabel.setIcon(new ImageIcon(new ImageIcon("Images/navigation.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        NavigationPanel.add(iconLabel);
        //-----------
        JPanel navButtonsPanel = new JPanel();

        //Setting the listener for the nav image
        iconLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                NavigationPanel.setSize(new Dimension(200, 1000));
                navButtonsPanel.setVisible(true);
            }
        });

        iconLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                NavigationPanel.setSize(new Dimension(100, 1000));
                navButtonsPanel.setVisible(false);
            }
        });

        navButtonsPanel.setVisible(false);
        navButtonsPanel.setLayout(new BoxLayout(navButtonsPanel, BoxLayout.Y_AXIS));

        JButton Home = new JButton("Home");
        navButtonsPanel.add(Home);
        navButtonsPanel.add(Box.createVerticalStrut(50));//sets the spacing between each button

        JButton Patient = new JButton("Patient");
        navButtonsPanel.add(Patient);
        navButtonsPanel.add(Box.createVerticalStrut(50));

        JButton Staff = new JButton("Staff");
        navButtonsPanel.add(Staff);
        navButtonsPanel.add(Box.createVerticalStrut(50));

        JButton Admissions = new JButton("Admissions");
        navButtonsPanel.add(Admissions);
        navButtonsPanel.add(Box.createVerticalStrut(50));

        JButton Discharges = new JButton("Discharges");
        navButtonsPanel.add(Discharges);
        navButtonsPanel.add(Box.createVerticalStrut(50));

        JButton ChatBot = new JButton("ChatBot");
        navButtonsPanel.add(ChatBot);
        navButtonsPanel.add(Box.createVerticalStrut(50));

       

        NavigationPanel.add(navButtonsPanel);


        homeFrame.add(NavigationPanel, BorderLayout.LINE_START); //adding panel into the frame


        //-----------------------------------Main Panel------------------------------
        JPanel MainPanel = new JPanel(); // created a new jpanel for the title at the top of the screen - default layout is flow layout
        MainPanel.setBackground(Colours.mainPanel_color); // set background color to black

        JLabel main_label = new JLabel(); //create a new jlabel for the title
        main_label.setText(Strings.main_string); // set text for the title
        main_label.setFont(Fonts.title_font); // set font of the text
        main_label.setForeground(Colours.mainText_color);

        MainPanel.add(main_label); // add label into the panel

        homeFrame.add(MainPanel, BorderLayout.CENTER); //adding panel into the frame

    }
}
