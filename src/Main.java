import Controller.Controller;
import Model.*;
import View.View;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//
//        System.out.println("Dataset you wish to view");
//        System.out.println("1.Airline");
//       System.out.println("2.Airport");
//        int choice;
//       choice=scanner.nextInt();
//
//        if(choice==1){

        View view= new View();
       ModelAirport modelaport = new ModelAirport();
       ModelAirline modelaline = new ModelAirline();
        Controller controlleraport = new Controller(modelaport,modelaline ,view);
//        } else if (choice==2) {
//            View view = new View();
//           ModelAirline modelaline = new ModelAirline();
//            ControllerAirline  controlleraline = new ControllerAirline(modelaline,view);
//        }
//        else {
//            System.out.println("Invalid choice");
//      }
    }
}
