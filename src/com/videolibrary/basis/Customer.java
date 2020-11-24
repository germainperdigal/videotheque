package com.videolibrary.basis;

public class Customer {
    public String fname;
    public String lname;
    public String email;

    public void Customer(String fname, String lname, String email) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    public void getCustomer() {
        System.out.println("--- Client "+ this.fname +" "+this.lname+" ---");
        System.out.println("Prénom : "+this.fname);
        System.out.println("Nom : "+this.lname);
        System.out.println("Adresse e-mail : "+this.email);
    }

}
