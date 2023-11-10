package org.cotiviti;

import org.cotiviti.models.Game;
import org.cotiviti.models.Players;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class CardsTest {
    // initializations
    String[] ranks = {
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "J",
            "Q",
            "K",
            "A",
    };
    Cards myGame = new Cards();
    Game my_game = new Game();
    List<Players> playersList = new ArrayList<>();
    List<Players> subPlayersList = new ArrayList<>();
    List<List<String>> hands = List.of(
            List.of("A of Hearts", "A of Spade", "A of Club"),
            List.of("J of Hearts", "J of Diamond", "J of Club"),
            List.of("J of Spade", "K of Spade", "Q of Spade"),
            List.of("3 of Spade", "A of Spade", "2 of Diamond")
    );
    int playersCount = hands.size();

    @Test
    public void checkingTrail() {

        myGame.checkTrail(playersList,
                subPlayersList,
                hands,
                my_game,
                ranks,
                playersCount);

        assertEquals(2, playersList.size());
        assertEquals(2, subPlayersList.size());
        assertEquals(2, my_game.getTrail());
    }

    @Test
    public void checkingDoubleRun() {

        myGame.checkDoubleRun(playersList,
                subPlayersList,
                hands,
                my_game,
                ranks,
                playersCount);

        assertEquals(1, playersList.size());
        assertEquals(1, subPlayersList.size());
        assertEquals(1, my_game.getDoubleRun());
    }

    @Test
    public void checkingRun() {

        myGame.checkRun(playersList,
                subPlayersList,
                hands,
                my_game,
                ranks,
                playersCount);

        assertEquals(1, playersList.size());
        assertEquals(1, subPlayersList.size());
        assertEquals(1, my_game.getRun());
    }

    @Test
    public void checkingColor() {

        myGame.checkColor(playersList,
                subPlayersList,
                hands,
                my_game,
                ranks,
                playersCount);

        assertEquals(1, playersList.size());
        assertEquals(1, subPlayersList.size());
        assertEquals(1, my_game.getColor());
    }

    @Test
    public void checkingPair() {

        myGame.checkPair(playersList,
                subPlayersList,
                hands,
                my_game,
                playersCount);

        assertEquals(0, playersList.size());
        assertEquals(0, subPlayersList.size());
        assertEquals(0, my_game.getPair());
    }

    @Test
    public void checkingDefault() {

        myGame.defaultHand(playersList,
                subPlayersList,
                hands,
                my_game,
                ranks,
                playersCount);

        assertEquals(playersCount, playersList.size());
        assertEquals(playersCount, subPlayersList.size());
        assertEquals(playersCount, my_game.getNothing());
    }

    @Test
    public void sortFunction(){
        String[] myHand = myGame.sortFunc(hands.get(3), ranks);
        assertEquals(List.of("2","3","A"), Arrays.asList(myHand));
    }
}
