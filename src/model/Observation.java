package model;

public class Observation {
public int id; public String date,by,notes,img;

    public Observation(int i,String d,String b,String n,String img){
        id=i; date=d; by=b; notes=n; this.img=img;
    }
}