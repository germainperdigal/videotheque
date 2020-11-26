package com.videolibrary.basis;

import java.io.Serializable;
import java.util.Date;

public class Movie implements Serializable {
    private String title;
    private String principalActor;
    private Date date;
    private String realisator;
    private String support;
    private Customer isRented;

    public Movie (String title, String principalActor, Date date, String realisator, String support)
    {
        this.title = title;
        this.principalActor = principalActor;
        this.date = date;
        this.realisator = realisator;
        this.support = support;

    }

    public String getTitle()
    {
        return this.title;
    }
    public String getPrincipalActor()
    {
        return this.principalActor;
    }
    public Date getdate()
    {
        return this.date;
    }
    public String getRealisator()
    {
        return this.realisator;
    }
    public String getSupport() { return this.support; }
    public Customer getIsRented()
    {
        return this.isRented;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setIsRented(Customer customer)
    {
        this.isRented = customer;
    }

    public void getMovie(int index)
    {
        System.out.println("Film "+index+" : "+this.title + ".");
        System.out.println("Acteur principal : "+ this.principalActor + ".");
        System.out.println("Date de sortie : "+ this.date + ".");
        System.out.println("Realisateur : "+ this.realisator + ".");
        System.out.println("Support : " + this.support + ".");
        System.out.println(this.isRented != null ? "Loué par "+this.isRented.getFname()+" "+this.isRented.getLname()  : "Disponible");  //FIXME : .thisFname che pas quoi
    }

}
