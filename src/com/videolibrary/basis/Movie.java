package com.videolibrary.basis;

import java.util.Date;

public class Movie {
    public String title;
    public String principalActor;
    public String date;
    public String realisator;
    public String support;
    public Customer isRented;

    public Movie (String title, String principalActor, String date, String realisator, String support)
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
    public String getSupport()
    {
        return this.support;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public void getMovie()
    {
        System.out.println("Film : "+this.title + ".");
        System.out.println("Acteur principal : "+ this.principalActor + ".");
        System.out.println("Date de sortie : "+ this.date + ".");
        System.out.println("Realisateur : "+ this.realisator + ".");
        System.out.println("Support : " + this.support + ".");
        System.out.println(this.isRented != null ? "Loué par "  : "Disponible");  //FIXME : .thisFname che pas quoi
    }

}
