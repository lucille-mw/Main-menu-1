import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Register extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    String[] gender = {"Male", "Female"};
    JLabel nameLabel = new JLabel("First Name");
    JLabel surnameLabel = new JLabel("Surname");
    JLabel genderLabel = new JLabel("Gender");
    JLabel usernameLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JLabel confirmPasswordLabel = new JLabel("Confirm Password");
    JLabel cityLabel = new JLabel("City");
    JLabel emailLabel = new JLabel("Email");
    JLabel identificationLabel = new JLabel("ID");
    JTextField nameTextField = new JTextField();
    JTextField surnameTextField = new JTextField();
    JComboBox genderComboBox = new JComboBox(gender);
    JTextField usernameTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField();
    JTextField cityTextField = new JTextField();
    JTextField emailTextField = new JTextField();
    JTextField identificationTextField = new JTextField();
    JButton registerButton = new JButton("REGISTER");
    JButton resetButton = new JButton("RESET");
    JTextArea messageLabel = new JTextArea("");
    JScrollPane messageBoxScroll = new JScrollPane(messageLabel);

    ArrayList<String> messageArray = new ArrayList<String>();


    Register() {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();



        //================================================================
        //=================R E G I S T E R   B U T T O N==================
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("");
                messageArray.clear();

                boolean firstNameValid = textValidation(nameTextField.getText(), "First name invalid");
                boolean surnameValid = textValidation(surnameTextField.getText(), "Surname invalid");
                boolean usernameValid = textValidation(usernameTextField.getText(), "Invalid Username");
                boolean passwordsMatch = passwordVerification(new String(passwordField.getPassword()),
                        new String(confirmPasswordField.getPassword()));


                if(firstNameValid && surnameValid && usernameValid && passwordsMatch){

                    WriteToFile(nameTextField.getText() + "," +
                            surnameTextField.getText() + "," +
                            genderComboBox.getSelectedItem().toString() + "," +
                            usernameTextField.getText() + "," +
                            new String(passwordField.getPassword()) + "," +
                            cityTextField.getText() + "," +
                            emailTextField.getText() + "," +
                            identificationTextField.getText());

                }
                printMessages();






            }
        });

        //==================================================================




        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetTextboxes();
            }
        });
    }

    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Registration Form");
        frame.setBounds(40, 40, 450, 700);
        frame.getContentPane().setBackground(Color.gray);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    public void setLocationAndSize() {
        nameLabel.setBounds(20, 20, 40, 70);
        surnameLabel.setBounds(20, 70, 80, 70);
        genderLabel.setBounds(20, 120, 120, 70);
        usernameLabel.setBounds(20, 170, 100, 70);
        passwordLabel.setBounds(20, 220, 100, 70);
        confirmPasswordLabel.setBounds(20, 270, 140, 70);
        cityLabel.setBounds(20, 320, 100, 70);
        emailLabel.setBounds(20, 370, 100, 70);
        identificationLabel.setBounds(20, 420, 100, 70);

        nameTextField.setBounds(180, 43, 165, 23);
        surnameTextField.setBounds(180, 93, 165, 23);
        genderComboBox.setBounds(180, 143, 165, 23);
        usernameTextField.setBounds(180, 195, 165, 23);
        passwordField.setBounds(180, 240, 165, 23);
        confirmPasswordField.setBounds(180, 295, 165, 23);
        cityTextField.setBounds(180, 345, 165, 23);
        emailTextField.setBounds(180, 390, 165, 23);
        identificationTextField.setBounds(180, 445, 165, 23);
        messageBoxScroll.setBounds(180,495, 200, 30 );
        registerButton.setBounds(70, 550, 100, 35);
        resetButton.setBounds(50, 550, 100, 35);
    }

    public void addComponentsToFrame() {
        frame.add(nameLabel);
        frame.add(surnameLabel);
        frame.add(genderLabel);
        frame.add(usernameLabel);
        frame.add(passwordLabel);
        frame.add(confirmPasswordLabel);
        frame.add(cityLabel);
        frame.add(emailLabel);
        frame.add(identificationLabel);
        frame.add(nameTextField);
        frame.add(surnameTextField);
        frame.add(genderComboBox);
        frame.add(usernameTextField);
        frame.add(passwordField);
        frame.add(confirmPasswordField);
        frame.add(cityTextField);
        frame.add(emailTextField);
        frame.add(identificationTextField);
        frame.add(registerButton);
        frame.add(resetButton);
        frame.add(messageBoxScroll);
    }

    public void actionEvent() {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }


    public void WriteToFile(String textToAdd) {
        try {
            FileWriter myWriter = new FileWriter("Login.txt", true);
            myWriter.write("\n" + textToAdd);
            //close the output stream
            myWriter.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void resetTextboxes() {
        nameTextField.setText("");
        surnameTextField.setText("");
        //genderComboBox ("");
        usernameTextField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
        cityTextField.setText("");
        emailTextField.setText("");
        identificationTextField.setText("");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
    }


    //--------VALIDATION and VERIFICATION---------
    //1) First name and surname fields should be between 2-30 characters and only contains letters
    //2) Username field validation
    //3) Password verification
    //4) Password validation
    //5) Email validation contains an @ sign and a .
    //6) Make sure all required fields are filled in

    public boolean textValidation(String name, String message){
        if(name.length() > 1 && name.length() < 31 && name.matches("[a-zA-Z]+")){
            return true;
        }else{
            messageArray.add(message);
            return false;
        }

    }


    public boolean passwordVerification(String password1, String password2){
        if(password1.equals("") || password2.equals("")) {
            messageArray.add("Password must be entered");
            return false;
        }else{
            if(password1.equals(password2)){
                return true;
            }else{
                messageArray.add("Passwords do not match");
                return false;
            }
        }
    }

    public boolean checkPassword(String password){
        return false;
    }

    public boolean emailValidation(String email){
        return false;
    }




    public void printMessages(){
        for(String message : messageArray){
            messageLabel.setText(messageLabel.getText() + "\n"+ message);
        }
    }


}
