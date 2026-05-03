package model;

public class Report {
    int id; String type,date,desc,file,by;

    public Report(int i,String t,String d,String desc,String f,String b){
        id=i; type=t; date=d; this.desc=desc; file=f; by=b;
    }
}