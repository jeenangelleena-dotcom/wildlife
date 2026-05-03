package model;

public class Habitat {
    public int habitatId;
    public String habitatName,location,habitatType,climate,description;

    public Habitat(int id,String n,String l,String t,String c,String d){
        habitatId=id; habitatName=n; location=l; habitatType=t; climate=c; description=d;
    }
}