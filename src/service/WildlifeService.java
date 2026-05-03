package service;

import model.*;
import util.*;
import java.util.*;

public class WildlifeService {

    Scanner sc = new Scanner(System.in);

    List<User> users = new ArrayList<>();
    List<Species> speciesList = new ArrayList<>();
    List<Habitat> habitats = new ArrayList<>();
    List<Animal> animals = new ArrayList<>();
    List<Observation> observations = new ArrayList<>();
    List<Incident> incidents = new ArrayList<>();
    List<Report> reports = new ArrayList<>();

   public void addUser() {

    try {
        System.out.println("\n--- Enter User Details ---");

        System.out.print("User ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        System.out.print("Role: ");
        String role = sc.nextLine();

        System.out.print("Phone: ");
        String phone = sc.nextLine();

        System.out.print("Status: ");
        String status = sc.nextLine();

        User u = new User(id, name, email, pass, role, phone, status);
        users.add(u);

        System.out.println("\nUser Added Successfully!");

    } catch (Exception e) {
        System.out.println(" Invalid input!");
    }
}

    public void addSpecies() {
        System.out.print("Species ID: ");
        int id = sc.nextInt(); sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Category: ");
        String cat = sc.nextLine();

        System.out.print("Scientific Name: ");
        String sci = sc.nextLine();

        System.out.print("Description: ");
        String desc = sc.nextLine();

        System.out.print("Status: ");
        String status = sc.nextLine();

        speciesList.add(new Species(id, name, cat, sci, desc, status));
        new LoggerThread("Species Added").start();
    }

    public void addHabitat() {
        System.out.print("Habitat ID: ");
        int id = sc.nextInt(); sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Location: ");
        String loc = sc.nextLine();

        System.out.print("Type: ");
        String type = sc.nextLine();

        System.out.print("Climate: ");
        String climate = sc.nextLine();

        System.out.print("Description: ");
        String desc = sc.nextLine();

        habitats.add(new Habitat(id, name, loc, type, climate, desc));
        new LoggerThread("Habitat Added").start();
    }

    public void addAnimal() {
        if (speciesList.isEmpty() || habitats.isEmpty()) {
            System.out.println("Add Species & Habitat first!");
            return;
        }

        System.out.print("Animal ID: ");
        int id = sc.nextInt(); sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Gender: ");
        String gender = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt(); sc.nextLine();

        System.out.print("DOB: ");
        String dob = sc.nextLine();

        System.out.print("Health: ");
        String health = sc.nextLine();

        System.out.print("Identification No: ");
        String idNo = sc.nextLine();

        System.out.print("Behavior: ");
        String behavior = sc.nextLine();

        System.out.print("Image URL: ");
        String img = sc.nextLine();

        System.out.println("Select Species ID:");
        speciesList.forEach(s -> System.out.println(s.speciesId + " " + s.speciesName));
        int sid = sc.nextInt();

        System.out.println("Select Habitat ID:");
        habitats.forEach(h -> System.out.println(h.habitatId + " " + h.habitatName));
        int hid = sc.nextInt();

        Species sp = speciesList.stream().filter(s -> s.speciesId == sid).findFirst().orElse(null);
        Habitat hb = habitats.stream().filter(h -> h.habitatId == hid).findFirst().orElse(null);

        animals.add(new Animal(id, name, gender, age, dob, health, idNo, behavior, img,
        sp.speciesId, sp.speciesName, sp.category,
        sp.scientificName, sp.description,
        sp.conservationStatus, hb));

        FileUtil.saveData("Animal Added: " + name);
        new LoggerThread("Animal Added").start();
    }

    public void addObservation() {
        System.out.print("Observation ID: ");
        int id = sc.nextInt(); sc.nextLine();

        System.out.print("Date: ");
        String date = sc.nextLine();

        System.out.print("Observed By: ");
        String by = sc.nextLine();

        System.out.print("Notes: ");
        String notes = sc.nextLine();

        System.out.print("Image URL: ");
        String img = sc.nextLine();

        observations.add(new Observation(id, date, by, notes, img));
        new LoggerThread("Observation Added").start();
    }

    public void addIncident() {
        System.out.print("Incident ID: ");
        int id = sc.nextInt(); sc.nextLine();

        System.out.print("Type: ");
        String type = sc.nextLine();

        System.out.print("Description: ");
        String desc = sc.nextLine();

        System.out.print("Location: ");
        String loc = sc.nextLine();

        System.out.print("Date: ");
        String date = sc.nextLine();

        System.out.print("Status: ");
        String status = sc.nextLine();

        incidents.add(new Incident(id, type, desc, loc, date, status));
        new LoggerThread("Incident Added").start();
    }

    public void generateReport() {
        System.out.print("Report ID: ");
        int id = sc.nextInt(); sc.nextLine();

        System.out.print("Type: ");
        String type = sc.nextLine();

        System.out.print("Date: ");
        String date = sc.nextLine();

        System.out.print("Description: ");
        String desc = sc.nextLine();

        reports.add(new Report(id, type, date, desc, "file.txt", "Admin"));
        FileUtil.saveData("Report Generated: " + desc);
        new LoggerThread("Report Generated").start();
    }

    public void viewAll() {
        System.out.println("\n--- USERS ---");
        users.forEach(System.out::println);

        System.out.println("\n--- SPECIES ---");
        speciesList.forEach(s -> System.out.println(s.speciesName));

        System.out.println("\n--- HABITATS ---");
        habitats.forEach(h -> System.out.println(h.habitatName));

        System.out.println("\n--- ANIMALS ---");
        animals.forEach(System.out::println);

        System.out.println("\n--- INCIDENTS ---");
        incidents.forEach(i -> System.out.println(i.type));

        System.out.println("\n--- OBSERVATIONS ---");
        observations.forEach(o -> System.out.println(o.notes));
    }
}