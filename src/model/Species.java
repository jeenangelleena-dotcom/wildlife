package model;

public class Species {
    public int speciesId;
    public String speciesName,category,scientificName,description,conservationStatus;

    public Species(int id,String n,String c,String s,String d,String cs){
        speciesId=id; speciesName=n; category=c; scientificName=s; description=d; conservationStatus=cs;
    }
}