

public class Staff{
  //--------Doctor information--
  private String FirstName;
  private String SurName;
  private String Gender;
  private String ID;
  private String Occupation; //Doctor or Nurse
  private int DoB;
  private int Age; 
  
  //----the setters----
  public void setFirstName(){
    this.FirstName = FirstName;
  }
  public void setSurName(){
    this.SurName = SurName;
  }
  public void setGender(){
    this.Gender = Gender;
  }
  public void setID(){
    this.ID = ID;
  }
  public void setOccupation(){
    this.Occupation = Occupation;
  }
  public void setDoB(){
    this.DoB = DoB;
  }
  public void setAge(){
    this.Age = Age;
  }

  //----The Getters-----
  public String getFirstName(){
    return FirstName;
  }
  public String getSurName(){
    return SurName;
  }
  public String getGender(){
    return Gender;
  }
  public String getID(){
    return ID;
  }
  public String getOccupation(){
    return Occupation;
  }
  public int getDoB(){
    return DoB;
  }
  public int getAge(){
    return Age;
  }






  public void StaffRecords(){
  Scanner input = new Scanner(System.in);

  System.out.println("Enter Staffs First Name: ");
  String fName = input.next();

  System.out.println("Enter Staffs SurName: ");
  String surName = input.next();

  System.out.println("Enter Staffs Gender: ");
  String gender = input.next();

  System.out.println("Enter Staffs ID: ");
  String ID = input.next();

  System.out.println("Enter Staffs Occupation: ");
  String Occupation = input.next();

  System.out.println("Enter Staffs Date of Birth: ");
  String DoB = input.next();

  System.out.println("Enter Staffs Age: ");
  int Age = input.next();
}
void Staff_info()
{
System.out.println(fName + "\t" +  surName + "\t" + gender +"\t" + ID + "\t" + Occupation + "\t" + DoB + "\t" + Age);
}




//to store the staffs data every time they enter staff info.
public void WriteToFile(String textToAdd) {
        try {
            FileWriter myWriter = new FileWriter("Staff.txt", true);
            myWriter.write("\n" + textToAdd);
            //close the output stream
            myWriter.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }

}