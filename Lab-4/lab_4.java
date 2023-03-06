import java.time.LocalDateTime;
import java.util.*;
import java.time.format.DateTimeFormatter;      

public class lab_4{
    static Scanner sc = new Scanner(System.in);
    static int acc_no;
    static String h_Name;
    static float acc_bal;
    static String[][] tran = new String[100][4];
    static int iter = 0;
    
    static float Initialize(){
        System.out.print("You are logged In.\nEnter the account number: ");
        acc_no = Integer.parseInt(sc.nextLine());
        System.out.print("\nEnter the account holder name: ");
        h_Name = sc.nextLine();
        System.out.print("\nEnter the initialize account balance: ");
        acc_bal = Float.parseFloat(sc.nextLine());
        return acc_bal;
    }

    static float Deposit(){
        System.out.print("\nEnter the ammount you want to deposit to your account: ");
        float depo_bal = Float.parseFloat(sc.nextLine());
        acc_bal = (acc_bal + depo_bal);
        System.out.print("\nThe amount "+depo_bal+" is credited to your account.\t||\tYour current balace is: "+acc_bal);
        // String D_t = Transactions();
        
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        
        iter++;
        
        tran[iter][0]="Deposit";   // Deposit OR Withdraw
        tran[iter][1]=""+depo_bal; // Deposit Ammount
        tran[iter][2]=""+acc_bal;  // Balance
        tran[iter][3]=""+dt.format(now);   // date-time
        
        return acc_bal;
    }

    static float Withdraw(){
        System.out.print("\nEnter the ammount you want to withdraw from your account: ");
        float widr_bal = Float.parseFloat(sc.nextLine());
        if(widr_bal<=acc_bal){
            acc_bal = (acc_bal - widr_bal);
            System.out.print("\nThe amount "+widr_bal+" is debited to your account.\t||\tYour current balace is: "+acc_bal);
            // String W_t = Transactions();
        }
        else {System.out.println("\nYour account has insufficient balance.");}


        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        
        iter++;
        
        tran[iter][0]="Withdraw";   // Deposit OR Withdraw
        tran[iter][1]=""+widr_bal; // Deposit Ammount
        tran[iter][2]=""+acc_bal;  // Balance
        tran[iter][3]=""+dt.format(now);   // date-time


        return acc_bal;
    }

    static void Transactions(float bal){
        System.out.println("Transaction Details:");
        System.out.println("Your current account balance is: "+acc_bal);
        System.out.println("Transaction Amount      Balance     Date       Time");
        for(String[] s: tran){
            if(s[0]==null){
                continue;
            }else{
                System.out.printf("%-12s"+"%-12s"+"%-12s"+"%s\n",s[0],s[1],s[2],s[3]);
            }
        }
        
    }

    static void Summary(){
        System.out.print("\nYour account number is: "+acc_no+"\t||\tYour name is: "+h_Name+"\t||\tYour current account balance is: "+acc_bal);
    }

    public static void main(String[] args) {
        char cont = 'n';
        System.out.println("\n**********************************************************");
        Initialize();
        float ini_acc_bal;
        do{
            ini_acc_bal = acc_bal;
            System.out.println("\n**********************************************************");
            System.out.print("Menu:\n1. Deposit\n2. Withdraw\n3. Print Transaction History\n4. Print Account Summary\nExit.\n\nEnter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            System.out.println("\n**********************************************************");
            switch(choice){
                case 1:
                    Deposit();
                    System.out.println("\n**********************************************************");
                    break;
                case 2:
                    Withdraw();
                    System.out.println("\n**********************************************************");
                    break;
                case 3:
                    Transactions(ini_acc_bal);
                    System.out.println("\n**********************************************************");
                    break;
                case 4:
                    Summary();
                    System.out.println("\n**********************************************************");
                    break;
                default:
                    System.out.println("Thank you for logged in.\nExit..!");
                    System.out.println("\n**********************************************************");
                    break;
            }
            System.out.println("\n****************************************************************************");
            System.out.println("Press 'y' or 'Y' to continue..");
            cont = sc.nextLine().charAt(0);
        } while(cont == 'y' || cont == 'Y');
        System.out.println("The program is ended..!");
    }
}