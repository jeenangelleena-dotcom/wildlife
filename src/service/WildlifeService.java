package service;

import model.*;
import util.FileUtil;
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

    // ---------------- USER ----------------
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

            FileUtil.saveData("User Added: " + name);

            System.out.println("\nUser Added Successfully!\n");

        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }

    // ---------------- SPECIES ----------------
    public void addSpecies() {
        try {
            System.out.println("\n--- Enter Species Details ---");

            System.out.print("Species ID: ");
            int id = Integer.parseInt(sc.nextLine());

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

            Species s = new Species(id, name, cat, sci, desc, status);
            speciesList.add(s);

            System.out.println("\n Species Added Successfully!\n");

        } catch (Exception e) {
            System.out.println(" Invalid input!");
        }
    }

    // ---------------- HABITAT ----------------
    public void addHabitat() {
        try {
            System.out.println("\n--- Enter Habitat Details ---");

            System.out.print("Habitat ID: ");
            int id = Integer.parseInt(sc.nextLine());

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

            Habitat h = new Habitat(id, name, loc, type, climate, desc);
            habitats.add(h);

            System.out.println("\n Habitat Added Successfully!\n");

        } catch (Exception e) {
            System.out.println(" Invalid input!");
        }
    }

    // ---------------- ANIMAL ----------------
    public void addAnimal() {
        try {
            if (speciesList.isEmpty() || habitats.isEmpty()) {
                System.out.println("\n⚠ Add Species & Habitat first!\n");
                return;
            }

            System.out.println("\n--- Enter Animal Details ---");

            System.out.print("Animal ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Gender: ");
            String gender = sc.nextLine();

            System.out.print("Age: ");
            int age = Integer.parseInt(sc.nextLine());

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

            // select species
            System.out.println("\nSelect Species ID:");
            for (Species s : speciesList) {
                System.out.println(s.speciesId + " - " + s.speciesName);
            }
            int sid = Integer.parseInt(sc.nextLine());

            Species sp = speciesList.stream()
                    .filter(s -> s.speciesId == sid)
                    .findFirst().orElse(null);

            // select habitat
            System.out.println("\nSelect Habitat ID:");
            for (Habitat h : habitats) {
                System.out.println(h.habitatId + " - " + h.habitatName);
            }
            int hid = Integer.parseInt(sc.nextLine());

            Habitat hb = habitats.stream()
                    .filter(h -> h.habitatId == hid)
                    .findFirst().orElse(null);

            Animal a = new Animal(id, name, gender, age, dob, health, idNo, behavior, img,
                    sp.speciesId, sp.speciesName, sp.category,
                    sp.scientificName, sp.description,
                    sp.conservationStatus, hb);

            animals.add(a);

            FileUtil.saveData("Animal Added: " + name);

            System.out.println("\n Animal Added Successfully!\n");

        } catch (Exception e) {
            System.out.println(" Error adding animal!");
        }
    }

    // ---------------- OBSERVATION ----------------
    public void addObservation() {
        try {
            System.out.println("\n--- Enter Observation Details ---");

            System.out.print("Observation ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Date: ");
            String date = sc.nextLine();

            System.out.print("Observed By: ");
            String by = sc.nextLine();

            System.out.print("Notes: ");
            String notes = sc.nextLine();

            System.out.print("Image URL: ");
            String img = sc.nextLine();

            observations.add(new Observation(id, date, by, notes, img));

            System.out.println("\n Observation Added Successfully!\n");

        } catch (Exception e) {
            System.out.println(" Invalid input!");
        }
    }

    // ---------------- INCIDENT ----------------
    public void addIncident() {
        try {
            System.out.println("\n--- Enter Incident Details ---");

            System.out.print("Incident ID: ");
            int id = Integer.parseInt(sc.nextLine());

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

            System.out.println("\n Incident Added Successfully!\n");

        } catch (Exception e) {
            System.out.println(" Invalid input!");
        }
    }

    // ---------------- REPORT ----------------
    public void generateReport() {
        try {
            System.out.println("\n--- Generate Report ---");

            System.out.print("Report ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Type: ");
            String type = sc.nextLine();

            System.out.print("Date: ");
            String date = sc.nextLine();

            System.out.print("Description: ");
            String desc = sc.nextLine();

            reports.add(new Report(id, type, date, desc, "file.txt", "Admin"));

            FileUtil.saveData("Report Generated: " + desc);

            System.out.println("\n Report Generated Successfully!\n");

        } catch (Exception e) {
            System.out.println(" Invalid input!");
        }
    }

    // ---------------- VIEW ----------------
    public void viewAll() {
        System.out.println("\n========== ALL DATA ==========");

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

        System.out.println("\n==============================\n");
    }
}