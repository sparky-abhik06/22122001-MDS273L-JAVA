import java.util.*;
import java.util.jar.Attributes.Name;
import java.io.*;

public class lab_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] studentNames = new String[100];
        int choice;
        String Name,sClass,Mail,Dep;
        Long phoneNo,regNo;
        System.out.print("Here are the options for you..\n1. Add a student.\n2. Search a student.\n3. Update a student.\n4. Print details of all student.\n Exit.\nEnter your choices: ");
        choice = Integer.parseInt(sc.nextLine());
        System.out.println("=========================================================================");
        switch (choice) {
            case 1:
                System.out.println("Adding a student..\nEnter the details of the student: ");
                System.out.print("Registration No: ");
                regNo = Long.parseLong(sc.nextLine());
                System.out.print("Name: ");
                Name = sc.nextLine();
                System.out.print("Mail I'd: ");
                Mail = sc.nextLine();
                System.out.print("Contact No: ");
                phoneNo = Long.parseLong(sc.nextLine());
                System.out.print("Class: ");
                sClass = sc.nextLine();
                System.out.print("Department: ");
                Dep = sc.nextLine();
                Student s1 = new Student(Name); 
                s1.addStudent(Name,sClass,Mail,Dep,phoneNo,regNo);
                break;
            case 4:
                //  .printDetails();
                break;
            default:
                System.out.println("Exited successfully..");
                break;
        }
        sc.close();
    }

}

class Student {
    
    // DYNAMIC CREATION OF THE FILE NAME 
    static String filename = "Student_Details.txt";

    static void addStudent(String Name,String sClass,String Mail,String Dep,Long phoneNo,Long regNo;){
        
        this.Name = Name;
        this.regNo = regNo;
        this.Mail = Mail;
        this.phoneNo = phoneNo;
        this.sClass = sClass;
        this.dep = Dep; 

        //code for writing the file content
        try{
            File file = new File(filename);
            FileWriter wr = new FileWriter(file);
            wr.write("\n\nRegistration No: "+regNo+"\t||Name: "+Name+"\t||Mail I'd: "+Mail+"\nContact No: "+phoneNo+"\t||Class: "+sClass+"\t||Department: "+Dep);
            wr.close();
            System.out.println("File created and written successfully.");
        }catch(Exception e){
            System.out.println("An error occurred while writing the file: "+e.getMessage());
            return;
        }

    }

    static void printDetails(){
                // read the file content
                try{
                    File file = new File(filename);
                    Scanner scan = new Scanner(file);
                    while(scan.hasNextLine()){
                        System.out.println(scan.nextLine());
                    }
                    scan.close();
                }catch(Exception e){
                    System.out.println("An error occurred while reading the file: "+e.getMessage());
                }
        
    }
}