package sample;

import javafx.scene.control.*;

public class Controller {

    public TextField textRank;
    public TextField textGame;
    public TextField textCopiesSold;
    public TextField textReleaseDate;
    public TextField textGenre;
    public TextField textDeveloper;
    public TextField textPublisher;
    public Label playStationGameNumberLabel;
    public Button previousButton;
    public Button nextButton;


public void initialize(){
    Game.setMyController(this);

    PlayStation4Game.initialize();
    Game.initialize();

    Game.describeAll();

    }

    void updatePlayStation4UI(PlayStation4Game playStationGame, int playStationGameNum, int numOfPlayStationGames) {
        textRank.setText(Integer.toString(Game.getRank()));
    }

}
