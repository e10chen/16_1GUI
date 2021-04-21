package sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayStation4Game extends Game {

    private static ArrayList<PlayStation4Game> playStation4Games;
    private static int currentGameNumber;
    private String genre;
    private String developer;
    private String publisher;


    public PlayStation4Game(int rank, String title, double copiesSold, String releaseDate, String genre, String developer, String publisher) {
        super(rank, title, copiesSold, releaseDate);
        this.genre = genre;
        this.developer = developer;
        this.publisher = publisher;

        if (playStation4Games == null) {
            playStation4Games = new ArrayList<PlayStation4Game>();
        }
        playStation4Games.add(this);
    }

    static void initialize() {
        read("PlayStation4Game");
        getMyController().updatePlayStation4UI(getFirstGame(), 1, getNumberOfGame());
    }



    String getGenre() {
        return genre;
    }

    void setGenre(String genre) {
        this.genre = genre;
    }

    String getDeveloper() {
        return developer;
    }

    void setDeveloper(String developer) {
        this.developer = developer;
    }

    String getPublisher() {
        return publisher;
    }

    void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    static public int getCurrentGameNumber() {
        return currentGameNumber;
    }

    static public int getNumberOfGame() {
        return playStation4Games.size();
    }

    @Override

    public String toString() {


        return "\"" + getTitle() + "\" had a rank of #" + getRank() + ". It is a " + getGenre() + " game that was developed by the " + getDeveloper() + "and publish by the" + getPublisher() + ".  It was release on " + getReleaseDate() + " and sold up to " + getCopiesSold() + " million copies.";
    }

    static void read(String playStation4GameData) {
        Scanner scanner = null;
        try {
            File file = new File(playStation4GameData);
            scanner = new Scanner(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Problem oping file: " + playStation4GameData);
        }
        if (scanner == null) {

            return;
        }

        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            Scanner lineScanner = new Scanner(next);
            lineScanner.useDelimiter("\t");

            int ranking = lineScanner.nextInt();
            String title = lineScanner.next();
            double copiesSold = lineScanner.nextDouble();
            String releaseDate = lineScanner.next();
            String genres = lineScanner.next();
            String developers = lineScanner.next();
            String publishers = lineScanner.next();

            Game game = new PlayStation4Game(ranking, title, copiesSold, releaseDate, genres, developers, publishers);
        }


    }

    static public PlayStation4Game getFirstGame() {
        currentGameNumber = 1;
        return playStation4Games.get(currentGameNumber - 1);
    }

    static public PlayStation4Game getNextGame() {
        if (currentGameNumber < playStation4Games.size()) {
            currentGameNumber = currentGameNumber +1;
        } else {
            currentGameNumber = 1;
        }
        return playStation4Games.get(currentGameNumber - 1);
    }

    static public PlayStation4Game getPreviousGame() {
        if (currentGameNumber > 1) {
            currentGameNumber = currentGameNumber -1;
        } else {
            currentGameNumber = playStation4Games.size();
        }
        return  playStation4Games.get(currentGameNumber - 1);
    }



}
