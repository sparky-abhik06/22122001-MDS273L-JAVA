import java.util.Scanner;
import java.util.Arrays;


public class lab_2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int ch;

        String name_list[] = new String[1024];

        String name, S_name, D_name;

        do {
            System.out.print("\n***Welcome*** \n'1' is for Inputing a name. \n'2' is for Searching a name. \n'3' is for Deleting a name. \nEnter your choice: ");
            ch = Integer.parseInt(scan.nextLine());

            switch(ch){
                case 1:
                    System.out.print("\nEnter the name you want to add: ");
                    name = scan.nextLine();
                    for(int i=0; i<1024; i++){
                        if(name_list[i] == name){
                            System.out.print("\nThe namne is already there in the list!");
                            break;
                        }
                        else {
                            name_list[i] = name;
                            System.out.print("\nThe new name is added to the list.");
                            // return name_list;
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.print("\nEnter the name you want to search: ");
                    S_name = scan.nextLine();
                    for(int i=0; i<1024; i++){
                        if(name_list[i] == S_name){
                            System.out.print("\nThe name is in the list.");
                            break;
                        }
                        else{
                            System.out.print("\nSorry! the name is not in the list.");
                            break;
                        }
                    }
                case 3:
                    System.out.print("\nEnter the name you want to delete: ");
                    D_name = scan.nextLine();
                    for(int i=0; i<1023; i++){
                        if(name_list[i] == D_name){
                            name_list[i] = name_list[i+1];
                            System.out.print("\nThe name is deleted from the list.");
                            break;
                        }
                    }
                    break;
                default:
                    System.out.print("\nSorry! You entered wrong input. \n*Exit*");
                    break; 
                }
            System.out.println("\n************************************************\nThe list of the names is: " + Arrays.toString(name_list));
            }
        while ( ch == 1 || ch == 2 || ch == 3);
        System.out.println("\n************************************************\nThe list of the names is: " + Arrays.toString(name_list));
    }
}
