package com.videolibrary.basis;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Videolibrary {
    private String title;
    private List<Movie> movieList = new ArrayList<>();
    private List<Customer> customerList = new ArrayList<>();

    public Videolibrary(String title) {
        this.title = title;
    }

    public void showPrincipalMenu() {
        Scanner sc = new Scanner(System.in);
        this.loadFromFile();
        System.out.println("\n ----- " + this.title + " - Menu principal ----- \n");
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

        System.out.println("\n ----- " + this.title + " - Menu Films ----- \n");
        System.out.println("(0) Retourner au menu principal");
        System.out.println("(1) Recherche de film");
        System.out.println("(2) Réserver un film");
        System.out.println("(3) Ajouter un film");
        System.out.println("(4) Supprimer un film");

        int opr = sc.nextInt();

        switch(opr) {
            case 0 :
                this.showPrincipalMenu();
                break;
            case 1 :
                this.showSearchingMenu();
                break;
            case 2 :
                this.rentMovie();
                this.showMoviesMenu();
                break;
            case 3 :
                this.addMovie();
                this.showMoviesMenu();
                break;
            case 4 :
                this.deleteMovie();
                this.showMoviesMenu();
                break;
            default :
                System.out.println("Entrée invalide. \n");
                this.showMoviesMenu();
        }
    }

    public void showSearchingMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n ----- " + this.title + " - Menu Recherche ----- \n");
        System.out.println("(0) Retourner au menu film");
        System.out.println("(1) Recherche par titre");
        System.out.println("(2) Recherche par support");
        System.out.println("(3) Films disponibles");
        System.out.println("(4) Films loués");

        int opr = sc.nextInt();

        switch(opr) {
            case 0 :
                this.showMoviesMenu();
                break;
            case 1 :
                this.showMoviesByTitle();
                this.showMoviesMenu();
                break;
            case 2 :
                this.showMoviesBySupport();
                this.showMoviesMenu();
                break;
            case 3 :
                this.showMovies(false);
                this.showMoviesMenu();
                break;
            case 4 :
                this.showMovies(true);
                this.showMoviesMenu();
                break;
            default :
                System.out.println("Entrée invalide. \n");
                this.showMoviesMenu();
        }
    }

    public void showCustomersMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n ----- " + this.title + " - Menu Clients ----- \n");
        System.out.println("(0) Retourner au menu principal");
        System.out.println("(1) Accéder au fichier clients");
        System.out.println("(2) Voir les films loués par un client");
        System.out.println("(3) Ajouter un client");

        int opr = sc.nextInt();

        switch(opr) {
            case 0 :
                this.showPrincipalMenu();
                break;
            case 1 :
                this.showCustomers();
                this.showCustomersMenu();
                break;
            case 2 :
                this.getRentedByCustomer();
                break;
            case 3 :
                this.addCustomer();
                break;
            default :
                System.out.println("Entrée invalide. \n");
                this.showCustomersMenu();
        }
    }

    public void showMoviesByTitle() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n Titre du film : \n");
        String title = sc.nextLine();

        int i = 1;
        for(Movie movie : movieList) {
            if(movie.getTitle().toLowerCase().equals(title.toLowerCase())) {
                movie.getMovie(i);
                i++;
            }
        }
        if(i == 1) {
            System.out.println("\n Aucun film existant... \n");
        }

        this.showMoviesMenu();
    }

    public void showMoviesBySupport() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n Quel support (cassette, DVD, bluray) : \n");
        String support = sc.nextLine();

        int i = 1;
        for(Movie movie : movieList) {
            if(movie.getSupport().toLowerCase().equals(support.toLowerCase())) {
                movie.getMovie(i);
                i++;
            }
        }
        if(i == 1) {
            System.out.println("\n Aucun film existant... \n");
        }

        this.showMoviesMenu();
    }

    public void addCustomer() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Prénom du client : ");
        String fname = sc.nextLine();
        System.out.println("Nom du client : ");
        String lname = sc.nextLine();
        System.out.println("Email du client : ");
        String email = sc.nextLine();
        this.customerList.add(new Customer(fname, lname, email));
        this.showCustomersMenu();
    }

    public void showMovies(boolean isRented) {
        int i = 1;
        for(Movie movie : movieList) {
            if(!isRented ? movie.getIsRented() == null : movie.getIsRented() != null) {
                movie.getMovie(i);
                System.out.println("\n");
                i++;
            }
        }
        if(i == 1) {
            System.out.println("\n Aucun film existant... \n");
        }
    }

    public void showCustomers() {
        int i = 1;
        for (Customer customer : customerList) {
            customer.getCustomer(i);
            System.out.println("\n");
            i++;
        }
    }

    public void addMovie() {
        Date date = new Date();
        Scanner sc = new Scanner(System.in);

        System.out.println("Titre : ");
        String title = sc.nextLine();
        System.out.println("Acteur principal : ");
        String principalActor = sc.nextLine();
        System.out.println("Date (dd/MM/aaaa) : ");
        String _date = sc.nextLine();
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(_date);
        }
        catch (ParseException e) {
            System.out.println("Format de date non compatible.");
        }
        System.out.println("Réalisateur : ");
        String realisator = sc.nextLine();
        System.out.println("Support : ");
        String support = sc.nextLine();
        this.movieList.add(new Movie(title, principalActor, date, realisator, support));
    }

    public void rentMovie() {
        Scanner sc = new Scanner(System.in);
        int idCustomer = 0, idFilm = 0;
        boolean typeError = true;
        this.showCustomers();
        do
        {
            System.out.println("Identifiant du client: ");
            try
            {
                idCustomer = sc.nextInt();
                typeError = false;
            }
            catch (InputMismatchException error)
            {
                System.out.println("Merci de rentrer l'identifiant du client.");
                sc.nextLine();
            }
        } while (typeError);
        this.showMovies(false);
        do
        {
            System.out.println("Identifiant du film : ");
            try
            {
                idFilm = sc.nextInt();
                typeError = false;
            }
            catch (InputMismatchException error)
            {
                System.out.println("Merci de rentrer l'identifiant du film.");
                sc.nextLine();
            }
        } while (typeError);

        movieList.get(idFilm-1).setIsRented(customerList.get(idCustomer-1));

        System.out.println("\n Film loué ! \n");

        this.showPrincipalMenu();
    }

    public void deleteMovie() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Titre du film à supprimer : ");
        String title = sc.nextLine();

        int i = 0;
        for(Movie movie : movieList) {
            if(movie.getTitle().toLowerCase().equals(title.toLowerCase())) {
                movieList.remove(i);
                System.out.println("Film supprimé.");
                i++;
                break;
            }
        }
        if(i == 0) {
            System.out.println("Aucun film à supprimer.");
        }

    }

    public void getRentedByCustomer() {
        Scanner sc = new Scanner(System.in);
        int idCustomer = 0, idFilm = 0;
        boolean typeError = true;
        this.showCustomers();
        do
        {
            System.out.println("Identifiant du client: ");
            try
            {
                idCustomer = sc.nextInt();
                typeError = false;
            }
            catch (InputMismatchException error)
            {
                System.out.println("Merci de rentrer l'identifiant du client.");
                sc.nextLine();
            }
        } while (typeError);

        int i = 0;
        for(Movie movie : movieList) {
            if(customerList.get(idCustomer-1) == movie.getIsRented()) {
                movie.getMovie(i);
                i++;
            }
        }

        this.showPrincipalMenu();
    }

    public void loadFromFile() {
        File file = new File("/Users/germainperdigal/Desktop/Videotheque/src/maliste.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line = br.readLine())!=null){
                Date date = new Date();
                String[] Film = line.split(", ");
                try {
                    date = new SimpleDateFormat("dd/MM/yyyy").parse(Film[2]);
                }
                catch (ParseException e) {
                    System.out.println("Format de date non compatible.");
                }
                this.movieList.add(new Movie(Film[0], Film[1], date, Film[3], Film[4]));
                this.showMovies(false);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
