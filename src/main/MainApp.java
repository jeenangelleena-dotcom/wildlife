package main;

import service.*;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

       try (Scanner sc = new Scanner(System.in)) {

    WildlifeService service = new WildlifeService();

    while (true) {
        System.out.println("\n------WILDLIFE MANAGEMENT SYSTEM ------");
        System.out.println("1. Add User");
        System.out.println("2. Add Species");
        System.out.println("3. Add Habitat");
        System.out.println("4. Add Animal");
        System.out.println("5. Add Observation");
        System.out.println("6. Add Incident");
        System.out.println("7. Generate Report");
        System.out.println("8. View All");
        System.out.println("9. Exit");

        System.out.print("Enter Choice: ");
        int ch = Integer.parseInt(sc.nextLine());
        System.out.println(); 
        switch (ch) {
            case 1: service.addUser(); 
            System.out.println();
            break;
            case 2: service.addSpecies(); 
            System.out.println();  break;
            case 3: service.addHabitat(); 
            System.out.println();  // add this
            break;
            case 4: service.addAnimal();
            System.out.println();  // add this
            break;
            case 5: service.addObservation();
            System.out.println();  // add this
            break;
            case 6: service.addIncident(); 
            System.out.println();  // add this
            break;
            case 7: service.generateReport(); 
            System.out.println();  // add this
            break;
            case 8: service.viewAll(); 
            System.out.println();  // add this
            break;
            case 9: System.exit(0);
            default: System.out.println("Invalid choice");
        }
    }
}
    }
}