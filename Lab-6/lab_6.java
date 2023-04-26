import java.util.*;
import java.io.*;


class StudentInfo {
    /* Student Class To create student objects, Display the object and write to a file */
    String name = new String();
    String regNo = new String();
    String email = new String();
    String phone = new String();
    String cl_name = new String();
    String Dep_name = new String();

    // Contructor
    StudentInfo() {
        name = "";
        regNo = "";
        email = "";
        phone = "";
        cl_name = "";
        Dep_name = "";
    }

    void Display() {
        /* Display info of the student object */
        System.out.println("Name: " + name);
        System.out.println("reg No.: " + regNo);
        System.out.println("email: " + email);
        System.out.println("phone: " + phone);
        System.out.println("Class: " + cl_name);
        System.out.println("Department: " + Dep_name);
    }

    public String toString() {
        /* Create a single string with all the value.
        Can be written in the file */
        String fullDetail = "Name: " + name + "\nreg No.: " + regNo + "\nemail: " + email
                            + "\nphone: " + phone + "\nClass: " + cl_name + 
                            "\nDepartment: " + Dep_name;
        return fullDetail;

    }

    void writeToFile() {
        /*Create a file with the name_info
         * And wite the info to the file
         */
        String fileName = name + "_info.txt";
        String filepath = "D:\\22122010--MDS273L-JAVA\\LAB6\\LAB6" + fileName;
        try {
            File file = new File(filepath);

            if (file.exists()) {
                System.out.println("File Already exists");
            }
            else {
                System.out.println("File Does not exist");
                file.createNewFile();
            }
            if (file.canWrite()) {
                FileWriter writeInFile = new FileWriter(file,true);
                writeInFile.write(toString());
                writeInFile.close();
            }
            else {
                System.out.println("Could not write in file");
            }
        }
        catch (Exception error) {
            System.out.println(error);
        }
        
    }

    
}

public class lab_6{

    public static Scanner scan = new Scanner(System.in);
    static int curr_count = 0;
    public static void main(String[] args) {
        int total_std = 5;
        
        StudentInfo[] obj = new StudentInfo[total_std];
        boolean out = false;

        do {
        System.out.println("Press '1' to Enter new Student Details");
        System.out.println("Press '2' to Search for a Name");
        System.out.println("Press '3' to Update any Student Detail");
        System.out.println("Press '4' to display all the Student details");
        System.out.println("Press '5' to write info to file");
        System.out.println("Press '6' to Exit the program");
        System.out.print("\n=========================\nEnter Your Choice: ");
        int choice = Integer.parseInt(scan.nextLine());
        System.out.println("\n=========================\n");
        switch (choice) {
            case 1:
            obj[curr_count] = new StudentInfo();
            addDetail(obj);
            break;
            case 2:
            System.out.print("Enter the name or reg no. to search: ");
            String change = scan.nextLine();
            StudentInfo retVal = searchObj(obj, change);
            if (retVal == null) {
                System.out.println("Student not found");
            }
            else {
                retVal.Display();
            }
            break;
            case 3:
            System.out.print("Enter the reg no. to update: ");
            String regVal = scan.nextLine();
            updateObj(obj, regVal);
            break;
            case 4:
            displayDetail(obj);
            break;
            case 6:
            out = true;
            break;
            case 5:
            for (int i = 0; i < curr_count; i++) {
                obj[i].writeToFile();
            }
        }
    }
    while (out == false);
        
        for (int i = 0; i < total_std; i++) {
            obj[i] = new StudentInfo();
        }


        
    }

    static void addDetail(StudentInfo[] obj) {
        System.out.print("Enter Name: ");
        obj[curr_count].name = scan.nextLine();
        System.out.print("Enter Reg No.: ");
        obj[curr_count].regNo = scan.nextLine();
        System.out.print("Enter Class Name: ");
        obj[curr_count].cl_name = scan.nextLine();
        System.out.print("Enter Phone No.: ");
        obj[curr_count].phone = scan.nextLine();
        System.out.print("Enter Email ID: ");
        obj[curr_count].email = scan.nextLine();
        System.out.print("Enter Department Name: ");
        obj[curr_count].Dep_name = scan.nextLine();
        curr_count += 1; 
    }

    static StudentInfo searchObj(StudentInfo[] obj, String ser_val) {
        boolean bol = false;
        StudentInfo retval = new StudentInfo();
        for (int i = 0; i < curr_count; i++) {
            String n = obj[i].name;
            String r = obj[i].regNo;
            if (ser_val.equals(n) || ser_val.equals(r)) {
                bol = true;
                retval = obj[i];
                break;
                
            }

        }

        if (bol == false) {
            return null;
        }
        else {
            return retval;
        }

        
        
    }


    static void updateObj(StudentInfo[] val, String ser_val) {
        StudentInfo obj = searchObj(val, ser_val);
        if (obj == null) {
                
        }
        else {
            System.out.print("Enter Name: ");
            obj.name = scan.nextLine();
            System.out.print("Enter Reg No.: ");
            obj.regNo = scan.nextLine();
            System.out.print("Enter Class Name: ");
            obj.cl_name = scan.nextLine();
            System.out.print("Enter Phone No.: ");
            obj.phone = scan.nextLine();
            System.out.print("Enter Email ID: ");
            obj.email = scan.nextLine();
            System.out.print("Enter Department Name: ");
            obj.Dep_name = scan.nextLine();


        }
    }

    static void displayDetail(StudentInfo[] obj) {
        for (int i = 0; i < curr_count; i++) {
            System.out.println("Detail of Student " + Integer.toString(i));
            obj[i].Display();
            System.out.println();
        }
    }


}