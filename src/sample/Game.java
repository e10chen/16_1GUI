package sample;

import java.util.ArrayList;

public class Game {
    private static Controller myController;
    private static ArrayList<Game> gameList;
    private int rank;
    private String title;
    private String releaseDate;
    private double copiesSold;

    Game(int rank, String title, double copiesSold, String releaseDate) {
        this.rank = rank;
        this.title = title;
        this.releaseDate = releaseDate;
        this.copiesSold = copiesSold;

        if (gameList == null) {
            gameList = new ArrayList<>();
        }
        gameList.add(this);
    }

    static void initialize() {

    }

    public static Controller getMyController() {
        return myController;
    }

    public static void setMyController(Controller myController) {
        Game.myController = myController;

    }
    public static ArrayList<Game> getGameList() {
        return gameList;
    }

    public static void setGameList(ArrayList<Game> games) {
        Game.gameList = games;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(double copiesSold) {
        this.copiesSold = copiesSold;
    }


    static void describeAll() {
        if (gameList !=null) {
            gameList.forEach(game -> {
                System.out.println(game.toString());
            });

        }

    }


}