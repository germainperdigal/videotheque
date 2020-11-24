package com.videolibrary.basis;

import java.util.Scanner;

public class Videolibrary {
    private String title;
    private Movie[] movies;
    private Customer[] customers;

    Videolibrary(String title) {
        this.title = title;
    }

    public void showPrincipalMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n ----- Garage " + this.title + " - Menu principal ----- \n");
        System.out.println("(1) Accéder au menu Films");
        System.out.println("(2) Accéder au menu Clients");

        int opr = sc.nextInt();

        switch(opr) {
            case 1 :
                this.showMoviesMenu();
                break;
            case 2 :
                this.showCustomersMenu();
                break;
            default :
                System.out.println("Entrée invalide. \n");
                this.showPrincipalMenu();
        }
    }

    public void showMoviesMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n ----- Garage " + this.title + " - Menu Films ----- \n");
        System.out.println("(0) Retourner au menu principal");
        System.out.println("(1) Voir tous les films (par support)");
        System.out.println("(2) Voir les films disponibles");
        System.out.println("(3) Voir les films loués");
        System.out.println("(4) Ajouter un film");

        int opr = sc.nextInt();

        switch(opr) {
            case 0 :
                this.showPrincipalMenu();
                break;
            case 1 :
                this.showMoviesBySupport();
                break;
            case 2 :
                this.showAvailableMovies();
                break;
            case 3 :
                this.showRentedMovies();
                break;
            case 4 :
                this.addMovie();
                break;
            default :
                System.out.println("Entrée invalide. \n");
                this.showMoviesMenu();
        }
    }

    public void showCustomersMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n ----- Garage " + this.title + " - Menu Clients ----- \n");
        System.out.println("(0) Retourner au menu principal");
        System.out.println("(1) Accéder au fichier clients");
        System.out.println("(2) Ajouter un client");

        int opr = sc.nextInt();

        switch(opr) {
            case 0 :
                this.showPrincipalMenu();
                break;
            case 1 :
                this.showCustomers();
                break;
            case 2 :
                this.addCustomer();
                break;
            default :
                System.out.println("Entrée invalide. \n");
                this.showCustomersMenu();
        }
    }

    public void showMoviesBySupport() {
        System.out.println("\n Tous les films : \n");
        int i = 1;
        for (Movie movie: movies) {
            System.out.println("(" + i + ") " + movie.getTitle + " | " + movie.getSupport);
            i++;
        }
        Scanner sc = new Scanner(System.in);

        System.out.println("(0) Retourner au menu des films");
        System.out.println("(n) Accéder au film");

        int opr = sc.nextInt();
        if(opr == 0) {
            this.showMoviesBySupport();
        } else {
            this.showMovie(i--);
        }
    }
}
