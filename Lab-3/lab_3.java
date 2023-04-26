import java.util.*;

// import javax.sound.sampled.SourceDataLine;

public class lab_3 {
    static Scanner scan = new Scanner(System.in);
    
    static String[] N_details = new String[1024];
    static int n = 0;

    static String[] collectDetails(){
        System.out.println("\n****************************************************************************");
        System.out.print("Enter the name of the student: ");
        String Name = scan.nextLine();
        System.out.print("\nEnter the registration number of the student: ");
        String Reg_no = scan.nextLine();
        System.out.print("\nEnter the email of the student: ");
        String Email = scan.nextLine();
        System.out.print("\nEnter the class of the student: ");
        String Class = scan.nextLine();
        System.out.print("\nEnter the department of the student: ");
        String Dep = scan.nextLine();
        String Sdetails[] = {Name, Reg_no, Email, Class, Dep};
        N_details[n] = Name;
        n += 1;
        return Sdetails;
    }

    static void displayDetails(String[][] arr){
        System.out.println("The students details list: " + Arrays.deepToString(arr));
    }

    static int searchDetails(String[][] arr){
        System.out.print("\nEnter the name of the student you want to search: ");
        String name = scan.nextLine();
        for(int i=0; i<arr.length; i++){
            if(arr[i][0].equalsIgnoreCase(name)){
                return i;
            }
        } 
        return -1;  
    }

    public static void main(String[] args) {
        String Details[][] = new String[1024][5];
        int k = 0;

        char cont = 'n'; 
        do {
            System.out.print("\n***Student Details Information***\nPress:: \n'1' for Collect Details\n'2' for Display Details\n'3' for Search Details\n'Any' for Exit.\nEnter your preference: ");
            int choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    String[] a = collectDetails();
                    Details[k] = a;
                    k+=1;
                    break;

                case 2:
                    displayDetails(Details);
                    break;
                
                case 3:
                    int index = searchDetails(Details);
                    System.out.println("The details of student you searched: "+Arrays.toString(Details[index]));
                    break;
            
                default:
                    System.out.println("Exited...\nThank you for joining..!");
                    break;
            }
            System.out.println("\n****************************************************************************");
            System.out.println("Press 'y' to continue");
            cont = scan.nextLine().charAt(0);
        }while (cont == 'y' || cont == 'Y');
        System.out.println("The program is ended..!!!");
    }    
}
