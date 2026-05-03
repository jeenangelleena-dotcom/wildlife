package model;

public class User {
    int id; String name,email,password,role,phone,status;

    public User(int id,String name,String email,String password,String role,String phone,String status){
        this.id=id; this.name=name; this.email=email; this.password=password;
        this.role=role; this.phone=phone; this.status=status;
    }

    public String toString(){ return name+" ("+role+")"; }
}