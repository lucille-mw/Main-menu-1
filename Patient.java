import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;



public class Patient {

  //==============================================PatientInformation==================================================================
  private String FirstName;
  private String SurName;
  private String Gender;
  private int DoB;
  private int Age;
  private double height;
  private double weight;

  //---The Setters---
  public void setFirstName(String firstName) {
    this.FirstName = firstName;
  }
  public void setSurName (String surName){
    this.SurName = surName;
  }
  public void setGender(String Gender){
    this.Gender = Gender; 
  }
  public void setDoB(int DoB){
    this.DoB = DoB;
  }
  public void setAge(int Age){
    this.Age = Age;
  }
  public void setHeight(double Height){
    this.height = Height;
  }
  public void setWeight(double Weight){
    this.weight = Weight;
  }
  //---The Getters----
  public String getfirstName(){
    return FirstName;
  }
  public String getsurName(){
    return SurName;
  }
  public String getGender(){
    return Gender;
  }
  public int getDoB(){
    return DoB;
  }
  public int getAge(){
    return Age;
  }
  public double getHeight(){
    return height;
  }
  public double getWeight(){
    return weight;
  }
  




public void PatientRecords(){
  Scanner input = new Scanner(System.in);

  System.out.println("Enter patients First Name: ");
  String fName = input.next();

  System.out.println("Enter patients SurName: ");
  String surName = input.next();

  System.out.println("Enter patients Gender: ");
  String gender = input.next();

  System.out.println("Enter patients Date of Birth: ");
  String DoB = input.next();
}
void Patient_info();


{
System.out.println(fName + "\t" +  surName + "\t" + gender +"\t" + DoB);
}
  //-------------------------------------------------The new page-------------------------------------------------
  // JFrame homeFrame = new JFrame("Patient Information"); // get new frame and set title to be patient information
  //       Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
  //       homeFrame.setSize(screensize.width, screensize.height);
  //       homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the home page
  //       homeFrame.setVisible(true); //to see the home page
  //       homeFrame.setResizable(true); // the home page doesn't have a fixed size
  //       homeFrame.setLayout(new BorderLayout());




//to store the patients data every time they enter the patients info.
public void WriteToFile(String textToAdd) {
        try {
            FileWriter myWriter = new FileWriter("Patient.txt", true);
            myWriter.write("\n" + textToAdd);
            //close the output stream
            myWriter.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }









  }








