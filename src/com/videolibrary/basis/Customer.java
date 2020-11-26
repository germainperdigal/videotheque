package com.videolibrary.basis;

public class Customer {
    private String fname;
    private String lname;
    private String email;

    public Customer(String fname, String lname, String email) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    public String getFname() {
        return this.fname;
    }

    public String getLname() {
        return this.lname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void getCustomer(int index) {
        System.out.println("--- Client "+index+" : "+ this.fname +" "+this.lname+" ---");
        System.out.println("Prénom : "+this.fname);
        System.out.println("Nom : "+this.lname);
        System.out.println("Adresse e-mail : "+this.email);
    }

}
