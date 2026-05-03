package model;

public class Animal extends Species {

    public int animalId;
    public String name;
    public String gender;
    public int age;
    public String dob;   // ✅ Added DOB
    public String health;
    public String idNo;
    public String behavior;
    public String img;

    public Habitat habitat; // Association

    // ✅ Updated Constructor (DOB included)
    public Animal(int aid, String n, String g, int age, String dob,
                  String health, String idNo, String behavior, String img,
                  int sid, String sn, String cat, String sci, String desc, String status,
                  Habitat hb) {

        super(sid, sn, cat, sci, desc, status);

        this.animalId = aid;
        this.name = n;
        this.gender = g;
        this.age = age;
        this.dob = dob;  // ✅ Used here
        this.health = health;
        this.idNo = idNo;
        this.behavior = behavior;
        this.img = img;
        this.habitat = hb;
    }

    // ✅ toString updated to include DOB
    @Override
    public String toString() {
        return "Animal ID: " + animalId +
               " | Name: " + name +
               " | Gender: " + gender +
               " | Age: " + age +
               " | DOB: " + dob +
               " | Species: " + speciesName +
               " | Habitat: " + habitat.habitatName +
               " | Health: " + health;
    }
}