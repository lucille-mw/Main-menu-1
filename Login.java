import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Login extends JFrame implements ActionListener {
    JPanel loginPanel;
    JLabel user_label, password_label, message;
    JTextField username_text;
    JPasswordField password_text;
    JButton submit, cancel;
    JButton registerBtn;


    Login() {
        // Username Label
        user_label = new JLabel();
        user_label.setText("User Name :");
        username_text = new JTextField();
        String usernameTextboxString = "Please enter your Username...";
        username_text.setText(usernameTextboxString);

        username_text.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (username_text.getText().equals(usernameTextboxString)) {
                    username_text.setText("");
                }
            }
        });
        // Password Label
        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField();


        //Add an action listener which clears the text box when clicked but add if statement so it only does it when you want it to


        // Submit
        submit = new JButton("SUBMIT");
        loginPanel = new JPanel(new GridLayout(4, 1));
        loginPanel.add(user_label);
        loginPanel.add(username_text);
        loginPanel.add(password_label);
        loginPanel.add(password_text);
        message = new JLabel();
        loginPanel.add(message);
        loginPanel.add(submit);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //compare the text entered for the username and password and if they are equal to 123 and 123
                // a new window will appear - if not, an error message will be displayed


                if (usernameCorrect(username_text.getText()) && passwordCorrect(new String(password_text.getPassword()))) {
                    System.out.println("Logged in");
                    loggedIn();
                } else {
                    //print error
                }

            }
        });

        //REGISTER
        registerBtn = new JButton("REGISTER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,600);
        this.setVisible(true);
        message = new JLabel();
        loginPanel.add(message);
        loginPanel.add(registerBtn);



        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.this.setVisible(false);
               new Register();
            }

        });



        //CONFIGURE LOGIN PANEL
        add(loginPanel, BorderLayout.CENTER);
        setTitle("Login Here!");
        setSize(450, 350);
        setVisible(true);

    }

    public Boolean usernameCorrect(String usernameEntered) {
        if (usernameEntered.equals("123")) {
            return true;
        } else {
            message.setText("Username incorrect");
            return false;
        }
    }

    public Boolean passwordCorrect(String passwordEntered) {
        if (passwordEntered.equals("123")) {
            return true;
        } else {
            message.setText("Password incorrect");
            return false;
        }
    }

    public void loggedIn() {
        this.setVisible(false);

        JFrame homeFrame = new JFrame("Home");
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setVisible(true);
        homeFrame.setSize(500, 600);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
