package model;

public class Incident {
public int id; public String type,desc,loc,date,status;

    public Incident(int i,String t,String d,String l,String dt,String s){
        id=i; type=t; desc=d; loc=l; date=dt; status=s;
    }
}