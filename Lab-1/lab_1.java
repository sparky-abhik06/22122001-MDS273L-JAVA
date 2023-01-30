import java.util.Scanner;

public class lab_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the name of the employee: ");
        String Name = scan.nextLine();
        System.out.print("Enter the age: ");
        int Age = Integer.parseInt(scan.nextLine());
        System.out.print("Enter the gender ['m'/'f'] : ");
        String Sex = scan.nextLine();
        System.out.print("Enter the state: ");
        String State = scan.nextLine();
        System.out.print("Enter the company name: ");
        String Company = scan.nextLine();
        System.out.println("************************************************************");
        System.out.println("Employee Details: { Name: '" + Name + "', Age: '" + Age + "', Gender: '" + Sex + "', State: '" + State + "', Company: '"+ Company + "'}");

        if(Sex.equals("m")) //check if the gender of the employee is 'm'//
        {
            System.out.println("The employee is 'MALE'.");
        }
        else if (Sex.equals("f")) //check if the gender of the employee is 'f'//
        {
            System.out.println("The employee is a 'FEMALE'.");
        }
        switch(State) //Checking for the region of the employee//
        {
            case "Chandigarh":
            case "Delhi":
            case "Haryana":
            case "Himachal Pradesh":
            case "Jammu & Kashmir":
            case "Punjab":
            case "Rajasthan":
                System.out.println("The Employee is from the 'northern' states of India; Preferable work location is in " + State);
                break;
            case "Arunachal Pradesh":
            case "Assam":
            case "Manipur":
            case "Meghalaya":
            case "Mizoram":
            case "Nagaland":
            case "Tripura":
            case "Andaman & Nicobar Islands":
            case "Bihar":
            case "Jharkhand":
            case "Orissa":
            case "Sikkim":
            case "West Bengal":
                System.out.println("The Employee is from the 'eastern' states of India; Preferable work location is in " + State);
                break;
            case "Chhattisgarh":
            case "Madhya Pradesh":
            case "Uttar Pradesh":
            case "Uttaranchal":
                System.out.println("The Employee is from the 'central' states of India; Preferable work location is in " + State);
                break;
            case "Dadra & Nagar Haveli":
            case "Daman & Diu":
            case "Goa":
            case "Gujarat":
            case "Maharashtra":
                System.out.println("The Employee is from the 'western' states of India; Preferable work location is in " + State);
                break;
            case "Andhra Pradesh":
            case "Karnataka":
            case "Kerala":
            case "Lakshadweep":
            case "Pondicherry":
            case "Tamil Nadu":
                System.out.println("The Employee is from the 'southern' states of India; Preferable work location is in " + State);
                break;
            default:
                System.out.println("You entered a wrong state of India!");
                break;
        }
        switch(Company) //Identify if the employee belongs to the top MNC Companies//
        {
            case "Facebook":
            case "Google":
            case "Microsoft":
            case "Samsung":
            case "IBM":
            case "Apple":
                System.out.println("The employee is working in Top MNC Companies.");
                break;
            default:
                System.out.println("The employee is working in normal Companies.");
                break;
        }
    }
}
